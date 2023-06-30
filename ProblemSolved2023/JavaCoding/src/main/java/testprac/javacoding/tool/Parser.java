package testprac.javacoding.tool;

public class Parser {

    public int[] parseIntegerList(String str) {
        str = str.replaceAll("\\[|\\]|\\s", "");
        String[] elements = str.split(",");
        int size = elements.length;
        int[] re = new int[size];

        for (int i = 0; i < size; i++) {
            re[i] = Integer.parseInt(elements[i]);
        }

        return re;
    }
}
