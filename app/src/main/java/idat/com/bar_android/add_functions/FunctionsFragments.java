package idat.com.bar_android.add_functions;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import idat.com.bar_android.R;

public class FunctionsFragments {

    private static Fragment fragment;

    public static Fragment getFragment() {
        return fragment;
    }

    public static void setFragment(Fragment fragment) {
        FunctionsFragments.fragment = fragment;
    }



}
