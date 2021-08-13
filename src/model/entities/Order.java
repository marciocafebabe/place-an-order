package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.OrderStatus;

public class Order {

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items;

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.items = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(this.moment));
		sb.append("\nOrder status: ");
		sb.append(this.status.toString());
		sb.append("\nClient: ");
		sb.append(this.client);
		sb.append("\nOrder items:");
		for (OrderItem item : items) {
			sb.append("\n");
			sb.append(item.getProduct().getName());
			sb.append(", Quantity: ");
			sb.append(item.getQuantity());
			sb.append(", Subtotal: ");
			sb.append(item.subTotal());
		}
		sb.append("\nTotal price: ");
		sb.append(this.total());
		
		return sb.toString();
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		Double total = 0.0d;
		for (OrderItem item : items) {
			total += item.subTotal();
		}
		return total;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

}
