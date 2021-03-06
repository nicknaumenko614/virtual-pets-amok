package pets_amok;

import java.util.Scanner;

// While we absolutely prefer you get a project done without tests than not get a project done at all, we want you to add tests to this
// application.
//
// - I added tests where possible, although I couldn't figure out how to correctly test abstract class methods,
//   and did not have enough time in my one-on-one to ask the instructors.

// Look for places where you have certain code repeated multiple times. For example, instead of calling the tickAllPets() method
// after each user choice, you can have it called one time at the bottom of your game loop.
//
// - I refactored a number of methods, specifically the Tick method and most of the methods that are used to perform actions on pets.


public class VirtualPetShelterApp {
    private static VirtualPetShelter shelter = new VirtualPetShelter();

    public static void main(String[] args) {

        System.out.println("Welcome to Virtual Pet Shelter!");
        System.out.println("");
        System.out.println("Do not allow your pets' Health and Happiness to drop to '0'");
        System.out.println("Be sure you attend to the pets' needs before any of them reach '50'");
        System.out.println("");
        shelter.addInitialPetsToShelter();

        displayAllPetsInShelter();

        while (!shelter.areNeedsTooHighForAnyPet()) {

            performActionOnPet(askUserForPetInteraction());
            shelter.tickAllPets();
            displayAllPetsInShelter();

        }
        System.out.println("");
        System.out.println("ONE OR MORE OF YOUR PETS' NEEDS WERE NOT ATTENDED TO IN TIME. YOU MUST LEAVE SHELTER NOW. ");


    }

    private static void displayAllPetsInShelter() {
        System.out.println("");
        System.out.println(" You currently have the following pets: ");
        System.out.println("");
        shelter.listAllPetsInShelter();

    }

    private static Integer askUserForPetInteraction() {
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("1. Feed All Organic Pets in Shelter");
        System.out.println("2. Water All Organic Pets in Shelter");
        System.out.println("3. Bathroom Break All Organic Pets in Shelter");
        System.out.println("4. Walk All Dogs in Shelter");
        System.out.println("5. Clean Organic Dog Cages");
        System.out.println("6. Oil All Robotic Pets in Shelter");
        System.out.println("7. Play with a pet in Shelter");
        System.out.println("8. Admit a new pet");
        System.out.println("9. Give up a pet for adoption");
        System.out.println("10. Quit");


        Scanner scanner = new Scanner(System.in);

        return Integer.valueOf(scanner.next());
    }

    private static void performActionOnPet(Integer userSelection) {

        if (userSelection.equals(1)) {
            shelter.feedAllOrganicPets();
            System.out.println("You fed all pets in shelter");

        } else if (userSelection.equals(2)) {
            shelter.waterAllOrganicPets();
            System.out.println("You watered all pets in shelter");

        } else if (userSelection.equals(3)) {
            shelter.bathroomBreakAllOrganicPets();
            System.out.println("You gave all pets in shelter a bathroom break ");

        } else if (userSelection.equals(4)) {
            shelter.walkAllDogs();
            System.out.println("You walked all dogs in shelter");

        } else if (userSelection.equals(5)) {
            shelter.cleanCagesForAllOrganicDogs();
            System.out.println("You cleaned all organic dog cages");

        } else if (userSelection.equals(6)) {
            shelter.oilAllRoboticPets();
            System.out.println("You oiled all robotic pets in shelter");

        } else if (userSelection.equals(7)) {
            System.out.println("Okay, which pet would you like to play with? ");
            String petToPlayWith = askUserWhichPetToInteractWith();
            shelter.playWithPet(petToPlayWith);
            System.out.println("You played with " + petToPlayWith);

        } else if (userSelection.equals(8)) {
            VirtualPet newPetToBePlacedInShelter = askUserForNewPetInfo();
            shelter.addHomelessPetToShelter(newPetToBePlacedInShelter);
            System.out.println("A pet named " + newPetToBePlacedInShelter.getPetName() + " has been placed in the shelter");

        } else if (userSelection.equals(9)) {
            System.out.println("Which Pet Would you like to give up for adoption");
            String petToGiveUpForAdoption = askUserWhichPetToInteractWith();
            shelter.giveUpPetForAdoption(petToGiveUpForAdoption);
            System.out.println("A pet named " + petToGiveUpForAdoption + " has been adopted by someone");

        } else if (userSelection.equals(10)) {
            System.out.println("You left the Virtual Pet Shelter. ");
            System.exit(0);

        }

    }

    private static String askUserWhichPetToInteractWith() {

        shelter.listAllPetNamesInShelter();
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static VirtualPet askUserForNewPetInfo() {
        System.out.println("What is the name of pet being placed in shelter?");
        Scanner scanner = new Scanner(System.in);
        String nameOfNewPet = scanner.next();

        System.out.println("What type of pet is it? ");
        System.out.println("1. Organic Dog");
        System.out.println("2. Organic Cat");
        System.out.println("3. Robotic Dog");
        System.out.println("4. Robotic Cat");

        VirtualPet newPet = null;
        scanner = new Scanner(System.in);
        int typeOfNewPet = Integer.parseInt(scanner.next());
        if (typeOfNewPet == 1) {
            newPet = new OrganicDog(nameOfNewPet, 20, 20, 20, 20, 20, 20);

        } else if (typeOfNewPet == 2) {
            newPet = new OrganicCat(nameOfNewPet, 20, 20, 20, 20, 20);

        } else if (typeOfNewPet == 3) {
            newPet = new RoboticDog(nameOfNewPet, 20, 20, 20);

        } else if (typeOfNewPet == 4) {
            newPet = new RoboticCat(nameOfNewPet, 20, 20, 20);
        }
        return newPet;

    }

}
