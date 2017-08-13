package ekalaya.id.repfanue.ui.intro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;

public class IntroActivity extends AppCompatActivity implements IntroContract.View {

    @Inject
    IntroPresenter presenter;

    IntroComponent actvComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        initUI();

        actvComponent = DaggerIntroComponent.builder()
                .introModule(new IntroModule(this))
                .appComponent(App.get(this).getComponent()).build();
        actvComponent.inject(this);
    }

    private void initUI(){

    }

    @Override
    public void showSplashScreen() {

    }

    @Override
    public void showInitScreen() {

    }

    @Override
    public void onAccessTokenExists() {

    }

    @Override
    public void onAccessTokenInexist() {

    }
}
