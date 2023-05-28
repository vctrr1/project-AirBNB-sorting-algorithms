import java.text.ParseException;
import java.util.Scanner;
import utils.SortingMethods;
public class App {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SortingMethods sm = new SortingMethods();
		
		int op=55;

		while(op != 0){
			System.out.println("\n\n---------------------------------Sorting Algorithms---------------------------------");
			System.out.println("1 -> SelectionSort");
			System.out.println("2 -> InsertionSort");
			System.out.println("3 -> CountSort");
			System.out.println("4 -> MergeSort");
			System.out.println("5 -> QuickSort");
			System.out.println("6 -> Mediana de Tres");
			System.out.println("7 -> HeapSort");
			System.out.println("8 -> Tempo de Execução de Todos os Algoritmos");
			System.out.println("0 -> Sair");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("\nDigite a opção Desejada: ");
			op = sc.nextInt();

			switch (op) {
				case 0:
				 	break;
				case 1:
					sm.selectionSort();
					break;
				case 2:
					sm.insertionSort();
					break;
				case 3:
					sm.countingSort();
					break;
				case 4:
					sm.mergeSort();
					break;
				case 5:
					sm.quickSort();
					break;
				case 6:
					sm.quickSortMedianaTres();
					break;
				case 7:
					sm.heapSort();
					break;
				case 8:
					sm.allSortingAlgorithm();
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
