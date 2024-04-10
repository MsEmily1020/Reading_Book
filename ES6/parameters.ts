// 1. default parameters
// number의 값이 없을 경우 디폴트로 10 넣어주기
function countDown(start: number = 10): () => number {
  return () => (start > 0 ? start-- : 0);
}

// 2. spread operator
// 전개 연산자 ...
let numbers: number[] = [101, 21, -12, 934, 87];

numbers = [10, 31, 11, ...numbers, -2, 0];

// 배열 => 개별 아이템으로 순차적 제공
let min_number: number = Math.min(...numbers);
let max_number: number = Math.max(...numbers);

// 3. rest parameters
// 나머지 매개변수 사용 (전개 연산자 매개변수 앞에 붙여 사용)
// 매개변수 앞에 ...을 정의한 매개변수 (배열로 전달받음)
function makeArray(...args: (number | string)[]): (number | string)[] {
  return args;
}

makeArray(11, "eleven", 100, "one hundred");
