package com.capgemini.CensusAnalyzer;

public class CSVBuilderFactory {
	
	public static ICSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder();
    }

}
