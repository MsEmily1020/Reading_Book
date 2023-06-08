### ✔ 엔티티와 매핑되는 테이블

| 컬럼명 | 자료형 | null 허용 | 키 | 설명 |
| ------ | ------ | ------- | -------- | ------------ |
| id | BIGINT | N | 기본키 | 일련번호, 기본키 |
| title | VARCHAR(255) | N |  | 게시물의 제목 |
| content | VARCHAR(255) | N | | 내용 |

<br>

package.domain에 Article.java파일 만들기

```java
@Entity // 엔티티로 지정
@Getter // getter 자동생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected 제어자로 기본 생성자 만들기
public class Article {

  @Id // id 필드를 기본키로 지정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
  @Column(name = "id", updateable = false)
  private Long id;
  
  @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
  private String title;
  
  @Column(name = "content", nullable = false)
  private String content;
  
  @Builder // 빌더 패턴으로 객체 생성
  public Article(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
```

<br> 

### ✔ 빌더 패턴

```java
// 빌더 패턴을 사용 x
new Article("abc", "def");

// 빌더 패턴 사용
Article.builder()
  .title("abc")
  .content("def")
  .build();
```

-> 어느 필드에 어느 값이 매칭되는지 바로 보여 객체 생성 코드의 가독성 높임,

    @Builder : 빌더 패턴을 사용하기 위한 코드를 자동 생성
