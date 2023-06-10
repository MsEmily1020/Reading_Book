## 🔍 스프링 데이터와 스프링 데이터 JPA
스프링 데이터 spring data는 비즈니스 로직에 더 집중 할 수 있게 데이터베이스 사용 기능을 클래스 레벨에서 추상화함.

스프링 데이터에서 제공하는 인터페이스를 통해서 스프링 데이터를 사용할 수 있음.

이 인터페이스는 CRUD를 포함한 여러 메서드가 포함되어 있고, 알아서 쿼리를 만들어 줌.

<br>

각 데이터베이스의 특성에 맞춰 기능을 확장해 제공하는 기술도 제공.

표준 스펙인 JPA는 스프링에서 구현한 스프링 데이터 JPA를,

몽고디비는 스프링 데이터 몽고디비를 사용한다.

<br>

## 🔍 스프링 데이터 JPA란?

스프링 데이터의 공통적인 기능에서 JPA의 유용한 기술이 추가된 기술.

스프링 데이터의 인터페이스인 PagingAndSortingRepository를 상속받아 JpaRepository 인터페이스를 만듦.

JPA를 더 편리하게 사용하는 메서드 제공

<br>
 
```java
@PersistenceContext
EntityManager em;

public void join() {
    // 기존에 엔티티 상태를 바꾸는 방법(메서드 호출을 해서 상태 변경)
    Member member = new Member(1L, "홍길동");
    em.persist(member);
}
```

<br>

기본 CRUD 메서드를 사용하기 위한 JpaRepository 상속 예

```java
public interface MemberRepository extends JpaRepository<Member, Long> {
}
```

<br>

## 🔍 스프링 데이터 JPA에서 제공하는 메서드

```java
// 생성 Create
memberRepository.save(new Member(1L, "A"));

// 조회 Read
Optional<Member> member = memberRepository.findById(1L); // 단건 조회
List<Member> allMembers = memberRepository.findAll();    // 전체 조회

// 삭제 Delete
memberRepository.deleteById(1L);
```

1. save() : 데이터 객체 저장

    전달 인수로 엔티티 Member를 넘기면 반환값으로 저장된 엔티티 반환받을 수 있음

 

2. findById() : id를 지정해 엔티티 하나 조회 가능

    findAll() : 전체 엔티티 조회

 

3. deleteById() : id를 지정하면 해당 엔티티 삭제

    (delete()로 엔티티를 전달 인수로 넘겨 삭제 가능)
