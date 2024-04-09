// 이 타입이 특정 타입 임을 단언합니다
// 오직 컴파일 과정에서만 사용

// 1. 앵글 브라켓(<>)
let assertion1: any = "타입 어셜선은 '타입을 단언'합니다.";
let assertion1_count: number = (<string>assertion1).length;

// 2. as 분법 사용
let assertion2: any = "타입 어셜션은 '타입을 단언'합니다";
let assertion2_count: number = (assertion1 as string).length;
