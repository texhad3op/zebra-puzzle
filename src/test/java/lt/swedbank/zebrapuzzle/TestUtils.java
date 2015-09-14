package lt.swedbank.zebrapuzzle;

import java.util.ArrayList;
import java.util.List;

import lt.swedbank.zebrapuzzle.data.Rule;
import lt.swedbank.zebrapuzzle.data.Statement;
import lt.swedbank.zebrapuzzle.data.Target;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;

public class TestUtils {
	public static ZebraPuzzleData getStandardZebraPuzzleRules() {
		List<Rule> list = new ArrayList<Rule>();
		list.add(new Rule(Target.SAME, new Statement("nationality", "English"),
				new Statement("color", "Red")));
		list.add(new Rule(Target.SAME,
				new Statement("nationality", "Spaniard"), new Statement("pet",
						"Dog")));
		list.add(new Rule(Target.SAME, new Statement("drink", "Coffee"),
				new Statement("color", "Green")));
		list.add(new Rule(Target.SAME, new Statement("drink", "Tea"),
				new Statement("nationality", "Ukrainian")));
		list.add(new Rule(Target.TO_THE_LEFT_OF,
				new Statement("color", "Ivory"),
				new Statement("color", "Green")));
		list.add(new Rule(Target.SAME, new Statement("smoke", "Old gold"),
				new Statement("pet", "Snails")));
		list.add(new Rule(Target.SAME, new Statement("smoke", "Kools"),
				new Statement("color", "Yellow")));
		list.add(new Rule(Target.SAME, new Statement("drink", "Milk"),
				new Statement("position", "3")));
		list.add(new Rule(Target.SAME,
				new Statement("nationality", "Norwegian"), new Statement(
						"position", "1")));
		list.add(new Rule(Target.NEXT_TO, new Statement("smoke",
				"Chesterfields"), new Statement("pet", "Fox")));
		list.add(new Rule(Target.NEXT_TO, new Statement("smoke", "Kools"),
				new Statement("pet", "Horse")));
		list.add(new Rule(Target.SAME, new Statement("smoke", "Lucky strike"),
				new Statement("drink", "Orange juice")));
		list.add(new Rule(Target.SAME, new Statement("smoke", "Parliaments"),
				new Statement("nationality", "Japanese")));
		list.add(new Rule(Target.NEXT_TO, new Statement("color", "Blue"),
				new Statement("nationality", "Norwegian")));
		list.add(new Rule(Target.SAME, new Statement("drink", "Water"), null));
		list.add(new Rule(Target.SAME, new Statement("pet", "Zebra"), null));

		ZebraPuzzleData data = new ZebraPuzzleData(5, list);
		return data;
	}
}
