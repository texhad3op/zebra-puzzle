package lt.swedbank.zebrapuzzle.data;

public class Rule {

	private Target target;
	private Statement statement1;
	private Statement statement2;

	public Rule(Target target, Statement statement1, Statement statement2) {
		this.target = target;
		this.statement1 = statement1;
		this.statement2 = statement2;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Statement getStatement1() {
		return statement1;
	}

	public void setStatement1(Statement statement1) {
		this.statement1 = statement1;
	}

	public Statement getStatement2() {
		return statement2;
	}

	public void setStatement2(Statement statement2) {
		this.statement2 = statement2;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Rule))
			return false;
		Rule otherRule = (Rule) other;

		if (otherRule.getTarget().equals(target)
				&& otherRule.getStatement1().equals(getStatement1())) {

			if (null == getStatement2() && null == otherRule.getStatement2())
				return true;

			else {
				if (otherRule.getStatement2().equals(getStatement2()))
					return true;
				else
					return false;
			}

		}

		return false;
	}
}