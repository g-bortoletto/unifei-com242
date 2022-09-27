package br.edu.unifei.com242.minicurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Functionality {

    public static String respostaMensagemTexto(String mensagemTexto) {
        return "Recebido \'" + mensagemTexto + "\'";
    }

    public static void alteraArquivoTexto(String caminhoArquivo, String alteracao) throws IOException {
        try {
            Files.write(Paths.get(caminhoArquivo), alteracao.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bhaskara(Double c1, Double c2) {
        Double result = Math.sqrt((c1 * c1) + (c2 * c2));
        return result.toString();
    }

}
