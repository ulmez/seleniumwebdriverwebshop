import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.addtocart.testsuite.AddToCartAllTests;
import seleniumjunitwebshop.homeflik.testsuite.HomeFlikAllTests;
import seleniumjunitwebshop.productcategoryflik.testsuite.ProductCategoryFlikAllTests;
import seleniumjunitwebshop.productpages.testsuite.ProductPagesAllTests;
import seleniumjunitwebshop.searchproducts.testsuite.SearchProductsAllTests;

@RunWith(Suite.class)
@SuiteClasses({ HomeFlikAllTests.class, ProductPagesAllTests.class, ProductCategoryFlikAllTests.class, SearchProductsAllTests.class, AddToCartAllTests.class })
public class AllTests {

}
