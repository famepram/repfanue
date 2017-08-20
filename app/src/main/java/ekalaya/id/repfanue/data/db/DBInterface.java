package ekalaya.id.repfanue.data.db;

import java.util.List;

import ekalaya.id.repfanue.data.models.entities.FBApps;

/**
 * Created by Femmy on 8/13/2017.
 */

public class DBInterface {

    public interface FBAppsList {
        void successGetList(List<FBApps> e);

        void emptyList();


    }

    public interface SaveAppListener{

        void onSaveSuccess();

        void onSaveFailed();
    }

    public interface deleteAppsLiestener {
        void onDelete();
    }

    public interface getSingleFbapp{
        void onSuccess(FBApps mApps);

        void onFailed();
    }
}
