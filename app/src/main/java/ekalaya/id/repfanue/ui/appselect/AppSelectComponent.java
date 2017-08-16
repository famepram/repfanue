package ekalaya.id.repfanue.ui.appselect;

import dagger.Component;
import ekalaya.id.repfanue.annot.PerActivity;
import ekalaya.id.repfanue.application.AppComponent;

/**
 * Created by WebDev on 14/08/2017.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules=AppSelectModule.class)
public interface AppSelectComponent {
    void inject(AppSelectActivity appSelectActivity);
}
