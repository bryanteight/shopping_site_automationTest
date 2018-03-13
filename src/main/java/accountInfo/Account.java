package accountInfo;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private final String email;
	private final String firstName;
	private final String lastName;
	private String password;
	private String company;
	private String address;
	private String city;
	private String zipcode;
	private String mobilePhone;
	private String alias;
	
	private List<Order> orderList;
	
	private Account(AccountBuilder builder) {
		
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.password = builder.password;
		this.company = builder.company;
		this.address = builder.address;
		this.city = builder.city;
		this.zipcode = builder.zipcode;
		this.mobilePhone = builder.mobilePhone;
		this.alias = builder.alias;
		
		orderList = new ArrayList<Order>();
	}
	
	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAlias() {
		return alias;
	}

	public String getEmail() {
		return email;
	}
	
	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public static class AccountBuilder {
		private final String email;
		private final String firstName;
		private final String lastName;
		
		private String password;
		private String company;
		private String address;
		private String city;
		private String zipcode;
		private String mobilePhone;
		private String alias;
		
		
		public AccountBuilder(String firstName, String lastName) {
			Generator generator = new Generator();
			this.email = generator.generateEmail();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public AccountBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public AccountBuilder company(String company) {
			this.company = company;
			return this;
		}
		
		public AccountBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public AccountBuilder city(String city) {
			this.city = city;
			return this;
		}
		
		public AccountBuilder zipcode(String zipcode) {
			this.zipcode = zipcode;
			return this;
		}
		
		public AccountBuilder mobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
			return this;
		}
		
		public AccountBuilder alias(String alias) {
			this.alias = alias;
			return this;
		}
		
		public Account build() {
			return new Account(this);
		}	
	}
}
