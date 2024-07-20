package src.com;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorHtml {

    public List<String> analisarConteudoHtml(String conteudoHtml) {
        List<String> linhasHtml = new ArrayList<>();
        String[] linhas = conteudoHtml.split("\n");
        for (String linha : linhas) {
            if (linha.contains("<") || linha.trim().length() > 0) {
                linhasHtml.add(linha.trim());
            }
        }
        return linhasHtml;
    }
}
