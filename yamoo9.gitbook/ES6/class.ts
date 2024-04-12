// 클래스
// private, default, protected, public
// 생성자
// static
class Book {
  private title: string;
  private author: string;
  public pages: number;
  static PI: number = Math.PI;

  constructor(title, author, pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
    this.init();
  }

  private init(): void {}

  protected changePaperType(type: string): void {}

  public setManufacturingPlant(plant: string): void {}

  static calcCircumference(radius: number): number {
    return this.PI * radius * 2;
  }
}

// 상속 클래스 (super())
class E_Book extends Book {
  pages = 20;

  constructor(
    title: string,
    author: string,
    pages: number,
    public is_downloadable: boolean
  ) {
    super(title, author, pages);
    this.is_downloadable = is_downloadable;
  }
}

let book = new Book("제목", "작가", 10);
console.log(book);
console.log(book.setManufacturingPlant("plant"));

// 추상 클래스
abstract class Project {
  public project_name: string | null = null;
  private budget: number = 20000000;

  // 추상 메서드
  public abstract changeProjectName(name: string): void;

  public calcBudget(): number {
    return this.budget * 2;
  }
}

class WebProject extends Project {
  // 추상 메서드 반드시 구현
  public changeProjectName(name: string): void {
    this.project_name = name;
  }
}

let new_project = new WebProject();
console.log(new_project);
