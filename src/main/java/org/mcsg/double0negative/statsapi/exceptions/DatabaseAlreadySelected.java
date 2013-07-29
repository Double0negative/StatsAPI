package org.mcsg.double0negative.statsapi.exceptions;

public class DatabaseAlreadySelected extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DatabaseAlreadySelected(String msg){
		super(msg);
	}
	
	public DatabaseAlreadySelected(){
		super();
	}
	

}
