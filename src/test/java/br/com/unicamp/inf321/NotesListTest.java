package br.com.unicamp.inf321;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.FileSinkImages.RendererType;
import org.graphstream.stream.file.FileSinkImages.Resolutions;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedEdge;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.event.Observer;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.CombinedPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.java.test.Result;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.unicamp.inf321.helper.GraphWalkerTestBuilder;
import br.com.unicamp.inf321.models.noteslist.NotesListModel;
import br.com.unicamp.inf321.observers.GraphStreamObserver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NotesListTest {
	public final static Path MODEL_PATH = Paths.get("/br/com/unicamp/inf321/NotesList.graphml");
	private static AndroidDriver<WebElement> driver;
	private Observer observer;
	private Graph graph;

	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void beforeTest() {
		// fecha aplicativo antes de cada teste
		driver.closeApp();
		//reseta aplicativo antes de cada teste
		driver.resetApp();
		// cria observer para habilitar execução do modelo animado
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		graph = new MultiGraph(NotesListTest.class.getSimpleName() + "_" + testName.getMethodName());
		graph.display(true);
		observer = new GraphStreamObserver(graph);
	}

	@After
	public void afterTest() throws Exception {
		//Capture screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./screenshots/Android_" + NotesListTest.class.getSimpleName() + "_" + testName.getMethodName()+ ".jpg"));
		//gera screenshot do modelo animado
		FileSinkImages pic = new FileSinkImages(OutputType.JPG, Resolutions.HD720);
		pic.setLayoutPolicy(LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
		pic.setRenderer(RendererType.SCALA);
		pic.stabilizeLayout(1);
		pic.setAutofit(true);
		pic.writeAll(graph, "screenshots/Graph_" + NotesListTest.class.getSimpleName() + "_" + testName.getMethodName() + ".jpg");
	}
	
	@BeforeClass
	public static void setup() {
		//seta os capabilities do android driver 
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "src/main/resources");
		File app = new File(appDir, "Notepad.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "	com.example.android.notepad");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".NotesList");
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, "true"); //disable soft keyboard
		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //inicia android driver passando url do server do appium
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.rotate(ScreenOrientation.PORTRAIT); //rotaciona tela
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //seta timeout implicito (sempre vai esperar no minimo 5 segundos pelo elemento na tela)
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void runSmokeTest() {
		CombinedPath cp = new CombinedPath();
		cp.addPathGenerator(new AStarPath(new ReachedEdge("e_Create")));
		cp.addPathGenerator(new AStarPath(new ReachedVertex("v_EditTitleView")));
		cp.addPathGenerator(new AStarPath(new ReachedVertex("v_EditNoteView")));
		
		Result result = new GraphWalkerTestBuilder()
				.addModel(MODEL_PATH,
						cp, new NotesListModel(driver))
				.addObserver(observer) //adicona observer para ver execução do modelo animada
				.execute(true);
		Assertions.assertThat(result.getErrors()).as("Errors: [" + String.join(", ", result.getErrors()) + "]").isNullOrEmpty();
	}
	
	@Test
	public void runStabilityTest() {
		Result result = new GraphWalkerTestBuilder()
				.addModel(MODEL_PATH,
						new RandomPath(new TimeDuration(60, TimeUnit.SECONDS)), "e_Init", new NotesListModel(driver))
				.addObserver(observer) //adicona observer para ver execução do modelo animada
				.execute(true);
		Assertions.assertThat(result.getErrors()).as("Errors: [" + String.join(", ", result.getErrors()) + "]").isNullOrEmpty();
	}

	@Test
	public void runFunctionalTest() {
		Result result = new GraphWalkerTestBuilder()
				.addModel(MODEL_PATH, new RandomPath(new EdgeCoverage(100)), "e_Init", new NotesListModel(driver))
				.addObserver(observer) //adicona observer para ver execução do modelo animada
				.execute(true);
		Assertions.assertThat(result.getErrors()).as("Errors: [" + String.join(", ", result.getErrors()) + "]").isNullOrEmpty();
	}

}
