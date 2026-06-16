public class Main {

    public static void main(String[] args) {

        // Start Alice (Server)
        Thread server = new Thread(() -> new Alice());
        server.start();

        // Small delay before client starts
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start Bob (Client)
        Thread client = new Thread(() -> new Bob());
        client.start();
    }
}
