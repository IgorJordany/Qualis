package br.ufmt.ic.qualis.qualis.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.ufmt.ic.qualis.qualis.fragments.FragmentConferencias;
import br.ufmt.ic.qualis.qualis.fragments.FragmentCorrelacao;
import br.ufmt.ic.qualis.qualis.fragments.FragmentPeriodicos;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTabTitiles;

    public MyFragmentPagerAdapter(FragmentManager fm, String[] mTabTitiles) {
        super(fm);
        this.mTabTitiles = mTabTitiles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentConferencias();
            case 1:
                return new FragmentPeriodicos();
            case 2:
                return new FragmentCorrelacao();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitiles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitiles[position];
    }
}
