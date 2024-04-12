interface ButtonInterface1 {
  onInit(): void;
  onClick(): void;
}

class Y9Button implements ButtonInterface1 {
  width: number;
  height: number;

  constructor(width, height) {
    this.width = width;
    this.height = height;
  }

  onInit(): void {}
  onClick(): void {}
}
