
package ekalaya.id.repfanue.data.models.responses.fbtokencheck;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("app_id")
    @Expose
    private Long appId;
    @SerializedName("application")
    @Expose
    private String application;
    @SerializedName("expires_at")
    @Expose
    private Integer expiresAt;
    @SerializedName("is_valid")
    @Expose
    private Boolean isValid;
    @SerializedName("issued_at")
    @Expose
    private Integer issuedAt;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("scopes")
    @Expose
    private List<String> scopes = null;
    @SerializedName("user_id")
    @Expose
    private Long userId;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Integer getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Integer expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Integer getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
