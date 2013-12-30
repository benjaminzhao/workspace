package bhPlayer;

import java.awt.Color;
import java.awt.Image;
import java.io.InputStream;
import java.util.ResourceBundle;

import javax.annotation.Resource;

public class Skin {
	
	private Config config;
	
	public static final String TITLETEXT = "BHPlayer";
	private String skinVersion = "1";
	private boolean dspEnabled = true;
	private String path = "";
	
	/*  window paras  */
	private int WinHeight;
	private int WinWidth;
	private String theMain = "main.bmp";
	private Image imMain = null;
	/*  title member  */
	private String theTitleBar = "titlebar.bmp";
	private Image imTitleBar = null;
	private Image imTitleB;
	private ActiveJBar acTitleBar;
	private Image[] releasedTitleImage = {imTitleB};
	private Image[] pressedTitleImage = {imTitleB};
	private int[] releasedTitlePanel = {27, 0, 264-20, 14};
	private int[] pressedTitlePanel = {27, 15, 264-20, 14};
	private int[] titleBarLocation = {0, 0};
	/*  minimize member  */
	private ActiveJButton acMinimize = null;
	private Image[] releasedMinimizeImage = {};
	private Image[] pressedMinimizeImage = {};
	private int[] releasedMinimizePanel = {};
	private int[] pressedMinimizePanel = {};
	private int[] minimizeLocation = {244, 3};
	/*  exit member  */
	private ActiveJButton acExit = null;
	private Image[] releasedExitImage = {};
	private Image[] pressedExitImage = {};
	private int[] releasedExitPanel = {};
	private int[] pressedExitPanel = {};
	private int[] exitLocation = {264, 3};
	/*  mono/stereo member  */
	private String theMode = "monoster.bmp";
	private Image imMode = null;
	private Image[] activeModeImage = {};
	private Image[] passiveModeImage = {};
	private int[] activeModePanel = {};
	private int[] passiveModePanel = {};
	private int[] monoLocation = {212, 41};
	private int[] stereoLocation = {239, 41};
	private ActiveJIcon acMonoIcon;
	private ActiveJIcon acStereoIcon;
	/*  posbar member  */
	public static final int POSBARMAX = 1000;
	private String thePosBar = "posbar.bmp";
	private Image imPosBar = null;
	private ActiveJSlider acPosBar;
	private Image[] releasedPosImage = {};
	private Image[] pressedPosImage = {};
	private int[] releasedPosPanel = {};
	private int[] pressedPosPanel = {};
	private int[] posBarLocation = {16, 72};
	/*  play/pause icon member  */
	private String theIcon = "playpaus.bmp";
	private Image imIcon = null;
	private Image[] iconsImage = {};
	private int[] iconsPanel = {};
	private int[] iconsLocation = {};
	private ActiveJIcon acPlayIcon;
	private ActiveJIcon acTimeIcon;
	/*  volume panel member  */
	public static final int VOLUMEMAX = 100;
	private String theVolume = "volume.bmp";
	private Image imVolume = null;
	private ActiveJSlider acVolume;
	private String fakeIndex = "abcdefghijklmnopqrstuvwxyz01";
	private Image[] volumeImage = {};
	private Image[] releasedVolumeImage = {};
	private Image[] pressedVolumeImage = {};
	private int[] releasedVolumePanel0 = {};
	private int[] pressedVolumePanel0 = {};
	private int[] releasedVolumePanel1 = {};
	private int[] pressedVolumePanel1 = {};
	private int[] volumeBarLocation = {107, 57};
	/*  balance panel member  */
	public static final int BALANCEMAX = 5;
	private String theBalance = "balance.bmp";
	private Image imBalance = null;
	private ActiveJSlider acBalance;
	private Image[] balanceImage = {};
	private Image[] releasedBalanceImage = {};
	private Image[] pressedBalanceImage = {};
	private int[] releasedBalancePanel0 = {};
	private int[] pressedBalancePanel0 = {};
	private int[] releasedBalancePanel1 = {};
	private int[] pressedBalancePanel1 = {};
	private int[] balanceBarLocation = {177, 57};
	/*  text member  */
	private int fontWidth = 5;
	private int fontHeoght = 6;
	private String theText = "text.bmp";
	private Image imText = null;
	private String fontIndex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\"@a  " + "0123456789  :()-'!_+ /[]^&%.=$#" + "  ?*";
	private ActiveFont acFont = null;
	private ActiveJLabel acTitleLabel;
	private int[] titleLocation = {111, 27};
	private ActiveJLabel acSampleRateLabel;
	private String SampleRateCleartext = "  ";
	private int[] sampleRateLocation = {156, 43};
	private ActiveJLabel acBitRateLabel;
	private String bitRateClearText = "  ";
	private int[] bitRateLocation = {110, 43};
	/*  number member*/
	private int numberWidth = 9;
	private int numberHeight = 13;
	private String theNumbers = "numbers.bmp";
	private String theNumEx = "nums_ex.bmp";
	private Image imNumbers = null;
	private String numberIndex = "0123456789 ";
	private int[] minuteHLocation = {48, 26};
	private int[] minuteLLocation = {60, 26};
	private int[] secondHLocation = {78, 26};
	private int[] secondLLocation = {90, 26};
	private ActiveJNumberLabel acMinuteH;
	private ActiveJNumberLabel acMinuteL;
	private ActiveJNumberLabel acSecondH;
	private ActiveJNumberLabel acSecondL;
	/*  button panel member  */
	private String theButtons = "cbuttons.bmp";
	private Image imButtons = null;
	private ActiveJButton acPlay;
	private ActiveJButton acPause;
	private ActiveJButton acStop;
	private ActiveJButton acPrevious;
	private ActiveJButton acNext;
	private ActiveJButton acEject;
	private Image imPlay;
	private Image imPause;
	private Image imStop;
	private Image imPrevious;
	private Image imNext;
	private Image imEject;
	private Image[] releasedImage = {imPlay, imPause, imStop, imPrevious, imNext, imEject};
	private Image[] pressedImage = {imPlay, imPause, imStop, imPrevious, imNext, imEject};
	private int[] releasedPanel = {};
	private int[] pressedPanel = {};
	private int[] panelLocation = {};
	/*  playlist member  */
	private PlaylistUIDelegate playlist = null;
	private String theImPLEdit = "pledit.bmp";
	private String plEdit = "";
	private Image imPlaylist = null;
	private String thePLEdit = "pledite.txt";
	private ActiveJSlider acPLSlider;
	private int[] plSliderLocation = {255, 20};
	private ActiveJButton acPLUp;
	private ActiveJButton acPLDown;
	private ActiveJButton acPLAdd;
	private ActiveJButton acPLRemove;
	private ActiveJButton acPLSelect;
	private ActiveJButton acPLMisc;
	private ActiveJButton acPLList;
	private int[] plAddLocation = {};
	private int[] plRemoveLocation = {};
	private int[] plSelectLocation = {};
	private int[] plMiscLocation = {};
	private int[] plListLocation = {};
	private ActiveJPopup acPLAddPopup;
	private ActiveJPopup acPLRemovePopup;
	private ActiveJPopup acPLSelectPopup;
	private ActiveJPopup acPLMiscPopup;
	private ActiveJPopup acPLListPopup;
	private int[] plAddPopupArea = {};
	private int[] plRemovePopupArea = {};
	private int[] plSelectPopupArea ={};
	private int[] plMiscPopupArea = {};
	private int[] plListPopupArea = {};
	
	
	
	
	private String theEPSRButtons = "shufrep.bmp";
	private String theEqMain = "eqmain.bmp";
	private String theViscolor = "viscolor.txt";
	private String theReadme = "readme.txt";
	private String viscolor = "";
	
