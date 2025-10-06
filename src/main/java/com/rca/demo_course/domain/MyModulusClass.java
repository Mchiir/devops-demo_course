package com.rca.demo_course.domain;

public class MyModulusClass {
    public double modulus(double dividend, double divisor) { return dividend % divisor; }

    public static void main(String[] args) {
        MyModulusClass model = new MyModulusClass();

        System.out.println(model.modulus(5, 2)); // Output: 1.0
    }
}
