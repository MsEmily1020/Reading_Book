function logProp(t: any, p: string) {
  let v = t[p];

  let getter = function () {
    return v;
  };

  let setter = function (new_v: any) {
    v = new_v;
  };

  if (delete t[p]) {
    Object.defineProperty(t, p, {
      get: getter,
      set: setter,
      enumerable: true,
      configurable: true,
    });
  }
}

class Button {
  @logProp
  type: string = "button";

  @logProp
  version: string = "0.0.2";

  constructor(public el: HTMLButtonElement) {}
}
