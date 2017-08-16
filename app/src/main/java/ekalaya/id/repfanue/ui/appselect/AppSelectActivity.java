package ekalaya.id.repfanue.ui.appselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;

public class AppSelectActivity extends AppCompatActivity implements AppSelectContract.View{

    AppSelectComponent appSelectComponent;

    @Inject
    AppSelectPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_select);
        initComponent();
        appSelectComponent.inject(this);
        initUI();
    }

    private void initComponent(){
        appSelectComponent = DaggerAppSelectComponent.builder()
                            .appSelectModule(new AppSelectModule(this))
                            .appComponent(App.get(this).getComponent())
                            .build();
    }

    private void initUI(){

    }

    @Override
    public void showDialogFrom() {

    }

    @Override
    public void showDialogAppMenu() {

    }

    @Override
    public void onSuccessAppSave() {

    }

    @Override
    public void onFailedAppSave() {

    }

    @Override
    public void onUpdateAppsItem() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_applist:
                break;
            case R.id.add_apps:
                showDialogFrom();
                break;
            default:
                break;
        }
        return true;
    }
}
