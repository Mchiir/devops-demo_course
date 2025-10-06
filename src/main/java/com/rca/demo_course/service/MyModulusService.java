package com.rca.demo_course.service;

import org.springframework.stereotype.Service;

@Service
public interface MyModulusService {
    double modulus(double dividend, double divisor);
}
