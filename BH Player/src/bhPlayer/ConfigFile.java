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
	public int getInt(String name){
		try{
			return Integer.parseInt((String)props.get(name));
		}catch(Exception e){
			//e.printStackTrace();
		}
		return -1;
	}
	public int getInt(String name, int default_value){
		try{
			return Integer.parseInt((String)props.get(name));
		}catch(Exception e){
			//e.printStackTrace();
		}
		return default_value;
	}
	public boolean getBoolean(String name){
		Object value = props.get(name);
		return value != null?value.equals("true"):false;
	}
	public boolean getBoolean(String name, boolean default_value){
		Object value = props.get(name);
		return value != null?value.equals("true"):default_value;
	}
	public double getDouble(String name){
		try{
			return new Double((String)props.get(name)).doubleValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1d;
	}
	public double getDouble(String name, double default_value){
		try{
			return new Double((String)props.get(name)).doubleValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return default_value;
	}
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
			String value = (line.length>1) ? line[1] : "";
			//String line = s.nextLine();
			//int id = line.indexOf("=");
			//String key = line.substring(0, id).trim();
			//String value = line.substring(id+1).trim();
			this.props.put(key, value);
		}
		s.close();
		return true;
	}
	public boolean saveConfig(){
		if(config_file == null)
			return false;
		try{
			return save();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean save() throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(config_file));
		Enumeration <String> names = this.props.keys();
		
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
