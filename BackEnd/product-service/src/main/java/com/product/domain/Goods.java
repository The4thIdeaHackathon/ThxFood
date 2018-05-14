package com.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Goods")
public class Goods {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String store;
	private String product;
	private String htpurchase;
	private int amount;
	private String price;
	
	protected Goods() {
	}
	
	public Goods(final String store,final String product, final int amount, 
			final String htpurchase, final String price) {
		
		this.store = store;
		this.product = product;
		this.htpurchase = htpurchase;
		this.amount = amount;
		this.price = price;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getProduct() {
		return product;
	}
	
	public String getHtpurchase()
	{
		return htpurchase;
	}
	
	public void setHtpurchase(String htpurchase)
	{
		this.htpurchase=htpurchase;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
	
}
