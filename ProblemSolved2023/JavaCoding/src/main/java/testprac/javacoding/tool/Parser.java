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

    public int[][] parseIntegerDoubleList(String sInfo) {
        sInfo = sInfo.replaceAll("\\[\\s+", "[").replaceAll("\\s+]", "]");
        String[] rows = sInfo.split("\\],\\s*\\[");
        int numRows = rows.length;
        int[][] numbers = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            String row = rows[i].replaceAll("\\[|\\]", "");
            String[] elements = row.split(",\\s*");
            int numElements = elements.length;
            numbers[i] = new int[numElements];

            for (int j = 0; j < numElements; j++) {
                numbers[i][j] = Integer.parseInt(elements[j].trim());
            }
        }

        return numbers;
    }

}
