package org.mcsg.double0negative.statsapi;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class StatsAPI extends JavaPlugin{
	
	private static final HashMap<Plugin, SessionsManager>managers = new  HashMap<Plugin, SessionsManager>();
	

	public void onEnable(){
		
		
	}
	
	public void onDisable(){
		for(SessionsManager m: managers.values()){
			m.shutdown();
		}
		
	}
	
	public static SessionsManager getSessionsManager(Plugin p){
		SessionsManager m = managers.get(p);
		if(m == null){
			m = new SessionsManager(p);
			managers.put(p, m);
		}
		return m;
	}
	
	
	
	
}
