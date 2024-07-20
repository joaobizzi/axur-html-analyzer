package src.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class ProvedorDeConteudoHtml {

    public String obterConteudoHtml(String url) throws IOException {
        URLConnection conexao = new URL(url).openConnection();
        conexao.setRequestProperty("Accept-Charset", "UTF-8");

        try (InputStream inputStream = conexao.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            StringBuilder conteudoHtml = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudoHtml.append(linha).append("\n");
            }
            return conteudoHtml.toString();
        }
    }
}
