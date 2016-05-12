package seleniumjunitwebshop.searchproducts.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.searchproducts.testcases.SearchProductsTest;

@RunWith(Suite.class)
@SuiteClasses({ SearchProductsTest.class })
public class SearchProductsAllTests {

}
