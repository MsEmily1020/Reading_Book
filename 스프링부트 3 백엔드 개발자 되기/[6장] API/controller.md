## 🔍 컨트롤러 메서드 작성

```java
@RequiredArgsController
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {
  private final BlogService blogService;
  
  // HTTP 메서드가 POST일 때 전달받은 URL와 동일하면 메서드로 매핑
  // /api/articles는 addArticle() 메서드에 매핑
  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
  // @RequestBody : HTTP를 요청할 때 응답에 해당하는 값을 AddArticleRequest에 매핑
    
    Article savedArticle = blogService.save(request);
    
    // 요청한 자원이 성공적으로 생성(*201), 저장된 블로그 글 정보를 응답 객체에 담아 전송
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(savedArticle);
  }
  
  // 전체 글을 조회한 뒤 반환하는 메서드
  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticles() {
  
    // findAll() : GET 요청이 오면 글 전체 조회 메서드
    List<ArticleResponse> articles = blogService.findAll()
      .stream()
      .map(ArticleResponse::new)
      .toList();
     
     // 클라이언트에 전송
     return ResponseEntity.ok()
            .body(articles);
  }
  
  // GET 요청 시 블로그 글 조회하기 위해 매핑할 메서드
  @GetMapping("/api/articles/{id}")
  // URL 경로에서 값 추출
  public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
    Article article = blogService.findById(id);
    
    return ResponseEntity.ok()
      .body(new ArticleResponse(article));
  }
}
```

### * 응답 코드

| 코드 | 설명 |
| ---- | ------- |
| 200 OK | 요청 성공 |
| 201 Created | 요청 성공 + 새로운 리소스 생성되었음 |
| 400 Bad Request | 요청 값 잘못되어 요청 실패 |
| 403 Forbidden | 권한이 없어 요청 실패 |
| 404 Not Found | 요청 값으로 찾은 리소스가 없어 요청 실패 |
| 500 Internal Server Error | 서버 상 문제가 있어 요청 실패 |
