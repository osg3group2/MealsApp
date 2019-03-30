package id.osg3group2.mealsapp.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import id.osg3group2.mealsapp.adapter.SearchMealsAdapter;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.helpers.MealsNavigator;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.vm.MealsViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuCariResepFragment extends Fragment implements MealsNavigator {

    View view;
    @BindView(R.id.recyclerView_resep_makanan)
    RecyclerView recyclerViewResepMakanan;
    Unbinder unbinder;
    @BindView(R.id.progressbar_search)
    ProgressBar progressbarSearch;

    private MealsViewModel mealsViewModel;
    private SearchMealsAdapter mealsAdapter;
    private ArrayList<SearchMealsData> searchMealsDataList;

    public static final String KEY_RESEP = "resep";


    public MenuCariResepFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu_cari_resep, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mealsViewModel = new MealsViewModel(Injection.provideMealsRepository(getActivity()));
        searchMealsDataList = new ArrayList<>();
        mealsViewModel.setMealsNavigator(this);

        mealsAdapter = new SearchMealsAdapter(searchMealsDataList, getActivity());

        recyclerViewResepMakanan.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewResepMakanan.setHasFixedSize(true);
        recyclerViewResepMakanan.setAdapter(mealsAdapter);

        if(savedInstanceState == null) {

            if (getArguments() != null) {
                String search_query = getArguments().getString("query_string");
                progressbarSearch.setVisibility(View.VISIBLE);
                mealsViewModel.getListMeals(search_query);
            }
        } else{
            ArrayList<SearchMealsData> mList2 = savedInstanceState.getParcelableArrayList(KEY_RESEP);
            searchMealsDataList.addAll(mList2);
            mealsAdapter.notifyDataSetChanged();
        }
      
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_RESEP, searchMealsDataList);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadListMeals(List<SearchMealsData> searchMealsDataList) {
        try {
            this.searchMealsDataList.addAll(searchMealsDataList);
            mealsAdapter.notifyDataSetChanged();
            progressbarSearch.setVisibility(View.GONE);
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Data Tidak Ditemukan !", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            progressbarSearch.setVisibility(View.GONE);
        }
    }

    @Override
    public void errorLoadListMeals(String message) {
        Log.e("ERROR", message);
        progressbarSearch.setVisibility(View.GONE);
    }
}
