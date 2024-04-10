let context = document.querySelector("html");

// let, const 사용 시, 블록 스코프(Block Scope) 사용 가능
{
  let context = document.querySelector("body");
  console.log("블록문 내부 context = ", context);
}

console.log("글로벌 context = ", context);
