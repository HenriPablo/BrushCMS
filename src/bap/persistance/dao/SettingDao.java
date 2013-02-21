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

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 1/23/13
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class SettingDao  {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
    }


    public Setting get(int id) {
        return (Setting) getSessionFactory().getCurrentSession().get( Setting.class, id );// this.getSession().get( Setting.class, id );

    }


    public DomainObject latest() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public List<Setting> list() {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        List<Setting> ls = getSessionFactory().getCurrentSession().createQuery( "from Setting " ).list();// .load( Setting.class);// this.getHibernateTemplate().loadAll( Setting.class );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
        return ls;
    }

    public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
    }

    public void delete(int id) {

        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().createQuery("delete from Setting where id = '" + id + "'" ).executeUpdate();
        getSessionFactory().getCurrentSession().getTransaction().commit();


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
