package seleniumjunitwebshop.checkoutyourcart.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.checkoutyourcart.testcases.CheckoutYourCartTest;

@RunWith(Suite.class)
@SuiteClasses({ CheckoutYourCartTest.class })
public class CheckoutYourCartAllTests {

}
