package daily;

public class july_24 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //sum表示路程总和
        int sum = 0;
        for (int i : distance) {
            sum += i;
        }
        int temp = 0;
        int n = distance.length;
        int end = destination > start ? destination : (destination + n);
        for (int j = start; j < end; j++) {
            temp += distance[j % n];
        }
        return Math.min(temp, (sum - temp));
    }
}
