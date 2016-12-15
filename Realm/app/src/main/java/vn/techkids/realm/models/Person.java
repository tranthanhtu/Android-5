package vn.techkids.realm.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Dell latitude E6520 on 11/2/2016.
 */

public class Person extends RealmObject{
    String name;
    int age;
    RealmList<Dog> dogs;

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Person create(String name, int age){
        Person p = new Person();
        p.name = name;
        p.age = age;
        return p;
    }
}
