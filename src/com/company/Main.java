package com.company;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        //sets the localDate brithday to caluclate age
        LocalDate birthday = LocalDate.of(2020, 4, 15);
        //creates a new Chicken named Specky
        Chicken Specky= new Chicken("Specky", birthday, Chicken.Color.SPOTS, "bugs", 1, Chicken.EggColor.LIGHTBROWN);
        //prints out her age, calulcated with the function chickenAge()
        System.out.println(Specky.chickenAge() + " years old");
        //adds a health condition
        Specky.addHealthConditions("curly toes");
        //prints out her health conditions
        System.out.println(Specky.healthConditions);


        LocalDate today= LocalDate.now();
        //creates the local date today to keep track in the file
        FileCreate specky= new FileCreate(today, "Specky");
        //creates a new FileCreate object with the date and file name
        String speckyStats= "name: " + Specky.getName() + " , birthdate: " + Specky.getBirthdate() + " , food preference: " + Specky.getFoodPreference() + " , color: " + Specky.getColor()
        + " , egg color: " + Specky.getEggColor();
        //creates a string of chicken stats
        String mes= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
        //reads what is in the file
        String age= (Specky.chickenAge() + " years old");
        //creates age for a message to put in 
        specky.finalWrite(mes, speckyStats, "Specky", 1);
        String mes2= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
        specky.finalWrite(mes2, age, "Specky", 2);
        String mes3= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
        specky.addConditions(mes3, Specky.healthConditions, "Specky", 3);


    }
}
