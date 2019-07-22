package com.example.dynatraceWH;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebhookController {

    @GetMapping("/call")
    @ResponseBody
    public String testResponse(){
         return "Test Response for WebHook Listener";
    }

    // use this to post dynatrace hooks to Listener 
    @PostMapping("/JSON")
    @ResponseBody
    public String jsonResponse(@RequestBody String msg){

         return msg;
    }
}