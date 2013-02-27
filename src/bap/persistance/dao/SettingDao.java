package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.settings.Setting;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.SessionFactory;
import org.postgresql.core.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class SettingDao  {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
    }


    public Setting get(int id) {
        return (Setting) getSessionFactory().getCurrentSession().get( Setting.class, id );// this.getSession().get( Setting.class, id );

    }


    public DomainObject latest() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public List<Setting> list() {
        List<Setting> ls = getSessionFactory().getCurrentSession().createQuery( "from Setting " ).list();// .load( Setting.class);// this.getHibernateTemplate().loadAll( Setting.class );
        getSessionFactory().getCurrentSession().flush();
        return ls;
    }

    public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
    }

    public void delete(int id) {

        getSessionFactory().getCurrentSession().createQuery("delete from Setting where id = '" + id + "'" ).executeUpdate();


    }

    public DomainObject getArticleLink(String section) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
