package rouse.richard.tools.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="COMMITS")
public class Commit implements Serializable {
    @Id
    private String MERGE_COMMIT;

    @Temporal(TemporalType.DATE)
    private Date CREATED_DATE;

    private String SOEID;

    @OneToOne(
            mappedBy = "commit",
            cascade = CascadeType.PERSIST
    )
    private Tag tag;

    public Tag getTags() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;

    }

    public String getMERGE_COMMIT() {
        return MERGE_COMMIT;
    }

    public void setMERGE_COMMIT(String MERGE_COMMIT) {
        this.MERGE_COMMIT = MERGE_COMMIT;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    public String getSOEID() {
        return SOEID;
    }

    public void setSOEID(String SOEID) {
        this.SOEID = SOEID;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "MERGE_COMMIT='" + MERGE_COMMIT + '\'' +
                ", CREATED_DATE=" + CREATED_DATE +
                ", SOEID='" + SOEID + '\'' +
                ", tags=" + tag +
                '}';
    }
}
