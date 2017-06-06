package annotationTest.service;

import annotationTest.annotation.Controller;
import annotationTest.annotation.RequestMapping;

@Controller
public class MoonService {
    @RequestMapping(id = true, name = "moon测试3", description = "/test3", value = "/test3")
    public void test3() {
        System.out.println("MoonService->test3()");
    }

    @RequestMapping(id = true, name = "moon测试4", description = "/test4", value = "/test4")
    public void test4() {
        System.out.println("MoonService->test4()");
    }
}