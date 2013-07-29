package org.mcsg.double0negative.statsapi;

import java.util.HashMap;

public class Data implements Comparable{


	HashMap<String, Object>data = new HashMap<String, Object>();
	

	public void setSchema(String schema){
		String[] s = schema.split(",");
		for(String str:s){
			data.put(str, null);
		}
	}

	public void set(String schema, Object... data){
		String[]keys = schema.split(",");
		int a = 0;
		for(String key:keys){
			try{
				this.data.put(key, data[a]);
			}catch(Exception e){}
		}
	}
	
	public Object get(String key){
		return data.get(key);
	}
	
	public String getString(String key){
		return data.get(key).toString();
	}
	
	
	public int getInt(String key){
		return Integer.valueOf(getString(key));
	}
	
	public long getLong(String key){
		return Long.valueOf(getString(key));
	}
	
	public short getShort(String key){
		return  Short.valueOf(getString(key));
	}
	
	public byte getByte(String key){
		return Byte.valueOf(getString(key));
	}

	
	public char getChar(String key){
		return getString(key).toCharArray()[0];
	}
	
	public boolean getBoolean(String key){
		return Boolean.valueOf((String) data.get(key));
	}
	
	public double getDouble(String key){
		return Double.valueOf(getString(key));
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
