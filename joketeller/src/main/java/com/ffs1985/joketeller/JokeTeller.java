package com.ffs1985.joketeller;

import java.util.Random;

public class JokeTeller {
    private static final String[] jokes = {
            "A: \"Hey, man! Please call me a taxi.\"\n\n" +
            "B: \"Yes, sir. You are a taxi.\"",

            "Mother: Did you enjoy your first day at school?\n\n" +
            "Girl: First day? Do you mean I have to go back tomorrow?",

            "Patient: Doctor! You've got to help me! Nobody ever listens to me. No one ever pays any attention to what I have to say.\n\n" +
            "Doctor: Next please!",

            "A snail walks into a bar and the barman tells him there's a strict policy about having snails in the bar and so kicks him out.\n\n" +
            "A year later the same snail re-enters the bar and asks the barman \"What did you do that for?\"",

            "A: \"Why do you take baths in milk?\"\n\n" +
            "B: \"I can't find a cow tall enough for a shower.\""
    };

    public static String tellAJoke() {
        return jokes[randomNumberInRange(0, 4)];
    }

    private static int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
