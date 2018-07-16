package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.databinding.ActivityAddAdverseReactionBinding;
import us.rst.farmacovigilanza.viewmodels.AdverseReactionViewModel;

public class AddAdverseReactionActivity extends BaseActivity implements View.OnClickListener{

    @Override protected int getLayoutId() {
        return R.layout.activity_add_adverse_reaction;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override protected AdverseReactionViewModel getViewModel() {
        if (viewModel == null) {
            AdverseReactionViewModel.Factory factory = new AdverseReactionViewModel.Factory(getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(AdverseReactionViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.activityAddAdverseReactionSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AdverseReactionEntity adverseReactionEntity = new AdverseReactionEntity();
        adverseReactionEntity.setName(binding.activityAddAdverseReactionNameText.getText().toString());
        adverseReactionEntity.setDescription((binding.activityAddAdverseReactionDescriptionText.getText().toString()));
        getViewModel().add(adverseReactionEntity);

        onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ActivityAddAdverseReactionBinding binding;
    private AdverseReactionViewModel viewModel;
}
