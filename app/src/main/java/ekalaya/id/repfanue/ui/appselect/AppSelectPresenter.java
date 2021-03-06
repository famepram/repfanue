package ekalaya.id.repfanue.ui.appselect;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ekalaya.id.repfanue.data.db.DBFunc;
import ekalaya.id.repfanue.data.db.DBInterface;
import ekalaya.id.repfanue.data.models.entities.FBApps;
import ekalaya.id.repfanue.data.models.responses.fbcheckapp.Apps;
import ekalaya.id.repfanue.data.models.responses.fbcheckapp.Roles;
import ekalaya.id.repfanue.data.sp.SPManager;
import ekalaya.id.repfanue.network.FBGraphApiService;
import ekalaya.id.repfanue.network.FBNetInterface;
import ekalaya.id.repfanue.ui.base.BasePresenter;
import ekalaya.id.repfanue.util.Const;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WebDev on 14/08/2017.
 */

public class AppSelectPresenter extends BasePresenter<AppSelectContract.View> implements AppSelectContract.Presenter{

    @Inject
    SPManager spManager;

    @Inject
    public AppSelectPresenter(DBFunc dbFunc, AppSelectContract.View view) {
        super(dbFunc, view);
    }

    @Override
    public void refreshList() {
        dbFunc.getAppsList(new DBInterface.FBAppsList() {
            @Override
            public void successGetList(List<FBApps> e) {
                view.onListUpdated(e);
            }

            @Override
            public void emptyList() {
                view.onListEmpty();
            }
        });
    }

    @Override
    public void saveApp(String appsid) {
        FBNetInterface graphAPIService = FBGraphApiService.getService().create(FBNetInterface.class);
        Call<Apps> result = graphAPIService.checkFBAppsRoles(appsid, Const.APP_FB_ACCESS_TOKEN);
        result.enqueue(new Callback<Apps>() {
            @Override
            public void onResponse(Call<Apps> call, Response<Apps> response) {
                Apps apps = response.body();
                if(apps == null){
                    view.onFailedAppSave("Apps not found, please re-check your apps id");
                } else {
                    FBApps mApp = new FBApps();
                    mApp.setApps_name(response.body().getName());
                    mApp.setFbapps_id(response.body().getId());
                    mApp.setCategory(response.body().getCategory());
                    mApp.setRevenue(0);
                    mApp.setActive(true);
                    if(!dbFunc.FBAppsExists(mApp.getFbapps_id())){
                        dbFunc.SaveApp(mApp, new DBInterface.SaveAppListener() {
                            @Override
                            public void onSaveSuccess() {
                                view.onSuccessAppSave();
                            }

                            @Override
                            public void onSaveFailed() {
                                view.onFailedAppSave("Apps not saved, try again later");
                            }
                        });
                    } else {
                        view.onFailedAppSave("Apps already exist");
                    }
                }
            }

            @Override
            public void onFailure(Call<Apps> call, Throwable t) {
                view.onFailedAppSave("Apps not found, please re-check your apps id");
            }
        });
    }

    @Override
    public void deleteItem(int id) {
        dbFunc.deleteApp(id, new DBInterface.deleteAppsLiestener() {
            @Override
            public void onDelete() {
                view.onItemDeleted();
            }
        });
    }

    @Override
    public void selectApp(int id) {
        spManager.put(Const.SP_APP_KEY_APP_ID_SELECTED,id);
    }

    @Override
    public void restoreDataTest() {
        List<FBApps> ListDataTest = new ArrayList<>();
        FBApps mApp = new FBApps();
        mApp.setApps_id(1);
        mApp.setApps_name("Find The Ass Hole");
        mApp.setFbapps_id("112336633211332");
        mApp.setActive(false);
        mApp.setCategory("Game");
        ListDataTest.add(mApp);

        FBApps mApp2 = new FBApps();
        mApp2.setApps_id(2);
        mApp2.setApps_name("Catch The Goodluck");
        mApp2.setFbapps_id("112336633215555");
        mApp2.setActive(false);
        mApp2.setCategory("Game");
        ListDataTest.add(mApp2);

        FBApps mApp3 = new FBApps();
        mApp3.setApps_id(3);
        mApp3.setApps_name("Forget That Jerk");
        mApp3.setFbapps_id("112336633215566");
        mApp3.setActive(false);
        mApp3.setCategory("Game");
        ListDataTest.add(mApp3);

        view.onListUpdated(ListDataTest);
    }
}
