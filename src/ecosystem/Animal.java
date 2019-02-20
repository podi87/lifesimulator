package ecosystem;

public abstract class Animal extends Creature  {

    protected void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Animal(final int x, final int y, final char sign) {
        super(x, y, sign);
    }
}
