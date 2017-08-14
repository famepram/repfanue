package ekalaya.id.repfanue.ui.fbauth;

/**
 * Created by WebDev on 14/08/2017.
 */

public class FBAuthContract {

    interface View {
        void onTokenSaved();
    }

    interface Presenter {
        void saveToken(String UserID, String Token);
    }
}
