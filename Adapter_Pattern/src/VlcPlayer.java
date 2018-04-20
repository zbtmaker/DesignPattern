package Adapter_Pattern;

public class VlcPlayer implements AdvanceMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		System.out.println("playing vlc file.name:"+fileName);
	}

	@Override
	public void playMp4(String fileName) {
		
	}
	
}
