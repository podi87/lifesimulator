package ecosystem;

public abstract class Creature {
    private int x;
    private int y;

    private char sign;

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(final char sign) {
        this.sign = sign;
    }

    public Creature(final int x, final int y, final char sign) {
        this.x = x;
        this.y = y;
        this.sign = sign;
    }
}
