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
			System.out.println("8 -> Tempo de Execução de Todos os Algoritmos");
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
					System.out.println("Os Algoritmos Ordenaram: " + selectionReviews.length + " Elementos");
					System.out.println();
					break;
				case 2:
					//ordena pelo preço
					System.out.println("\nInsertion sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] insertionPrice = ordenarComparativa.insertionSort(10);
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(insertionPrice, "resultados/insertion-ordena-preco.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					//ordena pela quantidade de reviews
					tempoInicial = System.currentTimeMillis();
					String[][] insertionReviews = ordenarComparativa.insertionSort(12); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(insertionReviews, "resultados/insertion-ordena-reviews.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + insertionReviews.length + " Elementos");
					System.out.println();
					break;
				case 3:
					System.out.println("\nCounting sort: ");    
					tempoInicial = System.currentTimeMillis();
					String[][] countingPriceOrdenado = ordenarLinear.countSort(array.clone(), 10); // PEGA A COLUNA PREÇO
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(countingPriceOrdenado, "resultados/counting-ordena-preco.csv"); 
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		
					tempoInicial = System.currentTimeMillis();
					String[][] countingReviews = ordenarLinear.countSort(array.clone(), 12); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(countingReviews, "resultados/counting-ordena-reviews.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + countingReviews.length + " Elementos");
					System.out.println();
					break;
				case 4:
					System.out.println("\nMerge sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] mergePrice = ordenarRecursao.mergeSort(array.clone(), 1, array.length, 10);
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(mergePrice, "resultados/merge-ordena-preco.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		
					tempoInicial = System.currentTimeMillis();
					String[][] mergeReviews = ordenarRecursao.mergeSort(array.clone(), 1, array.length, 12);
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(mergeReviews, "resultados/merge-ordena-reviews.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + mergeReviews.length + " Elementos");
					System.out.println();
					break;
				case 5:
					System.out.println("\nQuick sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] quickPrice = ordenarRecursao.quickSort(array.clone(), 1, array.length - 1, 10); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(quickPrice, "resultados/quick-ordena-preco.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		
					tempoInicial = System.currentTimeMillis();
					String[][] quickReviews = ordenarRecursao.quickSort(array.clone(), 1, array.length - 1, 12); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(quickReviews, "resultados/quick-ordena-reviews.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + quickReviews.length + " Elementos");
					System.out.println();
					break;
				case 6:
					System.out.println("QuickSort com Mediana de 3: ");
					tempoInicial = System.currentTimeMillis();
		
					String[][] medianaPrice = ordenarRecursao.medianaDeTres(array.clone(), 1,array.length - 1, 10);
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(medianaPrice, "resultados/medianaDeTrês-ordena-preco.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
		
					tempoInicial = System.currentTimeMillis();
					String[][] medianaReviews = ordenarRecursao.medianaDeTres(array.clone(), 1,array.length - 1, 12); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(medianaReviews, "resultados/medianaDeTrês-ordena-reviews.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + medianaReviews.length + " Elementos");
					System.out.println();
					break;
				case 7:
					System.out.println("Heap sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] heapifyPrice = ordenarRecursao.sort(array.clone(), 10); // PREÇO
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(heapifyPrice, "resultados/Heapify_ordena_preco.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

					tempoInicial = System.currentTimeMillis();
					String[][] heapifyReviews = ordenarRecursao.sort(array.clone(), 11); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(heapifyReviews, "resultados/Heapify_ordena.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + heapifyReviews.length + " Elementos");
					System.out.println();
					break;
				case 8:
					System.out.println("Insertion sort: ");
					tempoInicial = System.currentTimeMillis();
					String[][] insertionNames = ordenarComparativa.insertionSort(4); 
					tempoFinal = System.currentTimeMillis();
					gerarCsv.writeInFile(insertionNames, "resultados/insertion-ordena-nomes.csv");
					System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
					System.out.println("Os Algoritmos Ordenaram: " + insertionNames.length + " Elementos");
					break;
				default:
					System.out.println("Opção Invalida");
					break;
			}
		}
		sc.close();
		System.out.println("Programa executado com sucesso! Verifique os arquivos de saída na pasta resultados");

	}

}
