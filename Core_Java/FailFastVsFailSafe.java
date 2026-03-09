package com.jatin;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class FailFastVsFailSafe {

    public static void main(String[] args) {
        // ---------------- FAIL-FAST EXAMPLE ----------------
        System.out.println("Fail-Fast Example:");

        List<Integer> failFastList = new ArrayList<>();
        failFastList.add(1);
        failFastList.add(2);
        failFastList.add(3);

        try {
            for (Integer i : failFastList) {
                // Structural modification during iteration
                if (i == 1) {
                    failFastList.remove(Integer.valueOf(1));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        // ---------------- FAIL-SAFE EXAMPLE ----------------
        System.out.println("\nFail-Safe Example:");

        List<Integer> failSafeList = new CopyOnWriteArrayList<>();
        failSafeList.add(1);
        failSafeList.add(2);
        failSafeList.add(3);

        for (Integer i : failSafeList) {
            if (i == 2) {
                failSafeList.remove(i); // No exception
            }
        }

        System.out.println("Final List: " + failSafeList);
    }
}
