package com.capgemini.CensusAnalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
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
			CsvToBeanBuilder<CsvStateCensus> builder = new CsvToBeanBuilder<CsvStateCensus>(reader);
			builder.withType(CsvStateCensus.class);
			builder.withIgnoreLeadingWhiteSpace(true);

			CsvToBean<CsvStateCensus> csvToBean = builder.build();

			int noOfRecords = 0;
			Iterator<CsvStateCensus> stateCensusIterator = csvToBean.iterator();
			while (stateCensusIterator.hasNext()) {
				noOfRecords++;
				CsvStateCensus csvReader = stateCensusIterator.next();
				System.out.println(csvReader.toString());
			}
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
			CsvToBeanBuilder<CsvStateCodes> builder = new CsvToBeanBuilder<>(reader);
			builder.withType(CsvStateCodes.class);
			builder.withIgnoreLeadingWhiteSpace(true);

			CsvToBean<CsvStateCodes> csvStateCode = builder.build();

			int noOfRecords = 0;
			Iterator<CsvStateCodes> stateCodeIterator = csvStateCode.iterator();
			while (stateCodeIterator.hasNext()) {
				noOfRecords++;
				CsvStateCodes codeReader = stateCodeIterator.next();
				System.out.println(codeReader.toString());
			}
			return noOfRecords;
		} catch (IOException E1) {
			throw new StateCensusAnalyzerException("Invalid Path Provided",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_PATH);
		} catch (IllegalStateException E2) {
			throw new StateCensusAnalyzerException("Invalid state found",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE);
		}

	}

}
