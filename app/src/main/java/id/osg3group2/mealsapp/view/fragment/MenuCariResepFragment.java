package id.osg3group2.mealsapp.view.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.adapter.SearchMealsAdapter;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.helpers.MealsNavigator;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.view.activity.NavDrawerActivity;
import id.osg3group2.mealsapp.vm.MealsViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuCariResepFragment extends Fragment implements MealsNavigator {

    View view;
    @BindView(R.id.recyclerView_resep_makanan)
    RecyclerView recyclerViewResepMakanan;
    Unbinder unbinder;

    private MealsViewModel mealsViewModel;
    private SearchMealsAdapter mealsAdapter;
    private List<SearchMealsData> searchMealsDataList;


    public MenuCariResepFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu_cari_resep, container, false);
        unbinder = ButterKnife.bind(this, view);

        mealsViewModel = new MealsViewModel(Injection.provideMealsRepository(getActivity()));
        searchMealsDataList = new ArrayList<>();
        mealsViewModel.setMealsNavigator(this);

        if (getArguments() != null) {
            String search_query = getArguments().getString("query_string");
            mealsViewModel.getListMeals(search_query);
            mealsAdapter = new SearchMealsAdapter(searchMealsDataList, getActivity());
            recyclerViewResepMakanan.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recyclerViewResepMakanan.setAdapter(mealsAdapter);
        }

        return view;
    }

    public void setTestString(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadListMeals(List<SearchMealsData> searchMealsDataList) {
        this.searchMealsDataList.addAll(searchMealsDataList);
        mealsAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListMeals(String message) {
        Log.e("ERROR", message);

    }
}
