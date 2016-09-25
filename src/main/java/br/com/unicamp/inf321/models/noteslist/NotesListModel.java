package br.com.unicamp.inf321.models.noteslist;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.List;
import java.util.Random;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.unicamp.inf321.NotesList;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_NotesListView")
public class NotesListModel extends ExecutionContext implements NotesList {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	private static final String TEXT_VIEW_LOCATOR = "android.widget.TextView";
	private static final String LIST_VIEW_LOCATOR = "android.widget.ListView";
	private static final String EDIT_TEXT_LOCATOR = "android.widget.EditText";
	private static final String FIRST_NOTE_LOCATOR = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.ListView[1]/android.widget.TextView[1]";

	public NotesListModel(AndroidDriver<WebElement> driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}


	@Override
	public void e_EditTitle() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MENU);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/title")));
		TouchAction touchAction = new TouchAction(driver);
    	touchAction.tap(895, 1655).perform();
	}

	@Override
	public void e_Discard() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MENU);
		By discardButtonLocator = By.xpath("//*[@text='Discard']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(discardButtonLocator));
		driver.findElement(discardButtonLocator).click();
	}

	@Override
	public void e_GoBack() {
		driver.hideKeyboard();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
	}

	@Override
	public void v_EditNoteView() {
		By editNote = By.xpath("//*[@text='Edit note']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(editNote));
		WebElement notesEditor = driver.findElement(editNote);
		assertThat(notesEditor.isDisplayed()).isTrue();
	}

	@Override
	public void e_GoToNewNoteView() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MENU);
		By AddNote = By.xpath("//*[@text='Add note']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddNote));
		driver.findElement(AddNote).click();
	}

	@Override
	public void e_Create() {
		String locator = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.EditText[1]";
		String noteName = "test+" + new Random().nextInt();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		driver.findElement(By.xpath(locator))
				.sendKeys(noteName);
		driver.hideKeyboard();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
	}

	@Override
	public void e_SelectNote() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_NOTE_LOCATOR)));
		driver.findElement(By.xpath(FIRST_NOTE_LOCATOR)).click();
	}

	@Override
	public void e_Done() {
		driver.hideKeyboard();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
	}

	@Override
	public void v_EditTitleView() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
		assertThat(driver.findElement(By.id("android:id/title")).getText()).contains("Note title:");
	}

	@Override
	public void v_NotesListView() {
		By notePadLocator = By.xpath("//*[@text='Note pad']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(notePadLocator));
		assertThat(driver.findElement(By.id("android:id/title")).getText()).contains("Note pad");

		List<WebElement> notesInList = driver.findElement(By.className(LIST_VIEW_LOCATOR))
				.findElements(By.className(TEXT_VIEW_LOCATOR));	

		int actualNumberOfNotes = notesInList.size();
		String expectedNumberOfNotes = getAttribute("numberOfNotes").toString(); //pega o valor da variavel numberOfNotes do modelo
		assertThat(Double.valueOf(expectedNumberOfNotes).intValue()).isEqualTo(actualNumberOfNotes);
	}

	@Override
	public void v_NewNoteView() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(EDIT_TEXT_LOCATOR)));
		WebElement notesEditor = driver.findElementByClassName(EDIT_TEXT_LOCATOR);
		assertThat(notesEditor.isDisplayed()).isTrue();
	}

	@Override
	public void e_Init() {
		driver.launchApp();
	}

}
