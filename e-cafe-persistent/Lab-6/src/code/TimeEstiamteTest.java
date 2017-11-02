package code;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TimeEstiamteTest {

	@Test
	public void test() {
		int timeGap = 8;
		Cafe food = new Cafe();
		GregorianCalendar date = new GregorianCalendar();
		int second = date.get(Calendar.SECOND);
		int minute = date.get(Calendar.MINUTE);
		int hour = date.get(Calendar.HOUR);
		assertEquals(food.estimateTime(timeGap),hour + ":" + (minute+timeGap) + ":" + second);
	}
}
