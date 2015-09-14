package lt.swedbank.zebrapuzzle.data;

public class Statement {
	private String name;
	private String value;

	public Statement() {
		this.name = null;
		this.value = null;
	}

	public Statement(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Statement))
			return false;
		Statement otherStatement = (Statement) other;
		if (otherStatement.getName().equals(getName())
				&& otherStatement.getValue().equals(getValue()))
			return true;
		return false;
	}
}
