## 🔍 Given-When-Then 패턴

```java
public void getAllMembers() throws Exception {

    // given
    final String url = "/test";
    Member savedMember = memberRepository.save(new Member(1L, "홍길동"));
    
    // when
    final ResultActions result = mockMvc.perform(get(url)	// 1
    	.accept(MediaType.APPLICATION_JSON));               	// 2
        
    // then
    result
    	.andExpect(status().isOk());				// 3
        
        // 4
        .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
        .andExpect(jsonPath("$[0].name").value(savedMember.getName()));

}
```

Given : 멤버를 저장

When : 멤버 리스트를 조회하는 API 호출

Then : 응답 코드가 200 OK이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인

<br>
 
1. perform() : 요청을 전송하는 역할하는 메서드

    결과로 resultActions 객체를 받고 반환값을 검증, 확인하는 andExpect()메서드를 제공해줌.
 

2. accept() : 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드

 

3. andExpect() : 응답을 검증

   OK(200)을 반환하므로 이에 해당하는 메서드 isOk를 사용해 확인하기

 

4. jsonPath("$[0].${필드명}") : JSON 응답값의 값을 가져오는 역할하는 메서드
 
   0번째 배열에 들어있는 객체의 id, name값 가져오고 저장된 값과 같은지 확인
   
<br>

| 코드	| 매핑 메서드 |	설명 |
| ----- | ---------- | --------- |
| 200 OK	| isOk()	| HTTP응답 코드가 200 OK인지 검증 |
| 201 Created	| isCreated()	| ... 201 Created인지 검증 |
| 400 Bad Request |	isBadRequest() |	... 400 Bad Request인지 검증 |
| 403 Forbidden	| isForbidden() |	... 403 Forbidden인지 검증 |
| 404 Not Found	| isNotFound() |	... 404 Not Found인지 검증 |
| 400번대 응답 코드	| is4xxClientError() |	...400번대 응답 코드인지 검증 | 
| 500 Internal Server Error |	isinternalServerError() |	... 500 Internal Server Error인지 검증 |
| 500번대 응답 코드	| is5xxServererror() |	...500번대 응답 코드인지 검증 | 
