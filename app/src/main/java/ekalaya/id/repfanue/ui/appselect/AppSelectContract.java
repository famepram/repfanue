package ekalaya.id.repfanue.ui.appselect;

import ekalaya.id.repfanue.data.models.entities.FBApps;

/**
 * Created by WebDev on 14/08/2017.
 */

public class AppSelectContract {

    interface View {

        void showDialogFrom();

        void showDialogAppMenu();

        void onSuccessAppSave();

        void onFailedAppSave();

        void onUpdateAppsItem();
    }

    interface Presenter {
        void setupList();

        void saveApp(FBApps e);


    }
}
