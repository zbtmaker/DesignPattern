package Adapter_Pattern;

public class AudioPlayer implements MediaPlayer{
	private MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		//inbuilt support to play mp3 music files
		if(audioType.equalsIgnoreCase("mp3")) {
			
			System.out.println("Playing mp3 file.name: "+fileName);
			
		}else if(audioType.equalsIgnoreCase("mp4")||
				audioType.equalsIgnoreCase("vlc")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else {
			System.out.println("Invalid media."+audioType+"format not support");
		}
	}

}
