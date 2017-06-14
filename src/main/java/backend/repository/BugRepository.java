package backend.repository;

import backend.entity.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */
@Repository
public interface BugRepository extends JpaRepository<BugEntity,String> {

    List<BugEntity> findAll();

    List<BugEntity> findBugEntitiesByNameIsLike(String name);

    BugEntity findBugEntityByBugId(int bugId);

}

