package ekalaya.id.repfanue.ui.appselect;

import java.util.List;

import ekalaya.id.repfanue.data.models.entities.FBApps;

/**
 * Created by WebDev on 14/08/2017.
 */

public class AppSelectContract {

    interface View {


        void onSuccessAppSave();

        void onFailedAppSave();

        void onItemDeleted();

        void onUpdateAppsItem();

        void onListUpdated(List<FBApps> mList);

        void onListEmpty();
    }

    interface Presenter {
        void refreshList();

        void saveApp(String appsid);

        void deleteItem(int id);


    }
}
