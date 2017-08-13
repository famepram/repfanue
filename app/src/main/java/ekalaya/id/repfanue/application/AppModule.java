package ekalaya.id.repfanue.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.db.DBHelper;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.util.Const;

/**
 * Created by Femmy on 8/13/2017.
 */
@Module
public class AppModule {
    private final Application mApp;

    private DBHelper dbHelper;

    private DBFunc dbFunc;

    private SPManager spManager;

    public AppModule(Application app){
        mApp = app;
        dbHelper = new DBHelper(mApp);
        dbFunc = new DBFunc(dbHelper);
        spManager = new SPManager(mApp.getSharedPreferences(Const.SP_APP_KEY, Context.MODE_PRIVATE));
    }


    @Provides
    @Named("AppContext")
    public Context provideContext(){
        return mApp;
    }

    @Provides
    Application provideApplication(){
        return mApp;
    }

    @Singleton
    @Provides
    DBHelper provideDBHelper(){
        return dbHelper;
    }

    @Singleton
    @Provides
    SPManager provideSPManager(){
        return spManager;
    }

    @Singleton
    @Provides
    DBFunc provideDBFunc(){
        return dbFunc;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApp.getSharedPreferences(Const.SP_APP_KEY, Context.MODE_PRIVATE);
    }
}
