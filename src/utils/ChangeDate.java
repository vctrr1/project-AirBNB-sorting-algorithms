package utils;
import java.text.SimpleDateFormat;  
import java.util.*; 
import java.text.ParseException;
public class ChangeDate {

  public static void dateFormat() throws ParseException {

    GenerateCSV gerarCsv = new GenerateCSV();
    String[][] array = gerarCsv.readFile("src/airbnb-data/AirBNB-Data.csv");

    SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");

    for (int i = 1; i < array.length; i++) { 
      if(!array[i][13].equals("") && array[i][13] != null){
        Date data = formatador.parse(array[i][13]);
        array[i][13] = formatador2.format(data);
      }
    }        
    gerarCsv.writeInFile(array, "resultados/newDataSet-date-review.csv");
  }
}
  
    

