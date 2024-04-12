// 멤버라 불리는 명명된 값의 집합을 이루는 자료형
// 기본 0부터 시작.

enum Team1 {
  Manager, // 0
  Planner, // 1
  Developer, // 2
  Designer, // 3
}

// Team.Designer = 3
let sarha1: number = Team1.Designer;

// enum 아이템 값 할당

enum Team2 {
  Manager = 101,
  Planner = 208,
  Developer = 302,
  Designer,
}

let yamoo9: number = Team2.Manager; // 101
let sarha2: number = Team2.Designer; // 303

// 숫자 값으로 이름 찾기
let role: string = Team2[302]; // Developer
