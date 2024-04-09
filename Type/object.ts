// 변수에 초기 설정된 값을 암시적으로 할당 가능한 데이터 타입으로 설정시킴
// 초기 설정된 값 유추해서 타입 지정시킴

let Dom1 = {
  version: "0.0.1",
  el() {},
  css() {},
};

// 오류 : 할당할 수 없음.
// Dom1 = {
//   append() {},
// };

// 각 속성별 타입 명시
let Dom2: { version: string; el: () => void; css: () => void };

Dom2 = {
  version: "0.0.1",
  el() {},
  css() {},
};

// 또는 한번에 정의
let Dom3: { version: string; el: () => void; css: () => void } = {
  version: "0.0.1",
  el() {},
  css() {},
};

// 새로운 객체 속성 추가할 경우 오류 출력 시킴
// [propName: string]: any를 사용하여 해결
let Dom4: {
  version: string;
  el: () => void;
  css: () => void;
  [propName: string]: any; // 다음의 값은 아무 타입이나 가능함
};

Dom4 = {
  version: "0.0.1",
  el() {},
  css() {},
};

Dom4.each = function () {};
Dom4.map = function () {};
Dom4.filter = function () {};
