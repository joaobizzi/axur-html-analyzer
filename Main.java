import src.com.*;
import src.com.ProvedorDeConteudoHtml;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <URL>");
            return;
        }

        String url = args[0];

        ProvedorDeConteudoHtml provedorDeConteudoHtml = new ProvedorDeConteudoHtml();
        HtmlAnalyzer analisador = new HtmlAnalyzer(provedorDeConteudoHtml, new AnalisadorHtml(), new ValidadorHtml(), new LocalizadorTextoMaisProfundo());

        try {
            String textoMaisProfundo = analisador.analisar(url);
            System.out.println(textoMaisProfundo != null ? textoMaisProfundo : "HTML malformado");
        } catch (IOException e) {
            System.out.println("Erro de conexão com a URL");
        }
    }
}
