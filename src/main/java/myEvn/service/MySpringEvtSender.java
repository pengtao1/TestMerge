package myEvn.service;

import myEvn.model.MyDemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by pengtao on 2017/6/5.
 */
@Component
public class MySpringEvtSender {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void createDemoEvent(){
        MyDemoEvent myDemoEvent = new MyDemoEvent();
        myDemoEvent.setId(1);
        myDemoEvent.setMessage("xxxxxxxxxxxxxxxx");
        publisher.publishEvent(myDemoEvent);
        System.out.println("publish event myDemoEvent: "+myDemoEvent);
        MyDemoEvent myDemoEvent2 = new MyDemoEvent();
        myDemoEvent2.setId(11111);
        myDemoEvent2.setMessage("xxxxxxxxxxxxxxxx");
        publisher.publishEvent(myDemoEvent2);
        System.out.println("publish event myDemoEvent2: "+myDemoEvent2);
    }
}
