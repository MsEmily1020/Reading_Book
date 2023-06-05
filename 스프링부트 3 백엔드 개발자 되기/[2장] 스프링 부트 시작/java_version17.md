## 8. 🔍 자바 17버전
### ✔ """ 여러줄 텍스트 표현

```java
// 기존
String query11 = "SELECT * FROM item" +
                 "Hello" +
                 "World";
                 
// 바뀐 내용
String query17 = """
                 Select * FROM item
                 Hello
                 World
                 """;
 ```

<br> 

### ✔ formatted() 메서드


``` java
String textblock17 = """
{
    "id": %d,
    "name": %s
}
""".formatted(2, "juice");
```

해당 결과는 

%d에 2가 넣어지고

%s에 juice 값이 들어가짐.

<br>

### ✔ 레코드

데이터 전달을 목적으로 하는 객체를 더 빠르고 간편하게 만들기 위한 기능

상속할 수 없고, 파라미터에 정의한 필드는 private final로 정의.

private이라서 getter를 만들어줘야 하지만 레코드에서는 자동으로 만들기 때문에 따로 정의하지 않아도 괜찮음.


```java
recode Item(String name, int price) {
	// 파라미터 : private final로 정의
}

Item juice = new Item("juice", 3000);
juice.price(); // 3000
 ```

<br>

### ✔ 패턴 매칭
타입확인을 위한 instanceof + 형변환에서 다음과 같이 변경

``` java
// 11버전
if (o instanceof Integer) {
	Integer i = (Integer) o;
}

// 17버전
if(o instanceof Integer i) {
}
 ```

<br>

8.5. ✔ 자료형에 맞는 case 처리

```java
static double getIntegerValue(Object o) {
	return switch(o) {
    	case Double d -> d.intValue();
        case Float f -> f.intValue();
        case String s -> Integer.parseInt(s);
        default -> 0d;
    };
}
```
