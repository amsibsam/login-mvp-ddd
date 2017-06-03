package android.rahardyan.loginsimpleapp.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.rahardyan.loginsimpleapp.R;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by rahardyan on 31/05/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private Toolbar toolbar;
    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayout() != 0) {
            setContentView(getLayout());
            setUpProgressDialog();
            setUpAlertDialog();
        } else {
            Log.e(TAG, "please return layout ids on getLayout");
        }
    }

    /**
     * get activity layout
     *
     * @return layout id
     */
    public abstract int getLayout();


    public void setUpToolbar(boolean isBackButtonEnable, String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isBackButtonEnable);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            toolbar.setTitle(title);
        }
    }

    private void setUpProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
    }

    public void setUpProgressDialogTitle(String title) {
        progressDialog.setTitle(title);
    }

    private void setUpAlertDialog() {
        alertDialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create();
    }

    /**
     * show progress dialog
     */
    public void showProgressDialog() {
        if (progressDialog == null && !isFinishing()) {
            setUpProgressDialog();
            showProgressDialog();
        } else if (!isFinishing()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.show();
                }
            });
        }
    }

    private void showAlertDialog(String message) {
        if (alertDialog == null && !isFinishing()) {
            setUpAlertDialog();
            showAlertDialog(message);
        } else if (!isFinishing()) {
            alertDialog.setMessage(message);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    alertDialog.show();
                }
            });
        }
    }

    /**
     * dismiss progress dialog
     */
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            });
        }
    }

    /**
     * handle activity when no internet connection
     */
    public void onNoInternetConnection() {
        dismissProgressDialog();
        showAlertDialog(getResources().getString(R.string.error_no_internet));
    }

    /**
     * handle activity when api request failed
     *
     * @param errorMessage - error message
     */
    public void onRequestFailed(String errorMessage) {
        dismissProgressDialog();
        showAlertDialog(errorMessage);
    }

    /**
     * show Toast
     * @param message - string toast messagegit
     */
    public void showToast(String message) {
        if (getApplicationContext() != null) {
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}
