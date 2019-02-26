package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ecosystem.Animal;
import ecosystem.Creature;
import ecosystem.Position;

class MapService {

    private static final MapService INSTANCE = new MapService();

    static MapService getInstance() {
        return INSTANCE;
    }

    private static final Random RANDOM = new Random();

    private final CreatureFactory cf = CreatureFactory.getInstance();

    private Creature[][] map;

    private List<Position> freePositions = new ArrayList<>();

    private List<Animal> animals = new ArrayList<>();

    void initMap(final int heigth, final int width) {
        map = new Creature[heigth][width];
    }

    void fillMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (RANDOM.nextBoolean()) {
                    Creature randomCreature = cf.getRandomCreature(row, col);
                    map[row][col] = randomCreature;
                    if (randomCreature instanceof Animal) animals.add((Animal) randomCreature);
                } else {
                    freePositions.add(new Position(row, col));
                }
            }
        }
    }

    void drawMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                Creature creature = map[row][col];
                System.out.print(creature == null ? " " : creature.getSign());
            }
            System.out.println();
        }
    }

    void moveAnimals() {
        for (Animal animal : animals) {
            map[animal.getPosition().getX()][animal.getPosition().getY()] = null;
            animal.moveTo(swapToRandomFreePosition(animal.getPosition()));
            map[animal.getPosition().getX()][animal.getPosition().getY()] = animal;
        }
        drawMap();
        System.out.println();
    }

    Position swapToRandomFreePosition(final Position pos) {
        if (freePositions.size() == 0) return pos;
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

    Creature[][] getMap() {
        return map;
    }

}
