package src.com;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorHtml {

    public boolean ehHtmlValido(List<String> html) {
        Stack<String> pilha = new Stack<>();
        Pattern padraoTag = Pattern.compile("<(/\\w+).*?>|<\\w+>");
        for (String linha : html) {
            Matcher matcher = padraoTag.matcher(linha);
            if (matcher.matches()) {
                String tag = matcher.group(0).toLowerCase();
                if (tag.startsWith("</")) {
                    if (pilha.isEmpty()) return false;
                    String tagAbertura = pilha.pop();
                    if (!tag.substring(2).equals(tagAbertura.substring(1))) return false;
                } else pilha.push(tag);
                continue;
            }
            if (linha.startsWith("<") && linha.endsWith(">")) return false;
        }
        return pilha.isEmpty();
    }
}
