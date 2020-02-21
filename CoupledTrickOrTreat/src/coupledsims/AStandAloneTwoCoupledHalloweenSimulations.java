package coupledsims;

import assignments.util.inputParameters.AnAbstractSimulationParametersBean;
import assignments.util.mainArgs.ClientArgsProcessor;
import main.BeauAndersonFinalProject;
import stringProcessors.HalloweenCommandProcessor;
import util.interactiveMethodInvocation.SimulationParametersControllerFactory;
import util.trace.Tracer;
import util.trace.bean.BeanTraceUtility;
import util.trace.factories.FactoryTraceUtility;
import util.trace.port.nio.NIOTraceUtility;

public class AStandAloneTwoCoupledHalloweenSimulations extends AnAbstractSimulationParametersBean implements StandAloneTwoCoupledHalloweenSimulations{
	HalloweenCommandProcessor commandProcessor1; 
	HalloweenCommandProcessor commandProcessor2;
	
	protected HalloweenCommandProcessor createSimulation1(String aPrefix) {
		return 	BeauAndersonFinalProject.createSimulation(
					aPrefix,
					Simulation1.SIMULATION1_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET, 
					Simulation.SIMULATION_WIDTH, 
					Simulation.SIMULATION_HEIGHT, 
					Simulation1.SIMULATION1_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET);
	}
	
	protected  HalloweenCommandProcessor createSimulation2(String aPrefix) {
		return 	BeauAndersonFinalProject.createSimulation(
					aPrefix, 
					Simulation2.SIMULATION2_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET, 
					Simulation.SIMULATION_WIDTH, 
					Simulation.SIMULATION_HEIGHT, 
					Simulation2.SIMULATION2_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET);
	}
	/**
	 * Just printing some of the  args needed for the RMI assignment by a client.
	 * In your assignment, you will need to use the printed values in calls to
	 * the RMI API.
	 */
	void printArgs(String[] args) {
		System.out.println("Registry host:" + ClientArgsProcessor.getRegistryHost(args));
		System.out.println("Registry port:" + ClientArgsProcessor.getRegistryPort(args));
		System.out.println("Server host:" + ClientArgsProcessor.getServerHost(args));
	}
	
	protected void setTracing() {
		NIOTraceUtility.setTracing();
		FactoryTraceUtility.setTracing();
		BeanTraceUtility.setTracing();
		NIOTraceUtility.setTracing();
	}
	
	protected void init (String[] args) {
		printArgs(args);
		//Ideally the prefixes should be main args
		commandProcessor1 = createSimulation1(Simulation1.SIMULATION1_PREFIX);	
		commandProcessor2 = createSimulation2(Simulation2.SIMULATION2_PREFIX);
		new ASimulationCoupler(commandProcessor1, commandProcessor2);
		new ASimulationCoupler(commandProcessor2, commandProcessor1);
	}

	@Override
	public void  start (String[] args) {
		init(args);
		// register a callback to process actions denoted by the user commands
		SimulationParametersControllerFactory.getSingleton().addSimulationParameterListener(this);
		// use a library to interact with the user.
		SimulationParametersControllerFactory.getSingleton().processCommands();		

	}
	/**
	 * Below are some of the methods called by processCommands that are overridden here. The 
	 * The entire list of methods is in assignments.util.inputParameters.SimulationParametersListener
	 */
	@Override	
	public void quit(int aCode) {
		System.exit(aCode);
	}	
	@Override
	public void simulationCommand(String aCommand) {
		commandProcessor1.setInputString(aCommand); // all commands go to the first one
	}
	@Override
	
	public void trace(boolean newValue) {
		Tracer.showInfo(newValue);
	}
}
