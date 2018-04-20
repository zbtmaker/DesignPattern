package Adapter_Pattern;

public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		
		
		audioPlayer.play("mp3","Shadow.mp3");
		
		audioPlayer.play("mp4", "Game of Thrones.mp4");
		
		audioPlayer.play("vlc", "Far Far Away.vlc");
		
		audioPlayer.play("avi","Spartacus.avi");
	}
}
