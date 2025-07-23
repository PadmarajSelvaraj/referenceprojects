package com.demo.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils  {
	private WebDriver driver;
	private Actions act;
    private DriverManager drivermanager;
	
    public SeleniumUtils(DriverManager driverManager) {
        this.drivermanager = driverManager;
        this.driver = driverManager.getDriver(); // Use the existing WebDriver instance
    }
	
	  public WebElement waitForElementToBeVisible(WebElement ele) {
	        return drivermanager.getWait().until(ExpectedConditions.visibilityOf(ele));
	    }

	    // Wait for an element to be clickable
	    public WebElement waitForElementToBeClickable(WebElement ele) {
	        return drivermanager.getWait().until(ExpectedConditions.elementToBeClickable(ele));
	    }

	    // Wait for alert to be present
	    public Alert waitForAlert() {
	        return drivermanager.getWait().until(ExpectedConditions.alertIsPresent());
	    }

	   // Wait for an element to have specific text
	    public boolean  waitForElementToHaveText(WebElement element, String text) {
	        return drivermanager.getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
	    }

	

	

	public boolean validateTitle(String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			return actualTitle.equals(expectedTitle);
		} catch (Exception e) {
			System.out.println("Error retrieving the page title: " + e.getMessage());
			return false;
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	// Get text from an element
	public String getText(WebElement ele) {

		return ele.getText();
	}
	
	public boolean validateText(WebElement ele, String expectedtxt) {

		try {
			String actualtxt = ele.getText();
			return expectedtxt.equals(actualtxt);
		} catch (Exception e) {
			System.out.println("Error retrieving the text " + e.getMessage());
			return false;
		}
	}
	

	
	// Check if an element is displayed
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	

	public void clickOnListByText(List<WebElement> items, String itemText) {
		for (WebElement item : items) {
			if (item.getText().equals(itemText)) {
				item.click();
				break; // Exit loop after clicking the item
			}
		}
	}

	public void clickOnListByIndex(List<WebElement> items, String itemText) {
		for (WebElement item : items) {
			if (item.getText().equals(itemText)) {
				item.click();
				break; // Exit loop after clicking the item
			}
		}
	}

	public void enterText(WebElement ele, String txt) {

		
		
		ele.sendKeys(txt);
	}

	public void click(WebElement loginButton) {
		loginButton.click();

	}

	public void scrollUPDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + pixels + ");");
	}

	// Method to scroll up by a certain amount

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollRighLeftt(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + pixels + ", 0);");
	}

	

	// Method to select No radio button
	public void selectRadioButton(WebElement ele) {
		
		if (!ele.isSelected()) {
			ele.click();
		}
	}

	// Method to check if Yes radio button is selected
	public boolean isSelected(WebElement ele) {
		return ele.isSelected();
	}
	
	 public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
	       
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(visibleText);
	    }

	    // Method to select an option from a dropdown by value
	    public void selectDropdownByValue(WebElement dropdownElement, String value) {
	        
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByValue(value);
	    }

	    // Method to select an option from a dropdown by index
	    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
	        
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByIndex(index);
	    }

	    // Method to get the selected option text from a dropdown
	    public String getSelectedOptionText(WebElement dropdownElement) {
	       
	        Select dropdown = new Select(dropdownElement);
	        return dropdown.getFirstSelectedOption().getText();
	    }

	    
	    public List<List<String>> getTableData(WebElement ele) {
	      
	    	List<List<String>> tableData = new ArrayList<>();
	        // Get all rows in the table
	        List<WebElement> rows = ele.findElements(By.xpath(".//tr"));

	        for (WebElement row : rows) {
	            List<String> rowData = new ArrayList<>();
	            // Get all cells in the row
	            List<WebElement> cells = row.findElements(By.xpath(".//td"));

	            for (WebElement cell : cells) {
	                rowData.add(cell.getText()); // Retrieve cell text
	            }

	            if (!rowData.isEmpty()) {
	                tableData.add(rowData); // Add row data to table data
	            }
	        }

	        return tableData;
	    }
	    
	    public List<String> getColumnDataByHeader(WebElement ele, String headerText) {
	        List<String> columnData = new ArrayList<>();

	        

	        // Get all headers (assuming they are in <th> elements)
	        List<WebElement> headers = ele.findElements(By.xpath(".//th"));
	        
	        int columnIndex = -1;

	        // Find the index of the desired column based on header text
	        for (int i = 0; i < headers.size(); i++) {
	            if (headers.get(i).getText().equalsIgnoreCase(headerText)) {
	                columnIndex = i;
	                break;
	            }
	        }

	        // If the column is not found, return an empty list
	        if (columnIndex == -1) {
	            return columnData;
	        }

	        // Get all rows in the table
	        List<WebElement> rows = ele.findElements(By.xpath(".//tr"));

	        for (WebElement row : rows) {
	            // Get all cells in the row
	            List<WebElement> cells = row.findElements(By.xpath(".//td"));
	            if (columnIndex < cells.size()) {
	                String cellText = cells.get(columnIndex).getText(); // Retrieve cell text
	                columnData.add(cellText); // Add cell text to the column data list
	            }
	        }

	        return columnData;
	    }
	    
	    
		public void switchToAlert() {
			try {
				driver.switchTo().alert();

			} catch (NoAlertPresentException e) {
			} catch (WebDriverException e) {

			}
		}
		
		public void acceptAlert() {
			String text = "";
			try {
				drivermanager.getWait().until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
				alert.accept();
				
			} catch (NoAlertPresentException e) {
				
			} catch (WebDriverException e) {
				
			}

		}
		
		protected void dragAndDrop(WebElement eleSoutce, WebElement eleTarget) {
			act = new Actions(driver);
			act.dragAndDrop(eleSoutce, eleTarget).perform();
		}


		protected void hoverOverElement(WebElement element) {
		    act = new Actions(driver);
		    act.moveToElement(element).perform();
		}
		
		protected void rightClick(WebElement element) {
		    act = new Actions(driver);
		    act.contextClick(element).perform();
		}
		
		protected void doubleClick(WebElement element) {
		    act = new Actions(driver);
		    act.doubleClick(element).perform();
		}

        
		protected void switchToFrameByIndex(int index) {
		    driver.switchTo().frame(index);
		}
		
		protected void switchToFrameByName(String nameOrId) {
		    driver.switchTo().frame(nameOrId);
		}
		
		protected void switchToFrameByElement(WebElement frameElement) {
		    driver.switchTo().frame(frameElement);
		}
		
		protected void switchToDefaultContent() {
		    driver.switchTo().defaultContent();
		}
		
		protected void switchToParentFrame() {
		    driver.switchTo().parentFrame();
		}
		
		protected int getTotalFrames() {
		    return driver.findElements(By.tagName("iframe")).size();
		}
		
		protected void switchToFrameDynamically(int timeoutInSeconds) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		    List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		    for (WebElement frame : frames) {
		        try {
		            driver.switchTo().frame(frame);
		            System.out.println("Switched to frame successfully.");
		            return;
		        } catch (Exception e) {
		            System.out.println("Frame not found, trying next...");
		        }
		    }
		}
		
		
	
}
