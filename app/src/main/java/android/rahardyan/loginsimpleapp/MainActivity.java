package android.rahardyan.loginsimpleapp;

import android.rahardyan.loginsimpleapp.base.BaseActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity<MainPresenter> implements MainViewContract {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void fetchIntentExtra() {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }
}
