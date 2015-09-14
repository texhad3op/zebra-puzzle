package lt.swedbank.zebrapuzzle.reader.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import lt.swedbank.zebrapuzzle.data.Rule;
import lt.swedbank.zebrapuzzle.data.Statement;
import lt.swedbank.zebrapuzzle.data.Target;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.reader.ZebraPuzzleDataReader;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;
import lt.swedbank.zebrapuzzle.utils.ZebraPuzzleConstants;

public class ZebraPuzzleCSVDataReader extends ZebraPuzzleDataReader {

	public ZebraPuzzleCSVDataReader(FormatDescriber formatDescriber) {
		super(formatDescriber);
	}

	@Override
	public ZebraPuzzleData readData() {

		int housesQty = 0;
		List<Rule> rules = new ArrayList<Rule>();

		BufferedReader reader = null;
		try {
			try {
				reader = new BufferedReader(new FileReader(
						formatDescriber.getFile()));
			} catch (FileNotFoundException e) {
				throw new ZebraPuzzleCVSReaderException(
						"ZebraPuzzleDataReader can't find rules file: "
								+ formatDescriber.getFile());
			}

			try {
				housesQty = Integer.parseInt(reader.readLine());
			} catch (Exception e) {

				throw new ZebraPuzzleCVSReaderException(
						"ZebraPuzzleDataReader can't get house quantity from the first line of file: "
								+ formatDescriber.getFile());
			}

			String line;
			int lineNumumber = 0;
			try {
				while (null != (line = reader.readLine())) {

					String[] elements = line
							.split(ZebraPuzzleConstants.DELIMITER);

					Target target;
					try {
						target = Target.valueOf(elements[0]);
					} catch (IllegalArgumentException e) {
						throw new ZebraPuzzleCVSReaderException(
								"Wrong realtion type [" + elements[0]
										+ "] in line " + lineNumumber);
					}

					Statement statementFirst = null;
					Statement statementSecond = null;
					switch (elements.length) {
					case 5:
						statementFirst = new Statement(elements[1], elements[2]);
						statementSecond = new Statement(elements[3],
								elements[4]);
						break;
					case 3:
						statementFirst = new Statement(elements[1], elements[2]);
						break;
					default:
						throw new RuntimeException(
								"Wrong elements number in rule. [" + line
										+ "] in line " + lineNumumber);
					}
					rules.add(new Rule(target, statementFirst, statementSecond));
					lineNumumber++;
				}

			} catch (IOException ioe) {

				throw new ZebraPuzzleCVSReaderException(
						"ZebraPuzzleDataReader can't read rule file: "
								+ formatDescriber.getFile());
			}
		} catch (ZebraPuzzleCVSReaderException zpcre) {
			throw new RuntimeException(zpcre.getLocalizedMessage());
		} finally {
			closeReader(reader);
		}

		return new ZebraPuzzleData(housesQty, rules);
	}

	private void closeReader(Reader reader) {
		if (null != reader)
			try {
				reader.close();
			} catch (IOException e) {

			}
	}

}
