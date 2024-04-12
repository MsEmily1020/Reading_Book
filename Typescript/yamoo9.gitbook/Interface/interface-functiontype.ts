const factorial4 = (n: number): number => {
  if (n === 0) {
    return 0;
  }

  if (n === 1) {
    return 1;
  }

  return n * factorial4(n - 1);
};

interface FactorialInterface {
  (n: number): number;
}

const facto: FactorialInterface = (n) => {
  if (n === 0) {
    return 0;
  }

  if (n === 1) {
    return 1;
  }

  return n * facto(n - 1);
};
