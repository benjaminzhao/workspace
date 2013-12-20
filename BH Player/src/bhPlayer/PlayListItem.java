package bhPlayer;

import java.awt.SecondaryLoop;

public class PlaylistItem {
	protected String name = null;
	protected String dispaly_name = null;
	protected String location = null;
	protected boolean isFile = true;
	protected boolean isSelected = false;
	
	protected long second = -1;
	
//	protected TagInfo taginfo = null;
	
	public PlaylistItem() {
		// TODO Auto-generated constructor stub
	}
	public PlaylistItem(String name, String loc, long sec, boolean isFile){
		this.name = name;
		this.second = sec;
		this.isFile = isFile;
		this.location = loc;
		Config config = Config.getInstance();
		
//		if(){
//			getFileInfo(location, true);
//		}
//		else{
//			getFileInfo(location, false);
//		}
			
	}
	public boolean isFile(){
		return isFile;
	}
	public void setFile(boolean b){
		isFile = b;
	}
	public boolean isSelected(){
		return isSelected;
	}
	public void setSelected(boolean mode){
		isSelected = mode;
	}
	public String getName(){
		return name;
	}
	public String getFormattedName(){
		if(dispaly_name == null){
			if(second > 0){
				String len = getFormattedLength();
				return "("+len+") "+name;
			}
			else
				return name;
		}
		else
			return dispaly_name;
	}
	public String getFormattedDisplayName(){
		
	}
	public String getLocation(){
		return location;
	}
	public void setLocation(String s, boolean readInfo){
		location = s;
		if(readInfo == true){
			
		}
		dispaly_name = getFormattedDisplayName();
	}
	public void setLocation(String s){
		setLocation(s,false);
	}
	
	public long getLength(){
		return second;
	}
	public String getFormattedLength(){
		long time = getLength();//in second
		String length = "";
		if(time > -1){
			int min = (int) Math.floor(time / 60);
			int hour = (int) Math.floor(min / 60);
			min = min - hour * 60;
			int sec = (int)(time - min * 60 - hour * 3600);
			if(hour > 0){
				length += 
			}
			length +=
		}
		else
			length = "" + time;
		return length;
	}
	public void getFileInfo(String l, boolean readInfo){
		if(readInfo){
			if(location != null && !location.equals("")){
				//taginfo = getTagInfo(location);
			}
		}
		
	}
	public String getM3UExtInf(){
		
	}
	public int getBitrate(){
		return -1;
	}
	public int getSamplerate(){
		return -1;
	}
	public int getChannels(){
		return -1;
	}
	
	//	public TagInfo getTagInfo(){
//		if(taginfo == null){
//			getFileInfo(location, true);
//		}
//		return taginfo;
//	}
}
