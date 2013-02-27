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


@Transactional(propagation = Propagation.REQUIRED)
public class SettingGroupDao  {


    @Resource
    private
    SessionFactory sessionFactory;

    @Transactional
    public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
    }


    //@Transactional
    public SettingsGroup get(int id) {
        SettingsGroup sg = (SettingsGroup) getSessionFactory().getCurrentSession().get( SettingsGroup.class, id );
        return  sg;
    }


    public DomainObject latest() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public List<SettingsGroup> list() {
        List<SettingsGroup> ls;
        ls = getSessionFactory().getCurrentSession().createQuery( "from SettingsGroup " ).list();
        getSessionFactory().getCurrentSession().flush();
        return ls;
    }

    @Transactional
    public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().update( obj );
        getSessionFactory().getCurrentSession().flush();
    }

    @Transactional
    public void delete(int id) {
        getSessionFactory().getCurrentSession().createQuery("delete from SettingsGroup where id = " + id + "" ).executeUpdate();


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
