## 🔍 엔티티의 상태
 
```java
public class EntityManagerTest {
    @Autowired
    EntitiyManger em;
    
    public void example() {
    	// 1. 비영속 상태
        Member member = enw Member(1L, "홍길동");
        
        // 2. 관리 상태
        em.persist(member);
        
        // 3. 분리 상태
        em.detach(member);
        
        // 4. 삭제 상태
        em.remove(member);
    }
}
```

<br>

### ✔ 비영속 상태
엔티티를 처음 만들면 엔티티는 비영속 상태

엔티티 매니저가 엔티티를 관리하지 않은 상태를 말함.

<br> 

### ✔ 관리 상태
persist() 메서드를 사용해 이 상태로 만들 수 있음.

<br>

### ✔ 분리 상태
만약 엔티티를 영속성 컨텍스트에서 관리하고 싶지 않다면 detach()메서드를 사용해서 분리할 수 있음.

<br>

### ✔ 삭제 상태
더 이상 객체가 필요 없다면 remove() 메서드를 사용해 엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제 가능
