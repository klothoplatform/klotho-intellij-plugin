package com.cloudcompilers.klotho.language.parsing;

import com.github.cloudcompilers.klotho.language.parsing.KlothoParserDefinition;
import com.intellij.testFramework.ParsingTestCase;

public class KlothoParsingTest extends ParsingTestCase {

  public KlothoParsingTest() {
    super("", "klotho", new KlothoParserDefinition());
  }

  public void testParsingTestData() {
    doTest(true);
  }

  /**
   * @return path to test data file directory relative to root of this module.
   */
  @Override
  protected String getTestDataPath() {
    return "src/test/testData/parsingTestData";
  }

  @Override
  protected boolean skipSpaces() {
    return false;
  }

  @Override
  protected boolean includeRanges() {
    return true;
  }

}
