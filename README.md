## 💻 BMI 계산 프로그램(calculator) GUI
- 자신의 체중과 키를 입력하여 BMI 수치 계산(저체중, 정상, 과체중, 비만, 고도비만)

## ⌚ Project execution period
  - 2022.12.29

## 🛠 Development Environment
- MVC (모델-뷰-컨트롤러, model–view–controller) 이용
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
- BorderLayout 설정
- 입력 받는 JPanel : PanelAbove 내부 클래스
  ```java
  class PanelAbove extends JPanel
  ```
- 결과 나오는 JPanel : PanelBelow 내부 클래스
  ```java
  class PanelBelow extends JPanel
  ```

  - 결과확인 버튼 클릭시 입력 받은 값의 결과 확인 가능
  
    - 결과는 일회용이므로 따로 DAO는 생략

- BMI 계산기
![BMI](https://user-images.githubusercontent.com/121646949/226095859-157814fc-ce75-48cf-9327-aa48e2555e45.gif)
