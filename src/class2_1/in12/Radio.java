package class2_1.in12;

public class Radio implements Sound {
	private int soundLevel;

	public Radio() {
		soundLevel = 0;
	}

	@Override
	public void SoundUp(int level) {
		soundLevel += level;
		System.out.println("Radio볼륨 " + level + " 증가");
	}

	@Override
	public void SoundDown(int level) {
		soundLevel -= level;
		if(soundLevel < 0)
			soundLevel = 0;
		System.out.println("Radio볼륨 " + level + " 감소");
	}
}
