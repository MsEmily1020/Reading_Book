class Model {
  private _data: any[] = [];

  constructor(data: any[]) {
    this._data = data;
  }

  get data(): any {
    return this._data;
  }

  add(item: any): void {
    this._data.push(item);
  }
}

class ObjectModel extends Model {
  constructor(data: object[] = []) {
    super(data);
  }

  add(item: object): void {
    super.add(item);
  }
}
