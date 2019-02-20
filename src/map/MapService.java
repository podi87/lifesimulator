package map;

import java.util.Random;

import ecosystem.Creature;

public class MapService {

    private static final MapService INSTANCE = new MapService();

    public static MapService getInstance() { return INSTANCE; }

    private CreatureFactory cf = CreatureFactory.getInstance();

    private Creature[][] map;

    public void initMap(final int heigth, final int width) {
        map = new Creature[heigth][width];
    }

    public void fillMap() {
        Random random = new Random();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = random.nextBoolean() ? cf.getRandomCreature(row, col) : null;
            }
        }
    }

    public void drawMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                Creature creature = map[row][col];
                System.out.print(creature == null ? " " : creature.getSign());
            }
            System.out.println();
        }
    }

    private MapService(){}

    public Creature[][] getMap() {
        return map;
    }
}
