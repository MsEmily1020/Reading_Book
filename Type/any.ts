// Typescript는 타입 명시 지정 권장
// but, 어떤 타입 할당해야 할지 못하는 경우 any 설정 가능

// 1. 명시적 any 타입 지정
let product1: any = 124981;
product1 = "p9023412";

// 2. 암시적 any 타입 지정
let product2;

product2 = 124981;
product2 = "p9023412";
