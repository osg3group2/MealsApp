package id.osg3group2.mealsapp.vm;

import id.osg3group2.mealsapp.data.MealsDataSource;
import id.osg3group2.mealsapp.data.MealsRepository;
import id.osg3group2.mealsapp.helpers.MealsNavigator;
import id.osg3group2.mealsapp.model.SearchMealsResponse;

public class MealsViewModel {

    private MealsRepository mealsRepository;
    private MealsNavigator mealsNavigator;

    public MealsViewModel(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    public void setMealsNavigator(MealsNavigator mealsNavigator){
        this.mealsNavigator = mealsNavigator;
    }

    public void getListMeals(String search) {
        mealsRepository.getListMeals(new MealsDataSource.GetMealsCallback() {
            @Override
            public void onMealsLoaded(SearchMealsResponse data) {
                mealsNavigator.loadListMeals(data.getMeals());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                mealsNavigator.errorLoadListMeals(errorMessage);
            }
        }, search);
    }
}
