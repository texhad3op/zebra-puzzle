package lt.swedbank.zebrapuzzle.engine.impl;

import java.util.ArrayList;
import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.data.Rule;
import lt.swedbank.zebrapuzzle.data.Statement;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.engine.ZebraPuzzleEngine;

public class ZebraPuzzleBruteForceEngine extends ZebraPuzzleEngine {

	public ZebraPuzzleBruteForceEngine(ZebraPuzzleData zebraPuzzleData) {
		super(zebraPuzzleData);
	}

	public List<House[]> resolve() {
		List<House[]> solutionAtTheMoment = new ArrayList<House[]>();

		solutionAtTheMoment.add(generateInitialSolution());
		for (Rule rule : zebraPuzzleData.getRules()) {
			List<House[]> allPossibleOptions = new ArrayList<House[]>();
			for (House[] solution : solutionAtTheMoment) {
				for (int i = 0; i < solution.length; i++) {
					List<House[]> options = getPossibleOptionsForSolution(rule,
							solution, i);
					allPossibleOptions.addAll(options);
				}
			}
			solutionAtTheMoment = allPossibleOptions;
		}
		return solutionAtTheMoment;
	}

	private House[] generateInitialSolution() {
		House[] initialSolution = new House[zebraPuzzleData.getHousesQty()];
		for (int i = 0; i < initialSolution.length; i++) {
			initialSolution[i] = new House(i + 1);
		}
		return initialSolution;
	}

	protected List<House[]> getPossibleOptionsForSolution(Rule rule,
			House[] solution, int houseIndex) {
		House[] newSolution = null;
		List<House[]> result = new ArrayList<House[]>();
		switch (rule.getTarget()) {
		case SAME:
			newSolution = clone(solution);
			if (checkStatement(newSolution[houseIndex], rule.getStatement1())
					&& (rule.getStatement2() == null || checkStatement(
							newSolution[houseIndex], rule.getStatement2()))) {
				setStatement(newSolution[houseIndex], rule.getStatement1());
				if (null != rule.getStatement2())
					setStatement(newSolution[houseIndex], rule.getStatement2());
				result.add(newSolution);
			}
			break;
		case TO_THE_LEFT_OF:
			if (houseIndex > 0) {
				newSolution = clone(solution);
				if (checkStatement(newSolution[houseIndex - 1],
						rule.getStatement1())
						&& checkStatement(newSolution[houseIndex],
								rule.getStatement2())) {
					setStatement(newSolution[houseIndex - 1],
							rule.getStatement1());
					setStatement(newSolution[houseIndex], rule.getStatement2());
					result.add(newSolution);
				}
			}
			break;
		case NEXT_TO:
			if (houseIndex < solution.length - 1) {
				newSolution = clone(solution);
				if (checkStatement(newSolution[houseIndex + 1],
						rule.getStatement1())
						&& checkStatement(newSolution[houseIndex],
								rule.getStatement2())) {

					setStatement(newSolution[houseIndex + 1],
							rule.getStatement1());
					setStatement(newSolution[houseIndex], rule.getStatement2());
					result.add(newSolution);
				}
			}
			if (houseIndex > 0) {
				newSolution = clone(solution);
				if (checkStatement(newSolution[houseIndex - 1],
						rule.getStatement1())
						&& checkStatement(newSolution[houseIndex],
								rule.getStatement2())) {
					setStatement(newSolution[houseIndex - 1],
							rule.getStatement1());
					setStatement(newSolution[houseIndex], rule.getStatement2());
					result.add(newSolution);
				}
			}
			break;
		}
		return result;
	}

	protected boolean checkStatement(House house, Statement statement) {
		String value = house.getProperties().get(statement.getName());
		if (value == null) {
			return true;
		} else {
			if (value.equals(statement.getValue())) {
				return true;
			}
		}
		return false;
	}

	protected void setStatement(House house, Statement statement) {
		house.getProperties().put(statement.getName(), statement.getValue());
	}

	House[] clone(House[] solution) {
		House[] result = new House[solution.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = solution[i].clone();
		}
		return result;
	}

}