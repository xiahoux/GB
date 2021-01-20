package ru;

import java.util.Arrays;


public class Main {

    public static final int SIZE = 10000000;
    public static final int h = SIZE/2;


    public static void main(String[] args) {

        float[] arr11 = methodOne();

        float[] arr22 = methodTwo();

        for (int i = 0; i < SIZE; i++) {
            if(arr11[i] != arr22[i]){
                System.out.println("Ошибка!");
                System.out.println("Номер: " + i + " \n" + arr11[i] + "\n" + arr22[i]);
                break;
            }
        }
        System.out.println("Массивы одинаковы");
    }

    private static float[] methodOne(){

        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);
        return arr;

    }

    private static float[] methodTwo(){

        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        float[] arrCopy1 = new float[h];
        float[] arrCopy2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrCopy1, 0, h);
        System.arraycopy(arr, h, arrCopy2, 0, h);

        var t1 = new Thread(() -> {

            for (int i = 0; i < h; i++) {
                arrCopy1[i] = (float)(arrCopy1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        var t2 = new Thread(() -> {

            int h1 = h;

            for (int i = 0; i < h; i++) {
                arrCopy2[i] = (float)(arrCopy2[i] * Math.sin(0.2f + h1 / 5) * Math.cos(0.2f + h1 / 5) * Math.cos(0.4f + h1 / 2));
                h1++;
            }
        });

        t1.start();

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrCopy1, 0, arr, 0, h);
        System.arraycopy(arrCopy2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);

        return arr;
    }
}
