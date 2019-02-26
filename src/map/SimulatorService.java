package map;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Instant;

public class SimulatorService {

    private static final int DEFAULT_SPEED = 1000;

    private MapService ms = MapService.getInstance();

    public void simulateLife(int speed, int duration) {
        Instant currentInstant = Instant.now();
        Instant dur = currentInstant.plusSeconds(duration);
        while (currentInstant.isBefore(dur)) {
            ms.moveAnimals();
            try {
                Thread.sleep(DEFAULT_SPEED - speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentInstant = Instant.now();
        }
        saveCurrentStatus();
    }

    public void initLife(int height, int width) {
        ms.initMap(height, width);
        ms.fillMap();
        ms.drawMap();
        System.out.println();
    }

    private void saveCurrentStatus() {
        try (FileOutputStream fos = new FileOutputStream(new File("saved_game.txt"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ms.getMap());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot save current status!");
        }
    }

}
