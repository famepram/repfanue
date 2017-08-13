package ekalaya.id.repfanue.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Femmy on 8/13/2017.
 */

public class App extends Application {

    protected AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        getComponent().inject(this);
    }

    public AppComponent getComponent(){
        if(appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}
