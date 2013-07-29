package org.mcsg.double0negative.statsapi;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;
import org.mcsg.double0negative.statsapi.backend.Backend;

public class SessionsManager {

	private HashMap<Integer, Session>sessions = new HashMap<Integer, Session>();
	private Backend database;
	
	
	protected SessionsManager(Plugin p){
		
	}
	
	public Session getSession(int id){
		return sessions.get(id);
	}
	
	public void shutdown(){
		
	}
	
	
	
	
}
