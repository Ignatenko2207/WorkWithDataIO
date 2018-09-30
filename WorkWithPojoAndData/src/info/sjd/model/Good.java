package info.sjd.model;

public class Good {

	private String goodId;
	private String name;
	private Integer price;
	
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Good(String goodId, String name, Integer price) {
		this(goodId, name);
		this.price = price;
	}
	
	private Good(String goodId, String name) {
		this.goodId = goodId;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return goodId + ", " + name + ", " + price;
	}
}
