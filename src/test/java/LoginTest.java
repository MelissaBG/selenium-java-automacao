
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){

        this.paginaDeLogin = new LoginPage();
    }

    //Fecha a página
    @AfterEach
    public void afterEach(){

        this.paginaDeLogin.fecharPagina();
    }


    //Objetivo do teste: Testar do ponto de vista do usuario se a funcionalidade de login está funcionando corretamente.(Auntenticação)
    @Test
    public void deveriaEfetuarLoginComDadosValidos(){

        paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuarLogin();
        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin()); //Verificando se estou na página de Login.
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    //Objetivo do teste: Testar um usuário inválido. (Auntenticação)
    @Test
    public void efetuarLoginComDadosInvalidos(){
        paginaDeLogin.preencherFormularioDeLogin("invalido", "123");
        paginaDeLogin.efetuarLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin()); //Verificando se estou na página de Login.
        Assert.assertNull("fulano", paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos"));
    }
    //Objetivo do teste:Acessar um recurso restrito.(Autorização)
    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}