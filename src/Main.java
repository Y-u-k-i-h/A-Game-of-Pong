import Pong.Window;

public class Main {
    public static void main(String[] args) {

        // Create a new window and start it in a separate thread
        Window window = new Window();
        Thread t1 = new Thread(window);
        t1.start();
    }
}
