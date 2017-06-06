package annotationTest.service;

import annotationTest.annotation.Controller;
import annotationTest.annotation.RequestMapping;

@Controller
public class SunService {
    @RequestMapping(id = true, name = "test1", description = "sun测试1", value = "/test1")
    public void test1() {
        System.out.println("SunService->test1()");
    }

    @RequestMapping(id = true, name = "test2", description = "sun测试2", value = "/test2")
    public void test2() {
        System.out.println("SunService->test2()");
    }
}
