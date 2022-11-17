package common;

public class SearchUserStandard {
	
	private String condition;
	private String value;
	
	public SearchUserStandard() {}

	public SearchUserStandard(String condition, String value) {
		super();
		this.condition = condition;
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SearchUserStandard [condition=" + condition + ", value=" + value + "]";
	}
	
}
