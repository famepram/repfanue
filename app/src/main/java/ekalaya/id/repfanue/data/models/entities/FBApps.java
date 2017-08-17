package ekalaya.id.repfanue.data.models.entities;

/**
 * Created by Femmy on 8/16/2017.
 */

public class FBApps {

    private int apps_id;

    private String fbapps_id;

    private String apps_name;

    private String category;

    private double revenue;

    private boolean active;

    public int getApps_id() {
        return apps_id;
    }

    public void setApps_id(int apps_id) {
        this.apps_id = apps_id;
    }

    public String getFbapps_id() {
        return fbapps_id;
    }

    public void setFbapps_id(String fbapps_id) {
        this.fbapps_id = fbapps_id;
    }

    public String getApps_name() {
        return apps_name;
    }

    public void setApps_name(String apps_name) {
        this.apps_name = apps_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
