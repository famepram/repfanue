package ekalaya.id.repfanue.ui.overview;

import dagger.Module;
import dagger.Provides;
import ekalaya.id.repfanue.ui.overview.fragments.FragmentMain;

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

    @Provides
    OverviewContract.ViewFragmentMain provideViewFragmentMain(){
        return new FragmentMain();
    }
}

