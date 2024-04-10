function Write(able: boolean = true) {
  return function (t: any, p: string, d: PropertyDescriptor) {
    d.writable = able;
  };
}

class Button1 {
  constructor(public el: HTMLButtonElement) {}

  @Write(false) // false -> 외부에서 제거할 수 없음.
  disable() {
    this.el.setAttribute("disabled", "disabled");
  }
}

const btn = new Button1(<HTMLButtonElement>document.querySelector(".button"));
