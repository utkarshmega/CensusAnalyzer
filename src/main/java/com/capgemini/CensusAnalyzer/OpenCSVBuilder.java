package com.capgemini.CensusAnalyzer;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implemets ICSVBuilder {
	
	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws StateCensusAnalyzerException {
        return this.getCSVBean(reader, csvClass).iterator();
    }
	
	@Override
    public List getCSVFileList(Reader reader, Class csvClass) throws StateCensusAnalyzerException {
        return this.getCSVBean(reader, csvClass).parse();
    }
	
	private CsvToBean<E> getCSVBean(Reader reader, Class<E> csvClass) throws StateCensusAnalyzerException {
		try {
			CsvToBeanBuilder<E> builder = new CsvToBeanBuilder<E>(reader);
			CsvToBean<E> csvToBean = builder.withType(csvClass).withIgnoreLeadingWhiteSpace(true).withSeparator(',').build();
			return csvToBean;
		} catch (IllegalStateException e) {
			throw new StateCensusAnalyzerException("Invalid state present",
					StateCensusAnalyzerException.ExceptionType.INCORRECT_STATE);
		}

	}
	


}
