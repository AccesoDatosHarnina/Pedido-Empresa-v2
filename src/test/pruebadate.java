package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;

class pruebadate {

	@Test
	void test() {
		LocalDate ahora[]= {
				LocalDate.of(2020,1,12),
				LocalDate.of(2021,1,12),
				LocalDate.of(2022,1,12),
				};
		LocalDate anterior=LocalDate.of(2020,1,12);
		LocalDate posterior=LocalDate.of(2022,1,12);
		for (LocalDate localDate : ahora) {
			assertTrue(
					anterior.isBefore(localDate)
					&&posterior.isAfter(localDate)
					||anterior.isEqual(localDate)
					||posterior.isEqual(localDate));
		}
	}

}
