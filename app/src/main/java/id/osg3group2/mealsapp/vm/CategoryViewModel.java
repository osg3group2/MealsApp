package id.osg3group2.mealsapp.vm;

import id.osg3group2.mealsapp.data.CategoryDataSource;
import id.osg3group2.mealsapp.data.CategoryRepository;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.model.ListCategoryResponse;

public class CategoryViewModel {

    private CategoryRepository categoryRepository;
    private CategoryNavigator categoryNavigator;

    public CategoryViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setCategoryNavigator(CategoryNavigator categoryNavigator) {
        this.categoryNavigator = categoryNavigator;
    }

    public void getListCategory(){

        categoryRepository.getListCategory(new CategoryDataSource.GetCategoryCallback() {
            @Override
            public void onCategoryLoaded(ListCategoryResponse data) {
                categoryNavigator.loadListCategoryMeals(data.getMeals());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                categoryNavigator.errorLoadListCategoryMeals(errorMessage);
            }
        });
    }
}
