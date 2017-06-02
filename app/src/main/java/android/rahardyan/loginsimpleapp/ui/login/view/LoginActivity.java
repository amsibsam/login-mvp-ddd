package android.rahardyan.loginsimpleapp.ui.login.view;

import android.rahardyan.loginsimpleapp.R;
import android.rahardyan.loginsimpleapp.base.BaseActivity;
import android.os.Bundle;
import android.rahardyan.loginsimpleapp.ui.login.presenter.LoginContract;
import android.rahardyan.loginsimpleapp.ui.login.presenter.LoginPresenter;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private LoginPresenter loginPresenter;
    private TextInputEditText etNim, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(this, this);
        initView();
    }

    private void initView() {
        setUpToolbar(false, getString(R.string.login_title));

        etNim = (TextInputEditText) findViewById(R.id.nim);
        etPassword = (TextInputEditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.doLogin(etNim.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess() {
        showToast("Login success");
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        onRequestFailed(errorMessage);
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void dismissLoading() {
        dismissProgressDialog();
    }
}
