import org.testng.annotations.Test;

public class SampleTest1 extends Library
{
	private String[] categories =  {"Bulk Import","Catalog","Push Notifications","Crash Logs","Audit","Settings"};
	@Test
	public void TestCatogories() throws Exception
	{
		LogIn();
		ChooseCategories(categories[0]);
		ChooseCategories(categories[1]);
		ChooseCategories(categories[2]);
		ChooseCategories(categories[3]);
		ChooseCategories(categories[4]);
		//ChooseCategories(categories[6]);
		LogOut();
	}
	
}
