package us.rst.farmacovigilanza.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.inputmethod.InputMethodManager;

/**
 * Static functions to handle keyboard
 */
public class KeyboardHelper {
    /**
     * Hides the keyboard
     * @param activity current activity
     */
    public static void hideKeyboard(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null) {
            return;
        }

        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
