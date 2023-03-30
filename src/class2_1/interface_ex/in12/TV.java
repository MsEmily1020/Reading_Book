package class2_1.interface_ex.in12;

public class TV implements Sound {
	private int soundLevel;

	public TV() {
		soundLevel = 0;
	}

	@Override
	public void SoundUp(int level) {
		soundLevel += level; 
		System.out.println("TV볼륨 " + level + " 증가");
	}

	@Override
	public void SoundDown(int level) {
		soundLevel -= level;
		if(soundLevel < 0)
			soundLevel = 0;
		System.out.println("TV볼륨 " + level + " 감소");
	}
}
