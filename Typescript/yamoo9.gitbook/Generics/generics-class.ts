class Model1<T> {
  private _data: T[] = [];

  constructor(data: T[] = []) {
    this._data = data;
  }

  get data(): T[] {
    return this.data;
  }
}

const stringModel = new Model1<string>();
