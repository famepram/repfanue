package ekalaya.id.repfanue.network;

import ekalaya.id.repfanue.data.models.responses.fbcheckapp.Apps;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Femmy on 8/15/2017.
 */

public interface FBNetInterface {
    @GET("debug_token")
    Call<Result> debugAccessToken(@Query("input_token") String inputAT, @Query("access_token") String AppAT);

    @GET("/{apps_id}")
    Call<Apps> checkFBAppsRoles(@Path("apps_id") String AppsID, @Query("access_token") String AccessToken);
}
