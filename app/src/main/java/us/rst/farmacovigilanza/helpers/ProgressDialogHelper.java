package us.rst.farmacovigilanza.helpers;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogHelper {

    public static ProgressDialog start(Context context, String msg) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(msg);
        progressDialog.show();
        return progressDialog;
    }

    public static void stop(ProgressDialog progressDialog) {
        progressDialog.dismiss();
    }
}
