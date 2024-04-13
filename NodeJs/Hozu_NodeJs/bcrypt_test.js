const bcrypt = require("bcrypt");
const SALT_ROUNDS = 10;
const plainPassword = "1234";

bcrypt.hash(plainPassword, SALT_ROUNDS, function (err, hash) {
  console.log(hash);
});
