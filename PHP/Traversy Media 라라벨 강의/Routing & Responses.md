### 서버
- http://127.0.0.1:8000/

<br>

### Route 기본 구조
    Route:메소드(array('key값'=>'value값', 'key값'=>'value값'....)), 실행할함수명(){...}

<br>

### 1. 기본 get()

- project폴더 -> routes -> web.php에서 작업
- http://127.0.0.1:8000/hello
- 해당 주소에 들어가면 'Hello World'가 보임

```php
Route::get('/hello', function() {
  return 'Hello World';
});
```

<br>

### 2. response('문자열', http상태)

- project폴더 -> routes -> web.php에서 작업
- http://127.0.0.1:8000/hello

<br>

- html을 직접 넣을 수 있음
- 해당 주소에 들어가면 h1 크기로 Hello World가 보임
- F12 개발자도구에서 200 응답을 확인할 수 있음 (기본값 : 200)

```php
Route::get('/hello', function() {
  return response('<h1>Hello World</h1>', 200);
});
```

<br>

### 3. header 추가하기

- project폴더 -> routes -> web.php에서 작업
- http://127.0.0.1:8000/hello
- html을 직접 넣을 수 있음
- 해당 주소에 들어가면 h1 크기로 Hello World가 보임
- F12 개발자도구에서 200 응답을 확인할 수 있음 (기본값 : 200)

<br>

- 'Content-Type' : 해당 문서를 플레인 텍스트로 만들어 HTML 태그까지 모두 보여주는 데이터 타입 -> html을 렌더링하지 않음
- F12 개발자도구에서 해당 header가 추가

```php
Route::get('/hello', function() {
  return response('<h1>Hello World</h1>', 200)
    ->header('Content-Type', 'text/plain')
    ->header('foo', 'bar');
});
```
