package us.rst.farmacovigilanza.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pixplicity.easyprefs.library.Prefs;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.PharmacologistViewPagerAdapter;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;
import us.rst.farmacovigilanza.databinding.MainActivityPharmacologistBinding;

public class MainPharmacologistActivity extends BaseActivity {

    private MainActivityPharmacologistBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.activity_main_menu_logout:
                Prefs.putBoolean("isLoggedIn", true);
                // TODO: clear backstack
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_pharmacologist;
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
        TabLayout tabLayout = binding.activityPharmacologistTabLayout;
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.activity_pharmacologist_tab_title_reports)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.activity_pharmacologist_tab_title_drugs)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Set viewPager adapter
        final ViewPager viewPager = (ViewPager)binding.activityPharmacologistViewPager;
        final PharmacologistViewPagerAdapter adapter = new PharmacologistViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Listener of gesture to change tab
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Listener of click on tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
}
