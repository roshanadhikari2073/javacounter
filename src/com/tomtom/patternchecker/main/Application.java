package com.tomtom.patternchecker.main;

import com.tomtom.patternchecker.IOConsoleStream.Console.ConsoleOutput;
import com.tomtom.patternchecker.IOConsoleStream.Console.ConsolePrompt;
import com.tomtom.patternchecker.IOConsoleStream.IOStream.IOStream;
import com.tomtom.patternchecker.patterncounter.counter.IPatternCounter;
import com.tomtom.patternchecker.patterncounter.counter.impl.PatternCounterImpl;
import com.tomtom.patternchecker.utils.PatternCounterUtils;

import java.util.ArrayList;
import java.util.Map;

import static com.tomtom.patternchecker.patterncounter.PatternCounterConstants.IS_EMPTY;

public class Application {
// ---  /Users/roshanadhikari/Desktop/test.txt
	public static void main(String[] args) throws Exception {
	IPatternCounter patternCounterService = new PatternCounterImpl();
	IOStream ioStream = new IOStream(new ConsolePrompt(), new ConsoleOutput());
	ArrayList<String> userInput = ioStream.promptForInput();
	String pathName = userInput.get(0);
	Integer patternType = Integer.parseInt(userInput.get(1)) ;
	Boolean runTheProgram = true;
	if(	pathName.isEmpty() || pathName == null){
		System.out.println(IS_EMPTY+"Please provide the pathname correctly");
		runTheProgram = false;
	}
	if(patternType == null){
		System.out.println(IS_EMPTY+"Please provide the pattern number correctly");
		runTheProgram = false;
	}
	if(runTheProgram){
		try{
			Map<String, ?> results = patternCounterService.getCounts(pathName, patternType);
			PatternCounterUtils.consolePrintMap(results);
		} catch (Exception e){
			System.out.println("Some error occured while taking user inputs, please provide the information correctly");
		}

	}
}
}
