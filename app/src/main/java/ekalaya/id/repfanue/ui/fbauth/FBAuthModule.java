package ekalaya.id.repfanue.ui.fbauth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WebDev on 14/08/2017.
 */

@Module
public class FBAuthModule {
    private final FBAuthContract.View view;

    public FBAuthModule(FBAuthContract.View v){
        view = v;
    }

    @Provides
    FBAuthContract.View provideView(){
        return view;
    }
}
