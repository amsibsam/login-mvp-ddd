package android.rahardyan.loginsimpleapp.ui.login.presenter;

import android.content.Context;
import android.rahardyan.loginsimpleapp.base.BasePresenter;
import android.support.annotation.NonNull;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rahardyan on 31/05/17.
 */

public class LoginPresenter extends BasePresenter implements LoginContract.UserActionListener{

    @NonNull
    private LoginContract.View mLoginView;

    public LoginPresenter(Context context, LoginContract.View loginView) {
        super(context);
        this.mLoginView = loginView;
    }


    @Override
    public void doLogin(String nim, String password) {
        mLoginView.showLoading();
        networkManager.doLogin(nim, password)
                .enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        mLoginView.dismissLoading();
                        if (response.isSuccessful()) {
                            mLoginView.onLoginSuccess();
                        } else {
                            mLoginView.onLoginFailed("login failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        mLoginView.dismissLoading();
                        mLoginView.onLoginFailed("login failed");
                    }
                });
    }
}
