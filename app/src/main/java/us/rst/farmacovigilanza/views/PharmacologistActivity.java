package us.rst.farmacovigilanza.views;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.PharmacologistViewPagerAdapter;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;
import us.rst.farmacovigilanza.databinding.ActivityPharmacologistBinding;

public class PharmacologistActivity extends BaseActivity
        implements ReportsPharmacologistFragment.OnFragmentInteractionListener,
        DrugsPharmacologistFragment.OnFragmentInteractionListener {

    private ActivityPharmacologistBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pharmacologist;
    }

    @Override
    protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public BaseActivity getCurrentActivity() {
        return super.getCurrentActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set tabLayout
        TabLayout tabLayout = (TabLayout)binding.tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.activity_pharmacologist_tab_title_reports)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.activity_pharmacologist_tab_title_drugs)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Set viewPager adapter
        final ViewPager viewPager = (ViewPager)binding.viewPager;
        final PharmacologistViewPagerAdapter adapter = new PharmacologistViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Listener of gesture to change tab
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Listener of click on tab
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
