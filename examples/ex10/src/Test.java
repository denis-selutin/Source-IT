import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by denis.selutin on 6/8/2015.
 */
public class Test {
    //инициализируем строку из которой будем выбирать слова
    public static final String TEST_STRING = "This is a string about Nothing!\r\n" +
            "We do nothing here and we don't want to do anything here.\r\n" +
            "You can ask me why do we need this text and I will answer -    it's only for test. It's for fun Just add additional it's";

    //инициализируем список слов которые не должны попасть в результат
    public static final Set<String> STOP_WORDS =
            Collections.unmodifiableSet(//запрещяем изменение состояния создаваемого множества
                    new HashSet<String>(//создаем новое множество на основе коллекции
                            Arrays.asList("it", "a", "an", "this", "it's", "do", "we", "i", "not", "why", "we", "here",
                                    "don't", "for", "is", "and", "you", "can", "only", "to", "will", "me")));//преоразовуем массив в список

    //преобразовываем список строк в список оберток при поможи потока
    public static final Set<StringWrapper> STOP_WORDS2 =
            Collections.unmodifiableSet(//запрещяем изменение состояния создаваемого множества
                    STOP_WORDS.stream()//создаем поток на списке
                            .map(strings1 -> new StringWrapper(strings1))//выполняем трасформацию над каждым элементом списка
                                    //если точнее - то оборачиваем каждый элемент списка в обертку
                            .collect(Collectors.toSet()));//собираем полученные данные в виде множества


    public static void main(String[] args) {
        List<String> strings = Stream.of(TEST_STRING.split("\\s+"))
                //разбиваем нашу строку на слова - тоесть мы считаем что слова разделены пробелами или табуляцией или переводами строк
                .map(r -> r.replaceAll("[.]+|[,]+|[!]+|[-]+|[+]+", ""))//заменяем перечисленные в [] символы на пустую строку
                .filter(s -> !"".equals(s))//проверяем что получилось после замены - если пустая строка  - но не включаем ее в результат
                .collect(Collectors.toList());//собираем данные в виде списка
//        аналог но на java <8
//        for(String s : TEST_STRING.split("\\s+")) {
//            String s1 = s.replaceAll("[.]+|[,]+|[!]+|[-]+|[+]+", "");
//            if(!"".equals(s1)) {
//                strings.add(s1);
//            }
//        }

        //создаем компаратор для сравнения строк
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("" + o1 + " " + o2 + " " + o1.equalsIgnoreCase(o2));
                if(o1.equalsIgnoreCase(o2)) {
                    return 0;
                } else {
                    return o1.compareTo(o2);//будет сравнивать строки по умолчанию, но проблема с TreeSet в хранении данных в виде дерева
                    //тоесть когда мы начинаем идти с корня - мы сравниваем 2 строки по страндартному сравнению строк определенному в
                    //String классе. Тоесть при
                    /*
                    TreeSet tr = new TreeSet(comparator);
                    tr.add("q");
                    tr.add("t");
                    tr.add("T");
                    System.out.println(tr);
                    мы получим [T, q, t] поскольку t < q а T > q в intах
                     */
                    //надо так o1.toLowerCase().compareTo(o2.toLowerCase());
                }
            }
        };
        //создаем множество на основе TreeSet
        Set<String> tree = new TreeSet<>(comparator);/*
        аналогично можно написать на 8-ке
        new TreeSet<String>((o1, o2) -> {
            if(o1.equalsIgnoreCase(o2)) {
                return 0;
            }
            return o1.compareTo(o2);
        });*/
        //создаем множество на основе HashSet
        Set<String> hash = new HashSet<>();
        //добавляем в множества наши данные
        hash.addAll(strings);
        tree.addAll(strings);

        //выводим данные
        System.out.println("\r\nBase + Hash + Tree");
        printCollection(strings);
        printCollection(hash);
        printCollection(tree);

        //удаляем из нашего множествва слов все слова которые находятся в списке стоп-слов и печатаем полученный результат
        System.out.println("\nTree");
        tree.removeAll(STOP_WORDS);
        printCollection(tree);

        System.out.println("\nHash");
        hash.removeAll(STOP_WORDS);
        printCollection(hash);
        System.out.println("------------------------------");

        //выполняем оборачивание каждой строки из списка строк в обертку - трансформируем
        List<StringWrapper> stringsWrappers = strings.stream()
                .map(strings1 -> new StringWrapper(strings1))
                .collect(Collectors.toList());

        //создаем два множества
        Set<StringWrapper> tree2 = new TreeSet<StringWrapper>();
        Set<StringWrapper> hash2 = new HashSet<>();

        //добавляем в множества наши данные
        hash2.addAll(stringsWrappers);
        tree2.addAll(stringsWrappers);

        //печатаем что получилось
        System.out.println("\nHash 2 + Tree 2");
        printCollection2(hash2);
        printCollection2(tree2);

        //удаляем из нашего множествва слов все слова которые находятся в списке стоп-слов и печатаем полученный результат
        System.out.println("\nTree 2");
        tree2.removeAll(STOP_WORDS2);
        printCollection2(tree2);

        System.out.println("\nHash 2");
        hash2.removeAll(STOP_WORDS2);
        printCollection2(hash2);

        //удаляем стоп-слова непосредственно из списка и выводим его
        System.out.println("\nList 2");
        stringsWrappers.removeAll(STOP_WORDS2);
        Collections.sort(stringsWrappers);
        printCollection2(stringsWrappers);

    }

    /*
     * Вывод коллекции строк
     */
    private static final void printCollection(Collection<String> i) {
        System.out.println(i.stream().collect(Collectors.joining(", ")));
        //обьединяем все элементы коллекции в одну строку, разделяя элементы строкой ", "
        System.out.println(i.size());
        /*
        аналоги stream'а
        for(String s : i) {
            System.out.println(s + ", ");
        }
        i.forEach(s1 -> {
            System.out.println(s1 + ", ");
        });
        */
    }

    /*
     * Вывод коллекции оберток
     */
    private static final void printCollection2(Collection<StringWrapper> i) {
        System.out.println(i.stream().map(stringWrapper -> stringWrapper.toString()).collect(Collectors.joining(", ")));
        //преобразовываем обертки в строку, обьединяем преобразованные элементы коллекции в одну строку, разделяя элементы строкой ", "
        System.out.println(i.size());
    }

    public static class StringWrapper implements Comparable<StringWrapper> {
        private String val = "";

        public StringWrapper(String value) {
            this.val = value;
        }

        @Override
        /*
         * Переопределяем метод для hashset
         */
        public boolean equals(Object o) {
            //System.out.println("equals " + o + " " + val);
            if(o == null) {
                return false;
            }
            if(!(o instanceof StringWrapper)) {
                return false;
            }
            return val.equalsIgnoreCase(((StringWrapper) o).val);
        }

        public String toString() {
            return this.val;
        }

        /*
         * Переопределяем hashCode для правильной работы hashset
         */
        public int hashCode() {
            return this.val.toLowerCase().hashCode(); //this.val.hashCode() ;//
        }

        @Override
        /*
         * Реализываем метод для правильной работы treeset
         */
        public int compareTo(StringWrapper o) {
            //System.out.println("compareTo " + o + " " + val);
            if(val.equalsIgnoreCase(o.val)) {
                return 0;
            }
            return val.toLowerCase().compareTo(o.val.toLowerCase());
        }
    }
}
