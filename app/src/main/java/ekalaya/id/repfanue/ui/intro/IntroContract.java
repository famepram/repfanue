package ekalaya.id.repfanue.ui.intro;

/**
 * Created by Femmy on 8/13/2017.
 */

public class IntroContract {

    interface View {
        void showSplashScreen();

        void showInitScreen();

        void onAccessTokenExists();

        void onAccessTokenInexist();
    }

    interface Presenter {
        void countDownToInit();

        void checkAccessToken();


    }
}
