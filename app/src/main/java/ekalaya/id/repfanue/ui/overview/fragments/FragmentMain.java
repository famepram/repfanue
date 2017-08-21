package ekalaya.id.repfanue.ui.overview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Singleton;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.ui.overview.OverviewActivity;
import ekalaya.id.repfanue.ui.overview.OverviewContract;

/**
 * Created by WebDev on 18/08/2017.
 */
@Singleton
public class FragmentMain extends Fragment implements OverviewContract.ViewFragmentMain{

    @Inject
    FragmentMainPresenter presenter;

    OverviewActivity mAct;

    public FragmentMain(){

    }

    public static FragmentMain newInstance(){
        return new FragmentMain();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAct = (OverviewActivity) getActivity();
        mAct.getComponent().inject(this);
        presenter.requestDataApp();
        return inflater.inflate(R.layout.fragment_overview_main, container, false);
    }
}
