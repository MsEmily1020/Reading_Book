### 매개변수 요청 객체 받아오기

- 서버 : http://127.0.0.1:8000/search?name={name}
- 쿠키, 헤더, 파일 등 여러 정보가 화면에 띄워진다.

```php
Route::get('/search', function(Request $request) {
  dd($request);
});
```

<br>

### Request의 값 출력

- http://127.0.0.1:8000/search?변수=값...
- 변수가 name, city인 값 출력하기
- ex) http://127.0.0.1:8000/search?name=Name&city=Seoul
-> Name Seoul 출력

```php
Route::get('/search', function(Request $request) {
  return $request->name.' '.$request->city;
});
```
