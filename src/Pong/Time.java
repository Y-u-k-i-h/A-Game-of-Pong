package Pong;

public class Time {
// Time class to handle time-related functionalities

    // The time when the 'game engine' started
    public static double timeStarted = System.nanoTime();

    // Method to get elapsed time since the game started
    public static double getTime() {
        return ((System.nanoTime() - timeStarted) * 1E-9);
    }
}
