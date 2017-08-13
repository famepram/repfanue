package ekalaya.id.repfanue.ui.intro;

import dagger.Component;
import ekalaya.id.repfanue.annot.PerActivity;
import ekalaya.id.repfanue.application.AppComponent;

/**
 * Created by Femmy on 8/13/2017.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules=IntroModule.class)
public interface IntroComponent {
    void inject(IntroActivity introActivity);
}
