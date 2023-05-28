package utils;
import java.text.ParseException;

import algorithms.ComparisonSorting;
import algorithms.LinearSorting;
import algorithms.RecursiveSorting;

public class SortingMethods {
    GenerateCSV gerarCsv = new GenerateCSV();

    public SortingMethods() throws ParseException {
		  ChangeDate.dateFormat();
    }

    String[][] array = gerarCsv.readFile("resultados/newDataSet-date-review.csv"); //Armazena o dataSet com novo formato de data

    ComparisonSorting ordenarComparativa = new ComparisonSorting(array.clone());
    LinearSorting ordenarLinear = new LinearSorting();
    RecursiveSorting ordenarRecursao = new RecursiveSorting(array.clone());

    long tempoInicial = 0;
    long tempoFinal = 0;

    public void selectionSort(){
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
    }

    public void insertionSort(){
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
    }

    public  void countingSort(){
      System.out.println("\nCounting sort: ");    
      tempoInicial = System.currentTimeMillis();
      String[][] countingPriceOrdenado = ordenarLinear.countingSort(array.clone(), 10); // PEGA A COLUNA PREÇO
      tempoFinal = System.currentTimeMillis();
      gerarCsv.writeInFile(countingPriceOrdenado, "resultados/counting-ordena-preco.csv"); 
      System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");

      tempoInicial = System.currentTimeMillis();
      String[][] countingReviews = ordenarLinear.countingSort(array.clone(), 12); 
      tempoFinal = System.currentTimeMillis();
      gerarCsv.writeInFile(countingReviews, "resultados/counting-ordena-reviews.csv");
      System.out.println("Tempo de execução : " + (tempoFinal - tempoInicial) + " ms");
      System.out.println("Os Algoritmos Ordenaram: " + countingReviews.length + " Elementos");
      System.out.println();
    }
    
    public  void mergeSort(){
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
    }

    public  void quickSort(){
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
    }

    public  void quickSortMedianaTres(){
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
    }

    public void heapSort(){
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
    }

    public void allSortingAlgorithm(){
      selectionSort();
      insertionSort();
      countingSort();
      mergeSort();
      quickSort();
      quickSortMedianaTres();
      heapSort();
    }
}
