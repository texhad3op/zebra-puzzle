package lt.swedbank.zebrapuzzle.data;

import java.util.List;

public class ZebraPuzzleData {
	private int housesQty;
	private List<Rule> rules;

	public ZebraPuzzleData(int housesQty, List<Rule> rules) {
		this.housesQty = housesQty;
		this.rules = rules;
	}

	public int getHousesQty() {
		return housesQty;
	}

	public List<Rule> getRules() {
		return rules;
	}
}