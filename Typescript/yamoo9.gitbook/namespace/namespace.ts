namespace Dom {
  // 외부에서 접근 불가
  const document = window.document;

  // 외부에서 접근 가능하도록 export
  export function el(
    selector: string,
    context: HTMLElement | Document = document
  ) {
    return context.querySelector(selector);
  }

  // 외부에서 접근 가능하도록 export
  export function els(
    selector: string,
    context: HTMLElement | Document = document
  ) {
    return context.querySelectorAll(selector);
  }

  // export x -> 외부 접근 불가
  function each(list: any[]): void {}
}

// Dom에 있는 el 불러오면 접근 사용 가능
console.log(Dom.el("body"));
