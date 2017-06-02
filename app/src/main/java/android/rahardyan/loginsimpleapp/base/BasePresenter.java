package android.rahardyan.loginsimpleapp.base;

import android.content.Context;
import android.rahardyan.loginsimpleapp.BuildConfig;
import android.rahardyan.loginsimpleapp.network.NetworkFactory;
import android.rahardyan.loginsimpleapp.network.NetworkManager;

/**
 * Created by rahardyan on 31/05/17.
 */

public class BasePresenter {
    protected final NetworkManager networkManager;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
        this.networkManager = new NetworkManager(context, BuildConfig.SERVER_URL, BuildConfig.DEBUG);
    }
}
