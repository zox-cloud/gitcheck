package com.example.AuthTry.controller;


import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {


    @GetMapping("/welcome")
    public String welcome() {
        return "this is welcome";
    }


    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String pageForUser(){
        return "This is  user page";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String pageForAdmin(){
        return "this is admin page";
    }

    @GetMapping("/all")
    public String pageForAll(){
        return null;
    }
}
