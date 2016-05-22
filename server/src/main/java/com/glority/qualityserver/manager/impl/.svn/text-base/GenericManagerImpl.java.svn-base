package com.glority.qualityserver.manager.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.GenericManager;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public abstract class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {

    /**
     * Dao variable for the manager.
     * 
     * @return Implementation of GenericDao.
     */
    protected abstract GenericDao<T, PK> getDao();

    /**
     * Generic method used to get all objects of a particular type. This is the
     * same as lookup up all rows in a table.
     * 
     * @return List of populated objects
     */
    public List<T> getAll() {
        return getDao().getAll();
    }

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
     * found.
     * 
     * @param id
     *            the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    public T get(PK id) {
        return getDao().get(id);
    }

    /**
     * Checks for existence of an object of type T using the id arg.
     * 
     * @param id
     *            the identifier (primary key) of the object to get
     * @return - true if it exists, false if it doesn't
     */
    public boolean exists(PK id) {
        return getDao().exists(id);
    }

    /**
     * Generic method to save an object - handles both update and insert.
     * 
     * @param object
     *            the object to save
     * @return the updated object
     */
    public T save(T object) {
        return getDao().save(object);
    }

    /**
     * Generic method to delete an object based on class and id.
     * 
     * @param id
     *            the identifier (primary key) of the object to remove
     */
    public void remove(PK id) {
        getDao().remove(id);
    }

    /**
     * Generaic method to save/update a batch of a objects.
     */
    //TODO:compiler warning,need refactoring code.
    @SuppressWarnings("rawtypes")
    public void saveOrUpdateAll(Collection c) {
        getDao().saveOrUpdateAll(c);
    }

}
