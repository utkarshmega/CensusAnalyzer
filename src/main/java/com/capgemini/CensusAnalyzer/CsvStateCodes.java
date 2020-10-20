package com.capgemini.CensusAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCodes {
	
	@CsvBindByName(column = "State Name")
	public String stateName;
	
	@CsvBindByName(column = "StateCode")
	public String stateCode;
	
	public CsvStateCodes(String stateName, String stateCode) {
		this.stateName = stateName;
		this.stateCode = stateCode;
	}
	@Override
    public String toString() {
        return "CSVStateCode{" +
                ", stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }

}
