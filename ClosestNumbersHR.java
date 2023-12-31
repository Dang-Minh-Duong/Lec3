import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> resultList = new ArrayList<>();
        Collections.sort(arr);
        int min = arr.get(1)-arr.get(0);
        for (int i = 1;i<arr.size()-1;i++) {
            int tmp = arr.get(i+1)-arr.get(i);
            if (tmp<min) min = tmp;
        }
        for (int i = 0;i<arr.size()-1;i++) {
            if (arr.get(i+1)-arr.get(i)==min) {
                resultList.add(arr.get(i));
                resultList.add(arr.get(i+1));
            }
        }
        return resultList;
    }


}

public class ClosestNumbersHR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
