// 일반적 함수의 리턴 타입으로 사용됨.
// 항상 오류를 출력, 리턴 값 절대로 내보내지 않음.
// 어떤 값도 없기 때문에 any 타입 포함 아무 값도 가질 수 없음.
// 깔끔히 종료 안됨 -> void보다 never을 사용해서 직관적으로 나타내기
// 오류 나거나 무한루프 돌때 사용

// 항상 오류 발생
function invalid(message: string): never {
  throw new Error(message);
}

// never 타입을 결과 추론(Inferred)
function fail() {
  return invalid("실패");
}

// 무한 루프
function infiniteAnimal(): never {
  while (true) {
    infiniteAnimal();
  }
}
