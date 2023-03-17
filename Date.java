package KiemTraGiuaKy;
public class Date {

	public static void main(String[] args) {
		MyDate d1 = new MyDate(2024,12,32);
		System.out.println("Check day 1: "+ d1.toString());//32/12/2024
		d1.setDay(31); //31/12/2024
		System.out.println("\nCheck day 1: "+ d1.toString());
		if(MyDate.isValidDate(d1.getYear(), d1.getMonth(),d1.getDay())){
			MyDate d2 = d1.nextDay();
			System.out.println("Check day 2: "+ d2.toString());
		}
	}

}
