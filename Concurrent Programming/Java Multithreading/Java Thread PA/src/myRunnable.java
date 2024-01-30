
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

    public String getRabbitName() {
        return rabbitName;
    }

    public int getScore() {
        return score;
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
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (boxes[currentBoxIndex].hasCarrot()) {
                    System.out.println(rabbitName + " eats carrot in box "
                            + (currentBoxIndex + 1));
                    score++;
                    boxes[currentBoxIndex].removeCarrot();
                }

                currentBoxIndex++;

            }
        }
    }

}
