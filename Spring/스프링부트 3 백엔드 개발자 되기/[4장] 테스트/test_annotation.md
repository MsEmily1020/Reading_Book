## 🔍테스트 코드 애너테이션 정리

@DisplayName : 테스트 이름 명시

<br>

@Test : 이를 붙인 메서드는 테스트를 수행하는 메서드가 됨.

<br>

@SpringBootTest : 메인 애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplication이 있는 클래스를 찾고 그 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트라는 것을 만듦. 

<br>

@AutoConfigureMockMvc : MockMvc를 생성하고 자동으로 구성

MockMvc : 어플리케이션을 서버에 배포하지 않고도 테스트용 MVC환경을 만들어 요청 및 전송, 응답 기능을 제공하는 유틸리티 클래스. 즉, 컨트롤러를 테스트할 때 사용되는 클래스.

<br>

@BeforeEach : 테스트를 실행하기 전 실행하는 메서드에 적용

<br> 

@AfterEach : 테스트를 실행한 이후에 실행하는 메서드에 적용
