package ekalaya.id.repfanue.ui.intro;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Femmy on 8/13/2017.
 */
@Module
public class IntroModule {
    private final IntroContract.View view;

    public IntroModule(IntroContract.View v){
        view = v;
    }

    @Provides
    IntroContract.View provideView(){
        return view;
    }
}
