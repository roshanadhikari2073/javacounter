package com.tomtom.patternchecker.patterncounter.counter.impl;

import com.tomtom.patternchecker.IOConsoleStream.Console.ConsoleOutput;
import com.tomtom.patternchecker.IOConsoleStream.Console.ConsolePrompt;
import com.tomtom.patternchecker.IOConsoleStream.IOStream.IOStream;
import com.tomtom.patternchecker.patterncounter.PatternCounterConstants;
import com.tomtom.patternchecker.patterncounter.counter.IPatternCounter;
import com.tomtom.patternchecker.utils.PatternCounterUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tomtom.patternchecker.patterncounter.PatternCounterConstants.IS_EMPTY;

public class PatternCounterImpl implements IPatternCounter {

    public void run() {
        try {
            IOStream ioStream = new IOStream(new ConsolePrompt(), new ConsoleOutput());
            ArrayList<String> userInput = ioStream.promptForInput();
            String pathName = userInput.get(0);
            Integer patternType = Integer.parseInt(userInput.get(1).trim()) ;
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
                    Map<String, ?> results = getCounts(pathName, patternType);
                    ioStream.computeOutput(results);
                } catch (Exception e){
                    System.out.println("Some error occured while taking user inputs, please provide the information correctly" + e);
                }

            }
        }catch (Exception e){
            System.out.println("Some error occured while processing the given input, please retry");
        }
    }
    @Override
    public Map<String, ?> getCounts(String path, Integer patternType) throws Exception {
        ArrayList<String> content = PatternCounterUtils.stringToArrayList(path);
        Map<String, ?> counts = new HashMap<>();
        switch (patternType){
            case PatternCounterConstants.WORD_COUNTER:
                counts = PatternCounterUtils.getWordCounts(content);
                break;
            case PatternCounterConstants.INT_COUNTER:
                counts = PatternCounterUtils.getNumberCounts(content);
                break;
            case PatternCounterConstants.PHRASE_COUNTER:
                counts = PatternCounterUtils.getPhraseCounts(content);
                break;
            case PatternCounterConstants.ALL_PATTERNS_COUNTER:
                counts = PatternCounterUtils.getAllPattern(content);
                break;
        }
        return counts;
    }
}
