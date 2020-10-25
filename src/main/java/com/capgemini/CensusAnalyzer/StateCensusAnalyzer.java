package com.capgemini.CensusAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.io.BufferedReader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	public Path csvFilePath;

	// Constructor
	public StateCensusAnalyzer(Path csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	// Read the number of records in CSV file
	public int readStateCensusCsvRecords() throws StateCensusAnalyzerException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(csvFilePath);

			int noOfRecords = 0;
			ICSVBuilder<CsvStateCensus> builder = CSVBuilderFactory.createCSVBuilder();
			Iterator<CsvStateCensus> stateCensusIterator = builder.getCSVIterator(reader, CsvStateCensus.class);
			noOfRecords = getCount(stateCensusIterator);
			return noOfRecords;
		} catch (IOException E1) {
			throw new StateCensusAnalyzerException("Invalid Path Provided",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH);
		} catch (IllegalStateException E2) {
			throw new StateCensusAnalyzerException("Invalid state found",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE);
		}

	}

	// Read the number of records in the state code file
	public int readStateCodeCsvRecords() throws StateCensusAnalyzerException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(csvFilePath);
	
			int noOfRecords = 0;
			ICSVBuilder<CsvStateCodes> builder = CSVBuilderFactory.createCSVBuilder();
			Iterator<CsvStateCodes> stateCodeIterator = builder.getCSVIterator(reader, CsvStateCodes.class);
			noOfRecords = getCount(stateCodeIterator);
			return noOfRecords;
		} catch (IOException E1) {
			throw new StateCensusAnalyzerException("Invalid Path Provided",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH);
		} catch (IllegalStateException E2) {
			throw new StateCensusAnalyzerException("Invalid state found",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE);
		}

	}

	private <E> int getCount(Iterator<E> csvIterator)
	{
		Iterable<E> csvIterable = () -> csvIterator;
		int noOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return noOfEntries;
	}

}
