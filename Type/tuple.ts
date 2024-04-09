// typescript에서만 지원
// 배열 타입 보다 특수한 형태로 사용할 수 있음

// 지정된 형식(명시된 타입)에 따라 아이템 순서 정하기
let book__name_price: [string, number] = ["카밍 시그널", 13320];

// [number, string] 형식은 [string, number] 형식에 할당할 수 없음
// book__name_price = [13320, '카밍 시그널']

// false 형식의 인수는 string|number의 매개 변수에 할당할 수 없음.
// book__name_price.push(false);
book__name_price.push("ㄱ");
