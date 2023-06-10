## 4. 🔍 스프링 콘셉트 공부하기

### ✔ 제어의 역전 IoC란?
Inversion of Control 약자로, 외부에서 관리하는 객체를 가져와 사용하는 것을 말함.
    
```java
public class A {
	public B b; // 코드에서 객체를 생성하지 않고 어디선가 받아온 객체를 b에 할당
}
```

```java
// 일반적인 코드
public class A {
	B b = new B();
}

// 코드에서 객체를 생성하지 않음, 어디선가 받아온 객체를 b에 할당
public class IoC {
    B b;
    IoC(B b) {
    	this.b = b;
    }
}
```
 
<br>

### ✔ 의존성 주입 DI란?

Dependency Injection 약자로, 제어의 역전을 구현하기 위한 의존성 주입 방법.

DI는 어떤 클래스가 다른 클래스에 의존한다는 뜻

```java
public class A {
   // A에서 B를 주입받음
   @Autowired
   B b;
}
```

@Autowired 애니테이션 : 스프링 컨테이너에 있는 빈을 주입하는 역할

(빈 : 스프링 컨테이너에서 관리하는 객체)

-> 기존 자바 코드 : 클래스 A에서 직접 B 객체를 생성 했음

-> 스프링 : 스프링 컨테이너에서 객체를 주입받아 사용함.

 

