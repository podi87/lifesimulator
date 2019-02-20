import map.MapService;

public class LifeSimulatorApp {

    public static void main(String[] args) {
        MapService ms = MapService.getInstance();
        ms.initMap(8,8);
        ms.fillMap();
        ms.drawMap();
    }
}
