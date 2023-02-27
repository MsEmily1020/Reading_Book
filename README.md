## 💻 메모장 GUI
 📚 기본 프로그램 메모장 구현

## ⌚ Project execution period
  - 2022.01.06

## 🛠 Development Environment
- GUI
  
  - Language : `Java 8` 
  - JDK `1.8.0_341`
  - Tool : `Eclipse`

## 📃 Main Composition
  - 새로만들기, 열기, 저장, 나가기, 글꼴 기능 구현
  ```java
	//새로만들기
	if(i == 0) {
      area.setText("");
	}
  
	//열기
	else if(i == 1) {
	    readFile();
	}
  
	//저장
	else if(i == 2) {
	    saveFile();
	}
  
	//나가기
    else if(i == 3){
	    System.exit(0);
	}
  
    //글꼴모양 - 맑은 고딕
    else if(i == 4) {
	    area.setFont(new Font("맑은 고딕", Font.PLAIN, area.getFont().getSize()));
	}
  ...
  ```
  
  - 열기, 저장 기능 구현
  ```java
  //열기
		FileDialog dialog = new FileDialog(this, "File Open" ,FileDialog.LOAD);
		dialog.setVisible(true);
		try {
			FileReader reader = new FileReader(new File(dialog.getDirectory() + "/" + dialog.getFile()));
			BufferedReader bfReader = new BufferedReader(reader);
			String line = "";
			while((line = bfReader.readLine()) != null) area.append(line + "\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	//저장
		FileDialog dialog = new FileDialog(this, "File save", FileDialog.SAVE);
		dialog.setVisible(true);
		try {
			FileWriter writer = new FileWriter(new File(dialog.getDirectory() + "/" + dialog.getFile()));
			BufferedWriter bfWriter = new BufferedWriter(writer);
			bfWriter.write(area.getText());
			bfWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
  ```
