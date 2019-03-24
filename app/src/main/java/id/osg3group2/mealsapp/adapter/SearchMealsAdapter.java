package id.osg3group2.mealsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.utils.ItemClickSupport;
import id.osg3group2.mealsapp.view.activity.DetailResepMakananActivity;

public class SearchMealsAdapter extends RecyclerView.Adapter<SearchMealsAdapter.MealsHolder> {


    private LayoutInflater layoutInflater;
    private List<SearchMealsData> searchMealsDataList;
    private Context context;

    static final String STRMEAL = "STRMEAL";
    static final String STRMEALTHUMB = "STRMEALTHUMB";
    static final String STRINSTRUCTIONS = "STRINSTRUCTIONS";
    static final String STRJOININGREDIENTSANDMEASURE = "STRJOININGREDIENTSANDMEASURE";

    public SearchMealsAdapter(List<SearchMealsData> searchMealsDataList, Context context) {
        this.searchMealsDataList = searchMealsDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MealsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = layoutInflater.inflate(R.layout.item_resep_makanan, viewGroup, false);
        return new MealsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsHolder mealsHolder, final int i) {
        mealsHolder.textItemNamaResepMakanan.setText(searchMealsDataList.get(i).getStrMeal());
        mealsHolder.textItemAsalResepMakanan.setText(searchMealsDataList.get(i).getStrArea());
        Glide.with(context).load(searchMealsDataList.get(i).getStrMealThumb()).into(mealsHolder.imageItemResepMakanan);

        final String joinIngredientsandMeasure =
                searchMealsDataList.get(i).getStrIngredient1() + " " + searchMealsDataList.get(i).getStrMeasure1()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient2() + " " + searchMealsDataList.get(i).getStrMeasure2()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient3() + " " + searchMealsDataList.get(i).getStrMeasure3()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient4() + " " + searchMealsDataList.get(i).getStrMeasure4()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient5() + " " + searchMealsDataList.get(i).getStrMeasure5()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient6() + " " + searchMealsDataList.get(i).getStrMeasure6()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient7() + " " + searchMealsDataList.get(i).getStrMeasure7()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient8() + " " + searchMealsDataList.get(i).getStrMeasure8()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient9() + " " + searchMealsDataList.get(i).getStrMeasure9()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient10() + " " + searchMealsDataList.get(i).getStrMeasure10()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient11() + " " + searchMealsDataList.get(i).getStrMeasure11()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient12() + " " + searchMealsDataList.get(i).getStrMeasure12()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient13() + " " + searchMealsDataList.get(i).getStrMeasure13()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient14() + " " + searchMealsDataList.get(i).getStrMeasure14()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient15() + " " + searchMealsDataList.get(i).getStrMeasure15()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient16() + " " + searchMealsDataList.get(i).getStrMeasure16()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient17() + " " + searchMealsDataList.get(i).getStrMeasure17()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient18() + " " + searchMealsDataList.get(i).getStrMeasure18()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient19() + " " + searchMealsDataList.get(i).getStrMeasure19()
                        + "\n" + searchMealsDataList.get(i).getStrIngredient20() + " " + searchMealsDataList.get(i).getStrMeasure20();

        mealsHolder.cardViewItemResepMakanan.setOnClickListener(new ItemClickSupport(i, new ItemClickSupport.OnItemClick() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context, DetailResepMakananActivity.class);
                intent.putExtra(STRMEAL, searchMealsDataList.get(i).getStrMeal());
                intent.putExtra(STRMEALTHUMB, searchMealsDataList.get(i).getStrMealThumb());
                intent.putExtra(STRINSTRUCTIONS, searchMealsDataList.get(i).getStrInstructions());
                intent.putExtra(STRJOININGREDIENTSANDMEASURE, joinIngredientsandMeasure);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return searchMealsDataList.size();
    }


    static
    class MealsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_item_resep_makanan)
        ImageView imageItemResepMakanan;
        @BindView(R.id.text_item_nama_resep_makanan)
        TextView textItemNamaResepMakanan;
        @BindView(R.id.text_item_asal_resep_makanan)
        TextView textItemAsalResepMakanan;
        @BindView(R.id.cardView_item_resep_makanan)
        CardView cardViewItemResepMakanan;

        public MealsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
