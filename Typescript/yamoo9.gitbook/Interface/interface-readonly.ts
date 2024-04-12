interface Notebook {
  readonly CPU: string;
  readonly RAM: string;
}

let macbook: Notebook = {
  CPU: "2.9GHz 코어 i9",
  RAM: "32GB",
};

// 읽기 전용이므로 할당하지 못함.
// macbook.RAM = "128GB";
