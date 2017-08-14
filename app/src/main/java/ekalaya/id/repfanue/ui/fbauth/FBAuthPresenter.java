package ekalaya.id.repfanue.ui.fbauth;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.ui.base.BasePresenter;
import ekalaya.id.repfanue.util.Const;

/**
 * Created by WebDev on 14/08/2017.
 */

public class FBAuthPresenter extends BasePresenter<FBAuthContract.View> implements FBAuthContract.Presenter{

    FBAuthContract.View view;

    SPManager spManager;

    @Inject
    public FBAuthPresenter(DBFunc dbFunc, FBAuthContract.View view, SPManager spManager){
        super(dbFunc,view);
        this.spManager = spManager;
    }

    @Override
    public void saveToken(String UserID, String Token) {
        spManager.put(Const.SP_APP_KEY_FB_USER_ID, UserID);
        spManager.put(Const.SP_APP_KEY_FB_ACCESS_TOKEN, Token);
        view.onTokenSaved();
    }
}
