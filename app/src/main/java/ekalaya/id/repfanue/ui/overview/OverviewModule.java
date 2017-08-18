package ekalaya.id.repfanue.ui.overview;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Femmy on 8/17/2017.
 */

@Module
public class OverviewModule {
    private final OverviewContract.View view;

    public OverviewModule(OverviewContract.View v){
        view = v;
    }

    @Provides
    OverviewContract.View provideView(){
        return view;
    }
}

