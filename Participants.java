package ru;

public interface Participants extends Runner, Jumper{
    @Override
    boolean run(int distance);

    @Override
    boolean jump(int height);
}
