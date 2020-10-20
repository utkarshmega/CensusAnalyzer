package com.capgemini.CensusAnalyzer;

public class StateCensusAnalyzerException extends Exception {
	
	enum ExceptionType{
		INCORRECT_PATH, INCORRECT_STATE, INCORRECT_DELIMITER, INCORRECT_CSV_HEADER;
	}
	
	ExceptionType type;
	
	public StateCensusAnalyzerException(String msg, ExceptionType type) {
		super(msg);
		this.type = type;
	}

}
