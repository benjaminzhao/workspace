package bhPlayer;

import java.awt.Point;

public interface Loader {

	public void loaded();
	public void close();
	public void minimize();
	public void togglePlaylist(boolean en);
	public void toggleEqualizer(boolean en);
	public Point getLocation(); 
}
