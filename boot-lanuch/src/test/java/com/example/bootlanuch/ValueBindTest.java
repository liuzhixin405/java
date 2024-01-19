package com.example.bootlanuch;

import com.example.bootlanuch.model.Employee;
import com.example.bootlanuch.model.Family;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValueBindTest {
    @Resource
    Employee employee;
    @Resource
    Family family;
    @Test
    public void valueBindTest2() throws  Exception{
        System.out.println(family.toString()); //ENC()无效
    }

    @Test
    public void valueBindTest() throws Exception {
        System.out.println(employee.toString());
    }
}
