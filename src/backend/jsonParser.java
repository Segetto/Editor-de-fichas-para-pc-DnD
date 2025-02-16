/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class jsonParser {

    public String LerArquivo(String caminho) {
        String valores;  // Inicializando antes do bloco try-catch
        try {
            String caminhoArquivo = caminho;
            String conteudo = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

            JSONObject personagemVO = new JSONObject(new LinkedHashMap<>(new JSONObject(conteudo).toMap()));

            /*JSONArray personagemArray = personagemVO.getJSONArray("e");*/
            valores = personagemVO.toString();
            /*
        }*/

        } catch (IOException e) {
            e.printStackTrace();
            valores = "Erro ao ler arquivo.";  // Mensagem de erro se houver uma exceção
        }

        return valores;  // Retorna o valor ou a mensagem de erro
    }

    public String LerArray(String caminho) {
        String valores;  // Inicializando antes do bloco try-catch
        try {
            String caminhoArquivo = caminho;
            String conteudo = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

            JSONArray personagemVO = new JSONArray(conteudo);

            /*JSONArray personagemArray = personagemVO.getJSONArray("e");*/
            valores = personagemVO.toString();
            /*
        }*/

        } catch (IOException e) {
            e.printStackTrace();
            valores = "Erro ao ler arquivo.";  // Mensagem de erro se houver uma exceção
        }

        return valores;  // Retorna o valor ou a mensagem de erro
    }

    public void sobrescreverArquivo(String CaminhoArquivo, String ArquivoString, String NovoCaminho) {
        try {
            String caminhoArquivo = CaminhoArquivo;
            JSONObject ArquivoNovo = new JSONObject(ArquivoString);
            FileWriter file = new FileWriter(caminhoArquivo, false);
            file.write(ArquivoNovo.toString(4)); // O '4' é para formatar o JSON com uma indentação de 4 espaços
            file.close();
            File AntigoNome = new File(CaminhoArquivo);
            File NovoNome = new File(NovoCaminho);
            if (!AntigoNome.exists()) {
                System.out.println("O arquivo original não existe.");
                return;
            }
            if (AntigoNome.renameTo(NovoNome)) {
                System.out.println("Arquivo JSON sobrescrito com sucesso.");
            } else {
                System.out.println("Falha ao renomear o arquivo." + "\n Caminho: " + NovoCaminho);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
