package lt.swedbank.zebrapuzzle;

import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.data.Rule;
import lt.swedbank.zebrapuzzle.data.Statement;
import lt.swedbank.zebrapuzzle.data.Target;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.engine.impl.ZebraPuzzleBruteForceEngine;

import org.junit.Assert;
import org.junit.Test;

public class EngineTest {

	@Test
	public void testSolveStandartCase() {
		ZebraPuzzleData data = TestUtils.getStandardZebraPuzzleRules();
		List<House[]> decision = new ZebraPuzzleBruteForceEngine(data)
				.resolve();
		Assert.assertEquals(1, decision.size());
		House[] houses = decision.iterator().next();
		Assert.assertTrue(houses[4].getProperties().get("pet").equals("Zebra"));
		Assert.assertTrue(houses[0].getProperties().get("drink")
				.equals("Water"));
	}

	@Test
	public void testSolveNonSolvedCase() {
		ZebraPuzzleData data = TestUtils.getStandardZebraPuzzleRules();
		data.getRules()
				.add(new Rule(Target.SAME, new Statement("drink", "Red Bull"),
						null));
		List<House[]> decision = new ZebraPuzzleBruteForceEngine(data)
				.resolve();
		Assert.assertEquals(0, decision.size());
	}

	@Test
	public void testSolveMultipleSolutionCase() {
		ZebraPuzzleData data = TestUtils.getStandardZebraPuzzleRules();
		data.getRules().add(
				new Rule(Target.SAME, new Statement("sex", "Girl"), null));
		List<House[]> decision = new ZebraPuzzleBruteForceEngine(data)
				.resolve();
		Assert.assertEquals(5, decision.size());
	}

}
