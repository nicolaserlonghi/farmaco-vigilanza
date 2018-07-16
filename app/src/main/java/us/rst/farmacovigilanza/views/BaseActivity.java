package us.rst.farmacovigilanza.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;

/**
 * Standard Activity skeleton
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Gets the layout id
     * @return The layout id
     */
    protected abstract int getLayoutId();

    /**
     * Sets the toolbar
     */
    protected abstract void setToolbar();

    /**
     * Gets the view model
     * @return view model
     */
    protected abstract BaseViewModel getViewModel();

    /**
     * Sets the UI binding
     */
    protected abstract void setBinding();

    /**
     * Gets the current activity
     * @return current activity
     */
    public BaseActivity getCurrentActivity() {
        return this;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Why? An Activity may not have a layout. If that is the case, layoutId is zero
        if (getLayoutId() == 0) {
            Logger.w(BaseActivity.class.getSimpleName(), "Layout id is zero");

            return;
        }

        setBinding();
        setToolbar();
    }
}