package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="small-searchterms")
	WebElement SearchTextBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement serchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextElement(SearchTextBox, productName);
		ClickButton(serchBtn);
			
	}
	
	public void openProductDetailsPage()
	{
		ClickButton(productTitle);
	}
	
	public void searchProductUsingAutoSuggest(String SearchTxt) 
	{
		setTextElement(SearchTextBox, SearchTxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//clic sur le 1er elemt de la liste autocomplite 
		ProductList.get(0).click();
	}
	
}
