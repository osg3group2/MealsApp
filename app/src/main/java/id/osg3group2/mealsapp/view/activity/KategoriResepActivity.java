package id.osg3group2.mealsapp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.adapter.ListCategoryByFilterAdapter;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.vm.CategoryViewModel;

import static android.support.constraint.Constraints.TAG;

public class KategoriResepActivity extends AppCompatActivity implements CategoryNavigator {


    @BindView(R.id.recyclerView_kategori_makanan_by_filter)
    RecyclerView recyclerViewKategoriMakananByFilter;
    @BindView(R.id.jenis_category)
    TextView jenisCategory;
    @BindView(R.id.toolbar_detail_resep_makanan)
    Toolbar toolbarDetailResepMakanan;
    @BindView(R.id.progressbar_category)
    ProgressBar progressbarCategory;

    private CategoryViewModel categoryViewModel;
    private ListCategoryByFilterAdapter listCategoryByFilterAdapter;
    private List<ListMealsCategoryData> mealsCategoryDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_resep);
        ButterKnife.bind(this);

        categoryViewModel = new CategoryViewModel(Injection.provideCategoryRepository(this));
        mealsCategoryDataList = new ArrayList<>();
        categoryViewModel.setCategoryNavigator(this);

        String category_query = getIntent().getStringExtra("query_category");
        jenisCategory.setText("Category : " + category_query);
        progressbarCategory.setVisibility(View.VISIBLE);
        categoryViewModel.getListCategoryByFilter(category_query);
        listCategoryByFilterAdapter = new ListCategoryByFilterAdapter(mealsCategoryDataList, this);
        recyclerViewKategoriMakananByFilter.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewKategoriMakananByFilter.setAdapter(listCategoryByFilterAdapter);
        toolbarDetailResepMakanan.setTitle("Category : " + category_query);
        setSupportActionBar(toolbarDetailResepMakanan);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadListCategoryMeals(List<ListCategoryData> categoryDataList) {

    }

    @Override
    public void loadListCategoryByFilter(List<ListMealsCategoryData> mealsCategoryDataList) {
        try {
            this.mealsCategoryDataList.addAll(mealsCategoryDataList);
            listCategoryByFilterAdapter.notifyDataSetChanged();
            progressbarCategory.setVisibility(View.GONE);
        } catch (Exception e){
            e.printStackTrace();
            progressbarCategory.setVisibility(View.GONE);
            Toast.makeText(this, "Data Tidak Ditemukan !", Toast.LENGTH_SHORT).show();
        }
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
