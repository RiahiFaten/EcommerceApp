package Ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Product product;
	private int quantity;
	private double price;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Order order;
	public void setOrder(Order order) {
		// TODO Auto-generated method stub
		this.order=order;
	}
	public void setProduct(Product product) {
		// TODO Auto-generated method stub
		this.product=product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	public Order getOrder() {
		return order;
	}
	public void setPrice(double currentPrice) {
		// TODO Auto-generated method stub
		this.price=currentPrice;
	}
	public void setQuantity(int quantity) {
		// TODO Auto-generated method stub
		this.quantity=quantity;
	}
}




