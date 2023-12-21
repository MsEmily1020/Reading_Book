# @NotNull, @NotEmpty, @NotBlank 의 차이점 및 사용법 + 예외 처리

@NotNull
  - null만 허용 안 함. ( "", " "은 허용 )
  - 모든 타입 사용 가능

        The annotated element must not be null. Accepts any type.
    
  - @Column(nullable = false)와 차이점

      > @NotNull : 데이터베이스 SQL 쿼리 보내기 전 예외 발생.
      
      > @Column(nullable=false) : JPA가 만든 엔티티의 필드 값이 null로 채워진 상태에서도 정상적으로 수행되다가 데이터베이스 쪽으로 SQL 쿼리가 도착한 순간에 테이블 컬럼의 NOT NULL 옵션에 의해 예외가 발생.
      
      -> 결론 : 서버와 DB의 안정성을 위해 @NotNull을 사용하기.

 <br>
  
@NotEmpty
  - null, "" 허용 안 함. ( " " 허용 )
  - 문자, Collection, 배열, 맵 사용 가능 ( ex. Boolean은 X )

        The annotatd element must not be null nor empty.
        Supported types are :

        - CharSequence (length of character sequence is evaluated)
        - Collection (collection size is evaluated)
        - Map (map size is evaluated)
        - Array (array length is evaluated)

<br>

@NotBlank
  - null, "", " " 허용 안 함.
  - 문자 사용 가능

        The annotated element must not be null and must contain at least one non-whitespace character. Accepts CharSequence.

예외 처리 방법

@Valid @RequestBody DTO 객체 형태로 요청 받아 유효성 검사 실패 시

MethodArgumentNotValidException이 발생함.

-> @ControllerAdvice로 예외 잡아 Error 메시지 return 시키기

