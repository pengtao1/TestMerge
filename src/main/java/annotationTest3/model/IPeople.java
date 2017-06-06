package annotationTest3.model;

import annotationTest3.annotation.PeopleAnnotion;

public abstract class IPeople {
    @PeopleAnnotion(say="NoColor")
    public abstract void say();

    public void walk(){
        System.out.println("I can Walk");
    }

}