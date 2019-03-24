package id.osg3group2.mealsapp.helpers;

import android.content.Context;

import id.osg3group2.mealsapp.data.CategoryRepository;
import id.osg3group2.mealsapp.data.MealsRepository;
import id.osg3group2.mealsapp.data.remote.CategoryRemoteDataSource;
import id.osg3group2.mealsapp.data.remote.MealsRemoteDataSource;

public class Injection {
    public static MealsRepository provideMealsRepository(Context context) {
        return new MealsRepository(new MealsRemoteDataSource());
    }

    public static CategoryRepository provideCategoryRepository(Context context) {
        return new CategoryRepository(new CategoryRemoteDataSource());
    }
}
