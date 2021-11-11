package Ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	@OneToMany(mappedBy = "order")
	private Collection<OrderItem> orderItems;
	@ManyToOne
	private Client client;
	private double totalAmount;
	@OneToOne
	private Payment payment;
	public void setClient(Client client) {
		// TODO Auto-generated method stub
		this.client=client;
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date=date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Collection<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Date getDate() {
		return date;
	}
	public Client getClient() {
		return client;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double total) {
		// TODO Auto-generated method stub
		this.totalAmount=total;
	}


}





