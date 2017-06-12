package backend.controller;

import backend.entity.BugEntity;
import backend.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */
@RestController
@RequestMapping(value = "/bug")
public class BugController {
    @Autowired
    private BugService bugService;

    @RequestMapping(value = "/get/all",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BugEntity> getAllBugs(){
        List<BugEntity> bugEntities = bugService.getAllBugsByCdate();
        return  bugEntities;
    }
}
