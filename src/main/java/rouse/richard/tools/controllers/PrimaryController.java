package rouse.richard.tools.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rouse.richard.tools.data.GitDAO;

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
        this.gitDAO.getShitDone();
        return ResponseEntity.status(200).body("hey");
    }

    @PostMapping(path = "githook")
    public void processGitHook(
            @RequestBody HashMap<String, String> requestPayload,
            @RequestHeader HashMap<String,String> requestHeaders
            ){

        requestPayload.keySet().forEach(key ->{
            log.info("Key is: ", key);
            log.info("Value is: ", requestPayload.get(key));
        });
    }

}
