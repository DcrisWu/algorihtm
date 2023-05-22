package 灵茶2022年周赛总结.下半年.模拟.code_2409_统计共同度过的日子数;

/**
 * completion time = 2023.5.22
 */
class Solution {
    private int arriveAliceMonth;
    private int arriveAliceDate;
    private int leaveAliceMonth;
    private int leaveAliceDate;

    private int arriveBobMonth;
    private int arriveBobDate;
    private int leaveBobMonth;
    private int leaveBobDate;

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        this.arriveAliceMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        this.arriveAliceDate = Integer.parseInt(arriveAlice.substring(3, 5));
        this.leaveAliceMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        this.leaveAliceDate = Integer.parseInt(leaveAlice.substring(3, 5));

        this.arriveBobMonth = Integer.parseInt(arriveBob.substring(0, 2));
        this.arriveBobDate = Integer.parseInt(arriveBob.substring(3, 5));
        this.leaveBobMonth = Integer.parseInt(leaveBob.substring(0, 2));
        this.leaveBobDate = Integer.parseInt(leaveBob.substring(3, 5));

        int count = 0;
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = arriveAliceMonth; i <= leaveAliceMonth; i++) {
            if (i == arriveAliceMonth) {
                for (int j = arriveAliceDate; j <= months[i - 1]; j++) {
                    if (together(i, j)) {
                        count++;
                    }
                }
                continue;
            }
            if (i == leaveAliceMonth) {
                for (int j = 1; j <= leaveAliceDate; j++) {
                    if (together(i, j)) {
                        count++;
                    }
                }
                continue;
            }
            for (int j = 1; j <= months[i - 1]; j++) {
                if (together(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean together(int month, int date) {
        return ((month > arriveAliceMonth || (month == arriveAliceMonth && date >= arriveAliceDate)) &&
                (month < leaveAliceMonth || (month == leaveAliceMonth && date <= leaveAliceDate))) &&
                ((month > arriveBobMonth || (month == arriveBobMonth && date >= arriveBobDate)) &&
                        (month < leaveBobMonth || (month == leaveBobMonth && date <= leaveBobDate)));
    }
}