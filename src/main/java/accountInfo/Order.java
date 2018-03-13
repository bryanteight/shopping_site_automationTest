package accountInfo;


public class Order {
	private String order_reference;
	private String total_price;
	private String order_date;
	private String payment;
	
	public Order() {
		
	}
	
	public Order(String total_price, String order_date) {
		this.total_price = total_price;
		this.order_date = order_date;
	}

	public Order(String order_reference, String total_price, String order_date, String payment) {
		
		this.order_reference = order_reference;
		this.total_price = total_price;
		this.order_date = order_date;
		this.payment = payment;
	}

	public String getOrder_reference() {
		return order_reference;
	}

	public String getTotal_price() {
		return total_price;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getPayment() {
		return payment;
	}
	
	
}
