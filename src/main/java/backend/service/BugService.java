package backend.service;

import backend.entity.BugEntity;
import backend.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.camunda.spin.Spin.JSON;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */

@Service
public class BugService {
    @Autowired
    private BugRepository bugRepository;

    public List<BugEntity> getAllBugsByCdate() throws Exception {

        List<BugEntity> bugEntities = bugRepository.findAll();
        return bugEntities;
    }

    public List<BugEntity> findBugByNameLike(String name) throws Exception {
        List<BugEntity> bugEntities = bugRepository.findBugEntitiesByNameIsLike("%" + name + "%");
        return bugEntities;
    }

    @Transactional
    public BugEntity addBug(String body) throws ParseException {
        BugEntity tempBugEntity = new BugEntity();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,yyyy HH:mm ss:SS");

       /* if(JSON(body.toString()).hasProp("bug_id")&& !JSON(body).prop("bug_id").stringValue().isEmpty()){
            tempBugEntity.setBugId((Integer) JSON(body).prop("bug_id").value());
        }*/
        tempBugEntity.setName(JSON(body).prop("name").stringValue());

        tempBugEntity.setDesc(JSON(body).prop("desc").stringValue());

        tempBugEntity.setStId(JSON(body).prop("st_id").stringValue());

        tempBugEntity.setTpId(JSON(body).prop("tp_id").stringValue());

        if (JSON(body.toString()).hasProp("cdate") && !JSON(body).prop("cdate").stringValue().isEmpty()) {
            tempBugEntity.setcDate(formatter.parse(JSON(body.toString()).prop("cdate").stringValue()));
        } else {
            long yourmilliseconds = System.currentTimeMillis();
            Date resultDate = new Date(yourmilliseconds);
            tempBugEntity.setcDate(formatter.parse(formatter.format(resultDate)));
        }

        if (JSON(body.toString()).hasProp("udate") && !JSON(body).prop("udate").stringValue().isEmpty()) {
            tempBugEntity.setuDate(formatter.parse(JSON(body).prop("udate").stringValue()));
        } else {
            tempBugEntity.setuDate(null);
        }

        tempBugEntity.setcUser(JSON(body).prop("cuser").stringValue());
        tempBugEntity.setuUser(JSON(body).prop("uuser").stringValue());


        bugRepository.save(tempBugEntity);
        bugRepository.flush();

        return tempBugEntity;
    }

    @Transactional
    public BugEntity updateBug(String body) throws Exception {
        BugEntity tempBugEntity;
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,yyyy HH:mm ss:SS");

        long timeInMilliSecond = System.currentTimeMillis();
        Date currDateTime = new Date(timeInMilliSecond);

        tempBugEntity = bugRepository.findBugEntityByBugId(JSON(body).prop("bug_id").numberValue().intValue());

        tempBugEntity.setName(JSON(body).prop("name").stringValue());

        tempBugEntity.setDesc(JSON(body).prop("desc").stringValue());

        tempBugEntity.setStId(JSON(body).prop("st_id").stringValue());

        tempBugEntity.setTpId(JSON(body).prop("tp_id").stringValue());

        tempBugEntity.setuDate(formatter.parse(formatter.format(currDateTime)));

        tempBugEntity.setuUser(JSON(body).prop("uuser").stringValue());

        bugRepository.save(tempBugEntity);
        bugRepository.flush();

        return tempBugEntity;
    }
}
