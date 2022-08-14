package idat.com.bar_android.add_functions;

import androidx.fragment.app.Fragment;

public class ChosenFragment {

    private static Fragment fragment;

    public static Fragment getFragment() {
        return fragment;
    }

    public static void setFragment(Fragment fragment) {
        ChosenFragment.fragment = fragment;
    }
}
