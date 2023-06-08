```java
// 빈을 생성자로 생성하는 롬복 지원 애너테이션
// final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@RequiredArgsConstructor
// 해당 클래스를 빈으로 서블릿 컨테이너에 등록
@Service
public class BlogService {
  private final BlogRepository blogRepository;
  
  // 블로그 글 추가 메서드
  // JpaRepository에서 지원하는 저장 메서드 save()로 AddArticleRequest에 저장된 값들을 article 데이터베이스에 저장
  public Article save(AddArticleRequest request) {
    return blogRepository.save(request.toEntity());
  }
  
  // article 테이블 데이터베이스에 저장되어 있는 글 모두 가져오는 메서드
  // findAll() : JPA 지원 메서드
  public List<Article> findAll() {
    return blogRepository.findAll();
  }
  
  // 블로그 글 하나 조회하는 메서드
  public Article findById(long id) {
    return blogRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("not found: " + id)); // ID를 받아 엔티티 없을 경우 예외 발생시킴
  }
  
  // 해당 글의 ID 데이터베이스 데이터 삭제하는 메서드
  public void delete(long id) {
    blogRepository.deleteById(id);
  }
}
```
