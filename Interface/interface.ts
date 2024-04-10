// 사용자 정의 타입과 유사하지만
// 차이점 : 인터페이스는 선언을 병합할 수 있음.

// 사용자 정의 타입은 선언이 중복되면 오류
interface ButtonInterface {
  onInit(): void;
  onClick(): void;
}

interface ButtonInterface {
  onToggle(): void;
}
