package annotationTest.service;

import annotationTest.annotation.Controller;
import annotationTest.annotation.RequestMapping;

@Controller
public class DogController {
    @RequestMapping(value = "/test3")
    public void test3() {
        System.out.println("DogController->test3()");
    }

    @RequestMapping(value = "/test4")
    public void test4() {
        System.out.println("DogController->test4()");
    }
}