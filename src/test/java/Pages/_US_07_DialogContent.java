package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _US_07_DialogContent extends _US_00_Parent {
    WebElement myElement;

    public _US_07_DialogContent() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h3[text()='  Notifications ']")
    private WebElement notificationsCheck;
    @FindBy(xpath = "//ms-add-button//button//span")
    private WebElement addButton;
    @FindBy(xpath = "//ms-text-field//input")
    private WebElement nameInput;
    @FindBy(xpath = "(//mat-select//div)[3]")
    private WebElement typeButton;
    @FindBy(xpath = "//span[text()=' Upcoming Payment Deadline ']")
    private WebElement paymentDeadline;
    @FindBy(xpath = "//span[text()=' Examination Result ']")
    private WebElement examinationResult;
    @FindBy(xpath = "//mat-form-field//textarea")
    private WebElement description;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement Save;
    @FindBy(xpath = "(//button//fa-icon)[4]")
    private WebElement backButton;
    @FindBy(xpath = "//mat-form-field//input")
    private WebElement searchName;
    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;
    @FindBy(xpath = "(//ms-table//td)[2]")
    private WebElement nameSearcControl;
    @FindBy(xpath = "// ms-edit-button//button")
    private WebElement editButton;


    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement yesButton;


    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//ms-delete-button/button")
    private List<WebElement> deleteBtnList;

    @FindBy(xpath = "//ms-delete-button/button")
    public WebElement deleteButton;


    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement forwardButton;

    @FindBy(xpath = "//ms-edit-button/button")
    public List<WebElement> editBtnList;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement msjContainer;

    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//div[@fxlayoutalign='start center']")
    private WebElement forTimeOut; // dashboard'da tiklayarak liste elemani gelene kadar zaman kazaniyor

    public void findElementAndClickFunction(String ElementName) {
        switch (ElementName) {
            case "addButton":
                myElement = addButton;
                break;
            case "typeButton":
                myElement = typeButton;
                break;
            case "paymentDeadline":
                myElement = paymentDeadline;
                break;
            case "examinationResult":
                myElement = examinationResult;
                break;
            case "description":
                myElement = description;
                break;
            case "Save":
                myElement = Save;
                break;
            case "backButton":
                myElement = backButton;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "editButton":
                myElement = editButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "yesButton":
                myElement = yesButton;
                break;

            case "forTimeOut":
                myElement = forTimeOut;
                break;
        }
        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {
        switch (ElementName) {
            case "nameInput":
                myElement = nameInput;
                break;
            case "description":
                myElement = description;
                break;
            case "searchName":
                myElement = searchName;
                break;

    }
        sendKeysFunction(myElement, value);
    }

    public void findElementAndVerifyContainsText(String ElementName, String msg) {
        switch (ElementName) {
            case "msjContainer":
                myElement = msjContainer;
                break;

            case "ErrorMessage":
                myElement = ErrorMessage;
                break;
            case "notificationsCheck":
                myElement = notificationsCheck;
                break;
            case "nameSearcControl":
                myElement = nameSearcControl;
                break;
        }
        verifyElementContainsText(myElement,msg);
    }

    public void findElementAndDeleteFunction(String deleteName) {

        editOrDelete(deleteBtnList, deleteName);
    }

    public void findElementAndEditFunction(String editName) {
        editOrDelete(editBtnList, editName);
    }

    public void editOrDelete(List<WebElement> element, String name) {
        int i = 0;
        int returnNum = 0;
        boolean key = false;

        clickFunction(forTimeOut); // dashboard'da tiklayarak liste elemani gelene kadar zaman kazaniyor

        if (nameList.size() != 0) {
            String currentName = "";

            //waitVisibleListAllElement(myListElement);
            do {
                if (i == 0 && key == true) {
                    clickFunction(forTimeOut); //dashboard'da tiklayarak liste elemani gelene kadar zaman kazaniyor
                }
                currentName = nameList.get(i).getText();
                WebElement elm = element.get(i);
                i++;

                if (name.equalsIgnoreCase(currentName)) {
                    System.out.println(elm);
                    clickFunction(elm);
                    break;
                }
                if (i == 10 && forwardButton.isEnabled()) {
                    i = 0;
                    clickFunction(forwardButton);
                    key = true;
                }

            } while (!name.equals(currentName) && i < nameList.size());

        } else {
            System.out.println(" silinecek eleman bulunamadi....");
        }
    }

}
