package ecosystem.animals;

import java.io.Serializable;

import ecosystem.Animal;
import ecosystem.Position;

public class Dog extends Animal implements Serializable {

    public Dog(final Position position) {
        super(position, 'D');
    }
}
