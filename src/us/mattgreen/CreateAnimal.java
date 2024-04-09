package us.mattgreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAnimal implements Talkable, Animal {

    private Dog dog;
    private Cat cat;
    private Teacher teacher;
    private List<Animal> animals = new ArrayList<>();

    public CreateAnimal() {
        Scanner key = new Scanner(System.in);
        String typeOfAnimal, animalName, animalFriendly, miceKill = null, agePerson;

        System.out.println("\nCREATE AN ANIMAL\n----------------");
        System.out.println("What type of animal do you want to create?\n -> Type (1) if you want a dog.\n -> Type (2) if you want a cat.\n -> Type (3) if you want a teacher.");
        while (true) {
            int result;
            try {
                typeOfAnimal = key.nextLine();
                result = Integer.parseInt(typeOfAnimal);
            } catch(Exception e) {
                System.out.println("Invalid input! Please try again and select '1', '2' or '3':");
                continue;
            }

            if (result != 1 && result != 2 && result != 3) {
                System.out.println("Invalid input! Please select '1', '2' or '3':");
            }
            else {
                break;
            }
        }

        switch (typeOfAnimal) {
            case "1":
                System.out.println("You chose a dog!\nWhat is the dog's name?");
                animalName = key.nextLine();
                System.out.println("Is your dog friendly?\nType 'y' it is friendy.");
                animalFriendly = key.nextLine();
                boolean friendly = animalFriendly.equals("y");
                animals.add(dog = new Dog(friendly, animalName));
                break;
            case "2":
                System.out.println("You chose a cat!\nWhat is the cat's name?");
                animalName = key.nextLine();
                System.out.println("How many mice your cat kill?");
                //miceKill = key.nextLine();
                while (true) {
                    int result;
                    try {
                        miceKill = key.nextLine();
                        result = Integer.parseInt(miceKill);

                    } catch(Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        continue;
                    }
                    if (result <= 0 || result >= 100 ) {
                        System.out.println("It is a valid numbe! Please type a number between '0' and '100':");
                    }
                    else {
                        break;
                    }
                }
                animals.add(cat = new Cat(Integer.parseInt(miceKill), animalName));
                break;
            case "3":
                System.out.println("You chose a teacher!\nWhat is the teacher's name?");
                animalName = key.nextLine();
                System.out.println("How old is the teacher?");
                //agePerson = key.nextLine();
                while (true) {
                    int result;
                    try {
                        agePerson = key.nextLine();
                        result = Integer.parseInt(agePerson);

                    } catch(Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        continue;
                    }
                    if (result <= 0 || result >= 70 ) {
                        System.out.println("It is a valid numbe! Please type a number between '0' and '70':");
                    }
                    else {
                        break;
                    }
                }

                animals.add(teacher = new Teacher(Integer.parseInt(agePerson), animalName));
                break;
        }

        System.out.println("\nAnimal created:");
        for (Animal animalList : animals){
            System.out.printf(" -> %s\n", animalList);
        }

        System.out.println(" ");

    }

    @Override
    public String talk() {

        if (dog != null && cat == null) {
            return dog.talk();
        } else if (dog == null && teacher == null){
            return cat.talk();
        }else if (dog == null && cat == null){
            return teacher.talk();
        }

        return null;
    }

    public String getName() {

        if (dog != null && cat == null) {
            return dog.getName();
            //return String.format("The dog name is %s, it %s friendly.", dog.getName(), dog.isFriendly() ? "is" : "is not");
        } else if (dog == null && teacher == null){
            return cat.getName();
            //return String.format("The cat name is %s, it killed to %s mice", cat.getName(), cat.getMousesKilled());
        }else if (dog == null && cat == null){
            return teacher.getName();
            //return String.format("The teacher name is %s, the teacher is %s years old", teacher.getName(), teacher.getAge());
        }

        return null;
    }

}
