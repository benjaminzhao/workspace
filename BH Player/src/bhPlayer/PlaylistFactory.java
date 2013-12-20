package bhPlayer;

import java.lang.reflect.Constructor;

public class PlaylistFactory {

	private static PlaylistFactory _instance = null;
	private Playlist _playlistInstance = null;
	private Config _config = null;
	
	private PlaylistFactory(){
		_config = Config.getInstance();
	}
	
	public synchronized static PlaylistFactory getInstance(){
		if(_instance == null)
			_instance = new PlaylistFactory();
		
		return _instance;
	}
	
	public Playlist getPlaylist(){
		
		if(_playlistInstance == null){
			String classname = _config.getPlaylistClassName();
			boolean interfaceFound = false;
			try{
				Class a = Class.forName(classname);
				Class superclass = a;
				while(superclass != null){
					Class[] interfaces = superclass.getInterfaces();
					for(int i = 0; i<interfaces.length; i++){
						if(interfaces[i].getName().equalsIgnoreCase("playlist")){
							interfaceFound = true;
							break;
						}
					}
					if(interfaceFound == true)
						break;
					superclass = superclass.getSuperclass();
				}
				if(interfaceFound == false)
					throw new Error("Error: playlist class not found");
				else{
					Class[] argsClass = new Class[]{};
					Constructor c = a.getConstructor(argsClass);
					_playlistInstance = (Playlist)(c.newInstance(null))
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return _playlistInstance;
	}
}
