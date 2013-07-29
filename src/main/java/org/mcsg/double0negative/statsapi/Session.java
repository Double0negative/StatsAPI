package org.mcsg.double0negative.statsapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.mcsg.double0negative.statsapi.backend.Backend;

public class Session {

	/** Datastore for this session*/
	private ArrayList<Data>data = new ArrayList<Data>();
	
	/** The database backend to use */
	private Backend database;
	
	/** Session id*/
	private int id;
	
	/** Database name */
	private String dbname;
	
	/** Is this Session sorted */
	private boolean sorted = false;
	
	/** Is this Session auto sorted */
	private boolean autosort = false;
	
	/** What are we sorting this by */
	private String sortby;
	
	
	protected Session(int id, Backend database, String bdname){
		
	}
	
	public void defineSort(String key){
		autosort = true;
		sortby = key;
	}
	
	public void add(Data d){
		sorted = false;
		if(!autosort){
			data.add(d);
		}
		else{
			data.add(d);
			sort();
		}
	}
	
	public ArrayList<Data> getSortedBy(String key){
		setSortKey(key);
		sort();
		return data;
	}
	
	public void setSortKey(String key){
		sortby  = key;
	}
	
	
	public void sort(){
		Collections.sort(data, new Comparator<Data>() {
		    public int compare(Data o1, Data o2) {
		        return (int) (o2.getDouble(sortby) - o1.getDouble(sortby));
		    }});	
		sorted = true;
	}
	
	public ArrayList<Data> search(String key, Object value){
		if(sorted){
			return binarySearch(key, value);
		}
		else{
			return sequentialSearch(key, value);
		}
	}
	
	private ArrayList<Data> sequentialSearch(String key, Object value) {
		ArrayList<Data>result = new ArrayList<Data>();
		for(Data d:data){
			if(d.get(key).equals(value)){
				result.add(d);
			}
		}
		return result;
	}

	private ArrayList<Data> binarySearch(String key, Object value){
		ArrayList<Data>result = new ArrayList<Data>();
		int start = binarySearch0(key, value);
		while(data.get(start).equals(value)){
			result.add(data.get(start));
			start++;
		}
		return result;
	}
	
	private int binarySearch0(String key, Object value){
		int min  = 0, bottom = 0;
		int max  = data.size(), top = max;
		int pos  = max / 2;

		do{
			int a = data.get(pos).compareTo(value);
			if(a < 0){
				min = a;
			}
			else if ( a > 0){
				max = a;
			}
			else{
				return getBottom(pos, value); // incase there are multiple of the same value, get the bottom value
			}
			pos = (min + max) / 2;
		}while(!data.get(pos).equals(value) && pos != top && pos != bottom);
		
		return -1;
		
	}
	
	private int getBottom(int pos, Object value){
		if(pos < 0){
			return 0;
		}else if(!data.get(pos).equals(value)){
			return pos;
		}
		else return getBottom(pos--, value);
	}
	
}
