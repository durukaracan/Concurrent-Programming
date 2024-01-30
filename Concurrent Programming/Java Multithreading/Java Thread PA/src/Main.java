import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("RULES");
        System.out.println("1) each rabbit sleeps 300 milliseconds");
        System.out.println("2) person put carrots in random boxes in 200 milliseconds");
        System.out.println("3) every carrot disappears in 600 milliseconds if they hasn't eaten after they created. ");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        System.out.println("enter the box number:");
        int numBoxes = scanner.nextInt();

        Box[] boxes = new Box[numBoxes];
        for (int i = 0; i < numBoxes; i++) {
            boxes[i] = new Box(i,false);
        }

        scanner.nextLine(); //dummy

        System.out.println("enter the number of rabbit: ");
        int rabbitNumber = scanner.nextInt();

        System.out.println("GAME HAS STARTED");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");

        // rabbit yarattım
        myRunnable[] runnables = new myRunnable[rabbitNumber];
        Thread[] threads = new Thread[rabbitNumber];
        for (int i = 0; i < rabbitNumber; i++) {
            runnables[i] = new myRunnable("Rabbit" + (i + 1), boxes ,0);
            threads[i] = new Thread(runnables[i]);
        }


        // rabit threadlerini başlattım
        for (int i = 0; i < rabbitNumber; i++) {
            threads[i].start();
        }

        // person threadini başlattım
        PersonThread personThread = new PersonThread(boxes);
        Thread person = new Thread(personThread);
        person.start();


        //join methodu
        try {
            for (int i = 0; i<rabbitNumber ; i++){
                threads[i].join();
            }
            //person.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        person.stop();
        // output
        System.out.println("---------------------");
        System.out.println("Game over!");
        printScores(runnables);
    }
    private static void printScores(myRunnable[] rabbits) {
        System.out.println("Score Board:");
        for (myRunnable rabbit : rabbits) {
            System.out.println(rabbit.getRabbitName() + ": " + rabbit.getScore() + " points");
        }
    }
}
