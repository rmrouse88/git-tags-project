package rouse.richard.tools.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rouse.richard.tools.data.GitDAO;

import java.text.ParseException;

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

    @PostMapping
    @RequestMapping(path="bitbucketHook")
    public void bitbucketHook(@RequestBody Object reqBody){
        log.info(reqBody.toString());
    }
}
