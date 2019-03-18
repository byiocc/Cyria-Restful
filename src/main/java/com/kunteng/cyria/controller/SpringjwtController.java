package com.kunteng.cyria.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/springjwt")
public class SpringjwtController {
	
	@RequestMapping(value ="/jwtTest")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    public String jwtTest(){
        return "this is a test";
    }
}
