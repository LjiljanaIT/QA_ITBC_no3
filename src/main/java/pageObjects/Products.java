package pageObjects;

public class Products {
	public String name;
	public String id;
	public String description;
	public String long_description;
	public double price;
	public boolean tangible;
	public double weight;
	public double handling;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isTangible() {
		return tangible;
	}

	public void setTangible(boolean tangible) {
		this.tangible = tangible;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHandling() {
		return handling;
	}

	public void setHandling(double handling) {
		this.handling = handling;
	}

}
