package com.example.edith;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class arraylistcontainer {
    public static ArrayList<Ingredient> Usethisarray;

    public arraylistcontainer() {
        if (Usethisarray == null) {
            Usethisarray = new ArrayList<Ingredient>();
        }
    }

    public void setuparraylist(){
        Usethisarray.add(new Ingredient("Milk", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient( "Sirloin Steak", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Pork Chop", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Bananas", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient( "Apples", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Broccoli", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Garlic", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient( "Lamb", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Chicken Thighs", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Ground Bison", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient( "Ground Beef", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Strawberries", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient("Lemonade", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
        Usethisarray.add(new Ingredient( "Lettuce", 5, new SimpleDateFormat("MM/dd/yyyy").parse("05/04/2021", new ParsePosition(0))));
    }

    public void additemtothisarray(String s, int i, Date d){
        Usethisarray.add(new Ingredient( s, i, d));
    }

}