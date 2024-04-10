function Component(target: Function) {
  let $ = target.prototype;

  $.type = "component";
  $.version = "0.0.1";
}

@Component
class TabsComponent {}

const tabs = new TabsComponent();

console.log((tabs as any).type); // component 출력

// 클래스 재정의 (우선시)
function Component<T extends new (...args: any[]) => {}>(target: T) {
  return class extends target {
    type: string = "component";
    version: string = "0.1.0";

    open() {}
    close() {}
  };
}

@Component
class TabsComponent1 {
  el: HTMLElement;

  constructor(el: HTMLElement) {
    this.el = el;
  }

  open() {}
}

const tabs = new TabsComponent1(document.querySelector(".tab"));

console.log((tabs as any).type); // component 출력

// 클래스 팩토리
type ComponentType = {
  el: string;
  [prop: string]: any;
};

function Component(options: ComponentType) {
  const _el = document.querySelector(options.el);
  return function Component<T extends new (...args: any[]) => {}>(target: T) {
    return class extends target {
      el: HTMLElement = <HTMLElement>_el;
    };
  };
}

@Component({
  el: ".tabs",
})
class TabsComponent2 {}

const tabs = new TabsComponent2();
console.log((tabs as any).el);
