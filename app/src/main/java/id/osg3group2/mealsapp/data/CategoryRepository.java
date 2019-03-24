package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListCategoryResponse;

public class CategoryRepository implements CategoryDataSource {

    private CategoryDataSource categoryDataSource;

    public CategoryRepository(CategoryDataSource categoryDataSource) {
        this.categoryDataSource = categoryDataSource;
    }

    @Override
    public void getListCategory(final GetCategoryCallback getCategoryCallback) {
        categoryDataSource.getListCategory(new GetCategoryCallback() {

            @Override
            public void onCategoryLoaded(ListCategoryResponse data) {
                getCategoryCallback.onCategoryLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getCategoryCallback.onDataNotAvailable(errorMessage);
            }
        });
    }
}
