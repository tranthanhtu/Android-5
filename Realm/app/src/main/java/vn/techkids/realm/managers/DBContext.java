package vn.techkids.realm.managers;

import android.content.Context;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import vn.techkids.realm.models.Dog;
import vn.techkids.realm.models.Person;

/**
 * Created by Dell latitude E6520 on 11/2/2016.
 */

public class DBContext {
    private Realm realm;


    public DBContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    private static DBContext instance;
    public static DBContext getInstance(){
        return instance;
    }

    public static void init(Context context){
        if (context != null){
            instance = new DBContext(context);
        }
    }
/*=====================Person==============================*/
    public void add(Person p) {
        //2 Get Realm defaut
        Realm realm = Realm.getDefaultInstance(); //singleton

        //4 Add object to realm
        realm.beginTransaction();
        realm.copyToRealm(p);
        realm.commitTransaction();
    }

    public List<Person> findAllPerson() {
        //2
        Realm realm = Realm.getDefaultInstance();

        //3 Query  - Lazy load
        RealmResults<Person> persons = realm.where(Person.class).findAll();

        return persons;
    }

    public Person findPersonByName(String name) {
        //2
        Realm realm = Realm.getDefaultInstance();

        //3 Query  - Lazy load
        Person person = realm
                .where(Person.class)
                .equalTo("name", name, Case.INSENSITIVE)
                .findFirst();

        return person;
    }

    public void update(Person person, String name, int age) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        person.setAge(age);
        person.setName(name);
        realm.commitTransaction();
    }

    public void delete(Person person) {
        if (person != null) return;
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();

    }

    public void deleteAll(Class<? extends RealmModel> clazz){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();
    }


    /*=====================Person==============================*/

    public void add(Dog dog){
        realm.beginTransaction();
        realm.copyToRealm(dog);
        realm.commitTransaction();
    }
}
