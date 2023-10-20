import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0, j = 1; i < q.size(); i++, j++){
            if(map.containsKey(q.get(i))) continue;
            if(map.containsKey(j)){
                i--;
                continue;
            }
            if(q.get(i) - j != 0){
                int max = 2;
                boolean tooFar = true;
                for(int k = 1, add = 0; k <= max; k++){
                    if(map.containsKey(j + k)){
                        max++;
                        continue;
                    }
                    add++;
                    if(q.get(i) - (j + k) == 0){
                        bribes += add;
                        tooFar = false;
                        break;
                    }
                }
                if(tooFar){
                    System.out.println("Too chaotic");
                    return;
                }
                j--;
            }
            map.put(q.get(i), q.get(i));
        }
        System.out.println(bribes);
    }

}

public class NewYearChaosHR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
