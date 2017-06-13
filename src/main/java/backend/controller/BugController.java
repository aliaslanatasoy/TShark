package backend.controller;

import backend.entity.BugEntity;
import backend.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/find/all",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BugEntity> getAllBugs(){
        List<BugEntity> bugEntities = bugService.getAllBugsByCdate();
        return  bugEntities;
    }

    @RequestMapping(value = "/find/name-like",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BugEntity> findByNameLike(@RequestParam(name = "name") String name){
        List<BugEntity> bugEntities = bugService.findBugByNameLike(name);
        return  bugEntities;
    }
}
