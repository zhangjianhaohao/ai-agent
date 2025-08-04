package com.yupi.yuaiagent.app;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class SubStringTest {
    @Resource
    private ResourcePatternResolver resourcePatternResolver;
    @Test
    public void test() throws IOException {
        org.springframework.core.io.Resource[] resources = resourcePatternResolver.getResources("classpath:document/*.md");
        for (org.springframework.core.io.Resource resource : resources) {
            String filename = resource.getFilename();
            System.out.println(filename.substring(filename.length()-6,filename.length()-4));
        }
    }
}
