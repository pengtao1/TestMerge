package annotationTest.service;

import annotationTest.annotation.RequestMapping;

public class Stars {
    @RequestMapping(id = true, name = "test1", description = "stars测试1", value = "/test1")
    public void test1() {
        System.out.println("Stars->test1()");
    }
}
