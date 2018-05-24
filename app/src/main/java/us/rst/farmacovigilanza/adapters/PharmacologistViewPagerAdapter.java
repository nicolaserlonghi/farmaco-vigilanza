package us.rst.farmacovigilanza.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import us.rst.farmacovigilanza.views.DrugsPharmacologistFragment;
import us.rst.farmacovigilanza.views.ReportsPharmacologistFragment;

public class PharmacologistViewPagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PharmacologistViewPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ReportsPharmacologistFragment reportsPharmacologistFragment = new ReportsPharmacologistFragment();
                return reportsPharmacologistFragment;
            case 1:
                DrugsPharmacologistFragment drugsPharmacologistFragment = new DrugsPharmacologistFragment();
                return drugsPharmacologistFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
