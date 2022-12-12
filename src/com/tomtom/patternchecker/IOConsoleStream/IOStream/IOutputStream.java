package com.tomtom.patternchecker.IOConsoleStream.IOStream;

import java.util.Map;

/**
 * Output Interface
 */
public interface IOutputStream {
	/**
	 * @params takes the array result and prints it
	 */
	void computeOutput(Map<String, ?> result);
}
