package coupledsims;

import stringProcessors.HalloweenCommandProcessor;
import main.BeauAndersonFinalProject;

public class TwoCoupledHalloweenSimulations {
	
	public static int SIMULATION_Y_OFFSET = 0;
	public static int SIMULATION_WIDTH = 400;
	public static int SIMULATION_HEIGHT = 765;
	public static void main (String[] args) {
		HalloweenCommandProcessor commandProcessor1 = BeauAndersonFinalProject.createSimulation(
				Simulation1.SIMULATION1_PREFIX, 
				Simulation1.SIMULATION1_X_OFFSET, 
				SIMULATION_Y_OFFSET, SIMULATION_WIDTH, 
				SIMULATION_HEIGHT, 
				Simulation1.SIMULATION1_X_OFFSET, 
				SIMULATION_Y_OFFSET);
		HalloweenCommandProcessor commandProcessor2 = BeauAndersonFinalProject.createSimulation(
				Simulation2.SIMULATION2_PREFIX, 
				Simulation2.SIMULATION2_X_OFFSET, 
				SIMULATION_Y_OFFSET, 
				SIMULATION_WIDTH, 
				SIMULATION_HEIGHT, 
				Simulation2.SIMULATION2_X_OFFSET, 
				SIMULATION_Y_OFFSET);
		new ASimulationCoupler(commandProcessor1, commandProcessor2);
		new ASimulationCoupler(commandProcessor2, commandProcessor1);
	}

}
