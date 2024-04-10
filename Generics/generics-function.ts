// 기존
function getItemArray1(arr: any[], index: number): any {
  return arr[index];
}

// generics
function getItemArray2<T>(arr: T[], index: number): T {
  return arr[index];
}
