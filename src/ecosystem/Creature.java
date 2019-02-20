package ecosystem;

import map.Position;

public abstract class Creature {

    private Position position;

    private char sign;

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(final char sign) {
        this.sign = sign;
    }

    public Creature(final Position position, final char sign) {
        this.position = position;
        this.sign = sign;
    }
}
