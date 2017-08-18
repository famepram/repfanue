package ekalaya.id.repfanue.ui.overview;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.ui.base.BasePresenter;

/**
 * Created by Femmy on 8/17/2017.
 */

public class OverviewPresenter extends BasePresenter<OverviewContract.View> implements OverviewContract.Presenter {

    @Inject
    public OverviewPresenter(DBFunc dbFunc, OverviewContract.View view) {
        super(dbFunc, view);
    }
}
