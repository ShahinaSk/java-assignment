package com.nityainc;

/*Java program to which contains a.b.c = c.b.a; as a statement using static classes*/
public class Main {

    public static void main(String[] args) {
        a.b.c = c.b.a;
        System.out.println(a.b.c);
    }

    private static class a {
        private static class b {
            private static int c;
        }
    }

    private static class c {
        private static class b {
            private static int a = 5;
        }
    }

}
