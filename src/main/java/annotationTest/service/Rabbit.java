package annotationTest.service;

import annotationTest.annotation.RequestMapping;

/**
 * Created by pengtao on 2017/6/1.
 */
public class Rabbit
{
    @RequestMapping
    public void test1()
    {
        System.out.println("Rabbit->test1()");
    }
}
