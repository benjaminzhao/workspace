package bhPlayer;

import java.io.File;
import java.io.IOException;

public class Config {

	private static Config instance = null;
	private ConfigFile configfile = null;
	private static String CONFIG_FILE_NAME = "config.ini";
	
	public static String[] protocols = { "http:", "file:", "ftp:", "https:", "ftps:", "jar:" };
    public static String TAGINFO_POLICY_FILE = "file";
    public static String TAGINFO_POLICY_ALL = "all";
    public static String TAGINFO_POLICY_NONE = "none";
    // configuration keys
    private static final String LAST_URL = "last_url";
    private static final String LAST_DIR = "last_dir";
    private static final String ORIGINE_X = "origine_x";
    private static final String ORIGINE_Y = "origine_y";
    private static final String LAST_SKIN = "last_skin";
    private static final String LAST_SKIN_DIR = "last_skin_dir";
    private static final String EXTENSIONS = "allowed_extensions";
    private static final String PLAYLIST_IMPL = "playlist_impl";
    private static final String TAGINFO_MPEG_IMPL = "taginfo_mpeg_impl";
    private static final String TAGINFO_OGGVORBIS_IMPL = "taginfo_oggvorbis_impl";
    private static final String TAGINFO_APE_IMPL = "taginfo_ape_impl";
    private static final String TAGINFO_FLAC_IMPL = "taginfo_flac_impl";
    private static final String LAST_PLAYLIST = "last_playlist";
    private static final String PROXY_SERVER = "proxy_server";
    private static final String PROXY_PORT = "proxy_port";
    private static final String PROXY_LOGIN = "proxy_login";
    private static final String PROXY_PASSWORD = "proxy_password";
    private static final String PLAYLIST_ENABLED = "playlist_enabled";
    private static final String SHUFFLE_ENABLED = "shuffle_enabled";
    private static final String REPEAT_ENABLED = "repeat_enabled";
    private static final String EQUALIZER_ENABLED = "equalizer_enabled";
    private static final String EQUALIZER_ON = "equalizer_on";
    private static final String EQUALIZER_AUTO = "equalizer_auto";
    private static final String LAST_EQUALIZER = "last_equalizer";
    private static final String SCREEN_LIMIT = "screen_limit";
    private static final String TAGINFO_POLICY = "taginfo_policy";
    private static final String VOLUME_VALUE = "volume_value";
    private static final String AUDIO_DEVICE = "audio_device";
    private static final String VISUAL_MODE = "visual_mode";
   
    private String _audioDevice = "";
    private String _visualMode = "";
    private String _extensions = "m3u,pls,wsz,snd,aifc,aif,wav,au,mp1,mp2,mp3,ogg,spx,flac,ape,mac";
    private String _lastUrl = "";
    private String _lastDir = "";
    private String _lastSkinDir = "";
    private String _lastEqualizer = "";
    private String _defaultSkin = "";
    private String _playlist = "bhPlayer.BasePlaylist";
    private String _taginfoMpeg = "MpegInfo";
    private String _taginfoOggVorbis = "OggVorbisInfo";
    private String _taginfoAPE = "APEInfo";
    private String _taginfoFlac = "FlacInfo";
    private String _playlistFilename = "default.m3u";
    private int _x = 0;
    private int _y = 0;
    private String _proxyServer = "";
    private String _proxyLogin = "";
    private String _proxyPassword = "";
    private int _proxyPort = -1;
    private int _volume = -1;
    private boolean _playlistEnabled = true;
    private boolean _shuffleEnabled = false;
    private boolean _repeatEnabled = false;
    private boolean _equalizerEnabled = false;
    private boolean _equalizerOn = false;
    private boolean _equalizerAuto = false;
    private boolean _screenLimit = false;
    private String _taginfoPolicy = TAGINFO_POLICY_FILE;
	
