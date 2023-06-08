## 🔍 application.yml

```
spring:
  jpa:
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    defer-datasource-initialization: true
  
  datasource:
    url: jdbc:h2:mem:testdb
    
  h2:
    console:
      enabled: true
```

## 🔍 data.sql

```sql
INSERT INTO article (title, content) VALUES ('제목 1', '내용 1')
INSERT INTO article (title, content) VALUES ('제목 2', '내용 2')
INSERT INTO article (title, content) VALUES ('제목 3', '내용 3')
```
