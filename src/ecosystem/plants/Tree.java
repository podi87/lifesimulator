package ecosystem.plants;

import java.io.Serializable;

import ecosystem.Plant;
import ecosystem.Position;

public class Tree extends Plant implements Serializable {

    public Tree(final Position position) {
        super(position, 'T');
    }
}
