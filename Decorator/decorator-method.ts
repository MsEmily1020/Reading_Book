function Write(able: boolean = true) {
  return function (t: any, p: string, d: PropertyDescriptor) {
    d.writable = able;
  };
}

class Button1 {
  constructor(public el: HTMLButtonElement) {}

  @Write(false)
  disable() {
    this.el.setAttribute("disabled", "disabled");
  }
}

const btn = new Button1(<HTMLButtonElement>document.querySelector(".button"));
