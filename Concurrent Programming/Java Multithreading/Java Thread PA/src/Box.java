public class Box {
    private int boxNumber;
    private boolean hasCarrot;

    public Box(int number,boolean hasCarrot) {
        this.boxNumber = number;
        this.hasCarrot = hasCarrot;

    }
    public void putCarrot() {
        this.hasCarrot = true;

    }

    public boolean hasCarrot() {
        return hasCarrot;
    }

    public void removeCarrot() {
        this.hasCarrot = false;

    }
}
