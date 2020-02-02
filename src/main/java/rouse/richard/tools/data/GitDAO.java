package rouse.richard.tools.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rouse.richard.tools.entities.Commit;
import rouse.richard.tools.entities.Tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@Repository
public class GitDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public String getShitDone() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date myDate = sdf.parse("2020-01-20");

        Commit commit = new Commit();
        commit.setSOEID("rr00605");
        commit.setMERGE_COMMIT("fleefloo");
        commit.setCREATED_DATE(myDate);

        Tag tag = new Tag();

        tag.setCommit(commit);
        tag.setTAG_NAME("FUCK");

        commit.setTag(tag);

        Session session = sessionFactory.getCurrentSession();

        session.persist(commit);


        return "tight";
    }

}
