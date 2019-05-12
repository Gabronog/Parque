package main;

import main.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public final class CommonDates {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static LocalDate getLocalDate() {
		int day = -1,month = -1,year = -1;
		while (Year.of(year).isBefore(Year.now())){
			try {
				if (year != -1)
					System.out.println("     El anio debe ser posterior o igual a " + Year.now());
				System.out.println("        Por favor introduzca un anio para la entrada");
				year = Integer.parseInt(br.readLine());
			}catch (NumberFormatException | IOException io){
				year = -2;
				System.err.println("        Se produjo un error");
				continue;
			}
		}
		boolean currentYear = Year.of(year).equals(Year.now());
		boolean validMonth = false;
		Menu.clearConsole();
		while (!validMonth){
			try {
				if (month!=-1) System.out.println("     Mes no valido");
				System.out.println("        Por favor introduzca un mes para la entrada");
				month = Integer.parseInt(br.readLine());
				if(0 < month && month < 12) {
					if(currentYear){
						if(LocalDate.now().getMonth().getValue() <= month) validMonth = true;
					}else validMonth = true;
				}
			}catch (NumberFormatException | IOException io){
				validMonth = false;
				System.err.println("        Se produjo un error");
			}
		}
		boolean currentMonth = LocalDate.now().getMonth().getValue() == month;
		boolean validday = false;
		while (!validday){
			try {
				if (day!=-1) System.out.println("     Dia no valido");
				System.out.println("        Por favor introduzca un dia para la entrada");
				day = Integer.parseInt(br.readLine());
				Month month1 = Month.of(month);
				if(day<1) continue;
				int maxDay;
				switch (month1){
					case JANUARY:
					case MARCH:
					case MAY:
					case JULY:
					case AUGUST:
					case OCTOBER:
					case DECEMBER:
						maxDay = 31;
						break;
					case FEBRUARY:
						maxDay = Year.of(year).isLeap() ? 29 : 28;
						break;
					case APRIL:
					case NOVEMBER:
					case JUNE:
					case SEPTEMBER:
						maxDay = 30;
						break;
					default:
						return null;
				}
				if(day>maxDay) continue;
				if(currentYear){
					if(currentMonth){
						if(LocalDate.now().getDayOfMonth() <= day) validday = true;
					}else validday = true;
				}else validday = true;

			}catch (NumberFormatException | IOException io){
				System.err.println("        Se produjo un error");
			}
		}
		LocalDate localDate = LocalDate.of(year,month,day);
		return localDate;
	}
}
