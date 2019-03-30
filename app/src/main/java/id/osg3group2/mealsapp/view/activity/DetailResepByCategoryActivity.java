package id.osg3group2.mealsapp.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.helpers.Injection;
import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.vm.CategoryViewModel;

public class DetailResepByCategoryActivity extends AppCompatActivity implements CategoryNavigator {

    @BindView(R.id.image_detail_resep_makanan)
    ImageView imageDetailResepMakanan;
    @BindView(R.id.toolbar_detail_resep_makanan)
    Toolbar toolbarDetailResepMakanan;
    @BindView(R.id.text_ingredients_detail_resep_makanan)
    TextView textIngredientsDetailResepMakanan;
    @BindView(R.id.text_instruction_detail_resep_makanan)
    TextView textInstructionDetailResepMakanan;
    @BindView(R.id.parentView_detail_resep_makanan)
    CoordinatorLayout parentViewDetailResepMakanan;
    private CategoryViewModel categoryViewModel;
    private List<SearchMealsData> mealsCategoryDataList;
    private String namaMeals;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_by_category);
        ButterKnife.bind(this);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();


        String ID = getIntent().getStringExtra("ID");
        String NAME = getIntent().getStringExtra("NAME");

        categoryViewModel = new CategoryViewModel(Injection.provideCategoryRepository(this));
        mealsCategoryDataList = new ArrayList<>();
        categoryViewModel.setCategoryNavigator(this);


        categoryViewModel.getListCategoryById(ID);
        toolbarDetailResepMakanan.setTitle(NAME);
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

    }

    @Override
    public void loadListCategoryById(List<SearchMealsData> mealsDataList) {
        try {
            namaMeals = mealsDataList.get(0).getStrMeal();

            String joinIngredientsandMeasure =
                    mealsDataList.get(0).getStrIngredient1() + " " + mealsDataList.get(0).getStrMeasure1()
                            + "\n" + mealsDataList.get(0).getStrIngredient2() + " " + mealsDataList.get(0).getStrMeasure2()
                            + "\n" + mealsDataList.get(0).getStrIngredient3() + " " + mealsDataList.get(0).getStrMeasure3()
                            + "\n" + mealsDataList.get(0).getStrIngredient4() + " " + mealsDataList.get(0).getStrMeasure4()
                            + "\n" + mealsDataList.get(0).getStrIngredient5() + " " + mealsDataList.get(0).getStrMeasure5()
                            + "\n" + mealsDataList.get(0).getStrIngredient6() + " " + mealsDataList.get(0).getStrMeasure6()
                            + "\n" + mealsDataList.get(0).getStrIngredient7() + " " + mealsDataList.get(0).getStrMeasure7()
                            + "\n" + mealsDataList.get(0).getStrIngredient8() + " " + mealsDataList.get(0).getStrMeasure8()
                            + "\n" + mealsDataList.get(0).getStrIngredient9() + " " + mealsDataList.get(0).getStrMeasure9()
                            + "\n" + mealsDataList.get(0).getStrIngredient10() + " " + mealsDataList.get(0).getStrMeasure10()
                            + "\n" + mealsDataList.get(0).getStrIngredient11() + " " + mealsDataList.get(0).getStrMeasure11()
                            + "\n" + mealsDataList.get(0).getStrIngredient12() + " " + mealsDataList.get(0).getStrMeasure12()
                            + "\n" + mealsDataList.get(0).getStrIngredient13() + " " + mealsDataList.get(0).getStrMeasure13()
                            + "\n" + mealsDataList.get(0).getStrIngredient14() + " " + mealsDataList.get(0).getStrMeasure14()
                            + "\n" + mealsDataList.get(0).getStrIngredient15() + " " + mealsDataList.get(0).getStrMeasure15()
                            + "\n" + mealsDataList.get(0).getStrIngredient16() + " " + mealsDataList.get(0).getStrMeasure16()
                            + "\n" + mealsDataList.get(0).getStrIngredient17() + " " + mealsDataList.get(0).getStrMeasure17()
                            + "\n" + mealsDataList.get(0).getStrIngredient18() + " " + mealsDataList.get(0).getStrMeasure18()
                            + "\n" + mealsDataList.get(0).getStrIngredient19() + " " + mealsDataList.get(0).getStrMeasure19()
                            + "\n" + mealsDataList.get(0).getStrIngredient20() + " " + mealsDataList.get(0).getStrMeasure20();
            Glide.with(this)
                    .load(mealsDataList.get(0).getStrMealThumb())
                    .into(imageDetailResepMakanan);
            textInstructionDetailResepMakanan
                    .setText(mealsDataList.get(0).getStrInstructions());
            textIngredientsDetailResepMakanan.setText(joinIngredientsandMeasure);

            pd.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
            pd.dismiss();
            Toast.makeText(this, "Data tidak ditemukan !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void errorLoadListCategoryMeals(String message) {
        pd.dismiss();

    }
}
