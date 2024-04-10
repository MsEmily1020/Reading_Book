class Model3<T> {
  constructor(private _data: T[] = []) {}

  add(item: T): void {
    this._data.push(item);
  }
}

function initializeModel<T extends Model3<U>, U>(
  C: new () => T,
  items: U[]
): T {
  const c = new C();
  return c;
}

initializeModel<Model3<string>, string>(Model3, ["타입"]);
