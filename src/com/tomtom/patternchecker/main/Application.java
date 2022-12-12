package com.tomtom.patternchecker.main;

import com.tomtom.patternchecker.patterncounter.counter.impl.PatternCounterImpl;

public class Application {
	private static final PatternCounterImpl counter = new PatternCounterImpl();

	public static void main(String[] args) {
		counter.run();
}
}
