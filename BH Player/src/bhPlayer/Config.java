package bhPlayer;

import java.io.File;
import java.io.IOException;

public class Config {

	private static Config instance = null;
	private static String CONFIG_FILE_NAME = "jlgui.ini";
	private ConfigFile config = null;
	
	
	public Config(){	
			
	}
	
	public synchronized static Config getInstance(){
		if(instance == null)
			instance = new Config();
		return instance;
	}
	
	public void load(String configfile){
		if(configfile != null)
			CONFIG_FILE_NAME = configfile;
		config = new ConfigFile(CONFIG_FILE_NAME);
		if(config.)
		
		
	}
	public void save(){
		
	}
	
}
