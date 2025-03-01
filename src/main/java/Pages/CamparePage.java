package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CamparePage extends PageBase{

	public CamparePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css="a.clear-list")
	WebElement clearList;
	
	@FindBy(css="table.compare-products-table")
	WebElement campareTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCol;
	
	@FindBy(css="div.no-data")
	WebElement noDataLbl;
	
	/*@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement asusProduct;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement macProduct;*/
	
	public void clearCampareList()
	{
		ClickButton(clearList);
	}
	
	
	public void campareProducts()
	{
		//get all rows
		System.out.println(allRows.size());
		
		//get data from each Row
		for (WebElement row : allRows)
		{
			System.out.println(row.getText() + "\t");
			for(WebElement col : allCol)
			{
				System.out.println(col.getText() +"\t");
			}
		}
	}
}
