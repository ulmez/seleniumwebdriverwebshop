package seleniumjunitwebshop.productcategoryflik.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.productcategoryflik.testcases.ProductCategoryFlikVerifyAllProductCategoriesTest;

@RunWith(Suite.class)
@SuiteClasses({ ProductCategoryFlikVerifyAllProductCategoriesTest.class })
public class ProductCategoryFlikAllTests {

}
