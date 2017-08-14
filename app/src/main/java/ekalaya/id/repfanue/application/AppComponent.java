package ekalaya.id.repfanue.application;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.sp.SPManager;

/**
 * Created by Femmy on 8/13/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);

    @Named("AppContext")
    Context getContext();

    DBFunc getDbFunc();

    SPManager getSPManager();
}
