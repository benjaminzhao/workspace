package bhPlayer;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SkinLoader {

	private Hashtable imagetable = null;
	private ZipInputStream zis = null;
	
	public SkinLoader(String filename){
		imagetable = new Hashtable();
		try{
			zis = new ZipInputStream(new FileInputStream(filename));	
		}catch(Exception e){
			//try to load default skin
			ClassLoader cl = this.getClass().getClassLoader();
			InputStream is = cl.getResourceAsStream("metrix.wsz");
			if(is != null)
				zis = new ZipInputStream(is);
		}
	}
	public SkinLoader(InputStream inputstream){
		imagetable = new Hashtable();
		zis = new ZipInputStream(inputstream);
	}
	
	public void loadImage() throws Exception {
		
		int pos;
		String name;
		BMPLoader bmp = new BMPLoader();
		ZipEntry entry = zis.getNextEntry();
		
		while(entry != null){
			name = entry.getName().toLowerCase();
			pos = name.lastIndexOf("/");
			if(pos != -1)
				name = name.substring(pos+1);
			if(name.endsWith("bmp")){
				imagetable.put(name, bmp.getBMPImage(zis));
			}
			else if(name.endsWith("txt")){
				InputStreamReader reader = new InputStreamReader(zis);
				StringWriter writer = new StringWriter();
				char buf[] = new char[256];
				int charread;
				while( (charread = reader.read(buf)) != -1){
					writer.write(buf, 0, charread);
				}
				imagetable.put(name, writer.toString());
			}
			entry = zis.getNextEntry();
		}
		zis.close();
	}
	public Image getImage(String name){
		return (Image) imagetable.get(name);
	}
	public Object getContent(String name){
		return imagetable.get(name);
	}
}
