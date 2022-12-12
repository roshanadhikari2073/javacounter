package com.tomtom.patternchecker.patterncounter.counter.impl;

import com.tomtom.patternchecker.patterncounter.PatternCounterConstants;
import com.tomtom.patternchecker.patterncounter.counter.IPatternCounter;
import com.tomtom.patternchecker.utils.PatternCounterUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PatternCounterImpl implements IPatternCounter {
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
