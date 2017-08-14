
package ekalaya.id.repfanue.data.models.responses.fbtokencheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("sso")
    @Expose
    private String sso;

    public String getSso() {
        return sso;
    }

    public void setSso(String sso) {
        this.sso = sso;
    }

}
