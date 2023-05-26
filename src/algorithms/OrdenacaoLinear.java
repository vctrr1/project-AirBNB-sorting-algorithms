package algorithms;
public class OrdenacaoLinear { // counting

	public OrdenacaoLinear() {
	}

	public String[][] countSort(String[][] array, int dados) {
        int tamanho = array.length;

        String[][] saida = new String[tamanho + 1][0];

        String[] max = array[1];
        for (int i = 1; i < tamanho; i++) {
         //   System.out.println(array[i][dados] + " " + i); // POSIÇÃO DO DADOS E LINHA 
            if (Double.parseDouble(array[i][dados]) > Double.parseDouble(max[dados]))
                max = array[i];
        }
        //System.out.println(max[0]); // PEGANDO O MAIOR 

        int[] cont = new int[(int)Double.parseDouble(max[dados]) + 1];

        for (int i = 0; i <= (int)Double.parseDouble(max[dados]); ++i) {
            cont[i] = 0;
        }

        for (int i = 1; i < tamanho; i++) {
            cont[(int)Double.parseDouble(array[i][dados])]++;
        }

        for (int i = 1; i <= (int)Double.parseDouble(max[dados]); i++) {
            cont[i] += cont[i - 1];
        }

        for (int i = tamanho-1; i > 0; i--) {
            saida[cont[(int)Double.parseDouble(array[i][dados])] - 1] = array[i];
            cont[(int)Double.parseDouble(array[i][dados])]--;
        }
        for (int i = 0; i < tamanho; i++) {
            array[i] = saida[i];
        }
        return array;

    }

}
