package ekalaya.id.repfanue.ui.fbauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;
import ekalaya.id.repfanue.ui.appselect.AppSelectActivity;
import ekalaya.id.repfanue.util.Const;

import static ekalaya.id.repfanue.util.Const.APP_TAG;

public class FBAuthActivity extends AppCompatActivity implements FBAuthContract.View, FacebookCallback<LoginResult>{

    private TextView info;
    private LoginButton loginButton;

    private CallbackManager callbackManager;

    @Inject
    FBAuthPresenter presenter;

    FBauthComponent actvComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove notification bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fbauth);
        initUI();
        actvComponent = DaggerFBauthComponent.builder()
                .fBAuthModule(new FBAuthModule(this))
                .appComponent(App.get(this).getComponent()).build();
        actvComponent.inject(this);

    }

    private void initUI(){
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("read_audience_network_insights"));

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && data != null){
//            callbackManager.onActivityResult(requestCode, resultCode, data);
//        }

    }

    @Override
    public void onTokenSaved() {
        Log.d(APP_TAG, "onTokenSaved");
//        Intent i = new Intent(this, AppSelectActivity.class);
//        startActivity(i);
//        finish();
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        //loginResult.
        String FBUserID             = loginResult.getAccessToken().getUserId();
        String FBAccessToken        = loginResult.getAccessToken().getToken();
        presenter.saveToken(FBUserID,FBAccessToken);

        Intent i = new Intent(this, AppSelectActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onCancel() {
        Log.d(APP_TAG, "login Cancelled");
    }

    @Override
    public void onError(FacebookException error) {
        Log.d(APP_TAG, error.toString());
    }
}
