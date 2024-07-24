package org.example;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        bot.run();
    }

    public void run() {
        greetUser();
        String name = askUserName();
        int age = guessUserAge();
        countToNumber();
        testProgrammingKnowledge();

        // Placeholder for future levels
        // Uncomment these lines when ready to add levels 2 and 3
        // tellStory(name, age);
        // dayOfWeekPhrase();
    }

    public void greetUser() {
        System.out.println("Hello! I am your friendly chat bot.");
    }

    public String askUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "!");
        return name;
    }

    public int guessUserAge() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I will ask you a few questions to guess your age.");

        System.out.print("What is your favorite cartoon from childhood? ");
        String cartoon = scanner.nextLine();

        System.out.print("Do you remember life before smartphones? (yes/no) ");
        String beforeSmartphones = scanner.nextLine().toLowerCase();

        // A while loop ensures that the users input is valid.
        while (!beforeSmartphones.equals("yes") && !beforeSmartphones.equals("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            beforeSmartphones = scanner.nextLine().toLowerCase();
        }

        System.out.print("Which social media platform did you first sign up for? (myspace, facebook, instagram, tiktok) ");
        String firstSocialMedia = scanner.nextLine().toLowerCase();

        while (!firstSocialMedia.equals("myspace") &&
                !firstSocialMedia.equals("facebook") &&
                !firstSocialMedia.equals("instagram") &&
                !firstSocialMedia.equals("tiktok")) {
            System.out.print("Invalid input. Please enter one of the following: myspace, facebook, instagram, tiktok: ");
            firstSocialMedia = scanner.nextLine().toLowerCase();
        }

        int ageGuess = estimateAge(cartoon, beforeSmartphones, firstSocialMedia);

        System.out.println("Based on your answers, I guess your age is around " + ageGuess + " years old!");
        return ageGuess;
    }
    // a series of conditional statements to estimate the age based on the user's answers
    // 'private', can only be accessed within the same class in which it is defined.
    // This helps to encapsulate the internal workings of the class and protect the data from being accessed or modified directly from outside the class.
    private int estimateAge(String cartoon, String beforeSmartphones, String firstSocialMedia) {
        int age = 25; // Default starting point, can be adjusted based on assumptions or requirements.

        if (beforeSmartphones.equals("yes")) {
            age += 10; // This expression increments the age variable by 10.
        } else {
            age -= 5; // This expression decrements the age variable by 5.
        }

        switch (firstSocialMedia) {
            case "myspace":
                age += 10;
                break;
            case "facebook":
                age += 5;
                break;
            case "instagram":
                age -= 5;
                break;
            case "tiktok":
                age -= 10;
                break;
            default:
                break;
        }

        return age;
    }

    public void countToNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for me to count to: ");
        int number = scanner.nextInt();
        for (int i = 0; i <= number; i++) {
        // header of a for loop
            // loop initializes 'i' to 0, checks if 'i' is less than or equal to number, prints 'i', increments 'i' by 1, and repeats until 'i' exceeds number.
            System.out.println(i);
        }
    }

    public void testProgrammingKnowledge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's test your programming knowledge.");
        System.out.println("What is the correct way to declare a variable to store an integer value in Java?");
        System.out.println("1. int num = 1;");
        System.out.println("2. num = 1;");
        System.out.println("3. int = 1;");
        System.out.println("4. integer num = 1;");

        while (true) {
            System.out.print("Enter your answer (1, 2, 3, or 4): ");
            int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println("Congratulations! That is the correct answer.");
                break;
            } else {
                System.out.println("Sorry, that's incorrect. Please try again.");
            }
        }
    }

    // Placeholder for level 2 and 3 methods
    // Uncomment these methods when ready to add levels 2 and 3

    /*
    public void tellStory(String name, int age) {
        System.out.println("Once upon a time, there was a person named " + name + " who was " + age + " years old.");
        System.out.println(name + " loved to learn about programming and spent many hours coding.");
        System.out.println("One day, " + name + " created a chat bot that could do many amazing things.");
    }

    public void dayOfWeekPhrase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number from 1 to 7 to know what I enjoy about each day: ");
        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.println("I'm a little buggy on Mondays.");
                break;
            case 2:
                System.out.println("Tuesdays are for troubleshooting.");
                break;
            case 3:
                System.out.println("Wednesdays are wonderful.");
                break;
            case 4:
                System.out.println("Thursdays are terrific.");
                break;
            case 5:
                System.out.println("Fridays are fabulous.");
                break;
            case 6:
                System.out.println("Saturdays are super.");
                break;
            case 7:
                System.out.println("Sundays are serene.");
                break;
            default:
                System.out.println("Invalid input. Please enter a number from 1 to 7.");
        }
    }
    */
}
