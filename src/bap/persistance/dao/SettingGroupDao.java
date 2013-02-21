package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.settings.SettingsGroup;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
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
@Transactional(propagation = Propagation.REQUIRED)
public class SettingGroupDao  {


    @Resource
    private
    SessionFactory sessionFactory;

    @Transactional
    public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
    }


    //@Transactional
    public SettingsGroup get(int id) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        SettingsGroup sg = (SettingsGroup) getSessionFactory().getCurrentSession().get( SettingsGroup.class, id );
        getSessionFactory().getCurrentSession().getTransaction().commit();
        return  sg;
    }


    public DomainObject latest() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public List<SettingsGroup> list() {
        List<SettingsGroup> ls;
        getSessionFactory().getCurrentSession().getTransaction().begin();
        ls = getSessionFactory().getCurrentSession().createQuery( "from SettingsGroup " ).list();
        int lsSize = ls.size();

        //getSessionFactory().getCurrentSession().flush();
        //getSessionFactory().getCurrentSession().getTransaction().commit();
        //getSessionFactory().getCurrentSession().evict(ls);


        return ls;
    }

    @Transactional
    public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
    }

    @Transactional
    public void delete(int id) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().createQuery("delete from SettingsGroup where id = '" + id + "'" ).executeUpdate();
        getSessionFactory().getCurrentSession().getTransaction().commit();


    }

    public DomainObject getArticleLink(String section) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
