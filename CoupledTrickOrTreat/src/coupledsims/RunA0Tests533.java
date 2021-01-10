package coupledsims;

import gradingTools.comp533s21.assignment0.S21Assignment0Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunA0Tests533 {

	public static void main(String[] args) {
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
//		S21Assignment0Suite.setProcessTimeOut(45);
		S21Assignment0Suite.main(args);
	}

}
