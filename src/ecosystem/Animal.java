package ecosystem;

import map.Position;

public abstract class Animal extends Creature  {

    public void moveTo(Position position) {
        this.setPosition(position);
    }

    public Animal(final Position position, final char sign) {
        super(position, sign);
    }
}
