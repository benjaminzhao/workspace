package bhPlayer;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import javazoom.jl.*;
import javazoom.jl.player.*;



public class BHPlayerGUI extends JFrame{

	private boolean isStart;
	private boolean isStop;
	private boolean isExist;
	private boolean isPlaying;
	private boolean AutoRun;
	
	private String fileName;
	private String fileType;
	
	
	private JButton Play;
	private JButton Stop;
	private JButton Pause;
	
	private static JLabel PlayFile;
	private JProgressBar Progress;
	private JList playList;
	private DefaultListModel ListModel; 
	
	static BHPlayerIO bhplayerIO;
	
	private Config config = null;
	private String initConfig = "config.ini";
	
	
	BHPlayerGUI(){
		super();
	}
	
	void LoadGUI(){
		//MAIN GUI
		//JFrame a = new JFrame("BH Player");
		setTitle("BH player");
		//setSize(getMaximumSize());
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setLayout(null);
				
		JScrollPane PLScrollPanel = new JScrollPane();
		PLScrollPanel.setBounds(0, 20, 500, 300);
		add(PLScrollPanel);
		
		ListModel = new DefaultListModel<String>();
		playList = new JList(ListModel);
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 2)
			       	play();
		    }
		};
		playList.addMouseListener(mouseListener);
		PLScrollPanel.setViewportView(playList);
		
		PlayFile = new JLabel("please add audio files");
		PlayFile.setBounds(0, 430, 500, 20);
		add(PlayFile);
				
		JMenuBar jMenuBar = new JMenuBar();
		jMenuBar.setBounds(0, 0, 500, 20);
		add(jMenuBar);
				
		JMenu jMenuFile = new JMenu("File");
		jMenuBar.add(jMenuFile);
		{
			JMenuItem jMenuAddFiles = new JMenuItem("Add Files");
			jMenuAddFiles.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					JFileChooser jFileOpen = new JFileChooser();
					jFileOpen.setCurrentDirectory(new java.io.File("."));
					jFileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
					jFileOpen.setAcceptAllFileFilterUsed(false);
					jFileOpen.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){
							//Override
							public boolean accept(File f){
								if(f.isDirectory())
									return true;
								String extension = f.getName().substring(f.getName().lastIndexOf('.')+1);
								String[] allowed_extensions = {"mp3","wav","ogg","wma"};
										
								if(extension != null)
									for(String s:allowed_extensions){
										if(extension.equalsIgnoreCase(s))
											return true;
									}
								return false;				
							}	
							//Override
							public String getDescription(){
								return "music files";
							}
						});
					
					int ret = jFileOpen.showOpenDialog(BHPlayerGUI.this);
					if (ret == JFileChooser.APPROVE_OPTION){
						PlayFile.setText("add: " + jFileOpen.getSelectedFile().toString() );
						ListModel.addElement(jFileOpen.getSelectedFile().toString());
						//PlayList.setText( jFileOpen.getSelectedFiles()().toString() );
			        }
				}
			});
			jMenuFile.add(jMenuAddFiles);
			
			JMenuItem jMenuAddFolder = new JMenuItem("Add Folder");
			jMenuAddFolder.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					JFileChooser jFolderOpen = new JFileChooser();
					jFolderOpen.setCurrentDirectory(new java.io.File("."));
					jFolderOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					//jFolderOpen.setAcceptAllFileFilterUsed(false);
					int ret = jFolderOpen.showOpenDialog(BHPlayerGUI.this);
					if (ret == JFileChooser.APPROVE_OPTION){
						File folder = new File(jFolderOpen.getSelectedFile().toString());
						File[] files = folder.listFiles( new FilenameFilter() {
							public boolean accept(File dir, String name) {
								return name.toLowerCase().endsWith(".mp3");
							}
						});
						int i = 0;
						for(File f:files){
							i++;
							ListModel.addElement(f.toString());
						}
						PlayFile.setText(i+" files added" );
			        }
				}
			});
			jMenuFile.add(jMenuAddFolder);
			
			JMenuItem jMenuExit = new JMenuItem("Exit");
			jMenuExit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			jMenuFile.add(jMenuExit);
		}
				
		JMenu jMenuHelp = new JMenu("Help");
		jMenuBar.add(jMenuHelp);
		{
			JMenuItem jMenuAbout = new JMenuItem("About");
			jMenuAbout.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					//System.out.println("about clicked...");
					final JFrame about = new JFrame("About");
					about.setSize(200, 200);
					about.setLayout(null);
					about.setResizable(false);
					about.setLocationRelativeTo(null);
					about.setVisible(true);
					
					JLabel author = new JLabel("BB&HH Software");
					author.setBounds(35, 30, 130, 40);
					about.add(author);
					
					JLabel version = new JLabel("Ver 1.0");
					version.setBounds(35, 50, 130, 40);
					about.add(version);
					
					JLabel update = new JLabel("Build @ "+new Date().toString());
					update.setBounds(35, 70, 130, 40);
					about.add(update);
				}
			});
			jMenuHelp.add(jMenuAbout);
		}
				
		Stop = new JButton("STOP");
		Stop.setBounds(10, 350, 80, 30);
		Stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StopActionPerformed(e);
			}
		});
		add(Stop);
		
		Play = new JButton("Play");
		Play.setBounds(100, 350, 80, 30);
		Play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				play();
			}
		});
		add(Play);
		
		Pause = new JButton("PAUSE");
		Pause.setBounds(190, 350, 80, 30);
		Pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PauseActionPerformed(e);
			}
		});
		add(Pause);
			
		Progress = new JProgressBar();
		Progress.setBounds(0, 410, 500, 15);
		Progress.setValue(50);
		
		//setStringPainted(true);
		add(Progress);
		
		
		//JStatusBar Statusbar = new JStatusBar();
		//add(Statusbar);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void LoadParas(){
		//parameter
		isPlaying = false;
		AutoRun = false;
	}
	
	private void LoadPL(){
		//playlist
	}
	private void LoadConfig(){
		config = Config.getInstance();
		if(initConfig == null)
			new throws errors()
		config.load(initConfig);
	}
	public static void main(String args[]){
		
		final BHPlayerGUI BHPlayer = new BHPlayerGUI();
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				BHPlayer.LoadParas();
				BHPlayer.LoadConfig();
				BHPlayer.LoadGUI();
				BHPlayer.LoadPL();
			}
		});
		
		System.out.println("main start");
	}

	private void play(){
	    if(isPlaying){
	    	//stop playing music
	    	//System.out.println("already playing");
	    	//System.out.println("stopping and swicthing");
	    	bhplayerIO.close();
	    	//Progress.setValue(bhplayerIO.getPos());
	    	isPlaying = false;
	    }

	    try{
    		String playfile = ListModel.getElementAt(playList.getSelectedIndex()).toString();
    		PlayFile.setText("Playing: "+playfile);
    		bhplayerIO = new BHPlayerIO(playfile);
    		new Thread("PlayerPlaying"){
				public void run(){
					//Override
					bhplayerIO.play();
					
				}			
			}.start();
			isPlaying = true;
			new Thread("PlayerProgress"){
				public void run(){
					if(isPlaying){
						Progress.setValue(bhplayerIO.getPos());
					}
				}
			}.start();
    	}catch(Exception e){
    		//e.printStackTrace();
    	}
//		if(playerIO.isValidMusicType(playfile))
//		{
//		    
//			try{
//				//playerIO.fis = new FileInputStream(new File(playfile));
//				//playerIO.stream = new BufferedInputStream(playerIO.fis);
//				//playerIO.player = new Player(playerIO.stream);
//				playerIO.play(playfile);
//		    	isStart = true;
//		    }catch(Exception e){
//		    	e.printStackTrace();
//		    }finally{
//		    	System.out.println("Play Pressed");
//		    }
//			//4. set player status
//		}
		//else do nothing
	}

	private void StopActionPerformed(ActionEvent evt) {
		//1. check player status
		//2. stop
		//3. set player status
		if(isPlaying){
			bhplayerIO.close();
			isPlaying = false;
		}
			
		System.out.println("Stop Pressed");
	}
	private void PauseActionPerformed(ActionEvent evt) {
		if(isPlaying){
			bhplayerIO.pause();
			
		}
		//1.check Player status
		//2.pause
		//3.set player status
	}
	
	
//	private javax.swing.filechooser.FileFilter NewFileFilter(final String desc, final String[] allowed_extensions){
//		return new javax.swing.filechooser.FileFilter(){
//			//Override
//			public boolean accept(File f){
//				if(f.isDirectory())
//					return true;
//				String extension = f.getName().substring(f.getName().lastIndexOf('.')+1);
//				
//				if(extension != null)
//					for(String s:allowed_extensions){
//						if(extension.equalsIgnoreCase(s))
//							return true;
//					}
//				return false;				
//			}
//			
//			//Override
//			public String getDescription(){
//				return "music files";
//			}
//		};
//	}
}