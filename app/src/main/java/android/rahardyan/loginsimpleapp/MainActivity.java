package android.rahardyan.loginsimpleapp;

import android.rahardyan.loginsimpleapp.base.BaseActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainViewContract, android.support.v7.view.ActionMode.Callback {
    private TextView tvHello;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {
        setUpToolbar("Lul", true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

        tvHello = findViewById(R.id.tv_hello);

        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSupportActionMode(MainActivity.this);
            }
        });
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

    @Override
    public boolean onCreateActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onPrepareActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(android.support.v7.view.ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(android.support.v7.view.ActionMode mode) {

    }
}
