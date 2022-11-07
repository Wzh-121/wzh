import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner inport = new Scanner(System.in);
        int i, n;
        int[] num = new int[100];
        n = inport.nextInt();
        for (i = 0; i < n; i++)
            num[i] = inport.nextInt();
        Max max = new Max();
        System.out.println("连续子元素的最大和为: " + max.sum(num));
    }

}
class Max{
    public  int sum(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (sum <= 0) {
                sum = num[i];
            } else {
                sum = sum + num[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

