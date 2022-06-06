package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Flock {
    Map<String, Chicken> chickens = new HashMap<>();
    ArrayList<Chicken> flock= new ArrayList<>();

    public void addChicken(Chicken c) {
        chickens.put(c.getName(), c);
    }

    public void addToFlock(Chicken g){
        flock.add(g);
    }

    public Flock() {
    }

    //Prepare a report on the general health of the flock.
    //Include any red flags and treatments you need to do soon.
    public String healthUpdates() {
        int i= 0;
        String report = "";
        for(Chicken c : flock) {
            if (c.healthReport().length() >= 3) {
                report += c.getName() + ":"+ c.healthReport() + "\n";
            }
        }
        if(report.equals("")){
            report= "flock in good health";
        }

        return report;


    }
}
