package com.annotation.example.demo.annotate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @author: 杨玉冰
 * @Description:
 * @date:2019/8/21
 */
@RestController
public class TestController {

    @TestAnnotation(value = "test")
    @RequestMapping("/test")
    public Object test(){
        return null;
    }
}
