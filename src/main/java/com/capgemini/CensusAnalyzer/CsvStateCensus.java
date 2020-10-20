package com.capgemini.CensusAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensus {
	
	@CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "Population")
    public int population;

    @CsvBindByName(column = "AreaInSquareKm")
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSquareKm")
    public int densityPerSqKm;

    public CsvStateCensus() {
    }

    public CsvStateCensus(String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }
    
    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
