package tweeks.tweeksspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // '주소/hello' 로 접속
    public String hello(Model model) {
        // key : data, value : hello!
        model.addAttribute("data", "spring!!");
        return "hello"; // template : hello 실행
    }
}
