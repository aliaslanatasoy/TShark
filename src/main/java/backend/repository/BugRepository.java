package backend.repository;

import backend.entity.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */
@Repository
public interface BugRepository extends JpaRepository<BugEntity,String> {
    List<BugEntity> findAll();
}
