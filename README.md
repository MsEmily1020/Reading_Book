## 💻 경주 시합 GUI
- 말에 배팅 후 경주 시합해서 배팅 성공 및 실패하는 프로그램

## ⌚ Project execution period
  - 2022.01.04

## 🛠 Development Environment
- MVC (모델-뷰-컨트롤러, model–view–controller) 이용
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
- Thread 설정
- 각 객체(말) 당 쓰레드 만들기
  ```java
   for (int i = 0; i < horses.length; i++) {
		HorseThread t = new HorseThread(horses[i], i);
		t.start();
    }

	public class HorseThread extends Thread{
		JLabel lblHorse;
		int randomValue;
		int horseIndex;
		
		public HorseThread(JLabel lblHorse, int horseIndex) {
			this.lblHorse = lblHorse;
			this.horseIndex = horseIndex;
	      }
  ```
- 각 객체의 움직이는 애니메이션 쓰레드
  ```java
    while (true) {
				lblHorse.setLocation(lblHorse.getX()+5, lblHorse.getY()); //오른쪽으로 이동
				if(lblHorse.getX()>=540) { //도착지점
					winnerIndex[index++] = horseIndex;
					if(index == horses.length-1) { //마지막 말인지
						index = 0;
						for (int i = 0; i < horses.length; i++)
							horses[i].setLocation(0, horses[i].getY()); //출발지점으로 다시 이동
						btList = new ArrayList<BettingPerson>(); //새로운 배팅 사람 다시 입력 받기 위해서
					}
					break;
				}
				
				try {
					Random random = new Random();
					sleep(10 * random.nextInt(10)); //이동하는 애니메이션(랜덤 빠르기)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
  ```
