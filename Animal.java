package ru;

public abstract class Animal {

    protected String color;
    protected String name;
    protected int age;
    protected int maxRunDistance;
    protected double maxJumpHeight;
    protected int maxSwimDistance;

    public Animal(String color, String name, int age, int maxRunDistance, double maxJumpHeight, int maxSwimDistance) {
        this.color = color;
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
    }

    public Animal(String color, String name, int age, int maxRunDistance, double maxJumpHeight) {
        this.color = color;
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public abstract void run(int runDistance);
    public abstract void jump(double jumpHeight);
    public abstract void swim(int swimDistance);

}
