package org.mcsg.double0negative.statsapi.backend;

import org.mcsg.double0negative.statsapi.Data;

public abstract class Backend {

	

	private String dbname;
	
	
	
	public Backend(String dbname) {
		this.dbname = dbname;
		
		
	}
	
	
	
	public abstract boolean add(Data d);
	
	//public abstract 
	
	/**
	 * Select the database to be used
	 * @param name
	 * @return
	 */
	public abstract boolean selectdb(String name);
	
	
	
	
	
	
}
