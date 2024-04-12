class OnlyOne2 {
  private static instance: OnlyOne2;

  // 읽기 전용 속성
  public readonly name: string;

  private constructor(name: string) {
    this.name = name;
  }

  public static getInstance(name: string): OnlyOne {
    if (!OnlyOne2.instance) {
      OnlyOne2.instance = new OnlyOne2(name);
    }
    return OnlyOne2.instance;
  }
}

let special_one = OnlyOne2.getInstance("스페셜 원");
console.log(special_one);

// 오류 : 상수 또는 읽기 전용 속성이므로 name에 할당할 수 없음.
// special_one.name = "노멀원";
