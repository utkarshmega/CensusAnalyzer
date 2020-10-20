package com.capgemini.CensusAnalyzer;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {

	private static final String INDIA_CSV_FILE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\src\\IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_TYPE = "F:\\Capgemini workspace\\CensusAnalyzer\\IndianStateCensusData.csv";
	private static final String WRONG_DELIMITER_FILE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\WrongDelimiterIndiaStateCensusData.csv";
	private static final String WRONG_HEADER_FILE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\WrongHeaderIndiaStateCensusData.csv";
	
	private static final String STATECODE_CSV_FILE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\IndiaStateCode.csv";
	private static final String WRONG_STATECODE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\src\\IndiaStateCode.csv";
	private static final String WRONG_STATECODE_TYPE = "F:\\Capgemini workspace\\CensusAnalyzer\\IndianStateCode.csv";
	private static final String WRONG_DELIMITER_STATECODE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\WrongDelimiterIndiaStateCode.csv";
	private static final String WRONG_HEADER_STATECODE_PATH = "F:\\Capgemini workspace\\CensusAnalyzer\\WrongHeaderIndiaStateCode.csv";

	// Happy test case to find the number of records
	@Test
	public void givenIndianCensusFile_FindNumberOfRecords() throws StateCensusAnalyzerException {
		Path pathname = Paths.get(INDIA_CSV_FILE_PATH);
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		assertEquals(29, noOfRecords);
	}

	// TC 1.1
	@Test
	public void givenIndianCensusFile_FindNumberOfRecords_WrongTC() throws StateCensusAnalyzerException {
		Path pathname = Paths.get(INDIA_CSV_FILE_PATH);
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		assertTrue(20 != noOfRecords);
	}

	// Sad test case tc 1.2
	@Test
	public void givenIndianCensusFile_WrongFilePath() throws StateCensusAnalyzerException {
		try {
			Path pathname = Paths.get(WRONG_CSV_FILE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}
	
	// sad test tc 1.3
	@Test
	public void givenIndianCensusFile_WrongFileType() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_CSV_FILE_TYPE);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE, e.type);
		}
	}
	
	// SAD TESTCASE TC 1.4
	@Test
	public void givenIndianCensusFile_WrongDelimiterFile() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_DELIMITER_FILE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER, e.type);
		}
	}
	
	//SAD TESTCASE TC 1.5
	@Test
	public void givenIndianCensusFile_WrongHeader() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_HEADER_FILE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_CSV_HEADER, e.type);
		}
	}
	//TC 2 happy test case
	@Test
	public void givenStateCodeFile_FindNumberOfRecords()throws StateCensusAnalyzerException {
		Path pathname = Paths.get(STATECODE_CSV_FILE_PATH);
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		assertEquals(37, noOfRecords);
	}
	
	// TC 2.1
	@Test
	public void givenStateCodeFile_FindNumberOfRecords_WrongTC() throws StateCensusAnalyzerException {
		Path pathname = Paths.get(STATECODE_CSV_FILE_PATH);
		StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
		int noOfRecords = censusAnalyzer.readStateCensusCsvRecords();
		assertTrue(20 != noOfRecords);
	}
	
	// Sad test case tc 2.2
	@Test
	public void givenStateCodeFile_WrongFilePath() throws StateCensusAnalyzerException {
		try {
			Path pathname = Paths.get(WRONG_STATECODE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}
		
	// sad test tc 2.3
	@Test
	public void givenStateCodeFile_WrongFileType() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_STATECODE_TYPE);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE, e.type);
		}
	}
	
	// SAD TESTCASE TC 2.4
	@Test
	public void givenStateCodeFile_WrongDelimiterFile() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_DELIMITER_STATECODE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER, e.type);
		}
	}
	
	//SAD TESTCASE TC 2.5
	@Test
	public void givenStateCodeFile_WrongHeader() throws StateCensusAnalyzerException{
		try {
			Path pathname = Paths.get(WRONG_HEADER_STATECODE_PATH);
			ExpectedException exceptionRule=ExpectedException.none();
	        exceptionRule.expect(StateCensusAnalyzerException.class);
			StateCensusAnalyzer censusAnalyzer = new StateCensusAnalyzer(pathname);
			censusAnalyzer.readStateCensusCsvRecords();
		}
		catch(StateCensusAnalyzerException e)
		{
			assertEquals(StateCensusAnalyzerException.ExceptionType.INCORRECT_CSV_HEADER, e.type);
		}
	}
}
