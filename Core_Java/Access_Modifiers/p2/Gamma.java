package com.p2;

import com.p1.Alpha;

public class Gamma {
    public static void main(String[] args) {

        Alpha obj = new Alpha();

        // System.out.println(obj.a); //  default
        // System.out.println(obj.b); //  private
        // System.out.println(obj.c); //  protected
        System.out.println(obj.d);   //  public
    }
}
