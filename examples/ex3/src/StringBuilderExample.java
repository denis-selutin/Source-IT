import java.util.*;

public class StringBuilderExample {
    //Создание внутренних констант
    //Создание неизменяемых списков из обычных массивов
    private static final List<String> SELECT_COLUMNS = Collections.unmodifiableList(
            Arrays.asList("ID", "FIRST_NAME", "LAST_NAME", "MIDDLE_NAME", "SALARY", "RATE"));
    private static final List<String> GROUP_COLUMNS = Collections.unmodifiableList(
            Arrays.asList("FIRST_NAME", "LAST_NAME"));

    //Создание неизменяемого набора ключ-значение и его инициализация в статическом блоке
    private static final Map<String, String> WHERE_CONDITIONS;
    static {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("SALARY", "5000");
        conditions.put("RATE", "\"10$/hour\"");
        WHERE_CONDITIONS = Collections.unmodifiableMap(conditions);
    }

    /**
     * Пример создания SQL запроса на основании колонок для выбора SELECT_COLUMNS, условий для поиска WHERE_CONDITIONS
     * и колонок для группировки результата GROUP_COLUMNS
     *
     * <p>Метод не учитывает специфику SQL: типы данных, их преобразования и т.д. поскольку он упрощен.
     *
     * @return - строку SQL запроса.
     */
    private static String buildQuery() {
        //Не синхронизирований билдер. Чтобы убетитЬся Ctrl + Left click на StringBuilder и поищите слово synchronized
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for(int i = 0; i < SELECT_COLUMNS.size(); i++) {
            String value = SELECT_COLUMNS.get(i);
            sb.append(value);
            if(i < SELECT_COLUMNS.size() - 1) {
                sb.append(", ");
            }
        }
        /*  Конструкция java 8.
            sb.append(SELECT_COLUMNS
                .stream()
                .collect(Collectors.joining(", ")));
         */

        sb.append(" FROM SOME_TABLE WHERE ");

        int count = 0;
        for(Map.Entry entry : WHERE_CONDITIONS.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            if(count < WHERE_CONDITIONS.size() - 1) {
                sb.append(" AND ");
            }
            count++;
        }
        /* Конструкция java 8.
           sb.append(WHERE_CONDITIONS
                        .entrySet()
                        .stream()
                        .map(entry -> "" + entry.getKey() + "=" + entry.getValue())
                        .collect(Collectors.joining(" AND "))
           );
         */

        sb.append(" GROUP BY ");
        for(int i = 0; i < GROUP_COLUMNS.size(); i++) {
            String value = GROUP_COLUMNS.get(i);
            sb.append(value);
            if(i < GROUP_COLUMNS.size() - 1) {
                sb.append(", ");
            }
        }
        /*  Конструкция java 8.
            sb.append(GROUP_COLUMNS
                .stream()
                .collect(Collectors.joining(", ")));
         */

        return sb.toString();
    }

    /**
     * Пример на вывод слов в обрптном порядке.
     *
     * Этот пример также решается с без использования List'а - только на массиве.
     * String[] words = sentence.split(" ");
     * for(int i = words.length - 1; i >= 0; i--) {
     *     sb.append(words[i]);
     *     sb.append(" ");
     * }
     *
     * или конструкцией Java 8
     * Stream.of(sentence.split(" "))
     *    .sorted(Collections.reverseOrder())
     *    .collect(Collectors.joining(" "));
     *
     * @param sentence - исходное предложение
     * @return - результат обработки
     */
    private static String reverseSentence(String sentence) {
        StringBuilder sb = new StringBuilder();

        List<String> words = Arrays.asList(sentence.split(" "));
        Collections.reverse(words);
        for(String word : words) {
            sb.append(word);
            sb.append(" ");
        }

        return sb.toString();
    }

    //Точка входа в приложение
    public static void main(String[] args) {
        System.out.println(buildQuery());
        System.out.println(reverseSentence("This is some string"));
    }
}
