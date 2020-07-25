package social91;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Result {
public static void main(String[] args) throws ParseException {
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    Calendar c1 = Calendar.getInstance();
//    c1.set(1999, 0 , 20);
//    ArrayList<Calendar> a1 = new ArrayList<>();
//    a1.add(c1);
//    c1.set(2000, 0 , 20);
//    a1.add(c1);
////	System.out.println(sdf.format(c1.getTime()));
//    System.out.println(a1.get(0).getTime());
//    System.out.println(a1.get(1).getTime());
	ConfigurationClass config = new ConfigurationClass();
	config.configureData();
//	for(PartPriceInDateRange conf: con.pricingTable) {
//		System.out.println(conf);
//	}
	Scanner scr = new Scanner(System.in);
	System.out.println("Enter Purchase Date in yyyy/mm/dd formate");
	String purchaseDate = scr.nextLine();
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	Date utilDate = format.parse(purchaseDate); 
	System.out.println("Enter Parts name with ',' saperated ");
	String inputParts = scr.nextLine();
	String[] parts = inputParts.split(",");
	double totalPrice = 0;
	for(String singlePart: parts) {
		totalPrice += config.findPartsPriceOnDate(singlePart,utilDate);
	}
	System.out.println("Price of the cycle is: " +totalPrice);
}
}
