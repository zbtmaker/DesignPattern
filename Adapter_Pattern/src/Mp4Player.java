package Adapter_Pattern;
/**
 * mp4player/step2
 * @author zoubaitao
 * 2018/4/20
 */
public class Mp4Player implements AdvanceMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file.name:"+fileName);
	}

}
