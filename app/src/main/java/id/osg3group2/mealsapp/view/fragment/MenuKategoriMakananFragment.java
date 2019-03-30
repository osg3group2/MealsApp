package id.osg3group2.mealsapp.view.fragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.vm.CategoryViewModel;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuKategoriMakananFragment extends Fragment implements CategoryNavigator {

    @BindView(R.id.recyclerView_kategori_makanan)
    RecyclerView recyclerViewKategoriMakanan;
    Unbinder unbinder;
    @BindView(R.id.progressbar_category)
    ProgressBar progressbarCategory;

    private CategoryViewModel categoryViewModel;
    private ListCategoryAdapter categoryAdapter;
    private ArrayList<ListCategoryData> categoryDataList;

    public static final String KEY_CATEGORY = "category";


    public MenuKategoriMakananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_kategori_makanan, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryViewModel = new CategoryViewModel(Injection.provideCategoryRepository(getActivity()));
        categoryDataList = new ArrayList<>();
        categoryViewModel.setCategoryNavigator(this);

        categoryAdapter = new ListCategoryAdapter(categoryDataList, getActivity());
        recyclerViewKategoriMakanan.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewKategoriMakanan.setAdapter(categoryAdapter);

        if(savedInstanceState == null) {
            progressbarCategory.setVisibility(View.VISIBLE);
            categoryViewModel.getListCategory();
        } else {
            ArrayList<ListCategoryData> mList2 = savedInstanceState.getParcelableArrayList(KEY_CATEGORY);
            categoryDataList.addAll(mList2);
            categoryAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_CATEGORY, categoryDataList);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadListCategoryMeals(List<ListCategoryData> categoryDataList) {
        try{
            this.categoryDataList.addAll(categoryDataList);
            categoryAdapter.notifyDataSetChanged();
            progressbarCategory.setVisibility(View.GONE);
        } catch (Exception e) {
            progressbarCategory.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "Data Tidak Ditemukan !", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    @Override
    public void loadListCategoryByFilter(List<ListMealsCategoryData> mealsCategoryDataList) {

    }

    @Override
    public void loadListCategoryById(List<SearchMealsData> mealsDataList) {

    }

    @Override
    public void loadListCategoryByFilter(List<ListMealsCategoryData> mealsCategoryDataList) {

    }

    @Override
    public void loadListCategoryById(List<SearchMealsData> mealsDataList) {

    }

    @Override
    public void errorLoadListCategoryMeals(String message) {
        Log.e(TAG, "errorLoadListCategoryMeals: " + message);
        progressbarCategory.setVisibility(View.GONE);
    }
}
