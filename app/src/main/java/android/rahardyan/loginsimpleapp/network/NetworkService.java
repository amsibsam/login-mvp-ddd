package android.rahardyan.loginsimpleapp.network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by rahardyan on 31/05/17.
 */

public interface NetworkService {
    @FormUrlEncoded
    @POST("mahasiswa/login")
    Call<JsonElement> login(@Field("nim") String nim,
                            @Field("password") String password);
}
