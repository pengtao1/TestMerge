package myEvn.test;

import myEvn.service.MySpringEvtSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pengtao on 2017/6/5.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MySpringEvtSender bean = context.getBean(MySpringEvtSender.class);
        bean.createDemoEvent();
        Thread.sleep(5000L);
    }
}
