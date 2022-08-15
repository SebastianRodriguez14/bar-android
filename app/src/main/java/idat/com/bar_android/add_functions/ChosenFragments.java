package idat.com.bar_android.add_functions;

import androidx.fragment.app.Fragment;

public class ChosenFragments {

    private static Fragment fragment;
    private static int indexFragment = 0;

    public static int getIndexFragment() {
        return indexFragment;
    }

    public static void setIndexFragment(int indexFragment) {
        ChosenFragments.indexFragment = indexFragment;
    }

    public static Fragment getFragment() {
        return fragment;
    }

    public static void setFragment(Fragment fragment) {
        ChosenFragments.fragment = fragment;
    }



}
