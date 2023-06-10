### 6. 🔍 자바 애너테이션

자바 애너테이션(java annotation)은 자바로 작성한 코드에 추가하는 표식.

보통 @ 기호를 사용하며 JDK 1.5버전부터 사용할  수 있습니다.

보통은 메타 데이터로 사용하는 경우가 가장 많습니다.

<br>

대표적인 애너테이션으로는 다음과 같습니다.

| 애너테이션 | 내용|
| ---------- | ---------|
| @Override | 선언된 메서드가 오버라이드 되었음 |
| @Deprecated | 더 이상 사용되지 않음 |
| @SuppressWarnings | 컴파일 경고를 무시함 |

<br>

``` java
public class A extends B {
  @Override // 선언된 메서드가 오버라이드 되었음을 나타냄
  public void print() {
   System.out.println("Hello World");
  }
}
```
