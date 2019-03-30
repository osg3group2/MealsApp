package id.osg3group2.mealsapp.vm;

import id.osg3group2.mealsapp.data.CategoryDataSource;
import id.osg3group2.mealsapp.data.CategoryRepository;
import id.osg3group2.mealsapp.helpers.CategoryNavigator;
import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;
import id.osg3group2.mealsapp.model.SearchMealsResponse;

public class CategoryViewModel {

    private CategoryRepository categoryRepository;
    private CategoryNavigator categoryNavigator;

    public CategoryViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setCategoryNavigator(CategoryNavigator categoryNavigator) {
        this.categoryNavigator = categoryNavigator;
    }

    public void getListCategory() {

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

    public void getListCategoryByFilter(String category) {
        categoryRepository.getListCategoryByFilter(new CategoryDataSource.GetCategoryByFilterCallback() {
            @Override
            public void onCategoryByFilterLoaded(ListMealsCategoryResponse data) {
                categoryNavigator.loadListCategoryByFilter(data.getMeals());
            }

            @Override
            public void onDataNotByIdAvailable(String errorMessage) {
                categoryNavigator.errorLoadListCategoryMeals(errorMessage);
            }
        }, category);
    }

    public void getListCategoryById(String id) {
        categoryRepository.getListCategoryById(new CategoryDataSource.GetCategoryByIdCallback() {
            @Override
            public void onCategoryByIdLoaded(SearchMealsResponse mealsResponse) {
                categoryNavigator.loadListCategoryById(mealsResponse.getMeals());
            }

            @Override
            public void onDataNotByIdAvailable(String errorMessage) {
                categoryNavigator.errorLoadListCategoryMeals(errorMessage);
            }
        }, id);
    }
}
