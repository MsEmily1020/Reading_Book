### id값 매개변수를 받는 주소

- http://127.0.0.1:8000/posts/{id}
- id값을 입력하면 화면에 Post {id}가 보임
- ex) id = 10 -> Post 10이 보임
- 문제점 : 숫자가 아닌 문자열 값이 들어가도 그대로 출력.

```php
Route::get('/posts/{id}', function($id) {
  return response('Post '.$id);
});
```

<br>

### 제약 조건 추가

- 문제점 : 숫자가 아닌 문자열 값이 들어가도 그대로 출력.

<br>

-> 정규식 [0-9]+ 사용

-> 해결 : 문자열은 404 | NOT FOUND를 띄움

```php
Route::get('/posts/{id}', function($id) {
  return response('Post '.$id);
}) -> where('id', '[0-9+]+');
```

<br>

### dd(), ddd()

1) dd()
- dd()는 "Dump and Die"를 의미
- 변수를 읽기 위해 return 전에 dd()를 사용
- 페이지에서 dd() 결과를 볼 수 없으며 브라우저의 네트워크 탭을 통해 결과를 볼 수 있습니다(페이지를 검사하는 경우).

```php
Route::get('/posts/{id}', function($id) {
  dd($id);
  return response('Post '.$id);
}) -> where('id', '[0-9+]+');
```
<br>

2) ddd()
- ddd()는 "Dump and Die and Debug"를 의미
- 코드를 보여주며 중단점을 보여주는 등 다양한 정보 띄움

```php
Route::get('/posts/{id}', function($id) {
  ddd($id);
  return response('Post '.$id);
}) -> where('id', '[0-9+]+');
```
