package Ecommerce.web;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import Ecommerce.entities.Client;
@Data
public class OrderForm {
	private Client client=new Client();
	private List<OrderProduct> products=new ArrayList<>();
	public Client getClient() {
		// TODO Auto-generated method stub
		return this.client;
	}
	public List<OrderProduct> getProducts() {
		// TODO Auto-generated method stub
		return this.products;
	}
}
@Data
class OrderProduct{
	private Long id;
	private int quantity;
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public int getQuantity() {
		// TODO Auto-generated method stub
		return this.quantity;
	}

}
