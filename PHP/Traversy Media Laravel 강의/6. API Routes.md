### API 만들기

- project폴더 -> routes -> api.php에서 작업
- 서버 : http://127.0.0.1:8000/api/posts
- json api 확인 가능

```php
Route::get('/posts', function() {
  return response() -> json([
    'posts' => [
      [
        'title' => 'Post One'
      ]
    ]
  ]);
});
```
