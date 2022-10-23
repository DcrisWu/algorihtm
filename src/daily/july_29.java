package daily;

public class july_29 {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //选择一个点作为顶点，如果是正方形，必定会存在两个相邻的边，构成一个直角
        //选择p1作为起始顶点
        int[] a = {p2[0] - p1[0], p2[1] - p1[1]};
        int[] b = {p3[0] - p1[0], p3[1] - p1[1]};
        int[] c = {p4[0] - p1[0], p4[1] - p1[1]};
        int[] point1, point2, anotherPoint;
        if (a[0] * b[0] + a[1] * b[1] == 0) {
            point1 = p2;
            point2 = p3;
            anotherPoint = p4;
        } else if (a[0] * c[0] + a[1] * c[1] == 0) {
            point1 = p2;
            point2 = p4;
            anotherPoint = p3;
        } else if (b[0] * c[0] + b[1] * c[1] == 0) {
            point1 = p3;
            point2 = p4;
            anotherPoint = p2;
        } else {
            //如果不构成直角，就直接返回false
            return false;
        }
        //如果第四个角不是直角，就返回false
        if ((point1[0] - anotherPoint[0]) * (point2[0] - anotherPoint[0]) + (point1[1] - anotherPoint[1]) * (point2[1] - anotherPoint[1]) != 0) {
            return false;
        }
        //然后验证边长是否相等
        int edge1, edge2, edge3, edge4;
        edge1 = (int) (Math.pow(point1[0] - p1[0],2) + Math.pow(point1[1] - p1[1],2));
        edge2 = (int) (Math.pow(point2[0] - p1[0],2) + Math.pow(point2[1] - p1[1],2));
        edge3 = (int) (Math.pow(anotherPoint[0] - point1[0],2) + Math.pow(anotherPoint[1] - point1[1],2));
        edge4 = (int) (Math.pow(anotherPoint[0] - point2[0],2) + Math.pow(anotherPoint[1] - point2[1],2));
        return edge1 != 0 && edge1 == edge2 && edge2 == edge3 && edge3 == edge4;

    }

    public static void main(String[] args) {
        int[] a = {-1, 0};
        int[] b = {1, 0};
        int[] c = {0, 1};
        int[] d = {0, -1};
        System.out.println(validSquare(a, b, c, d));
    }
}
