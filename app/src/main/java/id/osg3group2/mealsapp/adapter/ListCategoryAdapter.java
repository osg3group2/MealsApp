package id.osg3group2.mealsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.osg3group2.mealsapp.R;
import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.utils.ItemClickSupport;

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.CategoryHolder> {

    private LayoutInflater layoutInflater;
    private List<ListCategoryData> categoryDataList;
    private Context context;

    public ListCategoryAdapter(List<ListCategoryData> categoryDataList, Context context) {
        this.categoryDataList = categoryDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = layoutInflater.inflate(R.layout.item_kategory_makanan, viewGroup, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder categoryHolder, int position) {
        categoryHolder.imageItemNamaKategoriMakanan.setText(categoryDataList.get(position).getStrCategory());
        categoryHolder.cardViewItemCategoryMakanan.setOnClickListener(new ItemClickSupport(position, new ItemClickSupport.OnItemClick() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(view.getContext(), "ini " + categoryDataList.get(position).getStrCategory(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return categoryDataList.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_item_nama_kategori_makanan)
        TextView imageItemNamaKategoriMakanan;
        @BindView(R.id.cardView_item_category_makanan)
        CardView cardViewItemCategoryMakanan;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
