package id.osg3group2.mealsapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.osg3group2.mealsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuKategoriMakananFragment extends Fragment {


    public MenuKategoriMakananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_kategori_makanan, container, false);
    }

}