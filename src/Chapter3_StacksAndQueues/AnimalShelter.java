package Chapter3_StacksAndQueues;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ashis on 1/9/2017.
 */
public class AnimalShelter {

    private static int timestamp;

    private List<Cat> catList = new LinkedList<>();
    private List<Dog> dogList = new LinkedList<>();

    public void enqueue(Animal a) {
        a.setTimestamp(++timestamp);
        if(a instanceof Cat) {
            catList.add((Cat) a);
        } else if(a instanceof Dog) {
            dogList.add((Dog) a);
        } else {
            System.out.println("Animal needs to be either Cat or Dog!!!");
        }
    }

    public Cat dequeueCat() {
        if(catList.isEmpty()) {
            System.out.println("No Cats!!!");
            return null;
        }

        return catList.remove(0);
    }

    public Dog dequeueDog() {
        if(dogList.isEmpty()) {
            System.out.println("No Dogs!!!");
            return null;
        }

        return dogList.remove(0);
    }

    public Animal dequeueAny() {
        if(dogList.isEmpty() && catList.isEmpty()) {
            System.out.println("No Cats and Dogs!!!");
            return null;
        } else if(dogList.isEmpty()) {
            return dequeueCat();
        } else if(catList.isEmpty()) {
            return dequeueDog();
        }

        Cat c = catList.get(0);
        Dog d = dogList.get(0);

        Animal oldest = null;
        if(c.getTimestamp() < d.getTimestamp()) {
            return dequeueCat();
        }

        return dequeueDog();
    }

}

abstract class Animal {
    protected String name;
    protected int timestamp;

    Animal(String name) {
        this.name = name;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

}
