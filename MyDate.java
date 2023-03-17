package KiemTraGiuaKy;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoField;
public class MyDate {
	private int year;
	private int month;
	private int day;
	static String[] MONTHS= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	static String[] DAYS = {"Sunday","Monday","Tuesday","Webnesday","Thursday","Friday","Saturday"};
	static int[] DAYS_IN_MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public static boolean isLeapYear(int year) {
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR, year);
		  return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
	public static boolean isValidDate(int year, int month, int day) {
        if (day <= 0 || month <= 0 || year <= 0)
            return false;
        if (month > 12 || day > 31)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > maxDay)
            return false;

        return true;
    }
	public static int getDayOfWeek(int year,int month,int day) {
		String monthStr,dayStr;
		if(month<10) {
			 monthStr = "0"+String.valueOf(month);
		}
		else {
			 monthStr = String.valueOf(month);
		}
		if(day<10) {
			 dayStr = "0"+String.valueOf(day);
		}
		else {
			 dayStr = String.valueOf(day);
		}
		String str = "";
		str=str+String.valueOf(year)+"-"+monthStr+"-"+dayStr;
		LocalDate dt = LocalDate.parse(str);
		int i = DayOfWeek.from(dt)
                .get(ChronoField.DAY_OF_WEEK);
		return i;
	}
	public MyDate nextDay() {
		if(isLeapYear(year)) {
			DAYS_IN_MONTHS[1]=29;
		}
		else {
			DAYS_IN_MONTHS[1]=28;
		}
		if(day<DAYS_IN_MONTHS[month-1]) {
			day++;
		}
		else {
			day = 1;
			month ++;
			if(month>12) {
				month=1;
				year++;
			}
		}
		return new MyDate(year,month,day);
	}
	
	public MyDate nextMonth() {
		month ++;
		if(month > 12) {
			year ++;
			month =1;
		}
		else {
			while(!isValidDate(year,month,day)) {
				day--;
			}
		}
		return new MyDate(year,month,day);
	}
	public MyDate nextYear() {
		year ++;
		while(!isValidDate(year,month,day)) {
			day--;
		}
		return new MyDate(year,month,day);
	}
	public MyDate previousDay() {
		if(isLeapYear(year)) {
			DAYS_IN_MONTHS[1]=29;
			
		}
		else {
			DAYS_IN_MONTHS[1]=28;
		}
		if(day==1) {
			day=DAYS_IN_MONTHS[month-2];
			month--;
			if(month==0) {
				month=12;
				year--;
			}
		}
		else {
			day--;
		}
		return new MyDate (year,month,day);
	}
	
	public MyDate previousMonth() {
		month--;
		if(month==0) {
			month=12;
			year--;
		}
		else {
			while(!isValidDate(year,month,day)) {
				day--;
			}
			
		}
		return new MyDate(year,month,day);
	}
	public MyDate previousYear() {
		year --;
		while(!isValidDate(year,month,day)) {
			day--;
		}
		return new MyDate(year,month,day);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(!isValidDate(year,month,day)) return "Ngay thang nam khong hop le!";
		int tmp = getDayOfWeek(year,month,day) == 7 ? 0 :getDayOfWeek(year,month,day);
		String dayOfWeek = DAYS[tmp];
		String monthStr = MONTHS[month-1];
		return String.format("%s %d %s %d",dayOfWeek,day,monthStr,year);
	}
	
}
