## 🔍 BlogAPIControllerTest

```java
@SpringBootTest // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성

class BlogApiControllerTest {
  @Autowired
  protected MockMvc mockMvc;
  
  @Autowired
  protected ObjectMapper objectMapper; // 직렬화(자바 객체 -> JSON), 역직렬화(JSON -> 자바 객체) 위한 클래스
  
  @Autowired
  protected WebApplicationContext context;
  
  @Autowired
  BlogRepository blogRepository;
  
  // 테스트 실행 전 실행하는 메서드
  @BeforeEach
  public void mockMvcSetUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
      .build();
    blogRepository.deleteAll();
  }
  
  // 추가하기
  @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
  @Test
  public void addArticle() throws Exception {
    
    // given
    final String url = "/api/articles";
    final String title = "title";
    final String content = "content";
    final AddArticleRequest userRequest = new AddArticleRequest(title, content);
    
    // writeValueAsString : 객체 -> JSON 직렬화
    final String requestBody = objectMapper.writeValueAsString(userRequest);
    
    // when
    // 설정한 내용을 바탕으로 요청 전송
    ResultActions result = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)  // 요청을 보낼 때 JSON 타입으로 요청 보낸다고 명시함.
        .content(requestBody));
        
   // then
   result.andExpect(status().isCreated());
   
   List<Article> articles = blogRepository.findAll();
   
   assertThat(articles.size()).isEqualTo(1);  // 크기가 1인지 검증
   asswerThat(articles.get(0).getTitle()).isEqualTo(title);
   asswerThat(articles.get(0).getContent()).isEqualTo(content);
  }
  
  // 글 전체 조회하기
  @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다.")
  @Test
  public void findAllArticles() throws Exception {
    
    // given
    final String url = "/api/articles";
    final String title = "title";
    final String content = "content";
    
    blogRepository.save(Article.builder()
        .title(title)
        .content(content)
        .build());
        
    // when
    final ResultActions resultActiosn = mockMvc.perform(get(url)
        .accept(MediaType.APPLICATION_JSON));
        
    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].content").value(content))
        .andExpect(jsonPath("$[0].title").value(title));
  }
  
  // id 글 조회
  @DisplayName("findArticle: 블로그 글 조회에 성공한다.")
  @Test
  public void findArticle() throws Exception {
    
    //given
    final String url = "/api/articles/{id}";
    final String title = "title";
    final String content = "content";
    
    Article savedArticle = blogRepository.save(Article.builder()
        .title(title)
        .content(content)
        .build());
        
    // when
    final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId()));
    
    // then
    resultActions.
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content").value(content))
        .andExpect(jsonPath("$.title").value(title));
  }
  
  @DisplayName("deleteArticle: 블로그 글 삭제에 성공한다.")
  @Test
  public void deleteArticle() throws Exception {
    
    //given
    final String url = "/api/articles/{id}";
    final String title = "title";
    final String content = "content";
    
    Article savedArticle = blogRepository.save(Article.builder()
        .title(title)
        .content(content)
        .build());
        
    // when
    mockMvc.perform(delete(url, savedArticle.getId()))
        .andExpect(status().isOk());
        
    // then
    List<Article> articles = blogRepository.findAll();
    
    asserThat(articles).isEmpty();
  }
  
  @DisplayName("updateArticle: 블로그 글 수정에 성공한다.")
  @Test
  public void updateArticle() throws Exception {
    
    // given
    final String url = "/api/articles/{id}";
    final String title = "title";
    final String content = "content";
    
    Article savedArticle = blogRepository.save(Article.builder()
        .title(title)
        .content(content)
        .build());
        
    final String newTitle = "new title";
    final String newContent = "new content";
    
    UpdateArticleRequest request = new UpdateArticleRequest(newTitle, newContent);
    
    // when
    resultActions result = mockMvc.perform(put(url, savedArticle.getid())
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(request)));
        
    // then
    result.andExpect(status().isOk());
    
    Article article = blogRepository.findById(savedArticle.getId()).get();
    
    assertThat(article.getTitle()).isEqualTo(newTitle);
    assertThat(article.getContent()).isEqualTo(newContent);
  }
}
```

<br>

## 🔍 Given-When-Then 패턴

### ✔ 추가

| 패턴 | 내용 |
| ----- | -------- |
| Given | 블로그 글 추가에 필요한 요청 객체 만듦 |
| When | 블로그 글 추가 API에 요청을 보냄. (JSON타입으로 보내고 given절에서 미리 만들어둔 객체를 함께 보냄) |
| Then | 응답 코드가 201 created인지, 전체 조회 크기가 1인지 확인하고 실제 저장된 데이터와 요청 값을 비교 |

<br>

### ✔ 글 전체 조회

| 패턴 | 내용 |
| ----- | -------- |
| Given | 블로그 글 저장 |
| When | 목록 조회 API 호출 |
| Then | 응답 코드가 200 OK, 반환값 중 0번째 요소의 content = title 확인하기 |

<br>

### ✔ id 글 조회


| 패턴 | 내용 |
| ----- | -------- |
| Given | 블로그 글 저장 |
| When | 저장된 블로그 글의 id값으로 API 호출 |
| Then | 응답 코드가 200 OK, 반환값 content = title 확인하기 |

<br>

### ✔ 삭제

| 패턴 | 내용 |
| ----- | -------- |
| Given | 블로그 글 저장 |
| When | 저장한 블로그 글의 id값으로 삭제 API 호출 |
| Then | 응답 코드가 200 OK, 전체 리스트 조회한 배열 크기가 0인지 확인 |

<br>

### ✔ 수정

| 패턴 | 내용 |
| ----- | -------- |
| Given | 블로그 글 저장, 블로그 글 수정에 필요한 요청 객체 만듦 |
| When | UPDATE API로 수정 요청을 보냄(JSON 타입으로 given절에서 미리 만들어둔 객체를 함께 보냄) |
| Then | 응답 코드가 200 OK, 블로그 글 id로 조회한 후 값이 수정되었는지  |

<br>

## 🔍 asserThat() 메서드

| 코드 | 설명 |
| ------ | ----------- |
| asserThat(articles.size()).isEqualTo(1); | 블로그 글 크기가 1이어야 함 |
| asserThat(articles.size()).isGreaterThan(2); | 블로그 글 크기가 2보다 커야 함 |
| asserThat(articles.size()).isLessThan(5); | 블로그 글 크기가 5보다 작아야 함 |
| asserThat(articles.size()).isZero(); | 블로그 글 크기가 0이어야 함 |
| asserThat(articles.title()).isEqualTo("제목"); | 블로그 title값이 "제목"이어야 함 |
| asserThat(articles.title()).isNotEmpty(); | 블로그 title값이 비어 있지 않아야 함 |
| asserThat(articles.title()).contains("제"); | 블로그 title값이 "제"를 포함해야 함 |
