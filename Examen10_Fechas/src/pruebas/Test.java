package pruebas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test {

	public static void main(String[] args) {
		LocalDate ldt1 = LocalDate.of(2023,11,30);
		LocalDate ldt2 = LocalDate.of(2023,11,30);
		LocalTime lt1 = LocalTime.of(13, 30);
		LocalTime lt2 = LocalTime.of(21, 15);
		System.out.println(Duration.between(lt1, lt2));
		
		ZonedDateTime zldt1 = ZonedDateTime.of(ldt1, lt1, ZoneId.of("GMT+2"));
		ZonedDateTime zldt2 = ZonedDateTime.of(ldt2, lt2, ZoneId.of("GMT-3"));
		System.out.println(Duration.between(zldt1, zldt2));
	}
}