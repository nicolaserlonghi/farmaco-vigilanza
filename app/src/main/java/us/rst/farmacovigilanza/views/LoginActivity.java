package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ActivityLoginBinding;
import us.rst.farmacovigilanza.helpers.SnackBarHelper;
import us.rst.farmacovigilanza.helpers.KeyboardHelper;
import us.rst.farmacovigilanza.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override protected void setToolbar() {
    }

    @Override protected LoginViewModel getViewModel() {
        if (viewModel == null) {
            LoginViewModel.Factory factory = new LoginViewModel.Factory(getApplication(),
                    ((FarmacoVigilanzaApp)getApplication()).getDataRepository().getDoctorsRepository());
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
        KeyboardHelper.hideKeyboard(LoginActivity.this);

        String id = binding.activityLoginInputCf.getText().toString();
        String password = binding.activityLoginInputPassword.getText().toString();

        // Check if the fields are empty
        if (id.isEmpty() || password.isEmpty()) {
            SnackBarHelper.showShort(v, getResources().getString(R.string.error_empty_field));
            return;
        }

        if (getViewModel().getDoctor(id, password) != null) {
            // User logged correctly
            Logger.d("LoginActivity", "user correctly logged");
        } else {
            // Wrong credential
            SnackBarHelper.showShort(v, getResources().getString(R.string.error_wrong_credentials));
            Logger.w("LoginActivity", "wrong credential");
        }
    }

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
}
