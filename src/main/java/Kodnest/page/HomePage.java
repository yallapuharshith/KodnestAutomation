package Kodnest.page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private TakesScreenshot ts;
    
    private By ChatwithBroKodButton = By.className("ExploreNow");
    private By ChatInterface = By.className("bro-kod-text-gradient");
    private By HistoryButton = By.xpath("//button[contains(@class,'items-center')]//span[text() = 'History']");
    private By NewChatButton = By.xpath("//span[text() = 'New Chat']");
    private By ChatInput = By.cssSelector("textarea[placeholder = 'Start your chat with BroKod...']");
    private By HistoryTab = By.xpath("(//div[@role = 'dialog'])[2]");
    private By HistoryTabClose = By.xpath("//span[text() = 'Create Session']");
    private By SendButton = By.className("lucide-arrow-up");
    private By Greeting = By.xpath("//div[text() = 'Hello World!']");
    private By KodChatClose = By.cssSelector("button[class='absolute text-textColor right-4 top-4 rounded-sm opacity-70 ring-offset-background transition-opacity hover:opacity-100 focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2 disabled:pointer-events-none data-[state=open]:bg-secondary'] svg");
    private By LiveClassNextButton = By.cssSelector("button[aria-label='Next live course']");
    private By LiveClassPrevButton = By.cssSelector("button[aria-label='Previous live course']");
    private By SelfPlacedCourseNextButton = By.cssSelector("button[aria-label='Next self-paced course']");
    private By SelfPlacedCoursePrevButton = By.cssSelector("button[aria-label='Previous self-paced course']");
    private By PracticeNextButton = By.cssSelector("button[aria-label='Next practice item']");
    private By PracticePrevButton = By.cssSelector("button[aria-label='Previous practice item']");
    private By AttendanceNextButton = By.cssSelector("button[aria-label='Next attendance card']");
    private By AttendancePrevButton = By.cssSelector("button[aria-label='Previous attendance card']");
    private By PendingActionsNextButton = By.cssSelector("button[aria-label='Next pending action']");
    private By PendingActionsPrevButton = By.cssSelector("button[aria-label='Previous pending action']");
    private By RecentPlacedStudentsNextButton = By.cssSelector("button[aria-label='Next item']");
    private By RecentPlacedStudentsPrevButton = By.cssSelector("button[aria-label='Previous item']");
    private By TestimonialNextButton = By.cssSelector("button[aria-label='Next for you item']");
    private By TestimonialPrevButton = By.cssSelector("button[aria-label='Previous for you item']");
    private By DarkMode = By.className("lucide-moon");
    private By LightMode = By.className("lucide-sun");
    private By ViewSyllabusButton = By.id("view-syllabus-button-43f28c27-221c-4c7f-a9a7-a6bb8184bb61");
    private By SelfPlacedContinueButton = By.className("lucide-circle-play");
    private By ViewProblemsButton = By.className("lucide-book-open");
    private By PracticeContinueButton = By.className("lucide-arrow-right");
    private By ProfilePic = By.cssSelector("button[role='menuitem']");
    private By CourseContinueButton = By.id("start-course-button-43f28c27-221c-4c7f-a9a7-a6bb8184bb61");
    private By Syllabus = By.xpath("//p[text() = 'Syllabus']");
    private By ModuleName = By.id("module-name");
    private By ViewFullSyllabus = By.id("view-syllabus-btn");
    private By TopicName = By.id("topic-name");
    private By CloseTopicTab = By.xpath("//span[text() = 'Close']");
    private By NextButton = By.id("next-button");
    private By ResetButton = By.id("reset-code-btn");
    private By ThemeSwitch = By.id("theme-switch");
    private By ExpandButton = By.id("expand-btn");
    private By KodnestLogo = By.cssSelector("img[src='/icon-192x192.png']");
    private By Unsolved = By.xpath("//span[text() = 'Unsolved']");
    private By Solved = By.xpath("//span[text() = 'Solved']");
    private By ProblemsNext = By.xpath("//button[text() = 'Next']");
    private By ProblemsPrev = By.xpath("//button[text() = 'Previous']");
    private By ViewReportButton = By.xpath("//span[text() = 'View']");
    private By StartPracticeButton = By.xpath("//span[text() = 'Start']");
    private By PendingButton = By.className("lucide-chevron-right");
    private By DriveDetailsClose = By.xpath("//span[text() = 'Close']");
    private By DriveLink = By.xpath("//button[text() = 'Click']");
    private By ProfileButton = By.xpath("//span[text() = 'My Account']");
    private By ProfileInfoEdit = By.xpath("//button[text() = 'Edit']");
    private By SavePersonalInfo = By.xpath("//button[text() = 'Save']");
    private By ClosePersonalInfo = By.xpath("//span[text() = 'Close']");
    private By GenericDetailsEdit = By.xpath("(//button[text() = 'Edit'])[2]");
    private By CareerGap = By.xpath("(//select[@aria-hidden= 'true'])[1]");
    private By CurrentState = By.xpath("(//select[@aria-hidden= 'true'])[2]");
    private By CurrentCity = By.xpath("(//select[@aria-hidden= 'true'])[3]");
    private By PreferredLoc = By.xpath("//div[@class='flex items-center justify-between']//*[name()='svg']");
    private By CloseGenericDetails = By.xpath("//span[text() = 'Close']");
    private By AttendanceTab = By.xpath("//span[text() = 'Attendance']");
    private By SubscriptionTab = By.xpath("//span[text() = 'Subsciption']");
    private By ReferralTab = By.xpath("//span[text() = 'Referral']");
    private By CertificateTab = By.xpath("//span[text() = 'Certificate']");
    private By ProfileBackBtn = By.className("back-btn");
    private By KodNestButton = By.id("header-logo");
    private By Home = By.xpath("//span[text() = 'Home']");
    private By Logout = By.xpath("//span[text() = 'Log Out']");
    private By LoginButton = By.id("login-submit-button");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
        this.ts = (TakesScreenshot) driver;
		
    }

    // ----- BroKod chat -----

    public void ClickBroKodButton() {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(ChatwithBroKodButton));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
    }

    public boolean validatechatscreen() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ChatInterface)).isDisplayed();
    }

    public boolean IsHistorybuttonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(HistoryButton)).isDisplayed();
    }

    public boolean IsNewChatbuttonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NewChatButton)).isDisplayed();
    }

    public boolean IsChatInputDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ChatInput)).isDisplayed();
    }

    public void ClickHistoryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(HistoryButton)).click();
    }

    public boolean IsHistoryTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(HistoryTab)).isDisplayed();
    }

    public void CloseHistoryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(HistoryTabClose)).click();
    }

    public void ChatInput(String text) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(ChatInput));
        input.click();
        input.clear();
        input.sendKeys(text);
    }

    public void ChatSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SendButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Greeting));
    }

    public boolean Greet() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Greeting)).isDisplayed();
    }

    public void closeKodChat() {
        WebElement closeBtn =
            wait.until(ExpectedConditions.visibilityOfElementLocated(KodChatClose));

        try {
            closeBtn.click();   // try normal click first
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true}));", closeBtn);
        }
    }

    // ----- Carousels & navigation -----

    public void ClickLiveClassNext() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(LiveClassNextButton));
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
        
    }

    public void ClickLiveClassPrev() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(LiveClassPrevButton));
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
    }

    public void ClickSelfPlacedCourseNextButton() {
        WebElement el  = wait.until(ExpectedConditions.elementToBeClickable(SelfPlacedCourseNextButton));
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
    }

    public void ClickSelfPlacedCoursePrevButton() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(SelfPlacedCoursePrevButton));
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
    }

    public void ClickPracticeNextButton() {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(PracticeNextButton));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", el);
    }

    public void ClickPracticePrevButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PracticePrevButton)).click();
    }

    public void ClickAttendanceNextButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(ChatwithBroKodButton));
    	
    	WebElement AttendanceNext = wait.until(ExpectedConditions.presenceOfElementLocated(AttendanceNextButton));
    	((JavascriptExecutor) driver)
    		.executeScript("arguments[0].scrollIntoView()", AttendanceNext);
    	((JavascriptExecutor) driver)
    		.executeScript("arguments[0].click()", AttendanceNext);
    	//action.moveToElement(AttendanceNext).perform();
        //wait.until(ExpectedConditions.elementToBeClickable(AttendanceNextButton)).click();
    }

    public void ClickAttendancePrevButton() {
    		WebElement AttendancePrev = driver.findElement(AttendancePrevButton);
        	JavascriptExecutor js = (JavascriptExecutor)driver;
        	js.executeScript("arguments[0].scrollIntoView()", AttendancePrev);
        	js.executeScript("arguments[0].click()", AttendancePrev);
    }

    public void ClickRecentPlacedStudentsNextButton() {
    	 WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(RecentPlacedStudentsNextButton));
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].click();", el);
    }

    public void ClickRecentPlacedStudentsPrevButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RecentPlacedStudentsPrevButton)).click();
    }

    public void ClickPendingActionsNextButton() {
    	 WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(PendingActionsNextButton));
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].click();", el);
    }

    public void ClickPendingActionsPrevButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PendingActionsPrevButton)).click();
    }

    public void ClickTestimonialNextButton() {
    	 WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(TestimonialNextButton));
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
         ((JavascriptExecutor) driver)
             .executeScript("arguments[0].click();", el);
    }

    public void ClickTestimonialPrevButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TestimonialPrevButton)).click();
    }

    // ----- Other actions -----

    public void ClickDarkMode() {
        wait.until(ExpectedConditions.elementToBeClickable(DarkMode)).click();
    }

    public void ClickLigtMode() {
        wait.until(ExpectedConditions.elementToBeClickable(LightMode)).click();
    }

    public void ClickViewSyllabus() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement Syllabus = wait.until(ExpectedConditions.elementToBeClickable(ViewSyllabusButton));
		js. executeScript ("arguments[0].click();",Syllabus);
        WebElement Cont = wait.until(ExpectedConditions.elementToBeClickable(CourseContinueButton));
		js.executeScript("arguments[0].click();",Cont);
        wait.until(ExpectedConditions.elementToBeClickable(ModuleName)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewFullSyllabus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CourseContinueButton)).click();
        WebElement Topic = wait.until(ExpectedConditions.elementToBeClickable(TopicName));
		js.executeScript("arguments[0].click();",Topic);
        wait.until(ExpectedConditions.elementToBeClickable(ViewFullSyllabus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CourseContinueButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ThemeSwitch)).click();
        driver.findElement(ResetButton).click();
        driver.findElement(ExpandButton).click();
        driver.findElement(KodnestLogo).click();
    }
    
    public boolean ValidateSyllabusHeader() {
    	return driver.findElement(Syllabus).isDisplayed();
    }
    
    public void ClickSelfPlaceContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(SelfPlacedContinueButton)).click();
    }

    public void ClickViewProblems() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.elementToBeClickable(ViewProblemsButton)).click();
        
        //driver.findElement(ProblemsNext).click();
        //driver.findElement(ProblemsPrev).click();
        wait.until(ExpectedConditions.elementToBeClickable(Unsolved)).click();
        driver.findElement(Solved).click();
        driver.findElement(ViewReportButton).click();
        WebElement HomeButton = driver.findElement(Home);
        
        js.executeScript("arguments[0].click();", HomeButton);
        //driver.findElement(StartPracticeButton).click();
        
    }

    public void ClickPracticeContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PracticeContinueButton)).click();
    }
    
    public void ClickOnProfileImage() {
    	driver.findElement(ProfilePic).click();
    	File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\harsh\\Downloads\\SeleniumScreenshots\\Kodnest.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void clickprofile() {
    	driver.findElement(ProfileButton).click();
    }
    
    public void editProfileInfo() {
    	wait.until(ExpectedConditions.elementToBeClickable(ProfileInfoEdit)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(SavePersonalInfo));
    	WebElement Save = driver.findElement(SavePersonalInfo);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", Save);
    	WebElement Close = driver.findElement(ClosePersonalInfo);
    	js.executeScript("arguments[0].click()", Close);
    }
    
    public void editGenericDetails() throws InterruptedException {
    	driver.findElement(GenericDetailsEdit).click();
    	wait.until(ExpectedConditions.elementToBeClickable(CareerGap));
    	WebElement Gap  = driver.findElement(CareerGap);
		Select dropdown1 = new Select(Gap);
		Thread.sleep(2000);
		dropdown1.selectByIndex(1);
		Thread.sleep(2000);
		
    	
    	WebElement CurrState = driver.findElement(CurrentState);
    	Select dropdown3 = new Select(CurrState);
    	Thread.sleep(2000);
    	dropdown3.selectByContainsVisibleText("Andhra Pradesh");
    	Thread.sleep(2000);
    	
    	WebElement CurrCity = driver.findElement(CurrentCity);
    	Select dropdown2 = new Select(CurrCity);
    	Thread.sleep(2000);
    	dropdown1.selectByValue("Nellore");
    	Thread.sleep(2000);
    	
    	WebElement PrefLoc = driver.findElement(PreferredLoc);
    	Select dropdown4 = new Select(PrefLoc);
    	Thread.sleep(3000);
    	dropdown4.selectByContainsVisibleText("Hyderabad");
    	
    	driver.findElement(CloseGenericDetails).click();
    }
    
    public void ProfileDetailsTabNav() {
    	driver.findElement(AttendanceTab).click();
    	driver.findElement(CertificateTab).click();;
    	driver.findElement(SubscriptionTab).click();;
    }
    
    public void CloseProfile() {
    	driver.findElement(ProfileBackBtn).click();;
    }
    
    public void logout() {
    	driver.findElement(Logout).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\harsh\\Downloads\\SeleniumScreenshots\\loginpage.png");
    }
    
}
