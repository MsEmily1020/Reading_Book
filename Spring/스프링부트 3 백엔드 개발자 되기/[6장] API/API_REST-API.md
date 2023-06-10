## 🔍 API

예시) 식당으로 보는 API

| 식당 | 프로그램 |
| ----- | -------- |
| 손님 | 클라이언트|
| 점원 | API |
| 주방 | 서버 |

손님이 요청시, 점원이 듣고 주방에 해당 내용을 전달하고,

주방은 다시 점원에게 해당 요청 사항을 준 다음, 점원이 손님에게 전달하는 방식

정리 -> 클라이언트의 요청을 서버에 전달하고 서버의 결과물을 클라이언트에게 돌려주는 역할

<br>

## 🔍 REST API

Representational State Transfer의 약자

자원을 이름으로 구분해 자원의 상태를 주고받는 API 방식을 말함.

쉽게 말해서 명확하고 이해하기 쉬운 API

REST API는 URL의 설계 방식을 말함.

REST하게 디자인한 API를 RESTful API라고 부르기도 함.

<br>

### ✔ 특징

서버/클라이언트 구조, 무상태, 캐시 처리 가능, 계층화, 인터페이스 일관성 등...

<br>

### ✔ 장점

URL만 보고도 무슨 행동을 하는 API인지 명확하게 알 수 있음. -> 강력한 장점!!!

상태가 없다는 특징 -> 클라이언트와 서버의 역할 명확하게 분리

HTTP 표준을 사용하는 모든 플랫폼에서 사용할 수 있음.


<br>

### ✔ 단점

HTTP 메서드, 즉 GET, POST와 같은 방식의 개수 제한

설계를 하기 위해 공식적으로 제공되는 표준 규약이 없음

<br>

## 🔍 REST API 사용 방법

### ✔ URL에는 동사 x, 자원을 표시

```
./students/1 -> restfult api
./get.student?student_id=1
```

예시 ) get 또는 show 등 다양한 표현으로 명확히 알기 어려움

```
/articles/1         -> 적합

-> 부적합
/articles/show/1
/show/articles/1
```

<br>

### ✔ 동사는 HTTP 메서드

HTTP 메서드 : 서버에 요청을 하는 방법 나눈 것

대표적으로 POST(만들기), GET(읽기), PUT(업데이트), DELETE(삭제하기)가 있음 -> CRUD 작업

| 설명 | 적합한 HTTP 메서드와 URL |
| --------- | ------------------ |
| id가 1인 블로그 글 조회 | GET/articles/1 |
| 블로그 글 추가하는 API | POST/articles |
| 블로그 글 수정하는 API | PUT/articles/1 |
| 블로그 글 삭제하는 API | DELETE/articles/1 |

