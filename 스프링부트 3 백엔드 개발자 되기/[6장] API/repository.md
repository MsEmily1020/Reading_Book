## 🔍 BlogRepository 인터페이스 생성

```java
// Article : 엔티티
// Long : 엔티티의 PK 타입
public interface BlogRepository extends JpaRepository<Article, Long> {
}
```
