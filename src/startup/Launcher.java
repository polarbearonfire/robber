package startup;


public class Launcher {

    public static void main(String[] args) {
        GameController master = new GameController();
        master.setUp();


        Thread t = new Thread(master);
        t.start();
    }
}
