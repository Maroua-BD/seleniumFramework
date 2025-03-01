package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	public Actions action;
	public JavascriptExecutor jse;
	public Select select;
	
	//création du constructeur 
	
	public  PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	protected static void ClickButton (WebElement button)
	{
		button.click();
	}

	protected static void setTextElement(WebElement txtElemt, String value )
	{
		txtElemt.sendKeys(value);
	}
	
	public void scrollToBottom()
	{
		//fct javascript permettant de scroller à la fin de la page
		jse.executeScript("scrollBy(0,2500)");
	}
}
