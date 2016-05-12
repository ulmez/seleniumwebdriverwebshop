package seleniumjunitwebshop.productpages.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.productpages.testcases.ProductPagesVerifyProductWithStarsTest;
import seleniumjunitwebshop.productpages.testcases.ProductPagesVerifyTheProductPageContainsTest;

@RunWith(Suite.class)
@SuiteClasses({ ProductPagesVerifyTheProductPageContainsTest.class, ProductPagesVerifyProductWithStarsTest.class })
public class ProductPagesAllTests {

}
