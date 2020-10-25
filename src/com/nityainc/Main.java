package com.nityainc;

/*Java program to which contains a.b.c = c.b.a; as a statement*/
public class Main {

    public static void main(String[] args) {
        A a = new A();
        a.b = new A.B();
        C c = new C();
        c.b = new C.B();
        c.b.a = 15;

        a.b.c = c.b.a;

        System.out.println(a.b.c);
    }

    private static class A {
        B b;
        private static class B {
            private int c;
        }
    }

    private static class C {
        B b;
        private static class B {
            private static int a;
        }
    }
}
