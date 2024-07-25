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
        tellStory(name, age);
        dayOfWeekPhrase();
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

        System.out.print("Which was your favorite cartoon from childhood? (spongebob, pokemon, looney tunes, teletubbies): ");
        String cartoon = scanner.nextLine().toLowerCase();

        while (!cartoon.equals("spongebob") &&
                !cartoon.equals("pokemon") &&
                !cartoon.equals("looney tunes") &&
                !cartoon.equals("teletubbies")) {
            System.out.print("Invalid input. Please enter one of the following: spongebob, pokemon, looney tunes, teletubbies: ");
            cartoon = scanner.nextLine().toLowerCase();
        }

        int ageGuess = estimateAge(cartoon, beforeSmartphones, firstSocialMedia);

        System.out.println("Based on your answers, I guess your age is around " + ageGuess + " years old!");
        return ageGuess;
    }

    private int estimateAge(String cartoon, String beforeSmartphones, String firstSocialMedia) {
        int age = 20; // Adjusted starting point

        if (beforeSmartphones.equals("yes")) {
            age += 10; // This expression increments the age variable by 10.
        } else {
            age -= 5; // This expression decrements the age variable by 5.
        }

        switch (firstSocialMedia) {
            case "myspace":
                age += 5;
                break;
            case "facebook":
                age += 3;
                break;
            case "instagram":
                age -= 2;
                break;
            case "tiktok":
                age -= 5;
                break;
            default:
                break;
        }

        // Adjust age based on favorite cartoon
        switch (cartoon) {
            case "spongebob":
                age -= 3;
                break;
            case "pokemon":
                age += 2;
                break;
            case "looney tunes":
                age += 5;
                break;
            case "teletubbies":
                age -= 5;
                break;
            default:
                // No change for unrecognized cartoons
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
            // initializes 'i' to 0, checks if 'i' is less than or equal to number, prints 'i', increments 'i' by 1, and repeats until 'i' exceeds number.
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
                System.out.println("Mondays are the perfect day to set new goals, start fresh, and chase my dreams with a big smile.");
                break;
            case 2:
                System.out.println("On Tuesdays I build momentum, tackle new challenges, and make great strides towards my goals.");
                break;
            case 3:
                System.out.println("Wednesdays are midweek vibes—it's a great time to reflect on what I've achieved so far and gear up to finish the week strong.");
                break;
            case 4:
                System.out.println("On Thursdays, I can almost see the weekend from here. It's the perfect day to power through tasks and start wrapping up the week.");
                break;
            case 5:
                System.out.println("Fridays: I've worked hard all week, and now it's time to wrap things up! TGIF!!");
                break;
            case 6:
                System.out.println("Saturdays is all about enjoying my time, doing what I love, and recharging for the week ahead.");
                break;
            case 7:
                System.out.println("Ah, Sunday! It's the perfect day to relax, reflect, and prepare for the week ahead.");
                break;
            default:
                System.out.println("Invalid input. Please enter a number from 1 to 7.");
        }
    }
}
