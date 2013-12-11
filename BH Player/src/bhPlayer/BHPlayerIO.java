package bhPlayer;

import java.io.*;
import java.nio.file.Files;
import javax.sound.sampled.*;
import javazoom.jl.player.*;

public class BHPlayerIO {
	
	FileInputStream fis;
	BufferedInputStream stream;

	String fileName;
	private Player player;

	BHPlayerIO(String filename) throws IOException{
					
		if(isValidMusicType(filename))
		{
			fileName = filename;
//			try{
//				//playerIO.fis = new FileInputStream(new File(playfile));
//				//playerIO.stream = new BufferedInputStream(playerIO.fis);
//				//playerIO.player = new Player(playerIO.stream);
//				//play(filename);
//		    	//isStart = true;
//		    }catch(Exception e){
//		    	e.printStackTrace();
//		    }
		}
		else{
			System.out.println("file error");
			throw new IOException("file error");
		}
	}
	
	
	public boolean isValidMusicType(String filename){
		boolean valid = false;
		
		//try file exist
		File fi = new File(filename);
		if(!fi.exists()){
			//throw new Error("file not exist");
			System.out.println("file not exist");
			return valid;
		}
		
		//get music type
		String type = getAudioFileType(filename);
		if(type.equalsIgnoreCase("mp3"))
			valid = true;
		else{
			//throw new Error("unsupported format");
			System.out.println("unsupported format");
			valid = false;
		}
		return valid;
	}
	
	
	private String getAudioFileType(String filename){
		String extension = null;
		
		try{
			File fi = new File(filename);
			
			extension = filename.substring(filename.lastIndexOf('.')+1);
			
			String fi_type = Files.probeContentType(fi.toPath());
			System.out.println(fi_type);
			
			if(fi_type.equalsIgnoreCase("audio/mid"))
				extension = "midi";
			else if(fi_type.equalsIgnoreCase("audio/mpeg"))
				extension = "mp3";
			else if(fi_type.equalsIgnoreCase("audio/wav")){
				//wav/aiff/au
				AudioFileFormat filetype = AudioSystem.getAudioFileFormat(fi);
				
				AudioFileFormat.Type[] alltype = AudioSystem.getAudioFileTypes();
				for(AudioFileFormat.Type i:alltype){
					if(filetype.getType() == i){
						extension = filetype.getType().toString();
					}
					//System.out.println(i.toString());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return extension;
	}
	
	public void play(){
		try{
				File fi = new File(fileName);			
				fis = new FileInputStream(fi);
				stream = new BufferedInputStream(fis);
				player = new Player(stream);
				player.play();
				
				//System.out.println("player again");
				//stream.reset();
				//mp3Player.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(){
		player.close();
	}
	
	public void pause(){
		//player.play();
	}
	
	public int getPos(){
		int millisec = player.getPosition();
		return millisec;
	}
}
