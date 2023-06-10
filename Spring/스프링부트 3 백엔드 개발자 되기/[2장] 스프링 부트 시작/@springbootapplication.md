## 🔍 @SpringBootApplication 이해하기

```java
@SpringBootApplication
public class SpringBootDeveloperApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDeveloperApplication.class, args);
  }
}
```
@SpringBootApplication : 스프링 부트 사용에 필요한 기본 설정

SprignApplication.run(메인 클래스 이름, 커맨드 라인의 인수들 전달) : 애플리케이션 실행

<br>

SpringBootApplication.java 구조

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration // 스프링 부트 관련 설정
@ComponentScan(excludeFilters = {
@Filter(type = FilterType.CUSTOM,
  // 사용자가 등록한 빈을 읽고 등록
  classes = TypeExcludeFilter.class),
  @Filter(type = FilterType.CUSTOM,
  classes = AutoConfigurationExcludeFilter.class)
})
@EnableAutoConfiguration // 자동으로 등록된 빈을 읽고 등록

public @interface SpringBootApplication { 
  // 생략
}
```

| 애너테이션 | 설명 |
| ------- | ----------- |
| @SpringBootConfiguration | <br> 스프링 부트 관련 설정을 나타내는 애너테이션 <br> @Configuration을 상속해서 만든 애너테이션 <br> @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration으로 이루어짐 <br><br> |
| @ComponentScan | <br> 사용자가 등록한 빈을 읽고 등록하는 애너테이션 <br> @Component 애너테이션을 가진 클래스들을 찾아 빈으로 등록하는 역할 <br> @Controller가 @ComponentScan을 통해 빈으로 등록되는 이유 <br> -> @Controller에서 @Component를 가지고 있음 <br> @Component를 가지고 있는 애너테이션 <br> @Controller, @RestController, @Configuration, @Repository, @Service <br><br> |
| @Configuration | <br> 설정 파일 등록하는 애너테이션 <br><br> |
| @Repository | <br> ORM 매핑하는 애너테이션 <br><br> |
| @Controller, @RestController | <br> 라우터 : HTTP 요청과 메서드를 연결하는 장치(클라이언트의 요청에 맞는 메서드를 실행) <br> @Controller + @ResponseBody = @RestController <br><br> |
| @Service | <br> 비즈니스 로직 <br><br> |
| @EnableAutoConfiguration | <br> 자동 설정으로 등록되는 빈을 읽고 등록하는 애너테이션 <br> (@ComponentScan과 무엇이 다른지?  -> 빈을 두번 등록함, @ComponentScan(처음) -> @EnableAutoConfiguration(추가적으로)) <br> 스프링 부트에서 자동 구성을 활성화하는 애터테이션 <br>스프링 부트 서버가 실행될 때 스프링 부트의 메타 파일을 읽고 정의된 설정들을 자동으로 구성하는 역할 <br><br> |

