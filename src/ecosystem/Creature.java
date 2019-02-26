package ecosystem;

public abstract class Creature {

    private Position position;

    private char sign;

    public void setPosition(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Creature(final Position position, final char sign) {
        this.position = position;
        this.sign = sign;
    }
}
