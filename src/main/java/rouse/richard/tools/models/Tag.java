package rouse.richard.tools.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TAGS")
public class Tag implements Serializable {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String TAG_NAME;

    @OneToOne
    @MapsId
    @JoinColumn(name="MERGE_COMMIT")
    public Commit commit;

    public String getTAG_NAME() {
        return TAG_NAME;
    }

    public void setTAG_NAME(String TAG_NAME) {
        this.TAG_NAME = TAG_NAME;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "TAG_NAME='" + TAG_NAME + '\'' +
                ", commit=" + commit +
                '}';
    }
}
