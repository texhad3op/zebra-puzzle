package lt.swedbank.zebrapuzzle;

import java.io.File;
import java.util.Iterator;

import junit.framework.Assert;
import lt.swedbank.zebrapuzzle.data.Rule;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.reader.impl.ZebraPuzzleCSVDataReader;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;

import org.junit.Test;

public class ZebraPuzzleCSVDataReaderTest {

	@Test
	public void testRead() {
		ZebraPuzzleCSVDataReader reader = new ZebraPuzzleCSVDataReader(
				new FormatDescriber("csv", "test-resources" + File.separator
						+ "testpuzzle.csv"));
		ZebraPuzzleData etalonData = TestUtils.getStandardZebraPuzzleRules();
		ZebraPuzzleData data = reader.readData();
		Assert.assertEquals(etalonData.getRules().size(), data.getRules()
				.size());
		int i = 0;
		Iterator<Rule> rules = data.getRules().iterator();
		while (rules.hasNext()) {
			Rule rule = rules.next();
			Assert.assertEquals(rule, etalonData.getRules().get(i++));
		}

	}
}
