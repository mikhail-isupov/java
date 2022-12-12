//Сформировать на основе json-строки sql запрос

public class Task1 {
    public static void main(String[] args) {
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String sqlString = "Select * from students where";
        System.out.println(SQLRequest(sqlString, filter));
    }

    public static String SQLRequest(String sqlString, String filter){
        String[] data = filter.split(","); // разбиение JSON строки на пары ключ: значение
        StringBuilder sqlRequest = new StringBuilder(sqlString);
        for (int i = 0; i < data.length; i++){ // анализируем каждую JSON пару ключ-значение
            if (data[i].contains("null")||data[i].contains("NULL")) continue; // параметры со значением null в запрос не попадают
            int counter = 0;
            if (i == 0 )sqlRequest.append(' '); // добавляем пробел перед первыми данными
            else sqlRequest.append(" AND "); // или AND
            for (int j=0; j < data[i].length(); j++){
                if (data[i].charAt(j)=='{' || data[i].charAt(j)=='}' || data[i].charAt(j)==' ') continue; // пропускаем
                if (data[i].charAt(j) == '"' && counter < 2) {
                    counter+=1;
                    continue; // пропускаем первые две кавычки
                }
                if (data[i].charAt(j)==':') sqlRequest.append('=');
                else sqlRequest.append(data[i].charAt(j)); // меняем : на = или добавляем как есть
            }
        }
    return sqlRequest.toString();
    }
}
