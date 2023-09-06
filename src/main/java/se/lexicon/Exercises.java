package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       Implemented Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        //()->
        List<Person> personNameErik= storage.findMany(person ->"Erik".equals(person.getFirstName()));
        for (Person person:personNameErik) {
            System.out.println(person);
        }
        //storage.findMany(person -> person.getFirstName().equals("Erik"));
        System.out.println("----------------------");
    }

    /*
        Implemented  2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        //Write your code here
        List<Person> peopleFemale= storage.findMany(person ->person.getGender().equals(Gender.FEMALE));
        peopleFemale.forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        Implemented  3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        //Write your code here
        List<Person> peopleBornAfter2000= storage.findMany(person ->person.getBirthDate().isAfter(LocalDate.of(2000,01,01)));
        peopleBornAfter2000.forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        Implemented.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        //Write your code here
        Person personWithId= storage.findOne(person ->person.getId()==123);
        System.out.println(personWithId);
        System.out.println("----------------------");

    }

    /*
        Implemented  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {

        System.out.println(message);
        //Write your code here
        //step 1: find person with id 456

        Person personWithId= storage.findOne(person ->person.getId()==456);
        //step 2: convert to string
        String result=storage.findOneAndMapToString((Predicate<Person>) personWithId,Person::toString);
        System.out.println(result);
        System.out.println("----------------------");
    }

    /*
        Implemented:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        //Write your code here
        List<Person> peopleMale= storage.findMany(person ->person.getGender().equals(Gender.MALE)&&person.getFirstName().startsWith("E"));
        for (String s : storage.findManyAndMapEachToString((Predicate<Person>) peopleMale, Person::toString)) {
            System.out.println(s);
        }
        System.out.println("----------------------");
    }

    /*
        Implemented  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);

        //Write your code here
        Predicate<Person> peopleWithBelowAge10=storage.findMany(person -> (LocalDate.now().getYear() - (person.getBirthDate().getYear())< 10);
        List<String> result = storage.findManyAndMapEachToString( peopleWithBelowAge10,Person::toString);

        System.out.println("----------------------");
    }

    /*
        Implemented  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here
        //1 step declare predicate to filter people with specified name
        //2 step print the person
        Predicate<Person> peopleWithNameUlf=person -> person.getFirstName().equals("Ulf");
        storage.findAndDo(peopleWithNameUlf,person -> System.out.println(person.getFirstName()+" "+person.getLastName()));
        System.out.println("----------------------");
    }

    /*
        Implemented  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here
        //step 1 declare predicate and check if lastName contains firstName
        Predicate<Person> lastNameContainsFirstName=person -> person.getLastName().contains(person.getFirstName());
        storage.findAndDo(lastNameContainsFirstName,person -> System.out.println(person.getFirstName()+""+person.getLastName()));
        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        Implemented  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> peopleSortedByNameA= person -> person.getFirstName().startsWith("A");
        List<Person> filteredAndSorted= storage.findAndSort(peopleSortedByNameA,Comparator.comparing(Person::getBirthDate));
        for (Person person:filteredAndSorted)
            System.out.println(person);

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here


        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here





        System.out.println("----------------------");
    }
}
