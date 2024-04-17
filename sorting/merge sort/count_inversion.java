import java.util.ArrayList;

public class count_inversion {
    static int countInversion(int[] arr, int n) {
        return mergeSort(arr, 0, n - 1);
    }

    static int mergeSort(int[] arr, int s, int e) {
        int cnt = 0;

        if (s >= e)
            return cnt;

        int mid = (s + e) / 2;

        cnt += mergeSort(arr, s, mid);
        cnt += mergeSort(arr, mid + 1, e);

        cnt += merge(arr, s, mid, e);

        return cnt;
    }

    static int merge(int[] arr, int s, int m, int e) {
        ArrayList<Integer> temp = new ArrayList<>();

        int i = s;
        int j = m + 1;

        int cnt = 0;
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                cnt += (m - i + 1);

                j++;
            }
        }

        while (i <= m) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= e) {
            temp.add(arr[j]);
            j++;
        }

        for (int l = s; l <= e; l++) {
            arr[l] = temp.get(l - s);
        }

        return cnt;
    }
}
