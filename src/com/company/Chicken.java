//the imports that allow us to axcess an arrayList, as well as calculate age based off local date and date.
package com.company;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;

public class Chicken {
    //all of our variables that make up a chicken
    String name;
    LocalDate birthdate;
    Color color;
    ArrayList<String> healthConditions= new ArrayList<>();
    String foodPreference;
    int eggsLaid;
    EggColor eggColor;

    //Two enums, one for the chicken color, and one for the egg color.
    public enum Color{
        WHITE,
        BLACK,
        BROWN,
        SPOTS,
        RED
    }

    public enum EggColor{
        WHITE,
        LIGHTBROWN,
        BROWN,
        DARKBROWN,
        BLUE,
        GREEN
    }

    //the constructor for a chicken, with all the variables except for the arrayList, which will be added to through functions.
    public Chicken(String name, LocalDate birthdate, Color color, String foodPreference, int eggsLaid, EggColor eggColor) {
        this.name = name;
        this.birthdate = birthdate;
        this.color = color;
        this.foodPreference = foodPreference;
        this.eggsLaid = eggsLaid;
        this.eggColor = eggColor;
    }

    //getters and setters for all the variables seen above, as well as one to add health conditions to the arrayList
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        birthdate = birthdate;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public String getFoodPreference() {
        return foodPreference;
    }
    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public int getEggsLaid() {
        return eggsLaid;
    }
    public void setEggsLaid(int eggsLaid) {
        this.eggsLaid = eggsLaid;
    }

    public EggColor getEggColor() {
        return eggColor;
    }
    public void setEggColor(EggColor eggColor) {
        this.eggColor = eggColor;
    }

    public void addHealthConditions(String condition){
        healthConditions.add(condition);
    }


    //function that calculates the age of the chicken in years based off their date of birth. This uded both date and local date time, and returns an int
    public int chickenAge(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();

        int bYear = birthdate.getYear();
        int bMonth = birthdate.getMonthValue();
        int bDay = birthdate.getDayOfMonth();

        int yearDif = year - bYear;
        if ((month - bMonth) > 0) {
            return yearDif;
        } else if (((month - bMonth) < 0)) {
            return (yearDif - 1);
        } else {
            if (day >= bDay) {
                return yearDif;
            } else {
                return (yearDif - 1);
            }
        }
    }

    public String healthReport() {
        return(healthConditions.toString());
    }


}
