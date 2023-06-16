### 초기화면 변경하기

- project 폴더 -> resources -> views -> welcome.blade.php에 작업
- welcome.blade.php에 있는 모든 내용 삭제 -> 다음 내용 추기
- 파일 이름 변경하기 welcome.blade.php -> listings.php

```php
<h1>Listings</h1>
```

- project 폴더 -> routes -> web.php에 작업
- 다음 내용으로 변경 (welcome 파일 -> listings 파일로 변경)

```php
Route::get('/', function() {
  return view('listings');
});
```

-> listings.php에 있는 내용이 화면에 보여짐 -> Lisings라는 문자열이 h1 크기로 보여짐

<br>

### view에 Data값 전달하기

- project 폴더 -> routes -> web.php에 작업
- 다음 내용으로 변경

```php
Route::get('/', function() { 
  return view('listings', ['heading' => 'Latest Listings']);
});
```

- project 폴더 -> resources -> views -> listings.php에 작업
- 다음 내용으로 변경

```php
<h1><?php echo $heading; ?></h1>
```

-> heading 변수에 Latest Listings 값을 넣어줌 -> php echo로 $heading 값 출력 -> Lastest Listings라는 문자열이 h1 크기로 보여짐

<br>

+ 배열 데이터값도 추가시키기

- project 폴더 -> routes -> web.php에 작업
- 다음 내용으로 변경

```php
Route::get('/', function () {
    return view('listings', ['heading' => 'Lastest Listings',
                             'listings' => [
                                [
                                    'id' => 1,
                                    'title' => 'Listing One',
                                    'description' => 'Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                    Quidem earum quia obcaecati tenetur ratione ullam ad repellat doloribus, placeat,
                                    in dolor veritatis voluptas aspernatur a sit qui suscipit beatae illum.'
                                ],

                                [
                                    'id' => 2,
                                    'title' => 'Listing Two',
                                    'description' => 'Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                    Quidem earum quia obcaecati tenetur ratione ullam ad repellat doloribus, placeat,
                                    in dolor veritatis voluptas aspernatur a sit qui suscipit beatae illum.'
                                ]
                             ]]);
});
```

- project 폴더 -> resources -> views -> listings.php에 작업
- 다음 내용으로 변경

```php
<h1><?php echo $heading ?></h1>
<?php foreach($listings as $listing): ?>
    <h2><?php echo $listing['title']; ?></h2>
    <p><?php echo $listing['description']; ?></p>
<?php endforeach; ?>
```

<br>

### blade.php와 .php의 차이점

- php -> '?php ?' 구문 사용

- blade.php -> {{ }}, @ 등 구문 사용

-> listings.blade.php로 변경한 경우 (결과값은 동일하나 코드 가독성 높일 수 있음)

```blade.php
<h1>{{$heading}}</h1>
@foreach($listings as $listing)
    
    <h2>
        {{$listing['title']}}
    </h2>
    <p>
        {{$listing['description']}}
    </p>

@endforeach
```

<br>

### listings 배열의 값이 없을 경우 NO 값 출력

문제 : 이런식으로 listings의 배열 길이가 0일 경우 No Listings found를 출력하고 싶다
```php
Route::get('/', function () {
    return view('listings', ['heading' => 'Lastest Listings',
                             'listings' => [
                             ]]);
});
```

<br>

1) if문 사용

- project 폴더 -> resources -> views -> listings.blade.php에 작업

```blade.php
@if(count($listings) == 0)
<p>No listings found<p>
@endif
```

<br>

2) unless 사용

```blade.php
@unless
...
@else
    <p>No listings found</p>
@endunless
```

