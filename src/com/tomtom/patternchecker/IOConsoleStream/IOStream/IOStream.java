package com.tomtom.patternchecker.IOConsoleStream.IOStream;


import java.util.ArrayList;
import java.util.Map;

public class IOStream {

	IInputStream inputStream;
	IOutputStream outputStream;
	
	public IOStream(IInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public IOStream(IOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public IOStream(IInputStream inputStream, IOutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	/**
	 * function to get the user inputs with given standard input specified
	 * @return ArrayList user inputs
	 */
	public ArrayList<String> promptForInput() {
		if (this.inputStream != null) {
			return this.inputStream.promptForInput();
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * function to print the output 
	 * @param result
	 */
	public void computeOutput(Map<String, ?> result) {
		if (this.outputStream != null) {
			this.outputStream.computeOutput(result);
		}

	}
}
