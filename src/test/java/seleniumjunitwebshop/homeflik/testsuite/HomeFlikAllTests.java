package seleniumjunitwebshop.homeflik.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import seleniumjunitwebshop.homeflik.testcases.HomeFlikLatestBlogPostTest;
import seleniumjunitwebshop.homeflik.testcases.HomeFlikProductTest;

@RunWith(Suite.class)
@SuiteClasses({ HomeFlikProductTest.class, HomeFlikLatestBlogPostTest.class })
public class HomeFlikAllTests {

}
