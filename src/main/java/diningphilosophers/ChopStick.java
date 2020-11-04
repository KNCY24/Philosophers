package diningphilosophers;

public class ChopStick {
    // Le nombre total de baguettes
    private static int stickCount = 0;
    // Le numéro de chaque baguette
    private final int myNumber;
    // Est-ce que ma baguette est libre ?
    private boolean iAmFree = true;

    public ChopStick() {
        // Chaque baguette est numérotée
        myNumber = ++stickCount;
    }

    public void take() {

    }

    public void release () {

    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
