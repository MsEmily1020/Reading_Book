/*
{
  "compilerOptions": {
    ...,
    "noImplicitAny": false, // 권장되지 않음
    ...
  }
}
*/

// interface에서 새로운 속성 추가 시 시그니처 사용하기
interface ButtonInterface3 {
  onInit?(): void;
  onClick(): void;
  // 인덱스 시그니처
  [prop: string]: any;
}

const button: ButtonInterface3 = {
  type: "button",
  disabled: false,
  onClick() {
    console.log("버튼 클릭");
  },
};
