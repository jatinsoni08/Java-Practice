package com.jatin.String;

public class StringConcepts {

    public static void main(String[] args) {

        System.out.println("========== STRING ==========");
        String str = "Java";
        System.out.println("Before change : " + str);

        str = str + " Programming";
        System.out.println("After change  : " + str);
        System.out.println("Result        : New object created (Immutable)\n");


        System.out.println("====== STRINGBUFFER ======");
        StringBuffer buffer = new StringBuffer("Java");
        System.out.println("Before change : " + buffer);

        buffer.append(" Programming");
        buffer.insert(4, " Core");
        System.out.println("After change  : " + buffer);
        System.out.println("Result        : Same object modified (Thread-safe)\n");


        System.out.println("====== STRINGBUILDER ======");
        StringBuilder builder = new StringBuilder("Java");
        System.out.println("Before change : " + builder);

        builder.append(" Programming");
        builder.replace(5, 16, "Developer");
        builder.reverse();
        System.out.println("After change  : " + builder);
        System.out.println("Result        : Same object modified (Fast, Not thread-safe)");
    }
}
