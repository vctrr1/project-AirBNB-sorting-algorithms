import java.text.ParseException;
import java.util.Scanner;

import algorithms.ComparisonSorting;
import algorithms.LinearSorting;
import algorithms.RecursiveSorting;
import utils.ChangeDate;
import utils.GenerateCSV;

public class App {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		GenerateCSV gerarCsv = new GenerateCSV();
		ChangeDate.dateFormat();

		//Delaração das Variaveis
		String[][] array = gerarCsv.readFile("resultados/newDataSet-date-review.csv"); //Armazena o dataSet com novo formato de data
		long tempoInicial;
		long tempoFinal;

		//Instanciamento das Classes Ordenação
		ComparisonSorting ordenarComparativa = new ComparisonSorting(array.clone());
		LinearSorting ordenarLinear = new LinearSorting();
		RecursiveSorting ordenarRecursao = new RecursiveSorting(array.clone());
		int op=55;

		while(op != 0){
			System.out.println("\n\n---------------------------------Sorting Algorithms---------------------------------");
			System.out.println("1 -> SelectionSort");
			System.out.println("2 -> InsertionSort");
			System.out.println("3 -> CountSort");
			System.out.println("4 -> MergeSort");
			System.out.println("5 -> QuickSort");
			System.out.println("6 -> Mediana de Tres");
			System.out.println("7 -> Heapify");
			System.out.println("8 -> Media de Todos os Algoritmos");
			System.out.println("0 -> Sair");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("\nDigite a opção Desejada: ");

			op = sc.nextInt();


			switch (op) {
				case 0:
				 	break;
				case 1:
					//ordena pelo preço
					System.out.println("\nSelection sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] selectionPrice = ordenarComparativa.selectionSort(10); // PRECO
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(selectionPrice, "resultados/selection-ordena-preco.csv"); 
					System.out.println("Tempo de execução Preço: " + (tempoFinal - tempoInicial) + " ms");
					//ordena pela quantidade de reviews
					tempoInicial = System.currentTimeMillis();
					String[][] selectionReviews = ordenarComparativa.selectionSort(12);  // NOME 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(selectionReviews, "resultados/selection-ordena-reviews.csv"); // CASOS
					System.out.println("Tempo de execução Reviews: " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Para Ordenar: " + selectionReviews.length + " Elementos\n");
					break;
				case 2:
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
					System.out.println();
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
					System.out.println("5");
					break;
					
				default:
					System.out.println("Opção Invalida");
					break;
			}
		}
		sc.close();
		System.out.println("Programa executado com sucesso! Verifique os arquivos de saída na pasta resultados");
			
			
			// Algoritmos Lineares
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
		//System.out.println("Insertion sort: ");
		/*tempoInicial = System.currentTimeMillis();
		String[][] insertionCidades = ordenarComparativa.insertionSort(4); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(insertionCidades, "resultados/insertion_ordena.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");*/



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

		String[][] mergeMortes = ordenarRecursao.mergeSort(array.clone(), 1, array.length, 10);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(mergeMortes, "resultados/merge_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] mergeCasos = ordenarRecursao.mergeSort(array.clone(), 1, array.length, 12);
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
		String[][] quickMortes = ordenarRecursao.quickSort(array.clone(), 1, array.length - 1, 10); 
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(quickMortes, "resultados/quick_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] quickCasos = ordenarRecursao.quickSort(array.clone(), 1, array.length - 1, 12); 
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

		String[][] medianaMortes = ordenarRecursao.medianaDeTres(array.clone(), 1,
				array.length - 1, 10);
		tempoFinal = System.currentTimeMillis();
		gerarCsv.writeInFile(medianaMortes, "resultados/medianaDeTrês_ordena_preco.csv");
		System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

		tempoInicial = System.currentTimeMillis();
		String[][] medianaCasos = ordenarRecursao.medianaDeTres(array.clone(), 1,
				array.length - 1, 12); 
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

	}

}
