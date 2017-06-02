package android.rahardyan.loginsimpleapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahardyan on 31/05/17.
 */

public class NetworkFactory {
    public static Retrofit createNetwork(String baseUrl, boolean isDebug) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(isDebug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit;
    }
}
