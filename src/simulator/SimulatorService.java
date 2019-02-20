package simulator;

import ecosystem.Animal;
import ecosystem.Creature;
import map.MapService;

public class SimulatorService {

    private MapService ms = MapService.getInstance();

    public void init(int heigth, int width) {
        ms.initMap(heigth, width);
        ms.fillMap();
        ms.drawMap();
        System.out.println();
    }

    public void simulate() {
        Creature[][] map = ms.getMap();
        for (Creature[] row : map) {
            for (Creature creature : row) {
                if (creature instanceof Animal) {
                    Animal animal = (Animal) creature;
                    animal.moveTo(ms.swapToRandomFreePosition(animal.getPosition()));
                }
            }
        }
        ms.drawMap();
        System.out.println();
    }

}
