const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2");
const session = require("express-session");
const bcrypt = require("bcrypt");

const SALT_ROUNDS = 10;

const app = express();
const sec = 1000;
const hour = 60 * 60 * sec;
app.use(
  session({
    secret: "secret",
    resave: false,
    saveUninitialized: true,
    cookie: {
      // maxAge: 10 * sec
      maxAge: hour,
    },
  })
);

app.use(bodyParser.json());
const port = 3000;
const pool = mysql.createPool({
  host: "localhost",
  user: "root",
  password: "1234",
  database: "hozu",
});

const loginRequired = function (req, res, next) {
  if (req.session.user) {
    next();
  } else {
    // 440 => 마소가 쓰는 세션 만료용 에러 코드
    res.status(440).json({ result: "현재 로그인 상태가 아닙니다." });
  }
};

const roleRequired = function (allowed) {
  return function (req, res, next) {
    const user = req.session.user;
    const roles = user.roles;
    let hasRole = false;
    for (const role of roles) {
      if (allowed.includes(role)) {
        hasRole = true;
        break;
      }
    }
    if (hasRole) next();
    else res.status(403).json({ result: "권한이 없습니다." });
  };
};

app.post("/api/users", (req, res) => {
  bcrypt.hash(req.body.password, SALT_ROUNDS, function (err, hash) {
    pool.query(
      "INSERT INTO user(email, password, name, roles) VALUES(?, ?, ?, ?)",
      [req.body.email, hash, req.body.name, req.body.roles],
      function (err, rows, fields) {
        if (err) {
          res.json({ result: err });
        } else {
          res.json({ result: "ok" });
        }
      }
    );
  });
});

app.delete("/api/users/:email", loginRequired, (req, res) => {
  const user = req.session.user;
  const email = req.params.email;

  if (user.email === email || user.roles.includes("admin")) {
    pool.query(
      "DELETE FROM user WHERE email=?",
      [email],
      function (err, rows, fields) {
        if (rows.affectedRows === 0) {
          res.status(404).json({ result: "존재하지 않는 사용자입니다." });
        } else {
          res.json({ result: "ok" });
        }
      }
    );
  } else {
    res.status(403).json({ result: "사용자 삭제 권한이 없습니다." });
  }
});

app.get("/api/users/:email", (req, res) => {
  const email = req.params.email;
  pool.query(
    "SELECT * FROM user WHERE email = ?",
    [email],
    function (err, rows, fields) {
      if (rows.length === 0) {
        res.status(404).json({ result: "존재하지 않는 사용자입니다." });
      } else {
        res.json({ result: rows[0] });
      }
    }
  );
});

app.get("/api/users", loginRequired, (req, res) => {
  pool.query("SELECT * FROM user", function (err, rows, fields) {
    res.json({ result: rows });
  });
});

app.post("/api/login", (req, res) => {
  const { email, password } = req.body;
  pool.query(
    "SELECT * FROM user WHERE email = ?",
    [email],
    function (err, rows, fields) {
      if (rows.length === 0) {
        res.json({ result: "로그인 실패 (사용자 없음)" });
      } else {
        const user = rows[0];
        bcrypt.compare(password, rows[0].password, function (err, result) {
          if (result) {
            req.session.user = {
              email: user.email,
              name: user.name,
              roles: user.roles.split(","),
            };
            req.session.save();
            res.json({ result: "로그인 성공" });
          } else {
            res.json({ result: "로그인 실패 (비밀번호 불일치)" });
          }
        });
      }
    }
  );
});

app.post("/api/logout", (req, res) => {
  req.session.destroy();
  res.json({ result: "로그아웃 완료" });
});

app.get("/api/me", loginRequired, (req, res) => {
  res.json({ result: req.session.user });
});

app.get("/api/admin", [loginRequired, roleRequired(["admin"])], (req, res) => {
  res.json("admin");
});

app.get(
  "/api/vip",
  [loginRequired, roleRequired(["admin", "vip"])],
  (req, res) => {
    res.json("vip");
  }
);

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
