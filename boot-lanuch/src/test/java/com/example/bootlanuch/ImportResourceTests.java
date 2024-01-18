package com.example.bootlanuch;


import jakarta.annotation.Resource;
import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ImportResourceTests {
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public  void testImport() throws Exception{
        boolean isImport = ioc.containsBean("testBeanService");
        System.out.println("输出结果为:"+isImport);
    }
}
