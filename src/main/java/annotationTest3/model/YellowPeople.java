package annotationTest3.model;

import annotationTest3.annotation.PeopleAnnotion;

public class YellowPeople extends IPeople{

    @Override
    @PeopleAnnotion(say="Yellow")
    public void say() {
        System.out.println("I am Yellow");
    }

}
