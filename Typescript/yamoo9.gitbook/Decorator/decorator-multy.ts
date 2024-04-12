function Size() {
  console.log("size(): 평가됨");
  return function (target: any, prop: string, desc: PropertyDecorator) {
    console.log("size(): 실행됨");
  };
}

function Color() {
  console.log("color(): 평가됨");
  return function (target: any, prop: string, desc: PropertyDecorator) {
    console.log("color(): 실행됨");
  };
}

class Button {
  @Size
  @Color
  isPressed() {}
}

/*
size(): 평가됨
color(): 평가됨
color(): 실행됨
size(): 실행됨
*/
