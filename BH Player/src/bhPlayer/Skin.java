package bhPlayer;

import java.awt.Color;
import java.awt.Image;
import java.util.ResourceBundle;

import javax.annotation.Resource;

public class Skin {
	
	private Config config;
	
	public static final String TITLETEXT = "BHPlayer";
	private String skinVersion = "1";
	private boolean dspEnabled = true;
	private String path = "";
	
	private String theMain = "main.bmp";
	private String theText = "text.bmp";
	private String theNumbers = "numbers.bmp";
	private String theNumEx = "nums_ex.bmp";
	private String theButtons = "cbuttons.bmp";
	private String theEPSRButtons = "shufrep.bmp";
	private String theVolume = "volume.bmp";
	private String theBalance = "balance.bmp";
	private String theTitleBar = "titlebar.bmp";
	private String theMode = "monoster.bmp";
	private String thePosBar = "posbar.bmp";
	private String theIcon = "playpaus.bmp";
	private String theViscolor = "viscolor.bmp";
	private String viscolor = "";
	
	private int fontWidth = 5;
	private int fontHeoght = 6;
	private String fontIndex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\"@a  " + "0123456789  :()-'!_+ /[]^&%.=$#" + "  ?*";
	private String fakeIndex = "abcdefghijklmnopqrstuvwxyz01";
	private String numberIndex = "0123456789 ";
	
	private ResourceBundle bundle = null;
	private int WinHeight;
	private int WinWidth;
	
	
	private ActiveJButton acPrevious;
	private ActiveJButton acNext;
	private ActiveJButton acEject;
	private ActiveJButton acPlay;
	private ActiveJButton acPause;
	private ActiveJButton acStop;
	private ActiveJButton acExit;
	private ActiveJButton acMinimize;
	private ActiveJButton acPresents;
	private ActiveJButton acPLUp;
	private ActiveJButton acPLDown;
	private ActiveJButton acPLAdd;
	private ActiveJButton acPLRemove;
	private ActiveJButton acPLSelect;
	private ActiveJButton acPLMisc;
	private ActiveJButton acPLList;
	
	private ActiveJToggleButton acEqualizer;
	private ActiveJToggleButton acPlaylist;
	private ActiveJToggleButton acRepeat;
	private ActiveJToggleButton acShuffle;
	private ActiveJToggleButton acOnOff;
	private ActiveJToggleButton acAuto;
	
	private ActiveJBar acTitleBar;
	
	private ActiveJSlider acVolume;
	private ActiveJSlider acBalance;
	private ActiveJSlider acPosBar;
	private ActiveJSlider acSlider;
	private ActiveJSlider acPLSlider;
	
	private ActiveJLabel acTitleLabel;
	private ActiveJLabel acSampleRateLabel;
	private ActiveJLabel acBitRateLabel;
	
	private ActiveJNumberLabel acMinuteH;
	private ActiveJNumberLabel acMinuteL;
	private ActiveJNumberLabel acSecondH;
	private ActiveJNumberLabel acSecondL;
	
	private ActiveJPopup acPLAddPopup;
	private ActiveJPopup acPLRemovePopup;
	private ActiveJPopup acPLSelectPopup;
	private ActiveJPopup acPLMiscPopup;
	private ActiveJPopup acPLListPopup;
	
	private ActiveJIcon acMonoIcon;
	private ActiveJIcon acStereoIcon;
	private ActiveJIcon acPlayIcon;
	private ActiveJIcon acTimeIcon;
	
	private SpectrumTimeAnalyzer analyzer;
	
	private SplinePanel spline;
	
	private PlaylistUIDelegate playlist;
	
	private Image imFullEqualizer = null;
	private Image imEqualizer = null;
	private Image imSlider = null;
	private Image imPlaylist = null;
	private Image imIcon = null;
	private Image imPosBar = null;
	private Image imMode = null;
	private Image imTitleBar = null;
	private Image imBalance = null;
	private Image imVolume = null;
	private Image imEPSRButton = null;
	private Image imButton = null;
	private Image imNumber = null;
	private Image imText = null;
	private Image imMain = null;
	//constructor
	public Skin(){
		super();
		String i18n = "bhPlayer/skin";//internationalization
		bundle = ResourceBundle.getBundle(i18n);
	}
	
	public String getResource(String key){
		String value = null;
		try{
			value = bundle.getString(key);
		}catch(Exception e){
			//e.printStackTrace();
		}
		return value;
	}


	public String getPath(){
		return this.path;
	}
	public void setPath(String p){
		this.path = p;
	}

	public boolean isDspEnabled(){
		return this.dspEnabled;
	}
	public void setDSPEnabled(boolean en){
		this.dspEnabled = en;
	}
	
