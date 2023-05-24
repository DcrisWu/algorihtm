package 灵茶2022年周赛总结.下半年.模拟.code_2502_设计内存分配器;

class Allocator {

    private int[] memory;

    public Allocator(int n) {
        memory = new int[n];
    }

    public int allocate(int size, int mID) {
        int cnt = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] != 0) {
                cnt = 0;
            } else {
                cnt++;
                if (cnt == size) {
                    for (int j = i; j > i - size; j--) {
                        memory[j] = mID;
                    }
                    return i - size + 1;
                }
            }
        }
        return -1;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = 0;
                cnt++;
            }
        }
        return cnt;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
