package src.com;

import java.io.IOException;
import java.util.List;

public class HtmlAnalyzer {

    private final ProvedorDeConteudoHtml provedorDeConteudoHtml;
    private final AnalisadorHtml analisadorHtml;
    private final ValidadorHtml validadorHtml;
    private final LocalizadorTextoMaisProfundo localizadorTextoMaisProfundo;

    public HtmlAnalyzer(ProvedorDeConteudoHtml provedorDeConteudoHtml, AnalisadorHtml analisadorHtml, ValidadorHtml validadorHtml, LocalizadorTextoMaisProfundo localizadorTextoMaisProfundo) {
        this.provedorDeConteudoHtml = provedorDeConteudoHtml;
        this.analisadorHtml = analisadorHtml;
        this.validadorHtml = validadorHtml;
        this.localizadorTextoMaisProfundo = localizadorTextoMaisProfundo;
    }

    public String analisar(String url) throws IOException {
        String conteudoHtml = provedorDeConteudoHtml.obterConteudoHtml(url);
        List<String> linhasHtml = analisadorHtml.analisarConteudoHtml(conteudoHtml);
        if (validadorHtml.ehHtmlValido(linhasHtml)) {
            return localizadorTextoMaisProfundo.encontrarTextoMaisProfundo(linhasHtml);
        }
        return null;
    }
}
