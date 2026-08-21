package gestorFinanceiro;

public class Transaction {
	private String description;
	private String date;
	private String type;
	private String category;
	private float value;

	public Transaction() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String toString() {
		return description + " | R$" + value + " | " + type + " | " + category + " | " + date;
	}

}
