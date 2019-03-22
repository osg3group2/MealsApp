package id.osg3group2.mealsapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit retrofit = null;

    /*
     * TODO: method yang digunakan untuk request mengggunakan retrofit
     *
     */
    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
