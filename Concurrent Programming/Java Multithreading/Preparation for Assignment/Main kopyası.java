public class Main {


    public static void main(String[] args) {
        int numBoxes = 10; // Number of boxes
        Box[] boxes = new Box[numBoxes];
        for (int i = 0; i < numBoxes; i++) {
            boxes[i] = new Box(i);
        }



        // rabbit yarattım
        myRunnable rabbit1 = new myRunnable("duru", boxes,0);
        myRunnable rabbit2 = new myRunnable("mesude", boxes,0);

        Thread myThread1 = new Thread(rabbit1);
        Thread myThread2 = new Thread(rabbit2);

        // rabit threadlerini başlattım
        myThread1.start();
        myThread2.start();

        //join methodu
        // catch e düşünce output yazdırsın diye
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // output
        System.out.println("Game over!");


    }

}
