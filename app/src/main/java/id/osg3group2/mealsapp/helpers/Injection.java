package id.osg3group2.mealsapp.helpers;

import android.content.Context;

import id.osg3group2.mealsapp.data.MealsDataSource;
import id.osg3group2.mealsapp.data.MealsRepository;
import id.osg3group2.mealsapp.data.remote.MealsRemoteDataSource;

public class Injection {
    public static MealsRepository provideMealsRepository(Context context){
        return new MealsRepository(new MealsRemoteDataSource());
    }
}
