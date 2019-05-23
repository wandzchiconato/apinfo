//Pacote

package apinfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.java.After;
import cucumber.api.java.Before;

//Bibliotecas

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//Classe

public class ConsultaVagas_Cucumber {

	// Atributos

	String baseurl;
	WebDriver driver;
	String pastaPrint = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\Wandz\\git\\apinfo\\apinfo\\target\\evidencias\\" + pastaPrint
				+ "\\" + nomePrint + ".png"));

	}

//Métodos

	@Before
	public void Iniciar() {
		baseurl = "http://www.apinfo.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\drivers\\chrome\\74\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void Finalizar() {
		driver.quit();
		
	}

	@Given("^Usuario acessa a APInfo$")
	public void usuario_acessa_a_APInfo() throws Throwable {
		driver.get(baseurl);
		System.out.println("Passo 1 - Acessou o site da Apinfo");
		Print("01 - Passo 1 - acessa o site");
	}

	@When("^pesquiso pela vaga \"([^\"]*)\"$")
	public void pesquiso_pela_vaga(String arg1) throws Throwable {
		driver.findElement(By.id("i-busca")).clear();
		driver.findElement(By.id("i-busca")).sendKeys(Keys.chord(arg1));
		driver.findElement(By.id("i-busca")).sendKeys(Keys.ENTER);
		System.out.println("Passo 2 - Efetuou a pesquisa");
		Print("02 - Passo 2 - efetua a pesquisa");
	}

	@Then("^Filtro as vagas por Cidade and seleciono \"([^\"]*)\" e clico em \"([^\"]*)\"$")
	public void filtro_as_vagas_por_Cidade_and_seleciono_e_clico_em(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("estado[]")).click();
		driver.findElement(By.name("cod_cidade[]")).click();
		driver.findElement(By.xpath("(//input[@name='cod_cidade[]'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='cod_cidade[]'])[7]")).click();
		driver.findElement(By.name("cargo2cod[]")).click();
		driver.findElement(By.xpath("(//input[@name='cargo2cod[]'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='cargo2cod[]'])[3]")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		System.out.println("Passo 3 - filtrou por Cidade");
		Print("03 - Passo 3 - Filtra por cidade");
		
	}

}