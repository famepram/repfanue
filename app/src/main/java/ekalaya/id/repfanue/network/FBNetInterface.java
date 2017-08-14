package ekalaya.id.repfanue.network;

import ekalaya.id.repfanue.data.models.responses.fbtokencheck.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Femmy on 8/15/2017.
 */

public interface FBNetInterface {
    @GET("users")
    Call<Result> debugAccessToken(@Query("id") String inputAT, @Query("id") String AppAT);
}
