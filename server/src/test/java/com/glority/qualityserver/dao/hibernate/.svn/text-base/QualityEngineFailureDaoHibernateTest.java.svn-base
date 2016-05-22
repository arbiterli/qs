package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.model.QualityEngineFailure;

/**
 * Junit test for QualityEngineFailureDao.
 * 
 * @author Chen.hong
 */
public class QualityEngineFailureDaoHibernateTest extends AbstractBaseTest {

    private String stackTrace = "";

    @Autowired
    private QualityEngineFailureDaoHibernate qualityEngineFailureDao;

    @Before
    public void setUp() throws FileNotFoundException {
        StringWriter strWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(strWriter);

        try {
            throw new NullPointerException("For testing only");
        } catch (NullPointerException e) {
            e.printStackTrace(writer);
        }
        stackTrace = strWriter.toString();
    }

    @Test
    public void testSave() {
        String taskName = "test_task";
        QualityEngineFailure failureEntity = new QualityEngineFailure();
        failureEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        failureEntity.setOwner("test");
        failureEntity.setTaskClassName(taskName);
        failureEntity.setStackTrace(stackTrace);

        this.qualityEngineFailureDao.save(failureEntity);

        List<QualityEngineFailure> ret = this.qualityEngineFailureDao.getQualityEngineFailureWithTask(taskName);

        assertEquals("Equal to 1", 1, ret.size());
        QualityEngineFailure failureFromDB = ret.get(0);

        assertEquals("test", failureFromDB.getOwner());
    }

    @Test
    public void testFindByTask() {
        int existence = this.qualityEngineFailureDao.getAll().size();

        String taskName = "test_task";

        String taskName2 = "test_task_name_2";
        List<QualityEngineFailure> entities = new ArrayList<QualityEngineFailure>();

        for (int i = 0; i < 100; i++) {
            QualityEngineFailure failure = new QualityEngineFailure();

            if (i % 2 == 0) {
                failure.setTaskClassName(taskName);
            } else {
                failure.setTaskClassName(taskName2);
            }

            failure.setStackTrace(stackTrace);
            failure.setOwner("owner_" + i);
            failure.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            entities.add(failure);
        }

        // now persist all the failures into the database.
        this.qualityEngineFailureDao.saveOrUpdateAll(entities);

        int afterSave = this.qualityEngineFailureDao.getAll().size();
        assertEquals(100, (afterSave - existence));

        // now testing if the find api works.
        List<QualityEngineFailure> ret = this.qualityEngineFailureDao.getQualityEngineFailureWithTask(taskName);
        assertEquals(50, ret.size());
    }
}
