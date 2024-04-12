function Log(t: any, p: string, i: number) {}

class Button2 {
  el: HTMLButtonElement;
  color: string;

  constructor(@Log el: HTMLButtonElement, @Log color: string = "transparent") {
    this.el = el;
    this.color = color;
  }

  static initialize(@Log els: NodeList, @Log color: string = "transparent") {
    return [].slice.call(els).map((el) => new Button(el, color));
  }
}
