package com.example.bootlanuch.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(value="classpath:employee.properties",encoding="utf-8")
public class Employee {

    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private List<String> firstEmployeeName;

    @Value("#{${employee.age}}")
    private Map<String,Integer> employeeAge;

    @Value("#{${employee.age}['three']}")
    private String employeeAgeThree;

    @Value("#{${employee.age}['five'?:31]}")
    private  Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private  String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private  String userDir;
}
