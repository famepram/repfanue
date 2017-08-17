package ekalaya.id.repfanue.data.models.responses.fbcheckapp;

/**
 * Created by Femmy on 8/17/2017.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Apps {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("namespace")
    @Expose
    private String namespace;
    @SerializedName("id")
    @Expose
    private String id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
