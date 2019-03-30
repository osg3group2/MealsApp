package id.osg3group2.mealsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ListCategoryData implements Parcelable {

	@SerializedName("strCategory")
	private String strCategory;

	public void setStrCategory(String strCategory){
		this.strCategory = strCategory;
	}

	public String getStrCategory(){
		return strCategory;
	}

	@Override
 	public String toString(){
		return 
			"ListCategoryData{" +
			"strCategory = '" + strCategory + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.strCategory);
	}

	public ListCategoryData() {
	}

	protected ListCategoryData(Parcel in) {
		this.strCategory = in.readString();
	}

	public static final Parcelable.Creator<ListCategoryData> CREATOR = new Parcelable.Creator<ListCategoryData>() {
		@Override
		public ListCategoryData createFromParcel(Parcel source) {
			return new ListCategoryData(source);
		}

		@Override
		public ListCategoryData[] newArray(int size) {
			return new ListCategoryData[size];
		}
	};
}