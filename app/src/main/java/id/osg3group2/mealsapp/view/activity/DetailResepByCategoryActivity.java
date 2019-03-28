package id.osg3group2.mealsapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.adapter.DetailResepByIdAdapter;
import id.osg3group2.mealsapp.adapter.ListCategoryByFilterAdapter;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.vm.CategoryViewModel;

public class DetailResepByCategoryActivity extends AppCompatActivity implements CategoryNavigator {

    private CategoryViewModel categoryViewModel;
    private DetailResepByIdAdapter detailResepByIdAdapter;
    private List<SearchMealsData> mealsCategoryDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_by_category);
        String ID = getIntent().getStringExtra("ID");

        categoryViewModel = new CategoryViewModel(Injection.provideCategoryRepository(this));
        mealsCategoryDataList = new ArrayList<>();
        categoryViewModel.setCategoryNavigator(this);


        categoryViewModel.getListCategoryByFilter(ID);
        detailResepByIdAdapter = new DetailResepByIdAdapter(mealsCategoryDataList, this);
    }

    @Override
    public void loadListCategoryMeals(List<ListCategoryData> categoryDataList) {

    }

    @Override
    public void loadListCategoryByFilter(List<ListMealsCategoryData> mealsCategoryDataList) {

    }

    @Override
    public void loadListCategoryById(List<SearchMealsData> mealsDataList) {
        this.mealsCategoryDataList.addAll(mealsDataList);
        detailResepByIdAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListCategoryMeals(String message) {

    }
}
