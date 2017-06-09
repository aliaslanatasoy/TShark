package backend.controller;

import backend.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value = "/test/case")
public class TestCaseController {
    @Autowired
    TestCaseService testCaseService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllTestCases(){
        return null;
    }
}
