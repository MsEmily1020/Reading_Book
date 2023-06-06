## 🔍 스프링 부트 스타터 테스트 목록

JUnit: 자바 프로그래밍 언어용 단위 테스트 프레임워크

     - 테스트 방식을 구분할 수 있는 애너테이션을 제공

     - @Test 애너테이션으로 메서드를 호출할 때마다 새 인스턴스를 생성, 독립 테스트 가능

     - 예상 결과를 검증하는 어설션 메서드 제공

     - 사용 방법이 단순, 테스트 코드 작성 시간이 적음

     - 자동 실행, 자체 결과를 확인하고 즉각적인 피드백을 제공

     - @DisplayName : 테스트 이름을 명시하는 애너테이션

     - assertEquals(기대하는 값, 실제로 검증할 값) : 검증 메서드

<br>

Spring Test & Spring Boot Test : 스프링 부트 애플리케이션을 위한 통합 테스트 지원

<br>

AssertJ : 검증문인 어설션을 작성하는 데 사용되는 라이브러리

 

     - JUnit과 함께 사용해 검증문의 가독성을 확 높여주는 라이브러리

     - Assertions.assertEquals(a + b, sum) -> assertThat(a + b).isEquals(sum) 가독성 높임

자주 사용하는 메서드

| 메서드 이름	| 설명 |
| ---------- | ------------- |
| isEqualTo(A) |	A값과 같은지 검증 |
| isNotEqualTo(A)	| A값과 다른지 검증 |
| contains(A)	| A 값을 포함하는지 검증 |
| doesNotContain(A) |	A 값을 포함하지 않는지 검증 |
| startsWith(A)	| 접두사가 A인지 검증 |
| endsWith(A)	| 접미사가 A인지 검증 |
| isEmpty()	| 비어있는 값인지 검증 | 
| isNotEmpty()	| 비어있지 않은 값인지 검증 |
| isPositive()	| 양수인지 검증 |
| isNegative()	| 음수인지 검증 | 
| isGreaterThan(1)	| 1보다 큰 값인지 검증 |
| isLessThan(1)	| 1보다 작은 값인지 검증 |
 

<br>

Hamcrest : 표현식을 보다 이해하기 쉽게 만드는 데 사용되는 Matcher 라이브러리

Mockito : 테스트에 사용할 가짜 객체인 목 객체를 쉽게 만들고, 관리하고, 검증할 수 있게 지원하는 테스트 프레임워크

JSONassert : JSON용 어설션 라이브러리

JsonPath : JSON 데이터에서 특정 데이터를 선택하고 검색하기 위한 라이브러리

 
