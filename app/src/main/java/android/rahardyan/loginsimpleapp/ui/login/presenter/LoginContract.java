package android.rahardyan.loginsimpleapp.ui.login.presenter;

/**
 * Created by rahardyan on 31/05/17.
 */

public interface LoginContract {
    interface View {
        void onLoginSuccess();

        void onLoginFailed(String errorMessage);

        void showLoading();

        void dismissLoading();
    }

    interface UserActionListener {
        void doLogin(String nim, String password);
    }
}
