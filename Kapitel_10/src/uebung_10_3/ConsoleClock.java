package uebung_10_3;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ConsoleClock {

	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE', 'dd. MMMM yyyy hh:mm:s z");
		dateFormat.setTimeZone(timeZone);
		
		while (true) {
			GregorianCalendar calendar = new GregorianCalendar(timeZone);
			System.out.println(dateFormat.format(calendar.getTime()));
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
