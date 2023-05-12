package guide;

public class exec {
	
	public static void main(String[] args) {
		
		GuideService gs = new GuideServiceImplV1();
		
		gs.loadGuide();
		gs.printGuideList();
	}

}
