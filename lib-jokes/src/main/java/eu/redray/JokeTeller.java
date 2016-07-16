package eu.redray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A simple joke library.
 */
public class JokeTeller {

    private ArrayList<String> mJokes = new ArrayList<>(Arrays.asList(
            "Why do Java programmers wear glasses? \nBecause they cannot see Sharp!",
            "I had a problem so I thought to use Java... Now I have ProblemFactory!",
            "Programmer (noun.) - A machine that turns coffee into code.",
            "Programmer (noun.) - A person who fixed the problem you didn't know you have "
                    + "in a way you don't understand",
            "Algorithm (noun.) - Word used by programmers when they do not want to explain what "
                    + "they did.",
            "Hardware (noun.) - A part of computer you can kick!",
            "What's the best object-oriented way to become rich? \nInheritance!",
            "What do computers and air-conditioners have in common? \nThey both become useless "
                    + "when you open windows!",
            "Chuck Norris can take screenshot of his blue screen!",
            "3 SQL Databases walked into NoSQL bar. They left right away because they couldn't "
                    + "find a table.",
            "UNIX is user friendly. It's just very particular who his friends are!",
            "I'd like to make world a better place... But they didn't give me the source code!",
            "There are 10 types of people in the world: those who understand binary and those who don't.",
            "Why do programmers always mix up Halloween and Christmas? \nBecause Oct 31 == Dec 25!",
            "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
            "How many programmers does it take to change a light bulb? \nNone. That's a hardware problem!",
            "Programming is like sex: One mistake and you have to support it for the rest of your life.",
            "Software is like sex: It's better when it's free.",
            "There are 10 types of people in the world. Those who understand binary and those who get laid.",
            "Why programmers like UNIX? \nunzip, strip, touch, finger, grep, mount, fsck, more, "
                    + " yes, fsck, fsck, fsck, umount, sleep",
            "I've got a really good UDP joke to tell you, but I don't know if you'll get it.",
            "Programming is 10% science, 20% ingenuity, and 70% getting the ingenuity to work with the science.",
            "There are three kinds of lies: Lies, damned lies, and benchmarks.",
            "The generation of random numbers is too important to be left to chance.",
            "Debugging: Removing the needles from the haystack.",
            "Program (noun.) - A magic spell cast upon a computer to enable it to turn input into error messages.",
            "Software developers like to solve problems. If there are no problems handily "
                    + "available, they will create their own problems.",
            "To understand what recursion is, you must first understand recursion."
    ));

    /**
     * Returns random joke from the library.
     *
     * @return String containing a joke
     */
    public String tellJoke() {
        Random random = new Random();
        return mJokes.get(random.nextInt(mJokes.size() - 1));
    }
}
