package com.sz.ben.hibernate.utils;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Classes entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.sz.ben.hibernate.utils.Classes
  * @author MyEclipse Persistence Tools 
 */
public class ClassesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ClassesDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";



    
    public void save(Classes transientInstance) {
        log.debug("saving Classes instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Classes persistentInstance) {
        log.debug("deleting Classes instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Classes findById( java.lang.Long id) {
        log.debug("getting Classes instance with id: " + id);
        try {
            Classes instance = (Classes) getSession()
                    .get("com.itheima11.hibernate.utils.Classes", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Classes instance) {
        log.debug("finding Classes instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.itheima11.hibernate.utils.Classes")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Classes instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Classes as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all Classes instances");
		try {
			String queryString = "from Classes";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Classes merge(Classes detachedInstance) {
        log.debug("merging Classes instance");
        try {
            Classes result = (Classes) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Classes instance) {
        log.debug("attaching dirty Classes instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Classes instance) {
        log.debug("attaching clean Classes instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}