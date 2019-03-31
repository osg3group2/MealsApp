package id.osg3group2.mealsapp.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.osg3group2.mealsapp.R;

public class DetailResepMakananActivity extends AppCompatActivity {

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

    static final String STRMEAL = "STRMEAL";
    static final String STRMEALTHUMB = "STRMEALTHUMB";
    static final String STRINSTRUCTIONS = "STRINSTRUCTIONS";
    static final String STRJOININGREDIENTSANDMEASURE = "STRJOININGREDIENTSANDMEASURE";
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.mAppBar)
    AppBarLayout mAppBar;
    private String namaMeals, imageMealsThumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_makanan);
        ButterKnife.bind(this);
        setData();

//        collapsingToolbar.setVisibility(View.INVISIBLE);
        toolbarDetailResepMakanan.setTitle(namaMeals);
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

    private void setData() {
        namaMeals = getIntent().getStringExtra(STRMEAL);
        imageMealsThumb = getIntent().getStringExtra(STRMEALTHUMB);


        Glide.with(this)
                .load(imageMealsThumb)
                .into(imageDetailResepMakanan);
        textIngredientsDetailResepMakanan.setText(getIntent().getStringExtra(STRJOININGREDIENTSANDMEASURE));
        textInstructionDetailResepMakanan.setText(getIntent().getStringExtra(STRINSTRUCTIONS));

        if (imageMealsThumb == null) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mAppBar.getLayoutParams();
            params.height = 3 * 50; // HEIGHT

            mAppBar.setLayoutParams(params);
            mAppBar.setExpanded(false);
        }
    }
}
