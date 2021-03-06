package com.jerry.serverside.operations;

public class Multiply implements IOperation {
    private Double number;
    public Multiply(){
    	this.number = 0.0;
    }
    public Multiply(Double number){
    	this.number = number;
    }
    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

	public Double doCalculation(Double baseValue) {
		return baseValue * this.number;
	}
	@Override
	public String toString(){
		return String.format("%s %s", this.getPrettyPrint(),this.getNumber());
	}
	@Override
	public String getPrettyPrint() {
		return "*";
	}
	@Override
	public String getDescription() {
		return "Diese Division ist eine der vier Grundrechnungsarten derArithmetik. Sie ist die Umkehroperation der Multiplikation. ";
	}
}