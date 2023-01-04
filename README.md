## 💻 도서관리 & 성적관리 프로그램 GUI
- 도서 및 성적 등록 

## ⌚ Project execution period
  - 2022.12.28

## 🛠 Development Environment
- MVC (모델-뷰-컨트롤러, model–view–controller) 이용
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
- BorderLayout 설정
- 입력 받는 JPanel : GridLayout 설정
  ```java
    BookVO vo = view.neededInsertData(); //입력받은 값 객체 생성
    dao.insert(vo); //dao List에 객체 저장
    view.setBookVoList(dao.select()); //dao에 저장한 객체List를 view에 저장
    view.putResult(); //view에 있는 List값을 table에 넣기
  ```
- 더블 클릭 : 해당 값 삭제
  ```java
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2) {
          dao.delete(table.getSelectedRow()); //선택한 해당 행 값을 dao에서 객체 삭제
          view.getSvo(dao.select()); //dao에 저장한 객체List를 view에 저장
          view.putResult(); //view에 있는 List값을 table에 넣기
        }
      }
    }
  ```
