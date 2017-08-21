package ekalaya.id.repfanue.ui.appselect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ekalaya.id.repfanue.R;
import ekalaya.id.repfanue.data.models.entities.FBApps;

/**
 * Created by Femmy on 8/16/2017.
 */

public class AppSelectRVAdapter extends RecyclerView.Adapter<AppSelectRVAdapter.FBAppsHolder>{

    private List<FBApps> ListFBApps;

    private itemEventListener mItemListener;

    interface itemEventListener {
        void deleteItem(int id);

        void onClick(int id);
    }

    public class FBAppsHolder extends RecyclerView.ViewHolder{

        public TextView TVAppsName, TVFBAppsID;

        public Button btnDelete;

        public FBAppsHolder(View itemView) {
            super(itemView);
            TVAppsName = (TextView) itemView.findViewById(R.id.fbapps_name);
            TVFBAppsID = (TextView) itemView.findViewById(R.id.fbapps_id);
            btnDelete  = (Button) itemView.findViewById(R.id.btn_delete_apps);
        }
    }

    public AppSelectRVAdapter(List<FBApps> FBAppsList){

        ListFBApps = FBAppsList;
    }

    public void setData(List<FBApps> ListFBApps){
        this.ListFBApps = ListFBApps;
    }

    public void setItemListener(itemEventListener mItemListener){
        this.mItemListener = mItemListener;
    }

    @Override
    public AppSelectRVAdapter.FBAppsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_fbapps_row, parent, false);
        return new FBAppsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppSelectRVAdapter.FBAppsHolder holder, int position) {
        FBApps mFBApps = ListFBApps.get(position);
        holder.TVAppsName.setText(mFBApps.getApps_name());
        holder.TVFBAppsID.setText(mFBApps.getFbapps_id());
        FBApps mApps = ListFBApps.get(position);
        holder.btnDelete.setTag(mApps.getApps_id());
        holder.itemView.setTag(mApps.getApps_id());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = (int) view.getTag();
                mItemListener.deleteItem(id);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemListener.onClick((int)view.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {

        return ListFBApps.size();
    }




}
