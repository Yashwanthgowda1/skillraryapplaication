package genericlibrareys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Javautility {
/**
 * this method is used to generate the random num
 */
	public void randomnumber(int limit) {
		Random rando=new Random();
		int random=rando.nextInt(limit);
	}
	
	public String getcurrentdatetime() {
		Date formate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String date=sdf.format(formate);
		return date;
	}
}
