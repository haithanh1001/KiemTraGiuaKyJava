package KiemTraGiuaKy;
public class Date {

	public static void main(String[] args) {
		MyDate d1 = new MyDate(2024,12,32);
		System.out.println("Check day 1: "+ d1.toString());//32/12/2024 1 thang co 32 ngay -> loi
		d1.setDay(31); //31/12/2024 -> ngay hop le
		System.out.println("\nCheck day 1: "+ d1.toString());
		if(MyDate.isValidDate(d1.getYear(), d1.getMonth(),d1.getDay())){
			MyDate d2 = d1.nextDay(); //ngay tiep theo la 1/1/2025
			System.out.println("Check day 2: "+ d2.toString());
		}
	}

}
