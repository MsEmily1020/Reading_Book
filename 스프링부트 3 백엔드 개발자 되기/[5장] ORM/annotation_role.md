## 🔍 애너테이션 역할 정리
### ✔ @Entitiy : 엔티티로 지정
### ✔ @NoArgsConstructor(access = AccessLevel.PROTECTED)
       // protected 제어자를 가진 기본 생성자 생성
 

### ✔ @Id : id 필드를 가진 기본키 지정
### ✔ @GeneratedValue(strategy = GenerationType.IDENTITY) : 자동 1씩 증가
       IDENTITY = AUTO_INCREMENT와 동일

 

### ✔ @Column(name = "name", nullable = false)
       name이라는 not null 컬럼과 매핑
