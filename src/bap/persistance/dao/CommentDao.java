/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.Comment;
import bap.domain.DomainObject;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
@Transactional(propagation = Propagation.REQUIRED)
public class CommentDao implements Dao {

    private static final String NOT_SUPPORTED_YET = "Not supported yet.";

    @Resource
    private SessionFactory sessionFactory;

	public int save(Comment comment) {
        Serializable id = 0;

        getSessionFactory().getCurrentSession().getTransaction().begin();
		id =  getSessionFactory().getCurrentSession().save( comment );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();

        return Integer.parseInt( id.toString() );

	}

    public Comment get( int id ){
        return (Comment) getSessionFactory().getCurrentSession().get( Comment.class, id );// this.getSession().get( Setting.class, id );

    }

    public List list(){
        getSessionFactory().getCurrentSession().getTransaction().begin();
        List<Comment> ls = getSessionFactory().getCurrentSession().createQuery( "from Comment " ).list();// .load( Setting.class);// this.getHibernateTemplate().loadAll( Setting.class );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
        return ls;
    }

	public void update(Comment comment) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().merge( comment );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}





//	@Override
	public void save(DomainObject obj) {
		throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
	}

//	@Override
	public DomainObject latest() {
		throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
	}

//	@Override
	public void update(DomainObject obj) {
		throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
	}

//	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
