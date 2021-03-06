package cz.cvut.fit.shiftify.data;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.greenrobot.greendao.database.Database;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import cz.cvut.fit.shiftify.data.managers.ScheduleTypeManager;
import cz.cvut.fit.shiftify.data.managers.UserManager;
import cz.cvut.fit.shiftify.data.models.ExceptionInSchedule;
import cz.cvut.fit.shiftify.data.models.Schedule;
import cz.cvut.fit.shiftify.data.models.ScheduleShift;
import cz.cvut.fit.shiftify.data.models.ScheduleType;
import cz.cvut.fit.shiftify.data.models.User;
import cz.cvut.fit.shiftify.data.models.UserDao;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukas on 26.01.2017.
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseTests {
    public void setUp() throws Exception {
        UserDao.dropTable(App.getNewDaoSession().getDatabase(), true);
        UserDao.createTable(App.getNewDaoSession().getDatabase(), true);
    }

    @Test
    public void testSaveCard() throws Exception {
        UserManager um = new UserManager();
        List<User> list = um.allUsers();
    }

    public void tearDown() throws Exception {

    }
}