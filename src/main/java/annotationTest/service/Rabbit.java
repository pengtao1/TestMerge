package annotationTest.service;

import annotationTest.annotation.RequestMapping;

public class Rabbit
{
    @RequestMapping
    public void test1()
    {
        System.out.println("Rabbit->test1()");
    }
}
