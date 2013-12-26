package bhPlayer;

import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;


public class PlayerUI extends JPanel implements ActionListener,ChangeListener{

	private Config config;
	private Skin skin;
	private Loader loader;
	private PlaylistUI playlistUI;
	private Playlist playlist;
	
	public PlayerUI(){
		super();
		setDoubleBuffered(true);
		skin = new Skin();
	}
	public Config getConfig(){
		return config;
	}
	public Skin getSkin(){
		return skin;
	}
	public Loader getLoader(){
		return loader;
	}
	
	public Playlist getPlaylist(){
		return playlist;
	}
	public void setPlaylistUI(PlaylistUI ui){
		this.playlistUI = ui;
	}
	
	public void loadUI(Loader l){
		this.loader = l;
		
		setLayout(new AbsoluteLayout());
		
		config = Config.getInstance();
		skin.setConfig(config);
		
		//playlistUI = new PlaylistUI();
		//playlistUI.setSkin(skin);
		//playlistUI.setPlayer(this);
		
		loadSkin();
		
	}
	
	public void loadSkin(){
		
		if(skin.getPath() != null){
			skin.loadSkin(skin.getPath());
			config.setDefaultSkin(skin.getPath());
		}
		else if(config.getDefaultSkin()!=null && !config. getDefaultSkin().trim().equals("")){
			skin.loadSkin(config.getDefaultSkin());
		}
		else{
			ClassLoader cl = getClass().getClassLoader();
			InputStream is = cl.getResourceAsStream("metrix.wsz");
			skin.loadSkin(is);
		}
		//ImageBorder border = new ImageBorder();
		//border.setImage(skin.getMainImage());
		//setBorder(border);
		
		//add(skin.getAcPrevius(), skin.getAcPrevius().getConstraints());
		//skin.getAcPrevius().removeActionListener(this);
		//skin.getAcPrevius().addActionListener(this);
		
	}
	
}
