package ekalaya.id.repfanue.ui.intro;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.Date;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Data;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Result;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.network.FBGraphApiService;
import ekalaya.id.repfanue.network.FBNetInterface;
import ekalaya.id.repfanue.ui.base.BasePresenter;
import ekalaya.id.repfanue.util.Const;
import ekalaya.id.repfanue.util.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static ekalaya.id.repfanue.util.Const.APP_TAG;

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
        new CountDownTimer(3000, 1000) {

            public void onTick(long m) {}

            public void onFinish() {

                checkAccessToken();
            }

        }.start();
    }

    @Override
    public void checkAccessToken() {
        String SavedAccessToken = getSPAccessToken();
        if(SavedAccessToken == ""){
            view.onAccessTokenInexist();
        } else {
            checkRefreshToken(SavedAccessToken);
        }
    }

    private void checkRefreshToken(String SavedAccessToken){
        FBNetInterface graphAPIService = FBGraphApiService.getService().create(FBNetInterface.class);
        Call<Result> result = graphAPIService.debugAccessToken(SavedAccessToken, Const.APP_FB_ACCESS_TOKEN);
        result.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Data data = response.body().getData();
                if(data.getIsValid() && !isTokenExpired(data)){
                    view.onTokenValid();
                } else {
                    view.onAccessTokenInexist();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                t.printStackTrace();
                view.onAccessTokenInexist();
            }
        });
    }

    private boolean isTokenExpired(Data data){
        int expiredAt = data.getExpiresAt();
        if(expiredAt < Helper.getCurrentTimestamp()){
            return true;
        } else {
            return false;
        }
    }

    private String getSPAccessToken(){
        return  spManager.get(Const.SP_APP_KEY_FB_ACCESS_TOKEN,"");
    }
}
