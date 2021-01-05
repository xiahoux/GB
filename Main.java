package ru;

import java.text.MessageFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать, сколько раз встречается каждое слово.

        String[] str = {"Кошка", "Танк", "Художник", "Сияние", "Кошка", "Ножницы", "Сияние", "Кошка", "Кирпич", "Колосс", "Танк"};



        Set<String> set = new HashSet<>(); // поиск и вывод уникальных слов без подсчёта дубликатов (надеюсь я правильно понял)

        for (int i = 0; i < str.length; i++) {
            set.add(str[i]);
        }
        for (String s : set ) {
            System.out.println(s);
        }
        System.out.println();



        Map<String, Integer> map = new HashMap<>(); //подсчёт сколько раз встречается какое слово

        for (int i = 0; i < str.length; i++) {
            if(map.containsKey(str[i])){
                map.put(str[i], map.get(str[i]) + 1);
            }else{
                map.put(str[i], 1);
            }
        }
        System.out.println(map.entrySet());


        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.

        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", "+71111111111");
        phonebook.add("Петров", "+72222222222");
        phonebook.add("Соколов", "+73333333333");
        phonebook.add("Петров", "+74444444444");
        phonebook.add("Ольхов", "+75555555555");
        phonebook.add("Соколов", "+76666666666");

        phonebook.get("Петров");
        phonebook.get("Соколов");
        phonebook.get("Ольхов");
    }
}
