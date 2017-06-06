package annotationTest3.model;

import annotationTest3.annotation.PeopleAnnotion;

public class WhitePeople extends IPeople {

    @Override
    @PeopleAnnotion(say = "White")
    public void say() {
        System.out.println("I am White");
    }

}
