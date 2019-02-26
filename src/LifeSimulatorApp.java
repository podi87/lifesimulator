import map.SimulatorService;

public class LifeSimulatorApp {

    public static void main(String[] args) {
        SimulatorService ss = new SimulatorService();
        ss.initLife(8,8);
        ss.simulateLife(500, 10);
    }
}
