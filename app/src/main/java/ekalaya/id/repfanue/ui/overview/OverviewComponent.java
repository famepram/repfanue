package ekalaya.id.repfanue.ui.overview;

import dagger.Component;
import ekalaya.id.repfanue.annot.PerActivity;
import ekalaya.id.repfanue.application.AppComponent;

/**
 * Created by Femmy on 8/17/2017.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules=OverviewModule.class)
public interface OverviewComponent {
    void inject(OverviewActivity overviewActivity);
}