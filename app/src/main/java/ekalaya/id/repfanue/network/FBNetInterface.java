package ekalaya.id.repfanue.network;

import java.util.Map;

import ekalaya.id.repfanue.data.models.responses.fbcheckapp.Apps;
import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Femmy on 8/15/2017.
 */

public interface FBNetInterface {
    @GET("debug_token")
    Call<Result> debugAccessToken(@Query("input_token") String inputAT, @Query("access_token") String AppAT);

    @GET("/{apps_id}")
    Call<Apps> checkFBAppsRoles(@Path("apps_id") String AppsID, @Query("access_token") String AccessToken);

    @GET("/{version}/{app_id}/app_insights/app_event")
    Call<Result> summary(@Path("version") String version, @Path("app_id") String AppAT, @QueryMap Map<String, String> params);
}
