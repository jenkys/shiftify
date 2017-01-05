package cz.cvut.fit.shiftify.data;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by petr on 11/22/16.
 */

public class App extends Application {

    private static Context sContext;

    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.sContext = getApplicationContext();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shiftify.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static Context getsContext() {
        return sContext;
    }
}
