import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Test {
        static int count = 0;

        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        heapSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + count);
            genAns();
        }

        static void heapify(int[] a, int i, int e) {
            int li = i;
            if (2 * i + 1 <= e && a[li] < a[2 * i + 1]) li = 2 * i + 1;
            if (2 * i + 2 <= e && a[li] < a[2 * i + 2]) li = 2 * i + 2;

            if (li != i) {

                int t = a[li];
                a[li] = a[i];
                a[i] = t;
                heapify(a, li, e);
                count++;
            }

        }

        static void buildHeap(int[] a, int e) {

            for (int i = (e - 1) / 2; i >= 0; i--){ heapify(a, i, e);}

        }

        static void heapSort(int[] a) {
            for (int i = a.length - 1; i > 0; i--) {

                buildHeap(a, i);
                int t = a[0];
                a[0] = a[i];
                a[i] = t;
            }

        }

        static void genAns() {
            System.out.printf("%-15s%-15s%-15s%-15s\n", "Ascending", "Descending", "Random", "Calculated Value");
            for (int i = 4; i <= 256; i *= 2) {
                int[] asc = new int[i],
                        des = new int[i],
                        rand = new int[i];
                Random r = new Random(4);
                for (int ind = 0; ind < i; ind++) {
                    asc[ind] = ind;
                    des[ind] = i - ind;
                    rand[ind] = r.nextInt();
                }
                count = 0;
                heapSort(asc);
                int ac = count;
                count = 0;
                heapSort(asc);
                int dc = count;
                heapSort(des);
                count = 0;
                heapSort(rand);
                int rn = count;
                int nlogn = i * (int) (Math.log10(i) / Math.log10(2));
                System.out.printf("%-15s%-15s%-15s%-15s\n", ac, dc, rn, nlogn);
            }
        }
    }
