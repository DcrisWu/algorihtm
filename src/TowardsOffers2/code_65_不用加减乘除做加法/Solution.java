package TowardsOffers2.code_65_不用加减乘除做加法;

class Solution {
    public int add(int a, int b) {
        int res = 0;
        int carry = 0, sum = 0;
        for (int i = 0; i < 32; i++) {
            int abit = (a >> i) & 1;
            int bbit = (b >> i) & 1;
            sum = abit ^ bbit ^ carry;
            carry = abit & bbit | carry & abit | carry & bbit;
            res = res | (sum << i);
        }
        return res;
    }
}
