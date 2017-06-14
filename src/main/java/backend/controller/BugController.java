package backend.controller;

import backend.entity.BugEntity;
import backend.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public List<BugEntity> getAllBugs()throws Exception{
        List<BugEntity> bugEntities = bugService.getAllBugsByCdate();
        return  bugEntities;
    }

    @RequestMapping(value = "/find/name-like",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BugEntity> findByNameLike(@RequestParam(name = "name") String name) throws Exception{
        List<BugEntity> bugEntities = bugService.findBugByNameLike(name);
        return  bugEntities;
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public BugEntity addBug(@RequestBody String body) throws Exception{
       BugEntity bugEntity = bugService.addBug(body);
        return bugEntity;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public BugEntity updateBug(@RequestBody String body) throws Exception {
        BugEntity bugEntity = bugService.updateBug(body);
        return bugEntity;
    }
}
