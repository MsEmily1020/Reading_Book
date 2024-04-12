// let members = ["이권", "감장겸", "장도일"];

// 오류 : number[] 형식은 string[] 형식에 할당할 수 없음.
// members = [9, 13, 26]

let members1: string[] = ["이권", "감장겸", "장도일"];

let members2: any[] = [{ name: "이권" }, "감장겸", ["장도일"]];

// number 형식은 any[] 형식에 할당할 수 없음.
// members2 = 209;

let nums: number[] = [100, 101, 102];
let strs: string[] = ["ㄱ", "ㄴ", "ㄷ"];
let boos: boolean[] = [true, false, true];
let anys: any[] = [100, "ㄴ", true];
let selects: (number | string)[] = [102, "o"];
