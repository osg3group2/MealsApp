package id.osg3group2.mealsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

public class SearchMealsAdapter extends RecyclerView.Adapter<SearchMealsAdapter.MealsHolder> {

    private LayoutInflater layoutInflater;
    private List<SearchMealsData> searchMealsDataList;
    private Context context;

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
    public void onBindViewHolder(@NonNull MealsHolder mealsHolder, int i) {
        mealsHolder.textItemNamaResepMakanan.setText(searchMealsDataList.get(i).getStrMeal());
        mealsHolder.textItemAsalResepMakanan.setText(searchMealsDataList.get(i).getStrArea());
        Glide.with(context).load(searchMealsDataList.get(i).getStrMealThumb()).into(mealsHolder.imageItemResepMakanan);

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

        public MealsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
