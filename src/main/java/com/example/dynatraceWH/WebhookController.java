package com.example.dynatraceWH;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.*;
import java.util.List;


class TestObject {
    private String username;
    private String password;
    TestObject() {

    }
}

// dynatrace object to be constructed from JSON string 
class DynatraceJavaObject {

    public List<ImpactedEntity> ImpactedEntities = null;
    public String ImpactedEntity;
    public String PID;
    public String ProblemDetailsHTML;
    public ProblemDetailsJSON ProblemDetailsJSON;
    public String ProblemID;
    public String ProblemImpact;
    public String ProblemTitle;
    public String ProblemURL;
    public String State;
    public String Tags;

    DynatraceJavaObject() {

    }

}

class ImpactedEntity {

    public String type;
    public String name;
    public String entity;

    ImpactedEntity() {

    }

}

class ProblemDetailsJSON {

    public String ID;

    ProblemDetailsJSON() {

    }

}

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
        Gson g = new Gson();
        DynatraceJavaObject p = g.fromJson(msg, DynatraceJavaObject.class);
        String json = g.toJson(p);  
        return json;
    }
}