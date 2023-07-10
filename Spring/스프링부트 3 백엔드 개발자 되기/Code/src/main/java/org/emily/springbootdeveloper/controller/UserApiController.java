package org.emily.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.emily.springbootdeveloper.dto.AddUserRequest;
import org.emily.springbootdeveloper.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@ConditionalOnExpression
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }
}
