import java.text.Collator;

public class OrdenacaoRecursao {
	String[][] array = new String[22553][16];

	public OrdenacaoRecursao(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.arraycopy(array[i], 0, this.array[i], 0, 14);
		}
	}

	// merge
	private static void organizar(String[][] vetor, int primeiro, int meio, int ultimo, int dados) {
		String[][] array = new String[ultimo - primeiro][];
		Collator comparar = Collator.getInstance();
		comparar.setStrength(Collator.NO_DECOMPOSITION);
		int posicao = 0;
		int i = primeiro;
		int meioAux = meio;
		if (dados != 4) {
			while (i < meio && meioAux < ultimo) {
				if (Double.parseDouble(vetor[i][dados]) <= Double.parseDouble(vetor[meioAux][dados])) {
					array[posicao] = vetor[i];

					posicao++;
					i++;
				} else {
					array[posicao] = vetor[meioAux];

					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) {
				array[posicao] = vetor[meioAux];

				posicao++;
				meioAux++;
			}

			while (i < meio) {
				array[posicao] = vetor[i];

				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) {
				vetor[i] = array[posicao];
				posicao++;
			}
		} else {
			while (i < meio && meioAux < ultimo) {
				if (comparar.compare(vetor[meioAux][dados], vetor[i][dados]) > 0) {

					array[posicao] = vetor[i];

					posicao++;
					i++;

				} else {
					array[posicao] = vetor[meioAux];

					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) {
				array[posicao] = vetor[meioAux];

				posicao++;
				meioAux++;
			}

			while (i < meio) {
				array[posicao] = vetor[i];

				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) {
				vetor[i] = array[posicao];
				posicao++;
			}
		}
	}

	public String[][] mergeSort(String[][] vetor, int inicio, int fim, int dados) {

		if (inicio < fim - 1) {

			int meio = (inicio + fim) / 2;

			mergeSort(vetor, inicio, meio, dados);
			mergeSort(vetor, meio, fim, dados);
			organizar(vetor, inicio, meio, fim, dados);
		}
		return vetor;
	}

	// QuickSort
	public String[][] quickSort(String[][] array, int inicio, int fim, int dados)
    {
		if (dados != 4) {
			int[] pilha= new int[fim - inicio + 1];
			int topo = -1;
			pilha[++topo] = inicio;
			pilha[++topo] = fim;
			while (topo >= 0) {
				fim = pilha[topo--];
				inicio = pilha[topo--];
				
				// Particionamento
				double pivo = Double.parseDouble(array[fim][dados]);
				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {
					if (Double.parseDouble(array[j][dados]) <= pivo) {
						i++;
						String[] temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
				String[] temp = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = temp;
				
				int p = i+1;
				if (p - 1 > inicio) {
					pilha[++topo] = inicio;
					pilha[++topo] = p - 1;
				}
				if (p + 1 < fim) {
					pilha[++topo] = p + 1;
					pilha[++topo] = fim;
				}
			}
		} else {
			int[] pilha= new int[fim - inicio + 1];
			int topo = -1;
			pilha[++topo] = inicio;
			pilha[++topo] = fim;
			while (topo >= 0) {
				fim = pilha[topo--];
				inicio = pilha[topo--];
				
				Collator comparar = Collator.getInstance();
				comparar.setStrength(Collator.NO_DECOMPOSITION);
				// Particionamento
				String pivo = array[fim][dados];
				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {
					if (comparar.compare(pivo, array[j][dados]) > 0) {
						i++;
						String[] temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
				String[] temp = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = temp;
				
				int p = i+1;
				if (p - 1 > inicio) {
					pilha[++topo] = inicio;
					pilha[++topo] = p - 1;
				}
				if (p + 1 < fim) {
					pilha[++topo] = p + 1;
					pilha[++topo] = fim;
				}
			}
		}

        
		return array;
    }

	// Mediana de três
	public String[][] medianaDeTres(String[][] array, int inicio, int fim, int dados)
    {
		if(dados != 4){
			int[] pilha= new int[fim - inicio + 1];
			int topo = -1;
			pilha[++topo] = inicio;
			pilha[++topo] = fim;
			while (topo >= 0) {
				fim = pilha[topo--];
				inicio = pilha[topo--];
				
				// Particionamento
				int meio = ((inicio + fim) / 2);
				int a = (int)Double.parseDouble(array[inicio][dados]);
				int b = (int)Double.parseDouble(array[meio][dados]);
				int c = (int)Double.parseDouble(array[fim][dados]);
				int medianaIndice;

				if (a < b) {
					if (b < c) {
						medianaIndice = meio;
					} else {
						if (a < c) {
							medianaIndice = fim;
						} else {
							medianaIndice = inicio;
						}
					}
				} else {
					if (c < b) {
						medianaIndice = meio;
					} else {
						if (c < a) {
							medianaIndice = fim;
						} else {
							medianaIndice = inicio;
						}
					}
				}
				swap(array, medianaIndice, fim);
				double pivo = Double.parseDouble(array[fim][dados]);
				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {
					if (Double.parseDouble(array[j][dados]) <= pivo) {
						i++;
						String[] temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
				String[] temp = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = temp;
				
				int p = i+1;
				if (p - 1 > inicio) {
					pilha[++topo] = inicio;
					pilha[++topo] = p - 1;
				}
				if (p + 1 < fim) {
					pilha[++topo] = p + 1;
					pilha[++topo] = fim;
				}
			}
		} else{
			int[] pilha= new int[fim - inicio + 1];
			int topo = -1;
			pilha[++topo] = inicio;
			pilha[++topo] = fim;
			while (topo >= 0) {
				fim = pilha[topo--];
				inicio = pilha[topo--];
				Collator comparar = Collator.getInstance();
				comparar.setStrength(Collator.NO_DECOMPOSITION);
				// Particionamento
				int meio = ((inicio + fim) / 2);
				String a = array[inicio][dados];
				String b = array[meio][dados];
				String c = array[fim][dados];
				int medianaIndice;

				if (comparar.compare(b, a) > 0) {
					if (comparar.compare(c, b) > 0) {
						medianaIndice = meio;
					} else {
						if (comparar.compare(c, a) > 0) {
							medianaIndice = fim;
						} else {
							medianaIndice = inicio;
						}
					}
				} else {
					if (comparar.compare(b, c) > 0) {
						medianaIndice = meio;
					} else {
						if (comparar.compare(a, c) > 0) {
							medianaIndice = fim;
						} else {
							medianaIndice = inicio;
						}
					}
				}
				swap(array, medianaIndice, fim);
				String pivo = array[fim][dados];
				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {
					if (comparar.compare(pivo, array[j][dados]) > 0) {
						i++;
						String[] temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
				String[] temp = array[i + 1];
				array[i + 1] = array[fim];
				array[fim] = temp;
				
				int p = i+1;
				if (p - 1 > inicio) {
					pilha[++topo] = inicio;
					pilha[++topo] = p - 1;
				}
				if (p + 1 < fim) {
					pilha[++topo] = p + 1;
					pilha[++topo] = fim;
				}
			}
		}
        
		return array;
    }

	
	public static void swap(String[][] A, int i, int j) {
		String[] temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// HeapSort

	public String[][] sort(String[][] array, int dados) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 1; i--)
			heapify(array, n, i, dados);

		for (int i = n - 1; i > 1; i--) {

			String[] temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0, dados);
		}

		return array;
	}

	static void heapify(String[][] array, int n, int i, int dados) {
		if (dados != 4) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if (l < n && Double.parseDouble(array[l][dados]) > Double.parseDouble(array[largest][dados]))
				largest = l;

			if (r < n && Double.parseDouble(array[r][dados]) > Double.parseDouble(array[largest][dados]))
				largest = r;

			if (largest != i) {
				String[] swap = array[i];
				array[i] = array[largest];
				array[largest] = swap;

				heapify(array, n, largest, dados);
			}
		} else {
			Collator comparar = Collator.getInstance();
			comparar.setStrength(Collator.NO_DECOMPOSITION);
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if (l < n && comparar.compare(array[l][dados], array[largest][dados]) > 0)
				largest = l;

			if (r < n && comparar.compare(array[r][dados], array[largest][dados]) > 0)
				largest = r;

			if (largest != i) {
				String[] swap = array[i];
				array[i] = array[largest];
				array[largest] = swap;

				// Funcao recursiva para cada ramo da arvore
				heapify(array, n, largest, dados);
			}
		}

	}
}
