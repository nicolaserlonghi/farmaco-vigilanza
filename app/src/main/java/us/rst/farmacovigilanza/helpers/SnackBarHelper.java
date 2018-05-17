package us.rst.farmacovigilanza.helpers;

import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackBarHelper {

    public static void showLong(View view, String text) {
        Snackbar snackBar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        snackBar.show();
    }

    public static void showShort(View view, String text) {
        Snackbar snackBar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        snackBar.show();
    }
}
