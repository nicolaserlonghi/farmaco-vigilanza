package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import com.pixplicity.easyprefs.library.Prefs;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ActivityLoginBinding;
import us.rst.farmacovigilanza.helpers.SnackBarHelper;
import us.rst.farmacovigilanza.helpers.KeyboardHelper;
import us.rst.farmacovigilanza.models.Credentials.UserType;
import us.rst.farmacovigilanza.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override protected void setToolbar() { }

    @Override protected LoginViewModel getViewModel() {
        if (viewModel == null) {
            LoginViewModel.Factory factory = new LoginViewModel.Factory(getApplication(),
                    ((FarmacoVigilanzaApp)getApplication()).getDataRepository().getCredentialsRepository());
            viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Listener login button
        binding.activityLoginBtnLogin.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        if (v.getId() != R.id.activity_login_btn_login) {
            return;
        }

        // Login button disable
        // KeyboardHelper.hideKeyboard(LoginActivity.this);

        String id = binding.activityLoginInputCf.getText().toString();
        String password = binding.activityLoginInputPassword.getText().toString();

        // Check if the fields are empty
        if (id.isEmpty() || password.isEmpty()) {
            SnackBarHelper.showShort(v, getResources().getString(R.string.error_empty_field));
            return;
        }

        getViewModel().getUser(id, password).observe(this, user -> {
            if (user == null) {
                // Wrong credential
                SnackBarHelper.showShort(v, getResources().getString(R.string.error_wrong_credentials));
                Logger.w("LoginActivity", "wrong credential");

                return;
            }

            Prefs.putString("userId", user.getId());
            Prefs.putString("userType", user.getUserType().toString());
            Prefs.putBoolean("isLoggedIn", true);

            if (user.getUserType() == UserType.DOCTOR) {
                startActivity(new Intent(this, MainDoctorActivity.class));
            }
            else {
                startActivity(new Intent(this, MainPharmacologistActivity.class));
            }
        });
    }

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
}
