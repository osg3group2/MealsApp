package id.osg3group2.mealsapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.adapter.ListCategoryAdapter;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.vm.CategoryViewModel;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuKategoriMakananFragment extends Fragment implements CategoryNavigator {

    @BindView(R.id.recyclerView_kategori_makanan)
    RecyclerView recyclerViewKategoriMakanan;
    Unbinder unbinder;

    private CategoryViewModel categoryViewModel;
    private ListCategoryAdapter categoryAdapter;
    private List<ListCategoryData> categoryDataList;


    public MenuKategoriMakananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_kategori_makanan, container, false);
        unbinder = ButterKnife.bind(this, view);

        categoryViewModel = new CategoryViewModel(Injection.provideCategoryRepository(getActivity()));
        categoryDataList = new ArrayList<>();
        categoryViewModel.setCategoryNavigator(this);

        categoryViewModel.getListCategory();
        categoryAdapter = new ListCategoryAdapter(categoryDataList, getActivity());
        recyclerViewKategoriMakanan.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewKategoriMakanan.setAdapter(categoryAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadListCategoryMeals(List<ListCategoryData> categoryDataList) {
        this.categoryDataList.addAll(categoryDataList);
        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListCategoryMeals(String message) {
        Log.e(TAG, "errorLoadListCategoryMeals: " + message);
    }
}
