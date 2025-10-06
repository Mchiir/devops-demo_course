package com.rca.demo_course.controller;

import com.rca.demo_course.service.MyModulusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/modulus")
@CrossOrigin(origins = "*")
public class MyModulusController {
    @Autowired
    MyModulusService myModulusService;

    @GetMapping("/mod")
    public ResponseEntity<Map<String, Object>> modulus(@RequestParam double dividend,
                                                       @RequestParam double divisor) {
        double result = myModulusService.modulus(dividend, divisor);
        return ResponseEntity.ok(createResponse(dividend, divisor, result, "modulus"));
    }

    private Map<String, Object> createResponse(double a, double b, double result, String operation) {
        Map<String, Object> response = new HashMap<>();
        response.put("a", a);
        response.put("b", b);
        response.put("result", result);
        response.put("operation", operation);
        return response;
    }
}
