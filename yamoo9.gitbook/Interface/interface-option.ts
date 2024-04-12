interface ButtonInterface2 {
  // onInit?():void; -> 구현하지 않아도 됨.
  onInit(): void;
  onClick(): void;
}

class ButtonComponent implements ButtonInterface2 {
  onInit(): void {}
  onClick(): void {}
}
