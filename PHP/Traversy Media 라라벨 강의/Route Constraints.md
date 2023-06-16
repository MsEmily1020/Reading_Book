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
