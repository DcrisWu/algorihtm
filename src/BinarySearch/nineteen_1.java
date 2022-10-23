package BinarySearch;

public class nineteen_1 {
    public static void main(String[] args) {
        nineteen_1 nineteen_1 = new nineteen_1();
        int[] arr = {1, 2, 3};
        System.out.println(nineteen_1.findLatestStep(arr, 2));
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[] link = new int[n + 2];
        int cnt = -1;
        int m_num = 0;
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            //左右都为0
            if (link[index - 1] == 0 && link[index + 1] == 0) {
                link[index] = index;
                if (m == 1) {
                    m_num += 1;
                }
            }
            //左边为0，右边不为0
            else if (link[index - 1] == 0 && link[index + 1] != 0) {
                if (link[index + 1] - index == m) {
                    m_num -= 1;
                }
                int right = link[index + 1];
                link[index + 1] = 0;
                link[right] = index;
                link[index] = right;
                if (right - index + 1 == m) {
                    m_num += 1;
                }
            }
            //左边不为0，右边为0
            else if (link[index - 1] != 0 && link[index + 1] == 0) {
                if (index - link[index - 1] == m) {
                    m_num -= 1;
                }
                int left = link[index - 1];
                link[index - 1] = 0;
                link[left] = index;
                link[index] = left;
                if (index - left + 1 == m) {
                    m_num += 1;
                }
            }
            //左右都不为0
            else {
                if (Math.abs(link[index - 1] - (index - 1)) + 1 == m) {
                    m_num -= 1;
                }
                if (Math.abs(link[index + 1] - (index + 1)) + 1 == m) {
                    m_num -= 1;
                }
                int left = link[index - 1];
                int right = link[index + 1];
                link[index - 1] = 0;
                link[index + 1] = 0;
                link[left] = right;
                link[right] = left;
                if (right - left + 1 == m) {
                    m_num += 1;
                }
            }
            if (m_num != 0) {
                cnt = i + 1;
            }
        }
        return cnt;
    }
}
