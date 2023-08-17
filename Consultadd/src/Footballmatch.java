//Sample input 0 :
//        4 -> teamA[] size n = 4
//        1 -> teamA = [1,4,2,4]
//        4
//        2
//        4
//        2-> teamB [] size m = 2
//        3-> teamB = [3,5]
//        5
//
//        Sample ōutput 0 :
//        2
//        4
//
//        Explanation 0 :
//        Given values are n =4, team A = [1,4,2,4], m= 2, and teamB = [3,5].
//        For teamB[0] = 3, we have 2 elements in teamA(teamA[0] = 1 and teamA[2] = 2) that are <_ teamB[0].
//        For teamB[1] = 5, we have 4 elements in teamA(teamA[0] = 1, teams[1] =4, teamA[2] = 2, and teamA[3] =4) that are <_teamB[1].
//        Thus , the function returns the array [2,4] as the answer.




import java.util.*;
public class Footballmatch {
    private static List<Integer> football(List<Integer> teamA, List<Integer> teamB){
        List<Integer> result = new ArrayList<>();

        Collections.sort(teamA);

        for (int goalB : teamB) {
            int count = getCountLessThanOrEqual(teamA, goalB);
            result.add(count);
        }

        return result;
    }

    private static int getCountLessThanOrEqual(List<Integer> teamA, int goalB) {
        int left = 0;
        int right = teamA.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (teamA.get(mid) <= goalB) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> teamA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            teamA.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> teamB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            teamB.add(scanner.nextInt());
        }

        List<Integer> result = football(teamA, teamB);

        for (int count : result) {
            System.out.println(count);
        }
    }
}
