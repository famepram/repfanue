package ekalaya.id.repfanue.ui.intro;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;
import ekalaya.id.repfanue.ui.appselect.AppSelectActivity;
import ekalaya.id.repfanue.ui.fbauth.FBAuthActivity;

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
//        PackageInfo info;
//        try {
//            info = getPackageManager().getPackageInfo("ekalaya.id.repfanue", PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md;
//                md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                String something = new String(Base64.encode(md.digest(), 0));
//                //String something = new String(Base64.encodeBytes(md.digest()));
//                Log.e("hash key", something);
//            }
//        } catch (PackageManager.NameNotFoundException e1) {
//            Log.e("name not found", e1.toString());
//        } catch (NoSuchAlgorithmException e) {
//            Log.e("no such an algorithm", e.toString());
//        } catch (Exception e) {
//            Log.e("exception", e.toString());
//        }
        presenter.checkAccessToken();
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
        Intent i = new Intent(this, FBAuthActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onTokenValid() {
        Intent i = new Intent(this, AppSelectActivity.class);
        startActivity(i);
        finish();
    }
}
