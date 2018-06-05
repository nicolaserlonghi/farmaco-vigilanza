package us.rst.farmacovigilanza.views;

import android.content.Intent;
import android.os.Bundle;
import com.pixplicity.easyprefs.library.Prefs;
import us.rst.farmacovigilanza.models.Credentials.UserType;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;

public class BootstrapActivity extends BaseActivity {

    @Override protected int getLayoutId() {
        return 0;
    }

    @Override protected void setToolbar() { }

    @Override protected BaseViewModel getViewModel() {
        return null;
    }

    @Override protected void setBinding() { }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!Prefs.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(this, AddAdverseReactionActivity.class));
        }
        else {
            // Get user type
            String userType = Prefs.getString("userType", null);
            if (UserType.valueOf(userType) == UserType.DOCTOR) {
                startActivity(new Intent(this, MainDoctorActivity.class));
            }
            else {
                // TODO:
            }
        }
    }
}
