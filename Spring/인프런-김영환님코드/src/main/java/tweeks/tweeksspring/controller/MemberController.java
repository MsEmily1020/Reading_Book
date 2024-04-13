package tweeks.tweeksspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tweeks.tweeksspring.service.MemberService;

@Controller
public class MemberController {
    @Autowired MemberService memberService;

    @Autowired
     public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    //    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
