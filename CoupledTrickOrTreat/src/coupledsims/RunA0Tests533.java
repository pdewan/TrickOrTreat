package coupledsims;

import gradingTools.comp533s22.assignment0.S22Assignment0Suite;
import gradingTools.comp533s22.assignment2.S22Assignment2Suite;
import gradingTools.comp533s22.assignment3.S22Assignment3Suite;
import gradingTools.comp533s22.assignment4.S22Assignment4Suite;
import gradingTools.comp533s22.assignment5.S22Assignment5Suite;
import gradingTools.comp533s22.assignment6.S22Assignment6Suite;
import gradingTools.comp533s22.assignment7.S22Assignment7Suite;
import gradingTools.comp533s24.assignment0.S24Assignment0Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunA0Tests533 {

	public static void main(String[] args) {
//		System.out.println("printing console output");
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
//		S21Assignment0Suite.setProcessTimeOut(45);
//		S24Assignment7Suite.main(args);
		S24Assignment0Suite.main(args);

	}

}
