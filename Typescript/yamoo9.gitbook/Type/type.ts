// 1. 타입 불일치

// let milk_chocolate = "밀크 초콜릿";
// milk_chocolate = 2018;

/*
  오류 출력:
    [ts] '2018' 형식은 'string' 형식에 할당할 수 없습니다.
    let milk_chocolate: string
*/

// 2. any 타입 : typescript 쓸 이유 없음(javascript 기본 사용)
// 쓰는 이유 : 잘못된 타입 할당 되었을 때 오류를 알려주므로 유용함.
let coffee_type;

coffee_type = "콜드브루";
coffee_type = 9112304129312;
