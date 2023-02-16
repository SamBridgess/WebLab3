package com.example.lab3;

import java.util.ArrayList;

public class AreaChecker {
    public static boolean check(double x, double y, double r) {

        if (x >= 0) {
            if (y >= 0) {
                return false;
            } else {
                return x*x + y*y <= r*r;
            }
        } else {
            if (y >= 0) {
                return x >= -r/2 && y < r;
            } else {
                return y >= -x/2 - r/2;
            }
        }


    }
}
