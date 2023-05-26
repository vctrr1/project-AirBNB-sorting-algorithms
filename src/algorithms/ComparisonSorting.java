package algorithms;
import java.text.Collator;

public class ComparisonSorting { // Insertion e selection

	String[][] array = new String[22553][16];

	//construtor
	public ComparisonSorting(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 16; j++) {
				this.array[i][j] = array[i][j];
			}
		}

	}

	public String[][] selectionSort(int dados) {
		Collator comparar = Collator.getInstance();
		comparar.setStrength(Collator.NO_DECOMPOSITION);

		for (int i = 1; i < this.array.length; i++) {

			int minimum = i;

			for (int j = i + 1; j < this.array.length; j++) {
				if (dados == 4) {
					if (comparar.compare(this.array[minimum][dados], this.array[j][dados]) > 0) {
						minimum = j;
					}
				} else {

					if (Double.parseDouble(this.array[j][dados]) < Double.parseDouble(this.array[minimum][dados])) {
						minimum = j;
					}
				}

			}
			if (i != minimum) {
				String[] aux = this.array[i];
				this.array[i] = this.array[minimum];
				this.array[minimum] = aux;
			}
		}
		return this.array;
	}

	public String[][] insertionSort(int dados) {
		Collator comparar = Collator.getInstance();
		comparar.setStrength(Collator.NO_DECOMPOSITION);
		String[] aux;
		int j;
		for (int i = 1; i < this.array.length; i++) {
			aux = this.array[i];

			j = i - 1;

			if (dados == 4) {
				while (j >= 1 && comparar.compare(this.array[j][dados], aux[dados]) > 0) {
					this.array[j + 1] = this.array[j];
					j--;
				}
			} else {
				while (j >= 1
						&& Double.parseDouble(this.array[j][dados]) > Double.parseDouble(aux[dados])) {
					this.array[j + 1] = this.array[j];
					j--;
				}
			}

			this.array[j + 1] = aux;
		}
		return this.array;
	}
}
