package edu.umd.cs.findbugs.ml;

import java.util.Collection;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SplitCamelCaseIdentifierTest extends TestCase {
	SplitCamelCaseIdentifier splitter;
	SplitCamelCaseIdentifier splitter2;
	SplitCamelCaseIdentifier splitterLong;
	
	//@Override
	protected void setUp() throws Exception {
		splitter = new SplitCamelCaseIdentifier("displayGUIWindow");
		splitter2 = new SplitCamelCaseIdentifier("DisplayGUIWindow");
		splitterLong = new SplitCamelCaseIdentifier("nowIsTheWINTEROfOURDiscontent");
	}
	
	public void testSplit() {
		Collection<String> words = splitter.split();
		checkContents(words, new String[]{"display","gui","window"});
	}
	
	public void testSplit2() {
		Collection<String> words = splitter2.split();
		checkContents(words, new String[]{"display","gui","window"});
	}
	
	public void testSplitLong() {
		Collection<String> words = splitterLong.split();
		checkContents(words, new String[]{"now","is","the","winter","of","our","discontent"});
	}

	private void checkContents(Collection<String> words, String[] expected) {
		Assert.assertEquals(words.size(), expected.length);
		for (int i = 0; i < expected.length; ++i) {
			Assert.assertTrue(words.contains(expected[i]));
		}
	}
}
