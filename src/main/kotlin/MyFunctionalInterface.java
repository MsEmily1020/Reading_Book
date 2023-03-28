// 함수형 인터페이스 : 인터페이스인데 추상 메서드(실행 문장 없는 메소드)가 하나인 인터페이스
@FunctionalInterface
public interface MyFunctionalInterface {
    public String method(Integer i);    // 추상 메소드(실행 문장 없는 메소드)
    // public String method(Integer i);  1개만 있어야 함
}