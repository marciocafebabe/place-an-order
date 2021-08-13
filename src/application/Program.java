package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import model.entities.Client;
import model.entities.DateFormats;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");

		System.out.print("Name: ");
		String name = sc.next();

		System.out.print("Email: ");
		String email = sc.next();

		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = new Date();
		try {
			birthDate = DateFormats.sdf1.parse(sc.next());

		} catch (ParseException e) {
			System.err.println("Wrong date format.");
			e.printStackTrace();
		}

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");

		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.println("How many items to this order?");
		int items_qnt = sc.nextInt();

		String prod_name = "";
		double prod_price = 0.0;
		int prod_qnt = 0;
		
		for (int i = 0; i < items_qnt; i++) {
			System.out.println("Enter #" + (i + 1) +" item data:");
			System.out.print("Product name: ");
			prod_name = sc.next();
			
			System.out.println("Product price: ");
			prod_price = sc.nextDouble();
			
			System.out.println("Quantity: ");
			prod_qnt = sc.nextInt();
			
			Product product = new Product(prod_name, prod_price);	
			OrderItem item = new OrderItem(prod_qnt, prod_price, product);
			order.addItem(item);
		}
		System.out.println("- ORDER SUMMARY -");
		System.out.println(order);
		
		sc.close();
	}

}
