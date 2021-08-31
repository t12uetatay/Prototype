package id.t12uetatay.prototype.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import id.t12uetatay.prototype.view.fragment.LoginFragment;
import id.t12uetatay.prototype.view.fragment.RegisterFragment;

public class RegisterAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public RegisterAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoginFragment();
            case 1:
                return new RegisterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}