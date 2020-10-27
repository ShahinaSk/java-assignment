package com.nityainc;

//Java program which has a().b().c = c().b().a; as a statement through method chaining
public class BuilderPatternDemo {
    private int c;
    private int a;

    public static void main(String[] args) {
        a().b().c = c().b().a;
        System.out.println(a().b().c = c().b().a);
    }


    private static BuilderPatternDemo a() {
        return new BuilderPatternDemo();
    }

    private BuilderPatternDemo b() {
        this.c = 10;
        this.a = 20;
        return this;
    }

    private static BuilderPatternDemo c() {
        return new BuilderPatternDemo();
    }
}
