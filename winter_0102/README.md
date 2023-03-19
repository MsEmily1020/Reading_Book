## 💻 음료 자판기 프로그램 GUI
- 해당 음료수 클릭 후 금액 투입하여 거스름돈 및 음료 받기

## ⌚ Project execution period
  - 2023.01.02

## 🛠 Development Environment
- MVC (모델-뷰-컨트롤러, model–view–controller) 이용
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
- GridLayout 설정

- 제품 선택 화면(클릭 시 해당 제품 배경화면 색 변경)
  ```java
    lb.setIcon(icon); //아이콘 설정
	lb.setText(Integer.toString(vo.getPrice()) + "원"); //금액 보이기
	lb.setHorizontalTextPosition(JLabel.CENTER);
	lb.setVerticalTextPosition(JLabel.BOTTOM);
	lb.setHorizontalAlignment(JLabel.CENTER);
			
	lb.setOpaque(true); //라벨 배경색 설정 할 수 있도록
	lb.setBackground(Color.white); //기본 색 하양
    lbList.add(lb);
  
    MouseEvent e...
    if((JLabel)e.getSource == lbList.get(i))
      e.getSource.setBackground(Color.red); //선택 시 해당 라벨 배경색은 빨강
  ```
  
- 거스름돈
  ```java
    int money = Integer.parseInt(insertTf.getText()); //입력값(투입한 돈)
	if(vo.getPrice() <= money) {
		JOptionPane.showMessageDialog(null, "거스름돈 : " + (money - vo.getPrice()));
		lbResult.setIcon(new ImageIcon("images/" + vo.getImageName() + ".jpg")); //해당 이미지 출력
	}
	else
		JOptionPane.showMessageDialog(null, vo.getPrice() - money + "원이 부족합니다.");
  ```
  
  
## 🎞 음료 자판기 (2배속)
![음료-자판기](https://user-images.githubusercontent.com/121646949/226096513-e7411840-9b3e-4ad6-8a84-44419a5b740c.gif)
