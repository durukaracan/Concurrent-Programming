import java.util.Random;

class PersonThread implements Runnable {
    private Box[] boxes;
    private Random random = new Random();

    public PersonThread(Box[] boxes) {
        this.boxes = boxes;
    }

    @Override
    public void run() {
        while (true) {
            int randomBoxIndex = random.nextInt(boxes.length);

            synchronized (boxes[randomBoxIndex]) {

                if (!boxes[randomBoxIndex].hasCarrot()) {
                    System.out.println("Person PUTS carrot to box " + (randomBoxIndex + 1));
                    boxes[randomBoxIndex].putCarrot();
                }
            }

            try {
                // Belirli bir süre bekle
                Thread.sleep(200);

                synchronized (boxes[randomBoxIndex]) {
                    // Eğer hala havuç varsa kaldır
                    if (boxes[randomBoxIndex].hasCarrot()) {
                        System.out.println("Carrot in box " + (randomBoxIndex + 1) + " EATEN.");
                        boxes[randomBoxIndex].removeCarrot();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
