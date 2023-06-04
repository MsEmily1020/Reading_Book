## 1. 🛠 build.gradle 파일 수정

``` java
// 1.
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.0.2'
    id 'io.spring.dependency-management' version '1.1.0'
}

// 2.
group = 'me.kimhyeseung' // 'me.kimhyseung' 같은 경우에는 자신이 만들었던 GroupId 쓰기
version = '1.0'
sourceCompatibility = '17'

// 3.
repositories {
    mavenCentral()
}

// 4.
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
    useJUnitPlatform()
}
```

<br>

1. 프로젝트에 사용할 플러그인인 스프링 부트 플러그인 org.springframework.boot와
   스프링의 의존성을 자동 관리하는 spring.dependency-management 추가
   
2. 자바 소스 컴파일할 때 사용할 자바 버전 '17' 입력

3. 의존성을 받을 저장소 지정 (기본값 : mavenCentral)

4. 프로젝트를 개발하며 필요한 기능의 의존성 입력
   - 웹 관련 기능 제공하는 spring-boot-starter-web과
   - 테스트 기능을 제공하는 spring-boot-starter-test 추가

<br>

## 2. ✅ 메인 클래스 생성

``` java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
```
