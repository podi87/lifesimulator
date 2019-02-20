import simulator.SimulatorService;

public class LifeSimulatorApp {

    public static void main(String[] args) {
        SimulatorService ss = new SimulatorService();
        ss.init(8,8);
        ss.simulate();
    }
}
