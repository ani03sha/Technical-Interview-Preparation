package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis.
 * <p>
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * <p>
 * They cannot select which specific animal they would like.
 * <p>
 * Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny,
 * dequeueDog, and dequeueCat.
 * <p>
 * You may use the built-in Linked List data structure.
 */
public class AnimalShelter {

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        // Create some objects and add them to shelter
        Dog bruno = new Dog("dog");
        animals.enqueue(bruno);
        Dog oscar = new Dog("dog");
        animals.enqueue(oscar);
        Cat tiago = new Cat("cat");
        animals.enqueue(tiago);
        Cat lancelot = new Cat("cat");
        animals.enqueue(lancelot);
        Dog goofy = new Dog("dog");
        animals.enqueue(goofy);

        System.out.println("We are getting a: " + animals.dequeueAny().type);
        System.out.println("We are getting a: " + animals.dequeueCat().type);
        System.out.println("We are getting a: " + animals.dequeueDog().type);
        System.out.println("We are getting a: " + animals.dequeueDog().type);
        System.out.println("We are getting a: " + animals.dequeueCat().type);
    }

    static class AnimalQueue {
        // List to store dogs
        private final Queue<Dog> dogs = new LinkedList<>();
        // List to store cats
        private final Queue<Cat> cats = new LinkedList<>();
        // Combined timestamp for each animal
        private int timestamp = 0;

        public void enqueue(Animal animal) {
            // Set the timestamp for this animal
            animal.setTimestamp(this.timestamp);
            // Update timestamp
            this.timestamp++;
            // Add the animal to the respective list
            if (animal instanceof Dog) {
                dogs.add((Dog) animal);
            } else if (animal instanceof Cat) {
                cats.add((Cat) animal);
            }
        }

        public Animal dequeueAny() {
            // Look at both the lists and pop the oldest animal
            if (dogs.isEmpty()) {
                return dequeueCat();
            } else if (cats.isEmpty()) {
                return dequeueDog();
            }
            // Get the oldest element in both queues
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            return dog.getTimestamp() < cat.getTimestamp() ? dequeueDog() : dequeueCat();

        }

        public Dog dequeueDog() {
            if (dogs.isEmpty()) {
                throw new RuntimeException("There are no dogs left");
            }
            return dogs.poll();
        }

        public Cat dequeueCat() {
            if (cats.isEmpty()) {
                throw new RuntimeException("There are no cats left");
            }
            return cats.poll();
        }
    }

    static abstract class Animal {
        // Type of the animal (e.g., dog, cat, etc.)
        String type;
        // Timestamp when the animal was brought into the shelter
        private int timestamp;

        Animal(String type) {
            this.type = type;
        }

        public int getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    static class Dog extends Animal {
        Dog(String type) {
            super(type);
        }
    }

    static class Cat extends Animal {
        Cat(String type) {
            super(type);
        }
    }
}
