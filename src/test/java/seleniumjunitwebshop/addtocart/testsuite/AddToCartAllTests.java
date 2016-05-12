package seleniumjunitwebshop.addtocart.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.addtocart.testcases.AddToCartTest;

@RunWith(Suite.class)
@SuiteClasses({ AddToCartTest.class })
public class AddToCartAllTests {

}
