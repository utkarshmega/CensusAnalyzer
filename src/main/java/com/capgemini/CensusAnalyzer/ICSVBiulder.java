package com.capgemini.CensusAnalyzer;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBiulder<E> {
	
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws StateCensusAnalyzerException;
	
	public List<E> getCSVFileList(Reader reader, Class csvClass) throws StateCensusAnalyzerException;

}
