// 1. 함수 + 멀티 타입
type pairArray = [any, any][];

function pushPairItem<T, M>(arr: pairArray, item: [T, M]): pairArray {
  arr.push(item);
  return arr;
}

// 2. 팩토리 함수 + 멀티 타입
class Model2 {
  constructor(public options: any) {}
}

function create<T, U>(C: { new (U): T }, options: U): T {
  return new C(options);
}

create<Model2, string[]>(Model2, ["class type"]);
