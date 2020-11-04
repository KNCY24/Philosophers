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

    synchronized void take() throws InterruptedException {
        stickCount = stickCount - 1;

        if (stickCount % 2 != 0) {
            while (this.iAmFree == false) {
                wait(); // Peut lever InterruptedException
            }
            assert (this.iAmFree == true);
            this.iAmFree = false;
            System.out.printf("Je prends la 2ème baguette" + '\n');
            notifyAll();

        } else {

            assert (this.iAmFree == true);
            this.iAmFree = false;
            System.out.printf("Je prends la 1ère baguette" + '\n');
            notifyAll();
        }
    }

    synchronized void release() throws InterruptedException {
        stickCount = stickCount + 1;
        if (stickCount % 2 != 0) {
            while (this.iAmFree == true) {
                wait(); // Peut lever InterruptedException
            }
            assert (this.iAmFree == false);
            this.iAmFree = true;
            System.out.printf("Je dépose la 2ème bague" + '\n');
            notifyAll();

        } else {

            assert (this.iAmFree == false);
            this.iAmFree = true;
            System.out.printf("Je dépose la 1ère bague" + '\n');
            notifyAll();
        }

    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
