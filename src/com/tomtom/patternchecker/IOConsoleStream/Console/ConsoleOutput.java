package com.tomtom.patternchecker.IOConsoleStream.Console;

import com.tomtom.patternchecker.IOConsoleStream.IOStream.IOutputStream;

import java.util.Map;

public class ConsoleOutput implements IOutputStream {

	@Override
	public void computeOutput(Map<String, ?> value) {
		if (!value.isEmpty()) {
			processResults(value);
		}
	}

	/**
	 * @param value
	 * Iterate and print the values to the console
	 */
	private void processResults(Map<String, ?> value) {
		try {
			for (Map.Entry<String, ?> entry : value.entrySet()) {
				if ((entry.getKey() != null) && (value == null)) {
					System.out.println(entry.getKey() + "\n");
				} else {
					System.out.println(entry.getKey() + ", " + entry.getValue() + "\n");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
