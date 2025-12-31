package com.p1;
public class Alpha {
    // DEFAULT (package-private)
    int a = 10;
    // PRIVATE
    private int b = 20;
    // PROTECTED
    protected int c = 30;
    // PUBLIC
    public int d = 40;
    
    public void show() {
        System.out.println("Inside Alpha class");
        System.out.println(a); // default
        System.out.println(b); // private
        System.out.println(c); // protected
        System.out.println(d); // public
    }
}
