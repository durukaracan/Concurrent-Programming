
public class myRunnable implements Runnable{
    private String rabbitName;
    private Box[] boxes;
    private int score;
    private int currentBoxIndex;
    private static volatile String winner = null;

    //constructor
    public myRunnable(String name, Box[] boxes, int currentBoxIndex) {
        this.rabbitName = name;
        this.boxes = boxes;
        this.score = 0;
        this.currentBoxIndex = currentBoxIndex;
    }

    //Runnable dan implement ettiğim için gelen method
    public void run() {
        while (currentBoxIndex < boxes.length - 1) {
                long threadId = Thread.currentThread().getId();
                if (winner == null) {
                    System.out.println(rabbitName + " jumps to box "
                                     + (currentBoxIndex + 1)
                                     +"................(Thread ID: " + threadId + ")");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentBoxIndex++;

                    if (currentBoxIndex >= 9 && winner == null) {
                        // The first rabbit to reach box 9 wins
                        winner = rabbitName;
                        System.out.println(rabbitName + " is the winner!!................(Thread ID: " + threadId +")");
                        return;
                    }
                }
        }
    }

}
