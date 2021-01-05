package ru;

import java.text.MessageFormat;
import java.util.*;

public class Phonebook {

     public static Map<String, ArrayList<String>> phoneBook = new HashMap<>();

     public static ArrayList <String> buffer = new ArrayList<>();
     public static ArrayList <String> phoneNumbersList = new ArrayList<>();

     public static void add(String surname, String number){
        if(!phoneBook.containsKey(surname)) {

            phoneNumbersList.add(number);
            phoneBook.put(surname, (ArrayList<String>) phoneNumbersList.clone());
            phoneNumbersList.clear();

        }else{

            phoneNumbersList.addAll(phoneBook.get(surname));
            phoneNumbersList.add(number);
            phoneBook.put(surname, (ArrayList<String>) phoneNumbersList.clone());
            phoneNumbersList.clear();

        }

     }

    public void get (String surname){
        System.out.println(surname + ": " + phoneBook.get(surname));
    }
}
