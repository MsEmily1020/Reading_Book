interface OnInitInterface {
  onInit(): void;
  initialize(): void;
}

const o = {
  onInit(): void {},
  initialize(): void {},
};

function ready(m: OnInitInterface): void {
  m.onInit();
  m.initialize();
}

ready(o);
