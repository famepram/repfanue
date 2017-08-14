package ekalaya.id.repfanue.ui.intro;

import android.os.CountDownTimer;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.ui.base.BasePresenter;
import ekalaya.id.repfanue.util.Const;

/**
 * Created by Femmy on 8/13/2017.
 */

public class IntroPresenter extends BasePresenter<IntroContract.View> implements IntroContract.Presenter {

    @Inject
    SPManager spManager;

    @Inject
    public IntroPresenter(DBFunc dbFunc, IntroContract.View view) {
        super(dbFunc,view);
    }

    @Override
    public void countDownToInit() {
        view.showSplashScreen();
        new CountDownTimer(5000, 1000) {

            public void onTick(long m) {

            }

            public void onFinish() {
                view.showInitScreen();
            }

        }.start();
    }

    @Override
    public void checkAccessToken() {
        if(getSPAccessToken() == ""){
            view.onAccessTokenInexist();
        } else {

        }
    }

    private String getSPAccessToken(){
        return  spManager.get(Const.SP_APP_KEY_FB_ACCESS_TOKEN,"");
    }
}
