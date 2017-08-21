package ekalaya.id.repfanue.ui.overview.fragments;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.db.DBInterface;
import ekalaya.id.repfanue.data.models.entities.FBApps;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Data;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Result;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.network.FBGraphApiService;
import ekalaya.id.repfanue.network.FBNetInterface;
import ekalaya.id.repfanue.ui.base.BasePresenter;
import ekalaya.id.repfanue.ui.overview.OverviewContract;
import ekalaya.id.repfanue.util.Const;
import ekalaya.id.repfanue.util.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Femmy on 8/19/2017.
 */

public class FragmentMainPresenter extends BasePresenter<OverviewContract.ViewFragmentMain>
        implements OverviewContract.PresenterFragmentMain{

    @Inject
    SPManager spManager;

    @Inject
    public FragmentMainPresenter(DBFunc dbFunc, OverviewContract.ViewFragmentMain view) {
        super(dbFunc, view);
    }

    @Override
    public void requestDataApp() {
        FBNetInterface graphAPIService = FBGraphApiService.getService().create(FBNetInterface.class);
        int app_id   = spManager.get(Const.SP_APP_KEY_APP_ID_SELECTED,0);
        final FBApps mApps = dbFunc.getFBApp(app_id);
        if(mApps != null){
            Map<String, String> param = new HashMap<>();
            param.put("since","0");
            param.put("until", String.valueOf(Helper.getCurrentTimestamp()));
            param.put("summary","true");
            param.put("access_token",spManager.get(Const.APP_FB_ACCESS_TOKEN,""));
            param.put("aggregateBy","SUM");
            param.put("event_name","fb_ad_network_revenue");
            Call<Result> result = graphAPIService.summary("v2.10",mApps.getFbapps_id(),param);
            result.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {

                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.printStackTrace();
                    //view.onAccessTokenInexist();
                }
            });
        } else {

        }


    }
}
