const someObject = {
  age: 35,
  gender: "male",
};

// const { age, gender }: { age: number; gender: string } = someObject;

interface User {
  age: number;
  gender: string;
}

const { age, gender }: User = someObject;
