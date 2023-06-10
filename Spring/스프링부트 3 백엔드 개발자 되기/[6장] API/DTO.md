## 🔍 컨트롤러에서 요청 본문을 받을 객체 생성

```java
@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        // 빌더 패턴을 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
```
<br>

## 🔍 GET 요청에서 응답을 위한 DTO

```java
@Getter
public class ArticleResponse {
    private final String title;     // 제목
    private final String content;   // 내용

    // 엔티티 Article을 인수로 받음
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
```

## 🔍 블로그 글 수정 요청 받을 DTO

```java
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;
}

```
