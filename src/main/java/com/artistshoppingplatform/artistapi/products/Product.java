package com.artistshoppingplatform.artistapi.products;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name="products_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private UUID id;
	
	@Column(name="procut_name")
	private String productName;
	
	private Integer price;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte productImage;

	protected Product() {}
	
	public Product(String productName, Integer price, byte productImage) {
		super();
		this.productName = productName;
		this.price = price;
		this.productImage = productImage;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public byte getProductImage() {
		return productImage;
	}

	public void setProductImage(byte productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", productImage="
				+ productImage + "]";
	}
	
	
	
	

}