	private ResourceBundle bundle = null;
		
	private ActiveJButton acPresents;
	private ActiveJToggleButton acEqualizer;
	private ActiveJToggleButton acPlaylist;
	private ActiveJToggleButton acRepeat;
	private ActiveJToggleButton acShuffle;
	private ActiveJToggleButton acOnOff;
	private ActiveJToggleButton acAuto;

	private ActiveJSlider acSlider;
	private SpectrumTimeAnalyzer analyzer;
	private SplinePanel spline;
	
	private PlaylistUIDelegate playlist;
	
	private Image imFullEqualizer = null;
	private Image imEqualizer = null;
	private Image imSlider = null;
		
	private Image imEPSRButton = null;
		
	
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
		SkinLoader skl = new SkinLoader(skinname);
		try{
			loadSkin(skl);
			path = skinname;
		}catch(Exception e){
			//try to load default skin
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("metrix.wsz");
			loadSkin(is);
		}
	}
	public void loadSkin(InputStream skinstream){
		SkinLoader skl = new SkinLoader(skinstream);
		try{
			loadSkin(skl);
		}catch(Exception e){
			//try to load default skin
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("metrix.wsz");
			loadSkin(is);
		}
	}
	public void loadSkin(SkinLoader skl) throws Exception{
		skl.loadImage();
		
		imMain = skl.getImage(theMain);
		imButtons = skl.getImage(theButtons);
		imTitleBar = skl.getImage(theTitleBar);
		imText = skl.getImage(theText);
		imMode = skl.getImage(theMode);
		imIcon = skl.getImage(theIcon);
		imEPSRButton = skl.getImage(theEPSRButtons);
		
		imNumbers = skl.getImage(theNumbers);
		if(imNumbers == null)
			imNumbers = skl.getImage(theNumEx);
		viscolor = (String) skl.getContent(theViscolor);
		
		imVolume = skl.getImage(theVolume);
		int vh = imVolume.getHeight(null)-422;
		if(vh > 0){
			releasedVolumePanel0[3] = vh;
			pressedVolumePanel0[3] = vh;
			releasedVolumePanel1[3] = vh;
			pressedVolumePanel1[3] = vh;
		}
		
		imBalance = skl.getImage(theBalance);
		if(imBalance == null)
			imBalance = imVolume;
		int bh = imBalance.getHeight(null)-422;
		if(bh > 0){
			releasedBalancePanel0[3] = bh;
			pressedBalancePanel0[3] = bh;
			releasedBalancePanel1[3] = bh;
			pressedBalancePanel1[3] = bh;
		}
		
		imPosBar = skl.getImage(thePosBar);
		int ph = imPosBar.getHeight(null);
		if(ph > 0){
			releasedPosPanel[3] = ph;
			pressedPosPanel[3] = ph;
		}
		
		WinHeight = imMain.getHeight(null);
		WinWidth = imMain.getWidth(null);
		/*  title bar  */
		readPanel();
		/*  playlist  */
		imPlaylist = skl.getImage(theImPLEdit);
		plEdit = (String) skl.getContent(thePLEdit);
		setPlaylistPanel();
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
