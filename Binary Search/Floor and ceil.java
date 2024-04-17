import java.util.*;
import java.io.*;

public class Solution {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = getFloor(a, n, x);
        int ceil = getCeil(a, n, x);

        int[] ans = new int[2];
        ans[0] = floor;
        ans[1] = ceil;

        return ans;
    }

    public static int getCeil(int[] a, int n, int x) {
        int l = 0;
        int r = n - 1;
        int ceil = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == x) {
                return a[mid]; // If element found, return as ceil
            }

            if (a[mid] > x) {
                ceil = a[mid];
                r = mid - 1;
            }

            else {
                l = mid + 1;
            }
        }

        return ceil;
    }

    public static int getFloor(int[] a, int n, int x) {
        int l = 0;
        int r = n - 1;
        int floor = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == x) {
                return a[mid];
            }

            else if (a[mid] > x) {
                r = mid - 1;
            }

            else {
                floor = a[mid];
                l = mid + 1;
            }
        }

        return floor;
    }

}