import java.text.ParseException;

public class Application {

	public static void main(String[] args) throws ParseException {

		GerarCsv gerarCsv = new GerarCsv();
		Data.dateFormat();
		String[][] array = gerarCsv.readFile("resultados/listings_review_date.csv"); // Mudar Arquivo 

		// Abaixo todos os arrays que serão usado para ordenar
		String[][] arrayElementar = array.clone();
		String[][] arrayRecursao = array.clone();

		long tempoInicial;
		long tempoFinal;
		
		OrdenacaoComparativa ordenarComparativa = new OrdenacaoComparativa(arrayElementar);
		OrdenacaoLinear ordenarLinear = new OrdenacaoLinear();
		OrdenacaoRecursao ordenarRecursao = new OrdenacaoRecursao(arrayRecursao);

		// Algoritmos Lineares

		// Counting sort
		System.out.println("Counting sort: ");    
		tempoInicial = System.currentTimeMillis();

		String[][] countingPrice = array.clone();
		

		String[][] countingPriceOrdenado = ordenarLinear.countSort(countingPrice, 10); // PEGA A COLUNA PREÇO
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(countingPriceOrdenado, "resultados/counting_ordena_preco.csv"); 
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		String[][] countingCasos = array.clone();
		tempoInicial = System.currentTimeMillis();
		String[][] countingCasosOrdenado = ordenarLinear.countSort(countingCasos, 12); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(countingCasosOrdenado, "resultados/counting_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		System.out.println();

		// Algoritmos Elementares

		// Insertion sort
		System.out.println("Insertion sort: ");
		tempoInicial = System.currentTimeMillis();

		String[][] insertionMortes = ordenarComparativa.insertionSort(10);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(insertionMortes, "resultados/insertion_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] insertionCasos = ordenarComparativa.insertionSort(12); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(insertionCasos, "resultados/insertion_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] insertionCidades = ordenarComparativa.insertionSort(4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(insertionCidades, "resultados/insertion_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		// Selection sort
		System.out.println("Selection sort: ");
		tempoInicial = System.currentTimeMillis();

		String[][] selectionMortes = ordenarComparativa.selectionSort(10); // PRECO
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(selectionMortes, "resultados/selection_ordena_preco.csv"); 
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] selectionCasos = ordenarComparativa.selectionSort(12);  // NOME 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(selectionCasos, "resultados/selection_ordena.csv"); // CASOS
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] selectionCidades = ordenarComparativa.selectionSort(4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(selectionCidades, "resultados/selection_ordena.csv"); // CIDADES
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		// Algoritmos de recursão

		// Merge sort
		System.out.println("Merge sort: ");
		tempoInicial = System.currentTimeMillis();

		String[][] mergeMortes = ordenarRecursao.mergeSort(arrayRecursao.clone(), 1, arrayRecursao.length, 10);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(mergeMortes, "resultados/merge_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] mergeCasos = ordenarRecursao.mergeSort(arrayRecursao.clone(), 1, arrayRecursao.length, 12);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(mergeCasos, "resultados/merge_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] mergeCidades = ordenarRecursao.mergeSort(arrayRecursao.clone(), 1, arrayRecursao.length, 4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(mergeCidades, "resultados/merge_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		//QuickSort
		System.out.println("quick sort: ");
		tempoInicial = System.currentTimeMillis();
		String[][] quickMortes = ordenarRecursao.quickSort(array.clone(), 1, arrayRecursao.length - 1, 10); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(quickMortes, "resultados/quick_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] quickCasos = ordenarRecursao.quickSort(array.clone(), 1, arrayRecursao.length - 1, 12); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(quickCasos, "resultados/quick_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] quickCidades = ordenarRecursao.quickSort(array.clone(), 1, arrayRecursao.length - 1, 4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(quickCidades, "resultados/quick_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		// Mediana de Três
		System.out.println("QuickSort com Mediana de 3: ");
		tempoInicial = System.currentTimeMillis();

		String[][] medianaMortes = ordenarRecursao.medianaDeTres(arrayRecursao.clone(), 1,
				arrayRecursao.length - 1, 10);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(medianaMortes, "resultados/medianaDeTrês_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] medianaCasos = ordenarRecursao.medianaDeTres(arrayRecursao.clone(), 1,
				arrayRecursao.length - 1, 12); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(medianaCasos, "resultados/medianaDeTrês_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] medianaCidades = ordenarRecursao.medianaDeTres(arrayRecursao.clone(), 1,
				arrayRecursao.length - 1, 4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(medianaCidades, "resultados/medianaDeTrês_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		// Heapify sort
		System.out.println("Heap sort: ");
		tempoInicial = System.currentTimeMillis();

		String[][] heapifyMortes = ordenarRecursao.sort(array.clone(), 10); // PREÇO
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(heapifyMortes, "resultados/Heapify_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		tempoInicial = System.currentTimeMillis();
		String[][] heapifyCasos = ordenarRecursao.sort(array.clone(), 11); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(heapifyCasos, "resultados/Heapify_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		/*tempoInicial = System.currentTimeMillis();
		String[][] heapifyCidades = ordenarRecursao.sort(array.clone(), 4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(heapifyCidades, "resultados/Heapify_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/
		System.out.println();

		System.out.println("Programa executado com sucesso! Verifique os arquivos de saída na pasta resultados");
	}

}
