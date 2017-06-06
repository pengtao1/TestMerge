package annotationTest3.model;

import annotationTest3.annotation.PeopleAnnotion;

public class BlackPeople extends IPeople {

    @Override
    @PeopleAnnotion(say = "Black")
    public void say() {
        System.out.println("I am Black");
    }

}
