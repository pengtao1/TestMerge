package annotationTest.model;

import java.lang.reflect.Method;

/**
 * Created by pengtao on 2017/6/1.
 */
public class ExecutorBean {
    private Object object;

    private Method method;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
