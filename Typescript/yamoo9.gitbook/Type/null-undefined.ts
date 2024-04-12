// typescript에서도 하나의 타입으로 처리됨.
let nullable: null = null;
let undefinedable: undefined = undefined;

// null과 undefined은 다름
// nullable = undefined; <- 오류

// 엄격하게 오류를 출력하는 이유 tsconfig.json
// tsconfig.json에서
// "strictNullChecks": true
// 엄격한 null 검사를 허용했기 때문

// 오류 : null 형식은 string형식에 할당할 수 없음.
// let assign_name:string = null;

// 해결 -> any 또는 union 타입 사용하기
// 문자 타입으로 특정 짓는 것이 아니라서 유니온 타입보다 any 타입을 권장
let assign_name2: string | null = null;
