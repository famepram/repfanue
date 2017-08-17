package ekalaya.id.repfanue.data.models.responses.fbcheckapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Femmy on 8/17/2017.
 */

public class Roles {

    @SerializedName("app_id")
    @Expose
    private String AppId;

    @SerializedName("user")
    @Expose
    private String User;

    @SerializedName("role")
    @Expose
    private List<String> Role;

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public List<String> getRole() {
        return Role;
    }

    public void setRole(List<String> role) {
        Role = role;
    }
}
