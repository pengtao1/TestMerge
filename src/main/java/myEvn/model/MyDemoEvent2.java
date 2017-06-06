package myEvn.model;

/**
 * Created by pengtao on 2017/6/5.
 */
public class MyDemoEvent2 {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MyDemoEvent2{" +
            "id=" + id +
            ", message='" + message + '\'' +
            '}';
    }
}
