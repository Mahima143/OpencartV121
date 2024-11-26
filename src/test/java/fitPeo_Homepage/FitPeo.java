package fitPeo_Homepage;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo {

	public static void main(String[] args) throws InterruptedException {
		
		try {
		
		    System.out.println("FitPeo Test Execution Started");  
		
			//Initialize the page
	        WebDriver driver = new ChromeDriver();
	        JavascriptExecutor js =(JavascriptExecutor)driver;
	        Actions action = new Actions(driver);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://www.fitpeo.com/");
	        driver.manage().window().maximize();
	        //Navigate to Revenue Calculator
	        driver.findElement(By.linkText("Revenue Calculator")).click();
	        //scroll till the slider
	        WebElement ele = driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-h4.crimsonPro.css-12siehf"));
	        js.executeScript("arguments[0].scrollIntoView();",ele);
	        //Finding the slider
	        WebElement slider = driver.findElement(By.cssSelector(".MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.css-1sfugkh"));
	        //Finding the slider text box
	        WebElement textBox = driver.findElement(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputSizeSmall.css-1o6z5ng"));
	        //Sliding the slider
		    action.clickAndHold(slider)
	            .moveByOffset(94, 0)
	            .release()
	            .perform();  
		    //Passing the value 560 to slider text box
		    js.executeScript(
		    	    "let input = arguments[0];" +
		    	    "let valueSetter = Object.getOwnPropertyDescriptor(input.__proto__, 'value').set;" +
		    	    "valueSetter.call(input, arguments[1]);" + // Update the value
		    	    "input.dispatchEvent(new Event('input', { bubbles: true }));", // Trigger 'input'
		    	    textBox, "560"
		    	);
		    
		    Thread.sleep(1000);
		    //Validating the value 560 for slider
		    if (textBox.getAttribute("value").equals("560")) {
                System.out.println("Slider value updated to 560 successfully.");
            } else {
                System.out.println("Failed to update slider value to 560.");
            }
		    
		    Thread.sleep(1000);
		   //Passing the value 820 to slider text box for obtaining 110700 validation for Reimbursement
            js.executeScript(
		    	    "let input = arguments[0];" +
		    	    "let valueSetter = Object.getOwnPropertyDescriptor(input.__proto__, 'value').set;" +
		    	    "valueSetter.call(input, arguments[1]);" + // Update the value
		    	    "input.dispatchEvent(new Event('input', { bubbles: true }));", // Trigger 'input'
		    	    textBox, "820"
		    	);
            
            Thread.sleep(1000);
		   	//Checking Check-boxes CPT-99091,99453,99454 and 99474
            List<WebElement> divElements = driver.findElements(By.cssSelector("div.MuiBox-root.css-1eynrej"));
            for (WebElement div : divElements) {
               
                    WebElement pElement = div.findElement(By.cssSelector("p.MuiTypography-root.MuiTypography-body1.inter.css-1s3unkt"));

                    String actualValue = pElement.getText();

                    if(actualValue.equals("CPT-99091")) {
                        WebElement cbox = div.findElement(By.cssSelector("input.PrivateSwitchBase-input.css-1m9pwf3"));

                        cbox.click();
                        Thread.sleep(1000);
                    }
                    
                    if(actualValue.equals("CPT-99453")) {
                        WebElement cbox1 = div.findElement(By.cssSelector("input.PrivateSwitchBase-input.css-1m9pwf3"));

                        cbox1.click();
                        Thread.sleep(1000);
                    }
                    
                    if(actualValue.equals("CPT-99454")) {
                        WebElement cbox2 = div.findElement(By.cssSelector("input.PrivateSwitchBase-input.css-1m9pwf3"));

                        cbox2.click();
                        Thread.sleep(1000);
                    }
                    
                    if(actualValue.equals("CPT-99474")) {
                        WebElement cbox3 = div.findElement(By.cssSelector("input.PrivateSwitchBase-input.css-1m9pwf3"));

                        cbox3.click();
                        Thread.sleep(1000);
                    }
                    

                }
            String Header1ActualHeaderValue="Total Recurring Reimbursement for all Patients Per Month:";
            
            String Header2ActualHeaderValue="$110700";
            
            //Validating if Total Recurring Reimbursement for all Patients Per Month: $110700 is displayed
            
            List<WebElement> divElements2 = driver.findElements(By.cssSelector("p.MuiTypography-root.MuiTypography-body2.inter.css-1xroguk"));
            
            for (WebElement div : divElements2) {          	
                 String Header1 = div.getText();
                 
                 
                 if(Header1.contains(Header1ActualHeaderValue)){
                	 WebElement pHeader2 = div.findElement(By.cssSelector("p.MuiTypography-root.MuiTypography-body1.inter.css-1bl0tdj"));
                     
                     String Header2 = pHeader2.getText();
                     
                     if(Header2.contains(Header2ActualHeaderValue)){
                    	 
                    	 System.out.println(Header1ActualHeaderValue+ Header2 + " is displayed is " + pHeader2.isDisplayed());                  	 
    	 
                     }
                     
                	 
                 }
                 	
            }
        driver.quit();
        
        System.out.println("FitPeo Test Execution Ended");   
		}
		catch (Exception E){
			 System.out.println("Error while performing Test");
	         E.printStackTrace();
		}
	}

}
