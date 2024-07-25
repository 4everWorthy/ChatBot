package org.example;

import java.util.Scanner;

public class ChatBot {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        bot.run();
        scanner.close(); // Close the scanner resource when done
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
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "!");
        return name;
    }

    public int guessUserAge() {
        System.out.println("I will ask you a few questions to guess your age.");

        System.out.print("Do you remember life before smartphones? (yes/no) ");
        String beforeSmartphones = getValidInput(new String[]{"yes", "no"});

        System.out.print("Which social media platform did you first sign up for? (myspace, facebook, instagram, tiktok) ");
        String firstSocialMedia = getValidInput(new String[]{"myspace", "facebook", "instagram", "tiktok"});

        System.out.print("What is your birth month? (1-12): ");
        int birthMonth = getValidIntInput(1, 12);

        System.out.print("What is your zodiac sign? ");
        String zodiacSign = scanner.nextLine().toLowerCase();

        int ageGuess = estimateAge(beforeSmartphones, firstSocialMedia, birthMonth, zodiacSign);

        System.out.println("Based on your answers, I guess your age is around " + ageGuess + " years old!");

        int low = 0;
        int high = 100;
        while (!confirmAge(ageGuess)) {
            if (refineAgeGuess(ageGuess).equals("higher")) {
                low = ageGuess + 1;
            } else {
                high = ageGuess - 1;
            }
            ageGuess = (low + high) / 2;
            System.out.println("I will guess your age is around " + ageGuess + " years old.");
        }
        return ageGuess;
    }

    private int estimateAge(String beforeSmartphones, String firstSocialMedia, int birthMonth, String zodiacSign) {
        int age = 20;

        if (beforeSmartphones.equals("yes")) {
            age += 15;
        } else {
            age -= 5;
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
        }

        if (birthMonth <= 6) {
            age += 2;
        } else {
            age -= 2;
        }

        if (zodiacSign.equals("aries") || zodiacSign.equals("leo") || zodiacSign.equals("sagittarius")) {
            age += 1;
        } else if (zodiacSign.equals("taurus") || zodiacSign.equals("virgo") || zodiacSign.equals("capricorn")) {
            age -= 1;
        }

        return age;
    }

    private boolean confirmAge(int age) {
        System.out.print("Is my guess correct? (yes/no) ");
        return getValidInput(new String[]{"yes", "no"}).equals("yes");
    }

    private String refineAgeGuess(int currentGuess) {
        System.out.print("Is your age higher or lower than " + currentGuess + "? (higher/lower) ");
        return getValidInput(new String[]{"higher", "lower"});
    }

    public void countToNumber() {
        System.out.print("Enter a number for me to count to: ");
        int number = scanner.nextInt();
        for (int i = 0; i <= number; i++) {
            System.out.println(i);
        }
        scanner.nextLine(); // consume the remaining newline
    }

    public void testProgrammingKnowledge() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("What is the correct way to declare a variable to store an integer value in Java?");
        System.out.println("1. int num = 1;");
        System.out.println("2. num = 1;");
        System.out.println("3. int = 1;");
        System.out.println("4. integer num = 1;");

        while (true) {
            System.out.print("Enter your answer (1, 2, 3, or 4): ");
            int answer = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
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
        System.out.print("Enter a number from 1 to 7 to know what I enjoy about each day: ");
        int day = getValidIntInput(1, 7);

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
        }
    }

    private String getValidInput(String[] validInputs) {
        String input;
        while (true) {
            input = scanner.nextLine().toLowerCase();
            for (String validInput : validInputs) {
                if (input.equals(validInput)) {
                    return input;
                }
            }
            System.out.print("Invalid input. Please enter one of the following: ");
            for (String validInput : validInputs) {
                System.out.print(validInput + " ");
            }
            System.out.println();
        }
    }

    private int getValidIntInput(int min, int max) {
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // consume the remaining newline
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                scanner.next(); // discard invalid input
            }
            System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
        }
    }
}
