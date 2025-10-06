package com.rca.demo_course.service.impl;

import com.rca.demo_course.service.MyModulusService;

public class MyModulusServiceImpl implements MyModulusService {
    @Override
    public double modulus(double dividend, double divisor) {
        return dividend % divisor;
    }
}