	public void loadSkin(String skinname){
		try{
			SkinLoader skl = new SkinLoader(skinname);
			loadSkin(skl);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void loadSkin(InputStream skinstream){
		
	}
	public void loadSkin(SkinLoader skinloader) throws Exception{
		
	}
	
	public void setOnOffAutoPanel(){
		
	}
	public void setPresentsPanel(){
		
	}
	public void setSplinePanel(){
		
	}
	public void setPlaylistPanel(){
		
	}
	
	private void setTitleBarPanel(){
		
	}
	private void setExitPanel(){
		
	}
	private void setMinimizePanel(){
		
	}
	private void setMonoStereoPanel(){
		
	}
	private void setPosBarPanel(){
		
	}
	private void setButtonPanel(){
		
	}
	private void setEPSRButtonPanel(){
		
	}
	private void setVolumeBalancePanel(){
		
	}
	private void setAnalyzerPanel(){
		
	}
	private void setSliderPanel(){
		
	}

	private ActiveJButton createPLButton(int x, int y){
		
	}
	private Color parsePLEditColor(String line) throws Exception{
		
	}
	
	public void readPanel(Image[] releasedImage, int[] releasedPanel, Image[] pressedImage, int[] pressedPanel, Image imPanel){
		
	}
	
	public ActiveJButton getAcNext(){
		return acNext;
	}
	public ActiveJButton getAcPrevius(){
		return acPrevious;
	}
	public ActiveJButton getAcPause(){
		return acPause;
	}
	public ActiveJButton getAcPlay(){
		return acPlay;
	}
	public ActiveJButton getAcStop(){
		return acStop;		
	}
	public ActiveJButton getAcExit(){
		return acExit;
	}
	public ActiveJButton getAcMinimize(){
		return acMinimize;
	}
	public ActiveJButton getAcEject(){
		return acEject;
	}
	public ActiveJButton getAcEqPresents(){
		return acPresents;
	}
	public ActiveJButton getAcPLUp(){
		return acPLUp;
	}
	public ActiveJButton getAcPLDown(){
		return acPLDown;
	}
	public ActiveJButton getAcPLAdd(){
		return acPLAdd;
	}
	public ActiveJButton getAcPLRemove(){
		return acPLRemove;
	}
	public ActiveJButton getAcPLSelect(){
		return acPLSelect;
	}
	public ActiveJButton getAcPLMisc(){
		return acPLMisc;
	}
	public ActiveJButton getAcPLList(){
		return acPLList;
	}
	
	

	public ActiveJToggleButton getAcEqualizer(){
		return acEqualizer;
	}
	public ActiveJToggleButton getAcPlaylist(){
		return acPlaylist;
	}
	public ActiveJToggleButton getAcRepeat(){
		return acRepeat;
	}
	public ActvieJToggleButton getAcShuffle(){
		return acShuffle;
	}
	public ActiveJToggleButton getAcEqOnOff(){
		return acOnOff;
	}
	public ActiveJToggleButton getAcEqAuto(){
		return acAuto;
	}

	public ActiveJBar getAcTitleBar(){
		return acTitleBar;
	}
	
	public ActiveJLabel getAcTitleLabel(){
		return acTitleLabel;
	}
	public ActiveJLabel getAcSampleRateLabel(){
		return acSampleRateLabel;
	}
	public ActiveJLabel getAcBitRateLabel(){
		return acBitRateLabel;
	}
	
	public ActiveJSlider getAcVolume(){
		return acVolume;
	}
	public ActiveJSlider getAcBalance(){
		return acBalance;
	}
	public ActiveJSlider getAcPosBar(){
		return acPosBar;
	}
	public ActiveJSlider getAcEqSlider(){
		return acSlider;
	}
	public ActiveJSlider getAcPlSlider(){
		return acPLSlider;
	}
	
	public ActiveJPopup getAcPLAddPopup(){
		return acPLAddPopup;
	}
	public ActiveJPopup getAcPLRemovePopup(){
		return acPLRemovePopup;
	}
	public ActiveJPopup getPLSelectPopup(){
		return acPLSelectPopup;
	}
	public ActiveJPopup getPLMiscPopup(){
		return acPLMiscPopup;
	}
	public ActiveJPopup getPLListPopup(){
		return acPLListPopup;
	}
	
	public ActiveJNumberLabel getAcMinuteH(){
		return acMinuteH;
	}
	public ActiveJNumberLabel getAcMinuteL(){
		return acMinuteL;
	}
	public ActiveJNumberLabel getAcSecondH(){
		return acSecondH;
	}
	public ActiveJNumberLabel getAcSecondL(){
		return acSecondL;
	}
	
	public ActiveJIcon getAcMonoIcon(){
		return acMonoIcon;
	}
	public ActiveJIcon getAcStereoIcon(){
		return acStereoIcon;
	}
	public ActiveJIcon getAcPlayIcon(){
		return acPlayIcon;
	}
	public ActiveJIcon getAcTimeIcon(){
		return acTimeIcon;
	}
	
	public SpectrumTimeAnalyzer getAcAnalyzer(){
		return analyzer;
	}
	
	public SplinePanel getSpline(){
		return spline;
	}
	
	public PlaylistUIDelegate getPlaylistPanel(){
		return playlist;
	}
	
	public int getMainHeight(){
		return WinHeight;
	}
	public int getMainWidth(){
		return WinWidth;
	}
	public Image getMainImage(){
		return imMain;
	}
	public Image getEqualizerImage(){
		return imEqualizer;
	}
	
	
	public String getSkinVersion(){
		return skinVersion;
	}
	public void setSkinVersion(String v){
		this.skinVersion = v;
	}
	public Config getConfig(){
		return config;
	}
	public void setConfig(Config c){
		this.config = c;
	}
	public String getVisColors(){
		return viscolor;
	}
}
