package map;

import java.util.Random;

import ecosystem.Creature;
import ecosystem.animals.Chicken;
import ecosystem.animals.Dog;
import ecosystem.plants.Tree;

public class CreatureFactory {

    private static final CreatureFactory INSTANCE = new CreatureFactory();

    public static CreatureFactory getInstance() { return INSTANCE; }

    private CreatureFactory() {
    }

    private static final int CREATURE_BOUND = 3;

    public Creature getRandomCreature(final int x, final int y) {
        int randomInt = new Random().nextInt(CREATURE_BOUND);
        switch (randomInt) {
            case 0:
                return new Tree(new Position(x,y));
            case 1:
                return new Chicken(new Position(x,y));
            case 2:
                return new Dog(new Position(x,y));
            default:
                return null;
        }
    }
}
