class OnlyOne {
  private static instance: OnlyOne;

  public name: string;

  // private을 앞에 붙이면 인스턴스를 생성하지 못하도록 제한을 두고
  private constructor(name: string) {
    this.name = name;
  }

  // -> 오직 getInstance() static 메서드를 통해서만 단 하나의 객체를 생성할 수 있음.
  public static getInstance() {
    if (!OnlyOne.instance) {
      OnlyOne.instance = new OnlyOne("싱글턴 객체");
    }
    return OnlyOne.instance;
  }
}
