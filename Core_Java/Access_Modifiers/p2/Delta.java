package com.p2;

import com.p1.Alpha;

public class Delta extends Alpha {
    public static void main(String[] args) {

        Delta obj = new Delta();

        // System.out.println(obj.a); //  default
        // System.out.println(obj.b); //  private
        System.out.println(obj.c);   //  protected (inheritance)
        System.out.println(obj.d);   //  public
    }
}
