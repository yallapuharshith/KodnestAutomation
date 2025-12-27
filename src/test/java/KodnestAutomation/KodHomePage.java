package KodnestAutomation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Kodnest.page.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class KodHomePage extends BaseTest{
	HomePage homepage;
	String ChatInput;
	//WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)  // Changed from @BeforeClass
	@Parameters("ChatInput")
	public void init(String ChatInput) {
		//Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		homepage = new HomePage(driver);
		this.ChatInput = ChatInput;
	}
	
	@Test(priority = 1, groups = {"regression"})
    @Description("Verify BroKod chat screen loads with all essential UI components")
    @Severity(SeverityLevel.CRITICAL)
    @Story("KodChat Core UI Validation")
	public void testBroKod() {
		homepage.ClickBroKodButton();
		boolean[] actual = {homepage.validatechatscreen(),homepage.IsHistorybuttonVisible(),homepage.IsNewChatbuttonVisible(),homepage.IsChatInputDisplayed()};
		boolean[] expected = {true,true,true,true};
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority = 2,groups = {"regression"})
    @Description("Verify History tab opens and closes correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("KodChat History Validation")
	public void testHistoryTab() {
		homepage.ClickHistoryButton();
		Assert.assertEquals(homepage.IsHistoryTabDisplayed(), true);
		homepage.CloseHistoryTab();
	}
	
	@Test(priority = 3,groups = {"regression"})
	@Description("Verify user can enter text in chat input and receive response")
	@Severity(SeverityLevel.CRITICAL)
	@Story("KodChat Message Interaction")
	public void ChatInput() {
		homepage.ChatInput(ChatInput);
		homepage.ChatSendButton();
		Assert.assertEquals(homepage.Greet(), true);
		homepage.closeKodChat();
	}
	
	@Test(priority = 4,groups = {"regression"}, retryAnalyzer = utils.Retry.class)
    @Description("Verify Live Course carousel navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Live Course Navigation")
	public void LiveCourseNavigation() {
		homepage.ClickLiveClassNext();
		homepage.ClickLiveClassPrev();
	}
	
	//@Test(priority = 2)
	@Description("Verify Navigation working as expected for SelfPlacedCourse")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SelfPlacedCourseNavigation")
	public void SelfPlacedCourseNavigation() {
		homepage.ClickSelfPlacedCourseNextButton();
		homepage.ClickSelfPlacedCoursePrevButton();
	}
	
	@Test(priority = 5,groups = {"regression"})
	@Description("Verify user can navigate to View Syllabus screen")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Syllabus Navigation")
	public void ViewSyllabus() {
		homepage.ClickViewSyllabus();
	}
	
	//@Test(priority = 7)
	@Description("Verify user navigates to selfplaced course menu")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SelfPlacedContinue")
	public void SelfPlacedContinue() {
		homepage.ClickSelfPlaceContinue();
	}
	
	@Test(priority = 6, groups = {"regression"})
    @Description("Verify Practice section carousel navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Practice Navigation")
	public void PracticeNavigation() {
		homepage.ClickPracticeNextButton();
		homepage.ClickPracticePrevButton();
	}
	
	@Test(priority = 7, groups = {"regression"})
	@Description("Verify user can navigate to View Problems section")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Problem Navigation")
	public void ViewProblems() {
		homepage.ClickViewProblems();
	}
	
	//@Test(priority = 10)
	@Description("Verify login fails with blank email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Validation")
	public void PracticeContinue() {
		homepage.ClickPracticeContinueButton();
	}
	
	@Test(priority = 8, groups = {"regression"}, retryAnalyzer = utils.Retry.class)
	@Description("Verify Attendance section navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Attendance Navigation" )
	public void AttendanceNavigation() {
		homepage.ClickAttendanceNextButton();
		homepage.ClickAttendancePrevButton();
	}
	
	@Test(priority = 9, groups = {"regression"})
    @Description("Verify Pending Actions carousel navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Pending Course Navigation")
	public void PendingCourseNavigation(){
		homepage.ClickPendingActionsNextButton();
		homepage.ClickPendingActionsPrevButton();
	}
	
	@Test(priority = 10,groups = {"regression"})
    @Description("Verify Recent Placed Students carousel navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Placement Section Navigation")
	public void RecentPlacedStudentsNavigation() {
		homepage.ClickRecentPlacedStudentsNextButton();
		homepage.ClickRecentPlacedStudentsPrevButton();
	}
	
	@Test(priority = 11,groups = {"regression"})
    @Description("Verify Testimonials section navigation works correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Testimonial Navigation")
	public void TestimonialNavigation() {
		homepage.ClickTestimonialNextButton();
		homepage.ClickTestimonialPrevButton();
	}
	
	@Test(priority = 12, groups = {"regression"})
	@Description("Verify user can switch between dark and light themes")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Theme Toggle Validation")
	public void ThemeChange() {
		homepage.ClickDarkMode();
		homepage.ClickLigtMode();
	}
	
	@Test(priority = 13, groups = {"regression","smoke"})
    @Description("Verify user can open profile panel from profile picture")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Profile Access Validation")
	public void ClickProfilePic() throws InterruptedException {
		homepage.ClickOnProfileImage();
		
	}
	@Test(priority = 14, groups = {"regression"})
    @Description("Verify user can edit and navigate through profile details")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Profile Edit Validation")
	public void EditProfile() throws InterruptedException {
		homepage.clickprofile();
		homepage.editProfileInfo();
		homepage.editGenericDetails();
		homepage.ProfileDetailsTabNav();
		homepage.CloseProfile();
	}
	
	@Test(priority = 15, groups = {"smoke"})
	@Description("Verify user can logout successfully from the application")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Logout Validation")
	public void LogOut() {
		homepage.logout();
	}
	
}