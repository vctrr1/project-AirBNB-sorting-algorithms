import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GerarCsv {

	String[][] arquivo = new String[22553][16];  // ESSES PARAMETROS

	public GerarCsv() {
	}

	public String[][] readFile(String path) { 
		String linha = "";
		int indice = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((linha = br.readLine()) != null) { // SEPARA POR '' ,'' CUIDADO COM STRING 
				String[] values = linha.split(";");
				for (int j = 0; j < 16; j++) {
					this.arquivo[indice][j] = values[j];
				}
				indice++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return this.arquivo;
	}

	public void writeInFile(String[][] lista, String filepath) {
		try {
			FileWriter criarArquivo = new FileWriter(filepath, true);
			BufferedWriter escreverArquivo = new BufferedWriter(criarArquivo);
			PrintWriter imprimeArquivo = new PrintWriter(escreverArquivo);

			for (int i = 0; i < lista.length; i++) {

				for (int j = 0; j < lista[i].length; j++) {
					if (j != 15) {
						imprimeArquivo.print(lista[i][j] + ";");
					} else {
						imprimeArquivo.print(lista[i][j]);
					}

				}
				imprimeArquivo.println();
				escreverArquivo.flush();
			}
			imprimeArquivo.close();

		} catch (Exception e) {
			System.out.println("Error na escritura do arquivo");
		}
	}
}
