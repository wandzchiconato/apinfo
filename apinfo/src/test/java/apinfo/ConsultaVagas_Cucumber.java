//Pacote

package apinfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;

//Bibliotecas

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//Classe

public class ConsultaVagas_Cucumber {
	
	//Atributos

String baseurl;
WebDriver driver;

//Métodos

@Before
public void Iniciar() {
	baseurl = "http://www.apinfo.com";
	System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Drivers\\Chrome\\chromeDriver74\\chromedriver.exe");
	driver = new ChromeDriver();
	
	
}

	@Given("^Usuario acessa a APInfo$")
	public void usuario_acessa_a_APInfo() throws Throwable {
	    System.out.println("Passo 1 - Acessou o site da Apinfo");
	}

	@When("^pesquiso pela vaga \"([^\"]*)\"$")
	public void pesquiso_pela_vaga(String arg1) throws Throwable {
	   System.out.println("Passo 2 - Efetuou a pesquisa");
	}

	@Then("^Filtro as vagas por Cidade and seleciono \"([^\"]*)\" e clico em \"([^\"]*)\"$")
	public void filtro_as_vagas_por_Cidade_and_seleciono_e_clico_em(String arg1, String arg2) throws Throwable {
		System.out.println("Passo 3 - filtrou por Cidade");
	}

}