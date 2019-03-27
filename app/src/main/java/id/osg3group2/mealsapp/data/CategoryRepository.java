package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;
import id.osg3group2.mealsapp.model.SearchMealsResponse;

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

    @Override
    public void getListCategoryByFilter(final GetCategoryByFilterCallback getCategoryByFilterCallback, String category) {
        categoryDataSource.getListCategoryByFilter(new GetCategoryByFilterCallback() {
            @Override
            public void onCategoryByFilterLoaded(ListMealsCategoryResponse data) {
                getCategoryByFilterCallback.onCategoryByFilterLoaded(data);
            }

            @Override
            public void onDataNotByIdAvailable(String errorMessage) {
                getCategoryByFilterCallback.onDataNotByIdAvailable(errorMessage);
            }
        }, category);
    }

    @Override
    public void getListCategoryById(final GetCategoryByIdCallback getCategoryByIdCallback, String id) {
        categoryDataSource.getListCategoryById(new GetCategoryByIdCallback() {
            @Override
            public void onCategoryByIdLoaded(SearchMealsResponse mealsResponse) {
                getCategoryByIdCallback.onCategoryByIdLoaded(mealsResponse);
            }

            @Override
            public void onDataNotByIdAvailable(String errorMessage) {
                getCategoryByIdCallback.onDataNotByIdAvailable(errorMessage);
            }
        }, id);
    }


}
