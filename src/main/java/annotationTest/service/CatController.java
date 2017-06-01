package annotationTest.service;

import annotationTest.annotation.Controller;
import annotationTest.annotation.RequestMapping;

@Controller
public class CatController {
    @RequestMapping(value = "/test1")
    public void test1() {
        System.out.println("CatController->test1()");
    }

    @RequestMapping(value = "/test2")
    public void test2() {
        System.out.println("CatController->test2()");
    }
}
