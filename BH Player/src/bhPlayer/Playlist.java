package bhPlayer;

import java.util.Collection;

public interface Playlist {

	public boolean load(String filename);
	
	public boolean save(String filename);
	
	public void addItemAt(PlaylistItem pli, int pos);
	
	public void removeItem(PlaylistItem pli);
	
	public void removeItemAt(int pos);
	
	public void removeAll();
	
	public PlaylistItem getItemAt(int pos);
	
	public void appendItem(PlaylistItem pli);
	
	public int getPlaylistSize();
	
	public boolean isModified();
	
	public boolean setModified(boolean set);
	
	public void begin();
	
	public void shuffle();
	
	public int getSelectedIndex();
	
	public int getIndex(PlaylistItem pli);
	
	public PlaylistItem getCursor();
	
	public void setCursor(int index);
	
	public void nextCursor();
	
	public void previousCursor();
}
