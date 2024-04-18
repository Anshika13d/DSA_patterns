public class Search_in_rotated_sorted_array {
    int search(int A[], int l, int h, int t) {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (A[mid] == t)
                return mid;

            if (A[mid] >= A[l]) {
                if (A[l] <= t && t <= A[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[mid] <= t && t <= A[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return -1;
    }
}
