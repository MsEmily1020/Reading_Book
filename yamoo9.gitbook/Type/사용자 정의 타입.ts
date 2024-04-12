// 복잡한 타입 매번 설정 번거로움
let Dom5: {
  version: string;
  el: (selector: string) => void;
  css: (prop: string) => void;
} = {
  version: "0.0.1",
  el() {},
  css() {},
};

// 타입 별칭 정의할 수 있음.
// 정의 시 type 키워드 사용

type operation = {
  data: number[];
  output: (num: number) => number[];
};

let sum: operation = {
  data: [10, 30, 60],
  output(num) {
    return this.data.map((n) => n + num);
  },
};
