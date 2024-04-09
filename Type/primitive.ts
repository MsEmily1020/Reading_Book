// 1. 명시적 변수 선언
let product_id: number = 124981;
let product_name: string = "VR 글래스";
let is_waterprofing: boolean = false;

// 오류 : number 형식에 할당할 수 없음.
product_id = "p9023412";

// 오류 : void 형식은 string 형식에 할당할 수 없음.
product_name = function () {};

// 오류 : number 형식은 boolean 형식에 할당할 수 없음
is_waterprofing = 0;
