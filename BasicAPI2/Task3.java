import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("data.json");
        String jsonString;
        try{
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()){
            jsonString = fileScanner.nextLine();
            String[] jsonData = jsonString.split("},");
            for (int i = 0; i < jsonData.length; i++) System.out.println(jsonParse(jsonData[i]));
        }
        fileScanner.close();;
    } 
    catch(IOException e){e.printStackTrace();}
    }
    public static String jsonParse(String jsonData){
        String[] data = jsonData.split(","); // разбиение JSON строки на пары ключ: значение
        StringBuilder parsedJSON = new StringBuilder();
        for (int i = 0; i < data.length; i++){ // анализируем каждую JSON пару ключ-значение
            String[] keyValue = data[i].split(":"); //Выделяем пару ключ-значение
            if (keyValue[0].contains("фамилия")){
                parsedJSON.append("Студент");
                for (int j = 0; j < keyValue[1].length(); j++){
                    if (keyValue[1].charAt(j)=='{'||keyValue[1].charAt(j)=='}'||keyValue[1].charAt(j)=='['||keyValue[1].charAt(j)==']') continue; 
                    if (keyValue[1].charAt(j)=='"') parsedJSON.append(" ");
                    else parsedJSON.append(keyValue[1].charAt(j));
                }
            }
            if (keyValue[0].contains("оценка")){
                parsedJSON.append("получил ");
                for (int j = 0; j < keyValue[1].length(); j++){
                    if (keyValue[1].charAt(j)=='{'||keyValue[1].charAt(j)=='}'||keyValue[1].charAt(j)=='['||keyValue[1].charAt(j)==']') continue; 
                    if (keyValue[1].charAt(j)=='"') parsedJSON.append(" ");
                    else parsedJSON.append(keyValue[1].charAt(j));
                }
            }
            if (keyValue[0].contains("предмет")){
                parsedJSON.append("по предмету ");
                for (int j = 0; j < keyValue[1].length(); j++){
                    if (keyValue[1].charAt(j)=='{'||keyValue[1].charAt(j)=='}'||keyValue[1].charAt(j)=='['||keyValue[1].charAt(j)==']') continue; 
                    if (keyValue[1].charAt(j)=='"') parsedJSON.append(" ");
                    else parsedJSON.append(keyValue[1].charAt(j));
                }
            }
        }
    return parsedJSON.toString();
    }
}
