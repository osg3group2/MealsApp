package id.osg3group2.mealsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailResepByIdResponse{

	@SerializedName("meals")
	private List<DetailResepByIdData> meals;

	public void setMeals(List<DetailResepByIdData> meals){
		this.meals = meals;
	}

	public List<DetailResepByIdData> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"DetailResepByIdResponse{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}