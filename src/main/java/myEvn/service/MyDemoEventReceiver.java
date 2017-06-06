package myEvn.service;

import myEvn.model.MyDemoEvent;
import myEvn.model.MyDemoEvent2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by pengtao on 2017/6/5.
 */
@Component
public class MyDemoEventReceiver {

    //@EventListener(value = {MyDemoEvent.class, MyDemoEvent2.class},condition = "#demoEvent.id >4")
    //public void handlerEvent(Object demoEvent){
    //    System.out.println("receiver event"+demoEvent);
    //}

    @EventListener
    public void handlerEvent(MyDemoEvent demoEvent) {
        System.out.println("receiver event : " + demoEvent);
    }

    @EventListener
    public void handlerEvent(MyDemoEvent2 demoEvent) {
        System.out.println("receiver event2 : " + demoEvent);
    }
}
