import gameoflife.Grid;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Grid g = new Grid(20);
        while (true) {
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J");
            System.out.flush();

            g.generateNextState();
            System.out.println(g.toString());
         
        }
    }
}
