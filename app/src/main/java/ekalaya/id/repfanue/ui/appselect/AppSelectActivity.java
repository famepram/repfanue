package ekalaya.id.repfanue.ui.appselect;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.application.App;
import ekalaya.id.repfanue.data.models.entities.FBApps;
import ekalaya.id.repfanue.util.Const;

import static ekalaya.id.repfanue.util.Const.APP_TAG;

public class AppSelectActivity extends AppCompatActivity implements AppSelectContract.View,AppSelectRVAdapter.itemEventListener {

    AppSelectComponent appSelectComponent;

    @Inject
    AppSelectPresenter presenter;

    RecyclerView RVFBApps;

    AppSelectRVAdapter mAdapter;

    TextView tvAppsID;

    Dialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_select);
        initComponent();
        appSelectComponent.inject(this);
        initUI();
        presenter.refreshList();
    }

    private void initComponent(){
        appSelectComponent = DaggerAppSelectComponent.builder()
                            .appSelectModule(new AppSelectModule(this))
                            .appComponent(App.get(this).getComponent())
                            .build();
    }

    private void initUI(){
        mAdapter = new AppSelectRVAdapter(null);
        mAdapter.setItemListener(this);
        RVFBApps = (RecyclerView) findViewById(R.id.recycler_view_fb_apps);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RVFBApps.setLayoutManager(mLayoutManager);
        RVFBApps.setItemAnimator(new DefaultItemAnimator());
        RVFBApps.setAdapter(mAdapter);
    }

    private void showDialog(){
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.appselect_dialog_form);
        mDialog.setTitle(getResources().getString(R.string.dialogform_title));

        final LinearLayout llInner      = (LinearLayout) mDialog.findViewById(R.id.ll_inner_form);
        final TextView tvLabelAppsID    = (TextView) mDialog.findViewById(R.id.tv_fbapps_id);
        final EditText etAppsID         = (EditText) mDialog.findViewById(R.id.et_fbapps_id);
        final ProgressBar pbAppsID      = (ProgressBar) mDialog.findViewById(R.id.progress_bar_saveapp);
        Button dialogBtnYes             = (Button) mDialog.findViewById(R.id.btn_save_app_yes);

        dialogBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apps_id = etAppsID.getText().toString().trim();
                if(apps_id.length() > 0 ){
                    llInner.setVisibility(View.GONE);
                    pbAppsID.setVisibility(View.VISIBLE);
                    presenter.saveApp(apps_id);
                } else {
                    Toast.makeText(getApplicationContext(),"Apps id must not be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button dialogBtnno  = (Button) mDialog.findViewById(R.id.btn_save_app_no);
        dialogBtnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        mDialog.show();
    }

    @Override
    public void onSuccessAppSave() {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(),"Apps has been saved",Toast.LENGTH_SHORT).show();
        presenter.refreshList();
    }

    @Override
    public void onFailedAppSave(String s) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemDeleted() {
        Toast.makeText(getApplicationContext(),"Apps is successfully deleted",Toast.LENGTH_SHORT).show();
        presenter.refreshList();
    }

    @Override
    public void onUpdateAppsItem() {

    }

    @Override
    public void onListUpdated(List<FBApps> mList) {
        mAdapter.setData(mList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onListEmpty() {
        Toast.makeText(getApplicationContext(),"No Apps Available",Toast.LENGTH_SHORT).show();
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
                presenter.refreshList();
                break;
            case R.id.add_apps:
                showDialog();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void deleteItem(final int id) {
        new AlertDialog.Builder(this)
            .setTitle("Delete app confirmation")
            .setMessage("Are you sure to delete this app?")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    //Toast.makeText(getApplicationContext(),"ID : "+id,Toast.LENGTH_SHORT).show();
                    presenter.deleteItem(id);
                }})
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
    }

    @Override
    public void onClick(int id) {
        Toast.makeText(getApplicationContext(),"ID : "+id,Toast.LENGTH_SHORT).show();
    }
}
