package myTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ EntrySetTest.class, MapAdapterTest.class })
public class AllTests {

}
