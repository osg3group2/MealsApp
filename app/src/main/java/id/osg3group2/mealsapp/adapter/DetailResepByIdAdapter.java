package id.osg3group2.mealsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.model.SearchMealsData;

public class DetailResepByIdAdapter extends RecyclerView.Adapter<DetailResepByIdAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<SearchMealsData> mealsDataList;
    private Context context;

    public DetailResepByIdAdapter(List<SearchMealsData> mealsDataList, Context context) {
        this.mealsDataList = mealsDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = layoutInflater.inflate(R.layout.activity_detail_resep_by_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.toolbarDetailResepMakanan
                .setTitle(mealsDataList.get(position).getStrMeal());
        viewHolder.textIngredientsDetailResepMakanan
                .setText(mealsDataList.get(position).getStrIngredient1());
        viewHolder.textInstructionDetailResepMakanan.setText(mealsDataList.get(position).getStrInstructions());
        String textImage = mealsDataList.get(position).getStrMealThumb();
        Glide.with(context)
                .load(textImage)
                .into(viewHolder.imageDetailResepMakanan);
    }

    @Override
    public int getItemCount() {
        return mealsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
