// 1. 함수
function setInfo1(id: number, name: string) {
  return { id, name };
}

let product_one = setInfo1(120912, "스노우보드");

// 2. 유니온 타입
// : 설정한 값을 모두 가능하게 | 를 사용하는 타입 (or)

function setInfo2(id: number | string, name: string) {
  return { id, name };
}

// 3. 함수 리턴 타입 : void
// 결과 값을 반환하는 함수의 경우 명시적 반환 값 타입 기술
function assignClass1(name: string): void {
  document.documentElement.classList.add(name);
}

function factorial1(n: number): number {
  if (n < 0) {
    return 0;
  }

  if (n === 1) {
    return 1;
  }

  return n * factorial1(n - 1);
}

function repeat(text: string, count: number = 1): string {
  let result: string = "";
  while (count--) {
    result += text;
  }
  return result;
}

// 4. 함수식

// (1) 전
let assignClass2 = function (name) {
  document.documentElement.classList.add(name);
};

// (1) 후
// 변수 함수 매개변수, 리턴 타입에 대한 명시적 설정
let assignClass3: (n: string) => void;

// 변수에 함수 값 할당
assignClass3 = function (name) {
  document.documentElement.classList.add(name);
};

// (2) 한번 정의
let factorial2: (n: number) => number = function (n) {
  if (n < 0) {
    return 0;
  }

  if (n === 1) {
    return 1;
  }

  return n * factorial2(n - 1);
};

// (3) 화살표 함수 정의
let factorial3: (n: number) => number = (n) =>
  n < 0 ? 0 : n === 1 ? 1 : n * factorial3(n - 1);
