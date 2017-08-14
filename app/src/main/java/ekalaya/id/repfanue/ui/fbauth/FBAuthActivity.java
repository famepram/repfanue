package ekalaya.id.repfanue.ui.fbauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;
import ekalaya.id.repfanue.util.Const;

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

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onTokenSaved() {
        //Intent i = new Intent(this,)
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        String FBUserID             = loginResult.getAccessToken().getUserId();
        String FBAccessToken        = loginResult.getAccessToken().getToken();
        presenter.saveToken(FBUserID,FBAccessToken);
    }

    @Override
    public void onCancel() {
        Log.d(Const.APP_TAG, "login Cancelled");
    }

    @Override
    public void onError(FacebookException error) {
        Log.d(Const.APP_TAG, error.toString());
    }
}
