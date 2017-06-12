package backend.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aslan.atasoy on 06/12/2017.
 */
@Entity
@Table(name = "bug",schema = "tshark")
public class BugEntity {
    @Id
    @GeneratedValue
    @Column(name = "BUG_ID", nullable = false)
    private Long bugId;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String name;

    @Basic
    @Column(name = "DESC", nullable = true)
    private String desc;

    @Basic
    @Column(name = "ST_ID", nullable = true)
    private String stId;

    @Basic
    @Column(name = "TP_ID", nullable = true)
    private String tpId;

    @Basic
    @Column(name = "CDATE", nullable = true)
    private Date cDate;
    @Basic
    @Column(name = "UDATE", nullable = true)
    private Date uDate;

    @Basic
    @Column(name = "CUSER", nullable = true)
    private String cUser;

    @Basic
    @Column(name = "UUSER", nullable = true)
    private String uUser;

    public Long getBugId() {
        return bugId;
    }

    public void setBugId(Long bugId) {
        this.bugId = bugId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getuDate() {
        return uDate;
    }

    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getuUser() {
        return uUser;
    }

    public void setuUser(String uUser) {
        this.uUser = uUser;
    }
}
