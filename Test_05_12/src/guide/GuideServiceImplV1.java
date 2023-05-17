package guide;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuideServiceImplV1 implements GuideService {

	List<GuideDto> guideList;

	public GuideServiceImplV1() {
		guideList = new ArrayList<>();
	}

	@Override
	public void loadGuide() {

		String file = "src/guide/guide.txt";
		Scanner scan = null;
		InputStream is = null;

		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] gArr = line.split(",");

			GuideDto gDto = new GuideDto();
			gDto.id = gArr[0];
			gDto.list = gArr[1];
			gDto.seq = gArr[2];
			gDto.guide = gArr[3];

			guideList.add(gDto);
		}
		scan.close();

	}

	@Override
	public void printGuideList() {
		System.out.println("=".repeat(150));
		System.out.println("id\t종목명\t\t순서\t방법");
		System.out.println("-".repeat(150));

		for (int i = 0; i < guideList.size(); i++) {
			System.out.printf("%-5s\t", guideList.get(i).id);
			System.out.printf("%-10s\t", guideList.get(i).list);
			System.out.printf("%s 회\t", guideList.get(i).seq);
			System.out.printf("%-10s\n", guideList.get(i).guide);
			if (i == guideList.size() - 1) {
				break;
			} else if (guideList.get(i).id.equals(guideList.get(i + 1).id)) {
				continue;
			} else {
				System.out.println("-".repeat(150));
			}

		}

		System.out.println("=".repeat(150));

	}

}
