package coupledsims;

import java.beans.PropertyChangeListener;

import assignments.util.inputParameters.AnAbstractSimulationParametersBean;
import assignments.util.mainArgs.ClientArgsProcessor;
import main.BeauAndersonFinalProject;
import stringProcessors.HalloweenCommandProcessor;
import util.interactiveMethodInvocation.SimulationParametersControllerFactory;
import util.misc.ThreadSupport;
import util.trace.Tracer;
import util.trace.bean.BeanTraceUtility;
import util.trace.factories.FactoryTraceUtility;
import util.trace.misc.ThreadDelayed;
import util.trace.port.PerformanceExperimentEnded;
import util.trace.port.PerformanceExperimentStarted;
import util.trace.port.PortTraceUtility;
import util.trace.port.consensus.ConsensusTraceUtility;
import util.trace.port.nio.NIOTraceUtility;
import util.trace.port.rpc.rmi.RMITraceUtility;

public class AStandAloneTwoCoupledHalloweenSimulations extends AnAbstractSimulationParametersBean implements StandAloneTwoCoupledHalloweenSimulations{
	HalloweenCommandProcessor commandProcessor1; 
	HalloweenCommandProcessor commandProcessor2;
	protected int NUM_EXPERIMENT_COMMANDS = 500;
	public static final String EXPERIMENT_COMMAND_1 = "move 1 -1";
	public static final String EXPERIMENT_COMMAND_2 = "undo";
	protected PropertyChangeListener simulation1Coupler, simulation2Coupler;

	
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
	 * Just printing some of the  client args needed for the RMI assignment by a client.
	 * In your client, you will need to use the printed client values in calls to
	 * the RMI API. In addition, in the server part, you will need to call
	 * ServerArgsProcessor instead to get the server args.
	 */
	void processArgs(String[] args) {	
		System.out.println("Registry host:" + ClientArgsProcessor.getRegistryHost(args));
		System.out.println("Registry port:" + ClientArgsProcessor.getRegistryPort(args));
		System.out.println("Server host:" + ClientArgsProcessor.getServerHost(args));
		System.out.println("Headless:" + ClientArgsProcessor.getHeadless(args));
		System.out.println("Client name:" + ClientArgsProcessor.getClientName(args));

		// Make sure you set this property when processing args
		System.setProperty("java.awt.headless", ClientArgsProcessor.getHeadless(args));
		
	}
	
	protected void setTracing() {
		PortTraceUtility.setTracing();
		RMITraceUtility.setTracing();
		NIOTraceUtility.setTracing();
		FactoryTraceUtility.setTracing();		
		ConsensusTraceUtility.setTracing();
		ThreadDelayed.enablePrint();
		trace(true);
	}
	
	
	protected void init (String[] args) {
		setTracing();
		processArgs(args);
		//Ideally the prefixes should be main args
		commandProcessor1 = createSimulation1(Simulation1.SIMULATION1_PREFIX);	
		commandProcessor2 = createSimulation2(Simulation2.SIMULATION2_PREFIX);
		simulation1Coupler = new ASimulationCoupler(commandProcessor1);
		simulation2Coupler = new ASimulationCoupler(commandProcessor2);
		commandProcessor1.addPropertyChangeListener(simulation2Coupler);
		commandProcessor2.addPropertyChangeListener(simulation1Coupler);
	}

	@Override
	public void  start (String[] args) {
		init(args);
		// register a callback to process actions denoted by the user commands
		SimulationParametersControllerFactory.getSingleton().addSimulationParameterListener(this);
		// use the calling back library
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
	/*
	 * You will need to delay not command input but sends(non-Javadoc)
	 */
	public void simulationCommand(String aCommand) {
		long aDelay = getDelay(); 
		if (aDelay > 0) {
			ThreadSupport.sleep(aDelay);
		}
		commandProcessor1.setInputString(aCommand); // all commands go to the first command window
	}
	@Override	
	public void trace(boolean newValue) {
		super.trace(newValue);
		Tracer.showInfo(isTrace());
	}
	@Override
	public void localProcessingOnly(boolean newValue) {
		super.localProcessingOnly(newValue);
		if (isLocalProcessingOnly()) {
			commandProcessor1.removePropertyChangeListener(simulation2Coupler);
			commandProcessor2.removePropertyChangeListener(simulation1Coupler);
		} else {
			commandProcessor1.addPropertyChangeListener(simulation2Coupler);
			commandProcessor2.addPropertyChangeListener(simulation1Coupler);
		}
	}
	@Override
	/**
	 * Relevant in consistency assignments only 
	 */
	public void atomicBroadcast(boolean newValue) {
		super.atomicBroadcast(newValue);
		commandProcessor1.setConnectedToSimulation(!isAtomicBroadcast());
		commandProcessor2.setConnectedToSimulation(!isAtomicBroadcast());
	}
	@Override
	public void experimentInput() {
		long aStartTime = System.currentTimeMillis();
		PerformanceExperimentStarted.newCase(this, aStartTime, NUM_EXPERIMENT_COMMANDS);
		boolean anOldValue = isTrace();
		this.trace(false);
		for (int i = 0; i < NUM_EXPERIMENT_COMMANDS; i++) {
			commandProcessor1.setInputString(EXPERIMENT_COMMAND_1);
			commandProcessor1.setInputString(EXPERIMENT_COMMAND_2);
		}
		trace(anOldValue);
		long anEndTime = System.currentTimeMillis();
		PerformanceExperimentEnded.newCase(this, aStartTime, anEndTime, anEndTime - aStartTime, NUM_EXPERIMENT_COMMANDS);
		
	}
	@Override
	/*
	 * This override is not really needed, provided here to show that this method
	 * exists.
	 */
	public void delaySends(int aMillisecondDelay) {
		// getDelay() can be used to determine the delay
		// in other parts of the program
		super.delaySends(aMillisecondDelay);
	}
}
