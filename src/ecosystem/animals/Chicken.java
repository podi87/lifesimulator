package ecosystem.animals;

import java.io.Serializable;

import ecosystem.Animal;
import ecosystem.Position;

public class Chicken extends Animal implements Serializable {

    public Chicken(final Position position) {
        super(position, 'C');
    }
}
