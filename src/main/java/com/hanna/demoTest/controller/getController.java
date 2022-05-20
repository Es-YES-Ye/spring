package com.hanna.demoTest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class getController {

    @RequestMapping(method = RequestMethod.GET, path="/getHello")
    public String getHello(){
        return "Hello Test here";
    }

    @GetMapping("/getParam")
    public String getParam(@RequestParam String id,
                           @RequestParam(name="pwd") String password){
        return "아이디 비밀번호 출력 " +id+password;
    }
//password로 받았지만 파라미터 주소에는 pwd로 표시되게 한다.
}
