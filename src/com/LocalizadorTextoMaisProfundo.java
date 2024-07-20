package src.com;

import java.util.List;

public class LocalizadorTextoMaisProfundo {

    public String encontrarTextoMaisProfundo(List<String> html) {
        String textoMaisProfundo = "";
        int profundidadeMaxima = 0;
        int profundidadeAtual = 0;
        for (String elemento : html) {
            if (elemento.startsWith("<")) {
                if (elemento.startsWith("</")) profundidadeAtual--;
                else profundidadeAtual++;
            } else {
                if (profundidadeAtual > profundidadeMaxima) {
                    profundidadeMaxima = profundidadeAtual;
                    textoMaisProfundo = elemento;
                }
            }
        }
        return textoMaisProfundo;
    }
}
