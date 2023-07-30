package tweeks.tweeksspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // '주소/hello' 로 접속
    public String hello(Model model) {
        // key : data, value : spring!!
        model.addAttribute("data", "spring!!");
        return "hello"; // template : hello 실행
    }

    @GetMapping("hello-mvc") // '주소/hello-mvc' 로 접속하지만...
    // @RequestParam("name") String : '주소/hello-mvc?name=[String 값]' 로 작성해 name 값 전달해줘야함.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // key : name, value : 파라미터 name 값
        model.addAttribute("name", name);
        return "hello-template"; // template : hello-template 실행
    }

    @GetMapping("hello-spring")
    @ResponseBody // http body에 return 값 직접 넣어줌
    // template 차이점 : 페이지 소스 보기를 할 경우 해당 return 문자만 보여짐
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }
}
