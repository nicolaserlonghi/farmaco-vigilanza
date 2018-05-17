package us.rst.farmacovigilanza.views;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ActivityLoginBinding;
import us.rst.farmacovigilanza.helpers.ProgressDialogHelper;
import us.rst.farmacovigilanza.helpers.SnackBarHelper;
import us.rst.farmacovigilanza.helpers.UtilityHelper;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;
import us.rst.farmacovigilanza.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private ProgressDialog progressDialogAuthenticating;

    @Override protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override protected void setToolbar() {
    }

    @Override protected LoginViewModel getViewModel() {
        if (viewModel == null) {
            LoginViewModel.Factory factory = new LoginViewModel.Factory(getApplication());
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
        binding.activityLoginBtnLogin.setOnClickListener(v -> {
            // Login button  disable
            binding.activityLoginBtnLogin.setEnabled(false);
            UtilityHelper.hideKeyboard(LoginActivity.this);
            String cf = binding.activityLoginInputCf.getText().toString();
            String password = binding.activityLoginInputPassword.getText().toString();
            // Check if the fields are empty
            if(cf.isEmpty() || password.isEmpty()) {
                SnackBarHelper.showShort(v, getResources().getString(R.string.snackBar_activity_login_empty_field));
                // Login button enable
                binding.activityLoginBtnLogin.setEnabled(true);
            }  else {
                // Start animation of authenticating
                progressDialogAuthenticating = ProgressDialogHelper.start(LoginActivity.this, getResources().getString(R.string.progress_dialog_activity_login_login));
                // Try to do login
                if(getViewModel().doLogin(cf, password)) {
                    // User logged correctly
                    Logger.d("LoginActivity", "user correctly logged");
                } else {
                    // Wrong credential
                    SnackBarHelper.showShort(v, getResources().getString(R.string.snackBar_activity_login_wrong_credential));
                    Logger.w("LoginActivity", "wrong credential");
                }
                // Stop animation of authenticating
                ProgressDialogHelper.stop(progressDialogAuthenticating);
                // login button and login link enable
                binding.activityLoginBtnLogin.setEnabled(true);
            }

        });
    }
}
