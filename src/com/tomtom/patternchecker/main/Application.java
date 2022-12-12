package com.tomtom.patternchecker.main;

import com.tomtom.patternchecker.patterncounter.counter.impl.PatternCounterImpl;

public class Application {
	private static PatternCounterImpl counter = new PatternCounterImpl();

	// ---  /Users/roshanadhikari/Desktop/test.txt
	public static void main(String[] args) {
		counter.run();
}
}
