package com.example.tp1mmm;

import android.os.Parcel;
import android.os.Parcelable;

public class MyData   implements Parcelable{

	private String nom;
	private String prenom;
	
	MyData(){};
	
	// Constructor when reconstructing object from parcel

	public MyData(Parcel in){
		nom = in.readString();
		prenom = in.readString();
	}
	
	@Override
	public int describeContents() {
		
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flag) {
	  
		dest.writeString(nom);
		dest.writeString(prenom);
	}
	 
	public  static  final Parcelable.Creator CREATOR =
			new Parcelable.Creator() {

				@Override
				public Object createFromParcel(Parcel in) {
					
					return new MyData(in);
				}

				@Override
				public Object[] newArray(int size) {
					
					return new MyData[size];
				}
		
			}; 
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
