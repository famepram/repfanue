package ekalaya.id.repfanue.ui.appselect;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.models.entities.FBApps;
import ekalaya.id.repfanue.ui.base.BasePresenter;

/**
 * Created by WebDev on 14/08/2017.
 */

public class AppSelectPresenter extends BasePresenter<AppSelectContract.View> implements AppSelectContract.Presenter{

    @Inject
    public AppSelectPresenter(DBFunc dbFunc, AppSelectContract.View view) {
        super(dbFunc, view);
    }

    @Override
    public void setupList() {

    }

    @Override
    public void saveApp(FBApps e) {

    }
}
