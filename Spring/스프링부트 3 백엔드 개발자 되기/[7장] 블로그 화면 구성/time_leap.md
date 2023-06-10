## 🔍 타임 리프란?

타임 리프는 템플릿 엔진이다.

템플릿 엔진 : 스프링 서버에서 데이터를 받아 HTMl 상에 그 데이터를 넣어 보여주는 도구.

- HTMl과 함께 템플릿 엔진을 위한 문법을 살짝 섞어 사용
- 스프링은 타임리프를 권장

<br>

## 🔍 템플릿 엔진 개념

- 대표적으로 JSP, 타임리프, 프리마커 등이 있음

```
{
  이름: "홍길동",
  나이: 11
}

<h1 text=${이름}>
<p text=${나이}>
```

<br>

### ✔ 타임리프 표현식과 문법

| 표현식 | 설명 |
| ------- | ---------- |
| ${...} | 변수의 값 표현식 |
| #{...} | 속성 파일 값 표현식 |
| @{...} | URL 표현식 |
| *{...} | 선택한 변수의 표현식. th:object에서 선택한 객체에 접근 | 

<br>

| 표현식 | 설명 | 예제 |
| ------- | ---------- | ----------- |
| th:text |  텍스트를 표현할 때 사용 | th:text=${person.name} |
| th:each | 컬렉션을 반복할 때 사용 | th:each="person : ${persons}" |
| th:if | 조건이 true일 때만 표시 | th:if="${person.age} >= 20" |
| th:unless | 조건이 false일 때만 표시 | th:unless = "${person.age} >= 20" |
| th:href | 이동 경로 | th:href="@{/persons(id=${person.id})}" |
| th:with | 변숫값으로 지정 | th:with="name=${person.name}" |
| th:object | 선택한 객체로 지정 | th:object="${person}" |

