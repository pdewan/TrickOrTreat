package coupledsims;

import main.BeauAndersonFinalProject;
import StringProcessors.HalloweenCommandProcessor;

public class TwoCoupledVetoingHalloweenSimulations {
	public static final String SIMULATION1_PREFIX = "1:";
	public static final String SIMULATION2_PREFIX = "2:";
	public static  final int COUPLED_SIMULATION_X_OFFSET = 250;
	public static int SIMULATION_COMMAND_Y_OFFSET = 0;
	public static int SIMULATION_WIDTH = 400;
	public static int SIMULATION_HEIGHT = 765;
	public static void main (String[] args) {
		HalloweenCommandProcessor commandProcessor1 = BeauAndersonFinalProject.createSimulation(
				"SIMULATION1_PREFIX", 0, SIMULATION_COMMAND_Y_OFFSET, SIMULATION_WIDTH, SIMULATION_HEIGHT, 0, 0);
		HalloweenCommandProcessor commandProcessor2 = BeauAndersonFinalProject.createSimulation(
				SIMULATION2_PREFIX, COUPLED_SIMULATION_X_OFFSET, SIMULATION_COMMAND_Y_OFFSET, SIMULATION_WIDTH, SIMULATION_HEIGHT, COUPLED_SIMULATION_X_OFFSET, 0);
		new AVetoingSimulationCoupler(commandProcessor1, commandProcessor2);
		new AVetoingSimulationCoupler(commandProcessor2, commandProcessor1);
	}

}
