import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void HelloWordSelenium() {
        // Inicialize o WebDriverManager para configurar automaticamente o driver do Chrome
        WebDriverManager.chromedriver().setup();

        // Crie uma instância do WebDriver para o Chrome
        WebDriver browser = new ChromeDriver();

        // Navegue até a página desejada
        browser.navigate().to("http://localhost:8080/leiloes");

        // Feche o navegador quando terminar
        browser.quit();
    }
}