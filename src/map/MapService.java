package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ecosystem.Creature;

public class MapService {

    private static final MapService INSTANCE = new MapService();

    public static MapService getInstance() {
        return INSTANCE;
    }

    private static final Random RANDOM = new Random();

    private final CreatureFactory cf = CreatureFactory.getInstance();

    private Creature[][] map;

    private List<Position> freePositions = new ArrayList<>();

    public void initMap(final int heigth, final int width) {
        map = new Creature[heigth][width];
    }

    public void fillMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (RANDOM.nextBoolean()) {
                    map[row][col] = cf.getRandomCreature(row, col);
                } else {
                    freePositions.add(new Position(row, col));
                }
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

    public Position swapToRandomFreePosition(final Position pos) {
        Position position = freePositions.get(RANDOM.nextInt(freePositions.size()));
        swapPositions(pos, position);
        return position;
    }

    private void swapPositions(final Position pos, final Position position) {
        freePositions.remove(position);
        freePositions.add(pos);
    }

    private MapService() {
    }

    public Creature[][] getMap() {
        return map;
    }
}
