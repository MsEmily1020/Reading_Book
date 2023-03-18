## 💻 경주 시합 GUI
- 말에 배팅 후 경주 시합해서 배팅 성공 및 실패하는 프로그램

## ⌚ Project execution period
  - 2023.01.04

## 🛠 Development Environment
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
- Thread 설정

- 개선 내용 : 2명애서 배팅하여 대결, 말이 멈췄을 때와 달릴 때의 이미지 차이, 말의 갯수 2 -> 5

- 각 객체(말) 당 쓰레드 만들기
  ```java
    for (int i = 0; i < horses.length; i++) {
			HorseThread t = new HorseThread(horses[i], "stop_horse" + (i + 1), i);
			t.start();
	}
				
   public HorseThread(JLabel lblHorse, String stopImageName, int horseIndex) {
			this.lblHorse = lblHorse;
			this.stopImageName = stopImageName;
			this.horseIndex = horseIndex;
	}
  ```
- 각 객체의 움직이는 애니메이션 쓰레드
  ```java
    while (true) {
				lblHorse.setLocation(lblHorse.getX() + 5, lblHorse.getY());
				if (lblHorse.getX() == 540) {
					lblHorse.setIcon(new ImageIcon("images/" + stopImageName + ".gif"));
					winnerIndex[index++] = horseIndex;
					if (index == horses.length - 1) {
						[배팅... 성공했는지 여부]
						index = 0;
						for (int i = 0; i < horses.length; i++) {
							System.out.println(winnerIndex[i]);
							horses[i].setLocation(0, horses[i].getY());
							horses[i].setIcon(new ImageIcon("imgs/horse" + (i + 1) + ".gif"));
						}
					}
					break;
				}
				try {
					Random random = new Random();
					randomValue = random.nextInt(10); // 0~9 사이의 값
					sleep(10 * randomValue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
  ```

## 🎞 경주시합
![경주시합](https://user-images.githubusercontent.com/121646949/226097838-77a6fe85-88a0-43c5-a89e-db6f57dff3c8.gif)
