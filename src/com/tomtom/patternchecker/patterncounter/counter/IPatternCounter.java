package com.tomtom.patternchecker.patterncounter.counter;

import java.util.Map;

/**
 * Interface to be implemented for the pattern counter
 */
public interface IPatternCounter {
    /**
     * Get Distinct counts of word/number/phrase from given input string
     * @param path - file contents as string
     * @param patternType - name of the file
     * @return  Map&lt;String,Integer&gt;- The unique item as key and count as number
     */
    Map<String, ?> getCounts(String path, Integer patternType) throws Exception;
}
