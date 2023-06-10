## 🔍 BlogRepository 인터페이스 생성

```java
public interface BlogRepository extends JpaRepository<Article, Long> { // <엔티티, 엔티티의 기본키 타입>
}

```
