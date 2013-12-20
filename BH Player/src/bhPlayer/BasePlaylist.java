package bhPlayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class BasePlaylist implements Playlist{
	
	private Vector _playlist = null;
	private int _cursorPos = -1;
	private boolean isModified = false;
	private String M3Uhome = null;
	private String PLShome = null;
	
	//constructor
	public BasePlaylist(){
		// use a vector for playlist
		_playlist = new Vector();
	}
	//
	public void setM3Uhome(String s){
		M3Uhome = s;
	}
	public String getM3Uhome(){
		return M3Uhome;
	}
	public void setPLShome(String s){
		PLShome = s;
	}
	public String getPLShome(){
		return PLShome;
	}
	private boolean loadM3U(String filename){
		Config config = Config.getInstance();
		if(_playlist == null)
			_playlist = new Vector();
		boolean loaded = false;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			String songName = null;
			String songFile = null;
			String songLength = null;
			while( (line = br.readLine()) != null){
				if(line.trim().length() == 0)
					continue;
				if(line.startsWith("#")){
					if(line.toUpperCase().startsWith("#EXTM3U")){
						//file header: #EXTM3U
						continue;
					}
					else if(line.toUpperCase().startsWith("#EXTINF")){
						//line header: #EXTINF
						int indA = line.indexOf(",", 0);
						if(indA != -1){
							songName = line.substring(indA+1,line.length());
						}
						int indB = line.indexOf(":", 0);
						if(indB != -1){
							if(indA > indB)
								songLength = line.substring(indB+1, indA).trim();
						}
					}
				}
				else{
					songFile = line;//file full dir+filename
					if(songName == null)
						songName = songFile;
					if(songLength == null)
						songLength = "-1";
					PlaylistItem pli = null;
					File f = new File(songFile);
					if(f.exists()){
						pli = new PlaylistItem(songName, songFile, Long.parseLong(songLength), true);
					}
					else{//file is not exist
						f = new File(config.getLastDir()+songFile);
						if(f.exists()){
							pli = new PlaylistItem(songName, config.getLastDir()+songFile, Long.parseLong(songLength), true);
						}
						else{
							if(M3Uhome != null)
								pli = new PlaylistItem(songName, M3Uhome+songFile, Long.parseLong(songLength), true);	
						}
					}
					if(pli != null)
						appendItem(pli);
					songName = null;
					songFile = null;
					songLength = null;
				}
			}
			loaded = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br != null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return loaded;
	}
	private boolean loadPLS(String filename){
		Config config = Config.getInstance();
		if(_playlist == null)
			_playlist = new Vector();
		boolean loaded = false;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			String songName = null;
			String songFile = null;
			String songLength = null;
			while( (line = br.readLine()) != null){
				if(line.trim().length() != 0)
					continue;
				if( line.toLowerCase().startsWith("file") ){
					//line header: file
					StringTokenizer st = new StringTokenizer(line, "=");
					st.nextToken();
					songFile = st.nextToken().trim();
				}
				else if( line.toLowerCase().startsWith("title") ){
					StringTokenizer st = new StringTokenizer(line, "=");
					st.nextToken();
					songName = st.nextToken().trim();
				}
				else if( line.toLowerCase().startsWith("length") ){
					StringTokenizer st = new StringTokenizer(line, "=");
					st.nextToken();
					songLength = st.nextToken().trim();
				}
				if(songFile != null){
					PlaylistItem pli = null;
					if(songName == null)
						songName = songFile;
					if(songLength == null)
						songLength = "-1";
					File f = new File(songFile);
					if(f.exists())
						pli = new PlaylistItem(songName, songFile, Long.parseLong(songLength), true);
					else{
						f = new File(config.getLastDir()+songName);
						if(f.exists())
							pli = new PlaylistItem(songName, config.getLastDir()+songFile, Long.parseLong(songLength), true);
						else{
							if(PLShome != null)
								pli = new PlaylistItem(songName,PLShome+songFile,Long.parseLong(songLength), true);
						}
					}
					if(pli != null)
						appendItem(pli);
					songName = null;
					songFile = null;
					songLength = null;
				}
			}
			loaded = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return loaded;
	}	
	//override func
	public boolean load(String filename){
		setModified(true);
		boolean loaded = false;
		if( (filename!=null) && (filename.toLowerCase().endsWith(".m3u")) ){
			loaded = loadM3U(filename);
		}
		else if( (filename!=null) && (filename.toLowerCase().endsWith(".pls")) ){
			loaded = loadPLS(filename);
		}
		return loaded;
	}
	public boolean save(String filename){
		//save as .M3U
		if(_playlist != null){
			BufferedWriter bw = null;
			try{
				bw = new BufferedWriter(new FileWriter(filename));
				bw.write("#EXTM3U");
				bw.newLine();
				Iterator it = _playlist.iterator();
				while(it.hasNext()){
					PlaylistItem pli = (PlaylistItem)it.next();
					bw.write("#EXTINF:"+pli.getM3UExtInf());
					bw.newLine();
					bw.write(pli.getLocation());
					bw.newLine();
				}
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(bw != null)
						bw.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		return false;
	}
	
	public void addItemAt(PlaylistItem pli, int pos){
		_playlist.insertElementAt(pli, pos);
		setModified(true);
	}
	
	public void removeItem(PlaylistItem pli){
		_playlist.remove(pli);
		setModified(true);
	}
	
	public void removeItemAt(int pos){
		_playlist.remove(pos);
	}
	
	public void removeAll(){
		_playlist.removeAllElements();
		_cursorPos = -1;
		setModified(true);
	}
	
	public PlaylistItem getItemAt(int pos){
		PlaylistItem pli = (PlaylistItem) _playlist.elementAt(pos);
		return pli;
	}
	
	public void appendItem(PlaylistItem pli){
		_playlist.addElement(pli);
		setModified(true);
	}
	
	public int getPlaylistSize(){
		return _playlist.size();
	}
	
	public boolean isModified(){
		return isModified;
	}
	
	public boolean setModified(boolean set){
		isModified = set;
		return isModified;
	}
	
	public void begin(){
		_cursorPos = -1;
		if(getPlaylistSize() > 0)
			_cursorPos = 0;
		setModified(true);
	}
	
	public void shuffle(){
		int size = _playlist.size();
		if(size < 2)
			return;
		Vector v = _playlist;
		_playlist = new Vector();
		while( (size = v.size())>0 ){
			int i = (int) (Math.random()*size );
			_playlist.addElement(v.remove(i));
		}
		begin();
	}
	
	public int getSelectedIndex(){
		return _cursorPos;
	}
	
	public int getIndex(PlaylistItem pli){
		int pos = -1;
		for(int i=0; i<_playlist.size(); i++){
			pos = i;
			PlaylistItem p = (PlaylistItem)(_playlist.elementAt(i));
			if(p.equals(pli))
				break;
		}
		return pos;
	}
	
	public PlaylistItem getCursor(){
		if(_cursorPos<0||_cursorPos>=_playlist.size()){
			return null;
		}
		return getItemAt(_cursorPos);
	}
	
	public void setCursor(int index){
		_cursorPos = index;
	}
	
	public void nextCursor(){
		_cursorPos++;
		if(_cursorPos>_playlist.size())
			_cursorPos = _playlist.size();
	}
	
	public void previousCursor(){
		_cursorPos--;
		if(_cursorPos<0)
			_cursorPos = 0;
	}
}
