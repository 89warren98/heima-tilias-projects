package Works;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int limit = 10000;  // 指定寻找素数的范围上限
        System.out.println("范围内的素数有：");

        for (int num = 2; num <= limit; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }

    // 判断一个数是否是素数
    public static boolean isPrime(int number) {
        // 2 是素数
        if (number == 2) {
            return true;
        }

        // 排除偶数（除了2，其他偶数都不是素数）
        if (number % 2 == 0) {
            return false;
        }

        // 检查从3开始到sqrt(number)的所有奇数
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;  // 如果能被整除，则不是素数
            }
        }

        // 没有找到可以整除的数，说明是素数
        return true;
    }
}
