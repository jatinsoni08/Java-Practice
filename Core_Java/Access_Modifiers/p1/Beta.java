package com.p1;

public class Beta {
    public static void main(String[] args) {

        Alpha obj = new Alpha();

        System.out.println(obj.a); // default
        // System.out.println(obj.b); //  private
        System.out.println(obj.c); // protected
        System.out.println(obj.d); // public
    }
}
