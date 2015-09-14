package lt.swedbank.zebrapuzzle;

import lt.swedbank.zebrapuzzle.solver.ZebraPuzzleResolver;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;

public class ZebraPuzzleTask {

	public static void main(String[] args) {
		if (4 != args.length) {
			System.out
					.println("Program usage: java lt.swedbank.zebrapuzzle.ZebraPuzzleTask INPUT_FORMAT rules_file_name OUTPUT_FORMAT result_file_name");
			System.out
					.println("Example: java lt.swedbank.zebrapuzzle.ZebraPuzzleTask CSV config\\rules.csv XML result\\decision.xml");

			System.exit(-1);
		}
		new ZebraPuzzleTask().start(args);
	}

	public void start(String[] args) {
		ZebraPuzzleResolver solver = new ZebraPuzzleResolver(
				new FormatDescriber(args[0], args[1]), new FormatDescriber(
						args[2], args[3]));
		solver.readInput();
		solver.solve();
		solver.writeOutput();

	}
}
