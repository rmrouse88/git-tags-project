package rouse.richard.tools.controllers;

import lombok.extern.slf4j.Slf4j;
import rouse.richard.tools.models.WebhookPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rouse.richard.tools.data.GitDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping(path="v1")
@CrossOrigin(origins = {"*"})
public class PrimaryController {

    @Autowired
    private GitDAO gitDAO;

    @GetMapping
    @RequestMapping(path = "hello")
    public ResponseEntity<String> sayHello() throws ParseException {
        log.info("request received!");
        return ResponseEntity.status(200).body("hey");
    }

    @PostMapping(path = "githook")
    public ResponseEntity<String> processGitHook(
            @RequestBody(required = false) WebhookPayload requestPayload,
            @RequestHeader HashMap<String,String> requestHeaders
            ) throws IOException {

        if (requestPayload != null){
           log.info(requestPayload.toString());
        }

        return ResponseEntity.status(200).body("Inputs received!");

    }

}
