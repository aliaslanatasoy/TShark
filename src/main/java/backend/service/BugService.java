package backend.service;

import backend.entity.BugEntity;
import backend.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */

@Service
public class BugService {
    @Autowired
    private BugRepository bugRepository;

    public List<BugEntity> getAllBugsByCdate(){

        List<BugEntity> bugEntities = bugRepository.findAll();
        return bugEntities;
    }
}
