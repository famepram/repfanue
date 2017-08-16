package ekalaya.id.repfanue.ui.appselect;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WebDev on 14/08/2017.
 */
@Module
public class AppSelectModule {

    private final AppSelectContract.View view;

    public AppSelectModule(AppSelectContract.View view){
        this.view = view;
    }

    @Provides
    AppSelectContract.View provideView(){
        return view;
    }
}