	public Config(){	
			
	}
	public synchronized static Config getInstance(){
		if(instance == null)
			instance = new Config();
		return instance;
	}
	public void load(String configfilename){
		if(configfilename != null)
			CONFIG_FILE_NAME = configfilename;
		configfile = new ConfigFile(CONFIG_FILE_NAME);

        // Creates config entries if needed.
        if (configfile.get(AUDIO_DEVICE) == null)
        	configfile.add(AUDIO_DEVICE, _audioDevice);
        if (configfile.get(VISUAL_MODE) == null)
        	configfile.add(VISUAL_MODE, _visualMode);
        if (configfile.get(LAST_URL) == null)
        	configfile.add(LAST_URL, _lastUrl);
        if (configfile.get(LAST_EQUALIZER) == null)
        	configfile.add(LAST_EQUALIZER, _lastEqualizer);
        if (configfile.get(LAST_DIR) == null)
        	configfile.add(LAST_DIR, _lastDir);
        if (configfile.get(LAST_SKIN_DIR) == null)
        	configfile.add(LAST_SKIN_DIR, _lastSkinDir);
        if (configfile.get(TAGINFO_POLICY) == null)
        	configfile.add(TAGINFO_POLICY, _taginfoPolicy);
        if (configfile.getInt(ORIGINE_X) == -1)
        	configfile.add(ORIGINE_X, _x);
        if (configfile.getInt(ORIGINE_Y) == -1)
        	configfile.add(ORIGINE_Y, _y);
        if (configfile.get(LAST_SKIN) == null)
        	configfile.add(LAST_SKIN, _defaultSkin);
        if (configfile.get(LAST_PLAYLIST) == null)
        	configfile.add(LAST_PLAYLIST, _playlistFilename);
        if (configfile.get(PLAYLIST_IMPL) == null)
        	configfile.add(PLAYLIST_IMPL, _playlist);
        if (configfile.get(TAGINFO_MPEG_IMPL) == null)
        	configfile.add(TAGINFO_MPEG_IMPL, _taginfoMpeg);
        if (configfile.get(TAGINFO_OGGVORBIS_IMPL) == null)
        	configfile.add(TAGINFO_OGGVORBIS_IMPL, _taginfoOggVorbis);
        if (configfile.get(TAGINFO_APE_IMPL) == null)
        	configfile.add(TAGINFO_APE_IMPL, _taginfoAPE);
        if (configfile.get(TAGINFO_FLAC_IMPL) == null)
        	configfile.add(TAGINFO_FLAC_IMPL, _taginfoFlac);
        if (configfile.get(EXTENSIONS) == null)
        	configfile.add(EXTENSIONS, _extensions);
        if (configfile.get(PROXY_SERVER) == null)
        	configfile.add(PROXY_SERVER, _proxyServer);
        if (configfile.getInt(PROXY_PORT) == -1)
        	configfile.add(PROXY_PORT, _proxyPort);
        if (configfile.getInt(VOLUME_VALUE) == -1)
        	configfile.add(VOLUME_VALUE, _volume);
        if (configfile.get(PROXY_LOGIN) == null)
        	configfile.add(PROXY_LOGIN, _proxyLogin);
        if (configfile.get(PROXY_PASSWORD) == null)
        	configfile.add(PROXY_PASSWORD, _proxyPassword);
        if (!configfile.getBoolean(PLAYLIST_ENABLED))
        	configfile.add(PLAYLIST_ENABLED, _playlistEnabled);
        if (!configfile.getBoolean(SHUFFLE_ENABLED))
        	configfile.add(SHUFFLE_ENABLED, _shuffleEnabled);
        if (!configfile.getBoolean(REPEAT_ENABLED))
        	configfile.add(REPEAT_ENABLED, _repeatEnabled);
        if (!configfile.getBoolean(EQUALIZER_ENABLED))
        	configfile.add(EQUALIZER_ENABLED, _equalizerEnabled);
        if (!configfile.getBoolean(EQUALIZER_ON))
        	configfile.add(EQUALIZER_ON, _equalizerOn);
        if (!configfile.getBoolean(EQUALIZER_AUTO))
        	configfile.add(EQUALIZER_AUTO, _equalizerAuto);
        if (!configfile.getBoolean(SCREEN_LIMIT))
        	configfile.add(SCREEN_LIMIT, _screenLimit);
        // Reads config entries
        _audioDevice = configfile.get(AUDIO_DEVICE, _audioDevice);
        _visualMode = configfile.get(VISUAL_MODE, _visualMode);
        _lastUrl = configfile.get(LAST_URL, _lastUrl);
        _lastEqualizer = configfile.get(LAST_EQUALIZER, _lastEqualizer);
        _lastDir = configfile.get(LAST_DIR, _lastDir);
        _lastSkinDir = configfile.get(LAST_SKIN_DIR, _lastSkinDir);
        _x = configfile.getInt(ORIGINE_X, _x);
        _y = configfile.getInt(ORIGINE_Y, _y);
        _defaultSkin = configfile.get(LAST_SKIN, _defaultSkin);
        _playlistFilename = configfile.get(LAST_PLAYLIST, _playlistFilename);
        _taginfoPolicy = configfile.get(TAGINFO_POLICY, _taginfoPolicy);
        _extensions = configfile.get(EXTENSIONS, _extensions);
        _playlist = configfile.get(PLAYLIST_IMPL, _playlist);
        _taginfoMpeg = configfile.get(TAGINFO_MPEG_IMPL, _taginfoMpeg);
        _taginfoOggVorbis = configfile.get(TAGINFO_OGGVORBIS_IMPL, _taginfoOggVorbis);
        _taginfoAPE = configfile.get(TAGINFO_APE_IMPL, _taginfoAPE);
        _taginfoFlac = configfile.get(TAGINFO_FLAC_IMPL, _taginfoFlac);
        _proxyServer = configfile.get(PROXY_SERVER, _proxyServer);
        _proxyPort = configfile.getInt(PROXY_PORT, _proxyPort);
        _volume = configfile.getInt(VOLUME_VALUE, _volume);
        _proxyLogin = configfile.get(PROXY_LOGIN, _proxyLogin);
        _proxyPassword = configfile.get(PROXY_PASSWORD, _proxyPassword);
        _playlistEnabled = configfile.getBoolean(PLAYLIST_ENABLED, _playlistEnabled);
        _shuffleEnabled = configfile.getBoolean(SHUFFLE_ENABLED, _shuffleEnabled);
        _repeatEnabled = configfile.getBoolean(REPEAT_ENABLED, _repeatEnabled);
        _equalizerEnabled = configfile.getBoolean(EQUALIZER_ENABLED, _equalizerEnabled);
        _equalizerOn = configfile.getBoolean(EQUALIZER_ON, _equalizerOn);
        _equalizerAuto = configfile.getBoolean(EQUALIZER_AUTO, _equalizerAuto);
        _screenLimit = configfile.getBoolean(SCREEN_LIMIT, _screenLimit);
	}
	public void save(){
		if(configfile != null){
			configfile.add(ORIGINE_X, _x);
			configfile.add(ORIGINE_Y, _y);
	        if (_lastDir != null)
	        	configfile.add(LAST_DIR, _lastDir);
	        if (_lastSkinDir != null)
	        	configfile.add(LAST_SKIN_DIR, _lastSkinDir);
	        if (_audioDevice != null)
	        	configfile.add(AUDIO_DEVICE, _audioDevice);
	        if (_visualMode != null)
	        	configfile.add(VISUAL_MODE, _visualMode);
	        if (_lastUrl != null)
	        	configfile.add(LAST_URL, _lastUrl);
	        if (_lastEqualizer != null)
	        	configfile.add(LAST_EQUALIZER, _lastEqualizer);
	        if (_playlistFilename != null)
	        	configfile.add(LAST_PLAYLIST, _playlistFilename);
	        if (_playlist != null)
	        	configfile.add(PLAYLIST_IMPL, _playlist);
	        if (_defaultSkin != null)
	        	configfile.add(LAST_SKIN, _defaultSkin);
	        if (_taginfoPolicy != null)
	        	configfile.add(TAGINFO_POLICY, _taginfoPolicy);
	        if (_volume != -1)
	        	configfile.add(VOLUME_VALUE, _volume);
	        configfile.add(PLAYLIST_ENABLED, _playlistEnabled);
	        configfile.add(SHUFFLE_ENABLED, _shuffleEnabled);
	        configfile.add(REPEAT_ENABLED, _repeatEnabled);
	        configfile.add(EQUALIZER_ENABLED, _equalizerEnabled);
	        configfile.add(EQUALIZER_ON, _equalizerOn);
	        configfile.add(EQUALIZER_AUTO, _equalizerAuto);
	        configfile.add(SCREEN_LIMIT, _screenLimit);
	        configfile.saveConfig();
		}
	}

	public String getLastDir(){
		if((_lastDir!=null)&&(!_lastDir.endsWith(File.separator))){
			_lastDir += File.separator;
		}
		return _lastDir;
	}
	public void setLastDir(String dir){
		_lastDir = dir;
		if( (_lastDir!=null)&&(!_lastDir.endsWith(File.separator)) ){
			_lastDir += File.separator;
		}
	}
	public String getPlaylistFilename(){
		return _playlistFilename;
	}
	public void setPlaylistFilename(String pl){
		_playlistFilename = pl;
	}
	public boolean isPlaylistEnable(){
		return _playlistEnabled;
	}
	public void setPlaylistEnable(boolean en){
		_playlistEnabled = en;
	}
	public String getPlaylistClassName(){
		return _playlist;
	}
	public void setPlaylistClassName(String s){
		_playlist = s;
	}
	

}
