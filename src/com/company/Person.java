package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person {

    Scanner scan= new Scanner(System.in);
    Map<String, Chicken> coop = new HashMap<>();

    public void interact() throws IOException {
        System.out.println("What would you like to do today? Would you like to:" + "\n" + "create a chicken => enter c "+ "\n" + "add a health condition => enter h" + "\n" +
                "create a file for a chicken => enter f" + "\n" +  "add a chicken to your flock => enter h");
        String answer= scan.nextLine();
        if(answer.equals("c")){
            System.out.println("What is the chickens name? EX- Specky");
            String name= scan.nextLine();
            System.out.println("What year were they born? EX- 2022");
            int year= scan.nextInt();
            System.out.println("What month were they born as an int? EX- 2");
            int month= scan.nextInt();
            System.out.println("What day were they born as an int? EX- 12");
            int day= scan.nextInt();
            System.out.println("What color are they? EX- WHITE,\n" +
                    "        BLACK,\n" +
                    "        BROWN,\n" +
                    "        SPOTS,\n" +
                    "        RED");
            String color= scan.nextLine();
            Chicken.Color colorTwo;
            if(color.equals("WHITE")){
                colorTwo= Chicken.Color.WHITE;
            }
            if(color.equals("BLACK")){
                colorTwo= Chicken.Color.BLACK;
            }
            if(color.equals("BROWN")){
                colorTwo= Chicken.Color.BROWN;
            }
            if(color.equals("SPOTS")){
                colorTwo= Chicken.Color.SPOTS;
            }
            if(color.equals("RED")){
                colorTwo= Chicken.Color.RED;
            }
            else{
                colorTwo= Chicken.Color.RED;
            }
            System.out.println("What is their food preference? EX- bugs");
            String food= scan.nextLine();
            System.out.println("How many engs have they laid? EX- 2");
            int eggs= scan.nextInt();
            System.out.println("What color are their eggs? EX- WHITE,\n" +
                    "        LIGHTBROWN,\n" +
                    "        BROWN,\n" +
                    "        DARKBROWN,\n" +
                    "        GREEN, \n"+
                    "        BLUE,");
            String eggColor= scan.nextLine();
            Chicken.EggColor colorThree;
            if(eggColor.equals("WHITE")){
                colorThree= Chicken.EggColor.WHITE;
            }
            if(eggColor.equals("LIGHTBROWN")){
                colorThree= Chicken.EggColor.LIGHTBROWN;
            }
            if(eggColor.equals("BROWN")){
               colorThree= Chicken.EggColor.BROWN;
            }
            if(eggColor.equals("DARKBROWN")){
                colorThree= Chicken.EggColor.DARKBROWN;
            }
            if(eggColor.equals("GREEN")){
                colorThree= Chicken.EggColor.GREEN;
            }
            if(eggColor.equals("BLUE")){
                colorThree= Chicken.EggColor.BLUE;
            }
            else{
                colorThree= Chicken.EggColor.WHITE;
            }
            LocalDate birthday = LocalDate.of(year, month, day);
            Chicken chicken= new Chicken(name, birthday, colorTwo , food, eggs, colorThree);
            coop.put(name, chicken);

        }
        if(answer.equals("h")) {
            System.out.println("what chicken would you like to add to? ");
            String userName= scan.nextLine();
            if(coop.containsKey(userName)){
                System.out.println("These are their conditions so far: ");
                coop.get(userName).healthReport();
                System.out.println("what condition would you like to add? ");
                String condition= scan.nextLine();
                coop.get(userName).addHealthConditions(condition);
            }System.out.println("This chicken has not been created yet");
        }
        if(answer.equals("f")){
            //create a file for a chicken
            System.out.println("What chicken would you like to create a file for? ");
            String p= scan.nextLine();
            if(coop.containsKey(p)){
                LocalDate today= LocalDate.now();
                //creates the local date today to keep track in the file
                FileCreate x= new FileCreate(today, "p");
                //creates a new FileCreate object with the date and file name
                String mes= x.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/" + p+ ".txt");
                //reads what is in the file
                String cStats= "name: " + coop.get(p).getName() + " , birthdate: " + coop.get(p).getBirthdate() + " , food preference: " + coop.get(p).getFoodPreference() + " , color: " + coop.get(p).getColor()
                            + " , egg color: " + coop.get(p).getEggColor();
                String age= (coop.get(p).chickenAge() + " years old");
                x.finalWrite(mes, cStats, p, 1);
                String mes2= x.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/"+ p + ".txt");
                x.finalWrite(mes2, age, p, 2);
                String mes3= x.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/"+ p+ ".txt");
                x.addConditions(mes3, coop.get(p).healthConditions, p, 3);
        }
            System.out.println("This chicken has not been created yet");}
        if(answer.equals("h")){
            System.out.println("What chicken would you like to add to a flock? ");
            String flockName= scan.nextLine();
            if(coop.containsKey(flockName)){
            Flock one= new Flock();
                    one.addToFlock(coop.get(flockName));
                    System.out.println(one.healthUpdates());
        }
            System.out.println("That chicken is not in our system");}

        System.out.println("would you like to continue? (y/n)");
        String q= scan.nextLine();
        if(q.equals("y")){
            interact();
        }
        else{
            System.out.println("thanks");
        }
    }

                //    //sets the localDate brithday to caluclate age
                //    LocalDate birthday = LocalDate.of(2020, 4, 15);
                //    //creates a new Chicken named Specky
                //    Chicken Specky= new Chicken("Specky", birthday, Chicken.Color.SPOTS, "bugs", 1, Chicken.EggColor.LIGHTBROWN);
                //    //prints out her age, calulcated with the function chickenAge()
                //        System.out.println(Specky.chickenAge() + " years old");
                //    //adds a health condition
                //        Specky.addHealthConditions("curly toes");
                //        Specky.addHealthConditions("limping");
                //        Specky.addHealthConditions("depressed");
                //    //prints out her health conditions
                //        System.out.println(Specky.healthConditions);
                //    LocalDate birthdate = LocalDate.of(2021, 4, 8);
                //    Chicken Polly= new Chicken("Polly", birthdate, Chicken.Color.WHITE, "blood of her enemies", 0, Chicken.EggColor.LIGHTBROWN);
                //        Polly.addHealthConditions("many toes");
                //        Polly.addHealthConditions("broody");
                //        Polly.addHealthConditions("mean");
                //
                //    LocalDate today= LocalDate.now();
                //    //creates the local date today to keep track in the file
                //    FileCreate specky= new FileCreate(today, "Specky");
                //    //creates a new FileCreate object with the date and file name
                //    String speckyStats= "name: " + Specky.getName() + " , birthdate: " + Specky.getBirthdate() + " , food preference: " + Specky.getFoodPreference() + " , color: " + Specky.getColor()
                //            + " , egg color: " + Specky.getEggColor();
                //    //creates a string of chicken stats
                //    String mes= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
                //    //reads what is in the file
                //    String age= (Specky.chickenAge() + " years old");
                //    //creates age for a message to put in
                //        specky.finalWrite(mes, speckyStats, "Specky", 1);
                //    String mes2= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
                //        specky.finalWrite(mes2, age, "Specky", 2);
                //    String mes3= specky.readFile("/Users/ryan.alexandra/IdeaProjects/chickenCoop/Specky.txt");
                //        specky.addConditions(mes3, Specky.healthConditions, "Specky", 3);
                //        System.out.println(Specky.healthReport());
                //    Flock one= new Flock();
                //        one.addToFlock(Specky);
                //        one.addToFlock(Polly);
                //        System.out.println(one.healthUpdates());
}
