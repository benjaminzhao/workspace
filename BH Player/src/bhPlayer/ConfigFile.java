package bhPlayer;

import java.io.*;
import java.util.Hashtable;
import java.util.zip.CRC32;

public class ConfigFile {

	private File config_file = null;
	private Hashtable<String, String> props = new Hashtable<String, String>(64);
	//constructor
	public ConfigFile(String configfilename){
		
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
			load();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean load(BufferReader buf) throws IOException{
		return true;
	}
	public boolean saveConfig(){
		return true;
	}
	public boolean save() throws IOException{
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
