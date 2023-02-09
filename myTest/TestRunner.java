package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(EntrySetTest.class, MapAdapterTest.class);
		//Here it is getting the run count from the result object
		System.out.println("Total number of tests " + result.getRunCount());
		//This is to get the failure count from the result object
		System.out.println("Total number of tests failed " + result.getFailureCount());

	}

}
