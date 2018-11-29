package android.rahardyan.loginsimpleapp;

import android.rahardyan.loginsimpleapp.base.BasePresenter;

class MainPresenter extends BasePresenter<MainViewContract> {

    public MainPresenter(MainViewContract viewContract) {
        this.view = viewContract;
    }
}
