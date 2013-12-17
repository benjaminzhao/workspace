package bhPlayer;

import java.io.*;
import java.util.*;
import java.util.zip.CRC32;

public class ConfigFile {

	private File config_file = null;//file name only, no path
	private Hashtable<String, String> props = new Hashtable<String, String>(64);
	
	//constructor
	public ConfigFile(String configfilename){
		config_file = new File(configfilename);
		loadConfig();
	}
	//item operation
	public String get(String name){
		return (String) props.get(name);
	}
	public String get(String name, String default_value){
		Object value = props.get(name);
		return value != null?(String)value:default_value;
	}
	
	public void add(String name, int value){
		props.put(name, Integer.toString(value));
	}
	public void add(String name, double value){
		props.put(name, Double.toString(value));
	}
	public void add(String name, String value){
		props.put(name, value);
	}
	public void add(String name, boolean value){
		props.put(name, value?"true":"false");
	}
	public void remove(String name){
		props.remove(name);
	}
	public void removeAll(){
		props.clear();
	}
	//save & load function
	public boolean loadConfig(){
		if(this.config_file == null)
			return false;
		if(!config_file.exists())
			return false;
		
		try{
			return load();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean load() throws IOException{
		Scanner s = new Scanner(config_file);
		while(s.hasNextLine()){
			String[] line = s.nextLine().split("=");
			String key = line[0];
			String value = line[1];
			this.props.put(key, value);
		}
		return true;
	}
	public boolean saveConfig(){
		if(config_file == null)
			return false;
		if(!config_file.exists())
			return false;

		try{
			return save();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean save() throws IOException{
		PrintWriter pw = new PrintWriter(config_file);
		Enumeration names = this.props.keys();
		
		while(names.hasMoreElements()){
			String name = names.nextElement().toString();
			String value = this.props.get(name);
			pw.println(name+"="+value);
		}
		pw.close();
		return true;
	}
	//crc functions
	public boolean isValidCRC(){
		String crc = generateCRC();
		String stored_crc = this.props.get("crc");
		if(stored_crc == null)
			return false;
		if(stored_crc.equals(crc))
			return true;
		else
			return false;
	}
	public String generateCRC(){
		return "CRC";
	}
	public void storeCRC(){
		add("crc", generateCRC());
	}
}
