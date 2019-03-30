package id.osg3group2.mealsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.utils.ItemClickSupport;
import id.osg3group2.mealsapp.view.activity.DetailResepByCategoryActivity;
import id.osg3group2.mealsapp.view.activity.DetailResepMakananActivity;
import id.osg3group2.mealsapp.view.fragment.MenuCariResepFragment;

public class ListCategoryByFilterAdapter extends RecyclerView.Adapter<ListCategoryByFilterAdapter.CategoryByFilterHolder> {


    private LayoutInflater layoutInflater;
    private List<ListMealsCategoryData> mealsCategoryDataList;
    private Context context;

    public ListCategoryByFilterAdapter(List<ListMealsCategoryData> mealsCategoryDataList, Context context) {
        this.mealsCategoryDataList = mealsCategoryDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryByFilterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = layoutInflater.inflate(R.layout.item_kategory_by_filter_makanan, viewGroup, false);
        return new CategoryByFilterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryByFilterHolder categoryByFilterHolder, int position) {
        categoryByFilterHolder.textItemNamaKategoriMakanan
                .setText(mealsCategoryDataList.get(position).getStrMeal());
        Glide.with(context)
                .load(mealsCategoryDataList.get(position).getStrMealThumb())
                .into(categoryByFilterHolder.imageItemKategoriMakanan);

        categoryByFilterHolder.cardViewItemCategoryMakanan.setOnClickListener(new ItemClickSupport(position, new ItemClickSupport.OnItemClick() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context, DetailResepByCategoryActivity.class);
                intent.putExtra("ID", mealsCategoryDataList.get(position).getIdMeal());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }));

    }

    @Override
    public int getItemCount() {
        return mealsCategoryDataList.size();
    }

    public class CategoryByFilterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_item_kategori_makanan)
        ImageView imageItemKategoriMakanan;
        @BindView(R.id.text_item_nama_kategori_makanan)
        TextView textItemNamaKategoriMakanan;
        @BindView(R.id.cardView_item_category_makanan)
        CardView cardViewItemCategoryMakanan;

        public CategoryByFilterHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
