package com.assesment.cmedtask02;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Character {
@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("alternate_names")
@Expose
private List<String> alternateNames;
@SerializedName("species")
@Expose
private String species;
@SerializedName("gender")
@Expose
private String gender;
@SerializedName("house")
@Expose
private String house;
@SerializedName("dateOfBirth")
@Expose
private String dateOfBirth;
@SerializedName("yearOfBirth")
@Expose
private Integer yearOfBirth;
@SerializedName("wizard")
@Expose
private Boolean wizard;
@SerializedName("ancestry")
@Expose
private String ancestry;
@SerializedName("eyeColour")
@Expose
private String eyeColour;
@SerializedName("hairColour")
@Expose
private String hairColour;
@SerializedName("wand")
@Expose
private Wand wand;
@SerializedName("patronus")
@Expose
private String patronus;
@SerializedName("hogwartsStudent")
@Expose
private Boolean hogwartsStudent;
@SerializedName("hogwartsStaff")
@Expose
private Boolean hogwartsStaff;
@SerializedName("actor")
@Expose
private String actor;
@SerializedName("alternate_actors")
@Expose
private List<Object> alternateActors;
@SerializedName("alive")
@Expose
private Boolean alive;
@SerializedName("image")
@Expose
private String image;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<String> getAlternateNames() {
return alternateNames;
}

public void setAlternateNames(List<String> alternateNames) {
this.alternateNames = alternateNames;
}

public String getSpecies() {
return species;
}

public void setSpecies(String species) {
this.species = species;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getHouse() {
return house;
}

public void setHouse(String house) {
this.house = house;
}

public String getDateOfBirth() {
return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}

public Integer getYearOfBirth() {
return yearOfBirth;
}

public void setYearOfBirth(Integer yearOfBirth) {
this.yearOfBirth = yearOfBirth;
}

public Boolean getWizard() {
return wizard;
}

public void setWizard(Boolean wizard) {
this.wizard = wizard;
}

public String getAncestry() {
return ancestry;
}

public void setAncestry(String ancestry) {
this.ancestry = ancestry;
}

public String getEyeColour() {
return eyeColour;
}

public void setEyeColour(String eyeColour) {
this.eyeColour = eyeColour;
}

public String getHairColour() {
return hairColour;
}

public void setHairColour(String hairColour) {
this.hairColour = hairColour;
}

public Wand getWand() {
return wand;
}

public void setWand(Wand wand) {
this.wand = wand;
}

public String getPatronus() {
return patronus;
}

public void setPatronus(String patronus) {
this.patronus = patronus;
}

public Boolean getHogwartsStudent() {
return hogwartsStudent;
}

public void setHogwartsStudent(Boolean hogwartsStudent) {
this.hogwartsStudent = hogwartsStudent;
}

public Boolean getHogwartsStaff() {
return hogwartsStaff;
}

public void setHogwartsStaff(Boolean hogwartsStaff) {
this.hogwartsStaff = hogwartsStaff;
}

public String getActor() {
return actor;
}

public void setActor(String actor) {
this.actor = actor;
}

public List<Object> getAlternateActors() {
return alternateActors;
}

public void setAlternateActors(List<Object> alternateActors) {
this.alternateActors = alternateActors;
}

public Boolean getAlive() {
return alive;
}

public void setAlive(Boolean alive) {
this.alive = alive;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alternateNames=" + alternateNames +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", house='" + house + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", wizard=" + wizard +
                ", ancestry='" + ancestry + '\'' +
                ", eyeColour='" + eyeColour + '\'' +
                ", hairColour='" + hairColour + '\'' +
                ", wand=" + wand +
                ", patronus='" + patronus + '\'' +
                ", hogwartsStudent=" + hogwartsStudent +
                ", hogwartsStaff=" + hogwartsStaff +
                ", actor='" + actor + '\'' +
                ", alternateActors=" + alternateActors +
                ", alive=" + alive +
                ", image='" + image + '\'' +
                '}';
    }

    @BindingAdapter(value = {"characterFullImage", "placeholder"}, requireAll = false)
    public static void loadFullImage(ImageView view, String imageUrl, Drawable placeHolder) {
        Picasso.get().load(imageUrl).placeholder(placeHolder).into(view);
    }

}