package bhPlayer;

import java.awt.SecondaryLoop;

public class PlayListItem {
	protected String name = null;
	protected String dispaly_name = null;
	
	protected String location = null;
	protected boolean isFile = true;
	protected boolean isSelected = false;
	
	protected long second = -1;
	
	protected TagInfo taginfo = null;
	
	public PlayListItem() {
		// TODO Auto-generated constructor stub
	}
	public PlayListItem(String name, String loc, long sec, boolean isFile){
		
	}
	
	
	public String getName(){
		return name;
	}
	public String getLocation(){
		return location;
	}
	public long getLength(){
		return second;
	}
	public void setLocation(String l, boolean readInfo){
		location = l;
		if(readInfo){
			if(location != null && !location.equals("")){
				taginfo = getTagInfo(location);
			}
		}
		
	}
	public TagInfo getTagInfo(){
		if(taginfo == null){
			setLocation(location, true);
		}
		return taginfo;
	}
}
