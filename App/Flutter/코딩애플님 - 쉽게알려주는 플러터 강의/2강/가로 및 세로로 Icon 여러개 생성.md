# 가로 및 세로로 Icon 여러개 생성

```dart
MaterialApp(
  home: Scaffold(
    body: Row(또는 Column) (
      children: [
        Icon(Icons.start),
        Icon(Icons.start),
        Icon(Icons.start),
      ]
    ),
  )
);
```

가로 : Row() 안에 children : [ 여러 위젯 ]
세로 : Column() 안에 children : [ 여러 위젯 ]
