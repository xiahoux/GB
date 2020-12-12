package ru;

public class Main {

    public static final int SIZE = 5;

    public static void main(String[] args) {
        System.out.println("БАЗА ДАННЫХ СОТРУДНИКОВ");
        System.out.println();
        System.out.println("Сотрудники старше 40 лет:");
        System.out.println();

        Person[] persArray = new Person[5];

        persArray[0] = new Person("Узумаки Наруто", "Хокаге", "best_shinobi_ever@konoha.fire", "+79459997666", 2000, 25);
        persArray[1] = new Person("Нара Шикамару", "Советник", "shogi_clouds@konoha.fire", "+79994482801", 1500, 25);
        persArray[2] = new Person("Хатаке Какаши", "Заместитель Хокаге", "come_heaven@konoha.fire", "+77777777777", 1800, 41);
        persArray[3] = new Person("Митараши Анко", "Преподаватель ниндзюцу", "orochimaru_baka@konoha.fire", "+74956660258", 900, 38);
        persArray[4] = new Person("Майто Гай", "Зелёный зверь Конохи", "sweat_is_power@konoha.fire", "+79296252470", 1200, 42);

        personOverForty(persArray);

    }

    private static void personOverForty(Person[] persArray) {
        for (int i = 0; i < SIZE; i++){
            if(persArray[i].age > 40) persArray[i].printInfo();
        }
    }


}
