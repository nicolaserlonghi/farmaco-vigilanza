package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.Toolbar;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ActivityLoginBinding;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;
import us.rst.farmacovigilanza.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity {

    @Override protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
    }

    @Override protected BaseViewModel getViewModel() {
        if (viewModel == null) {
            LoginViewModel.Factory factory = new LoginViewModel.Factory(getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
}
