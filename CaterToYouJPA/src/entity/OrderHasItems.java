package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_has_items")
public class OrderHasItems {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private int count;
}
