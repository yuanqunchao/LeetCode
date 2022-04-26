import java.util.Random;

public class Sort {
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp;  // 临时变量
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 冒泡排序优化
    public static void bubbleSort1(int[] arr) {
        int temp;  // 临时变量
        boolean flag;  // 是否交换的标志
        for (int i = arr.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找到最小的数的下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小数交换到i位置
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // 希尔排序
    public static void shellSort(int[] arr) {
        int temp;
        int incre = arr.length;
        while (true) {
            incre = incre / 2;  // 增量变化
            for (int k = 0; k < incre; k++) {  // 根据增量划分子序列
                for (int i = k + incre; i < arr.length; i += incre) {
                    for (int j = i - incre; j >= k; j -= incre) {
                        if (arr[j] > arr[j + incre]) {
                            temp = arr[j];
                            arr[j] = arr[j + incre];
                            arr[j + incre] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int random = new Random().nextInt(right - left + 1) + left;
            // 将基准值交换到最后一个位置
            swap(arr, random, right);
            int pivot = arr[right];  // 基准值
            int rk = left - 1;
            for (int i = left; i < right; i++) {
                if (arr[i] < pivot) {
                    swap(arr, ++rk, i);
                }
            }
            swap(arr, rk + 1, right);
            quickSort(arr, left, rk);
            quickSort(arr, rk + 2, right);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 归并排序
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            // 对左右两部分分别调用递归排序
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            int i = left, j = mid + 1;  // i指向左半部分开始，j指向右半部分开始
            int[] tmp = new int[right - left + 1];
            int cnt = 0;
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    tmp[cnt++] = arr[i++];
                } else {
                    tmp[cnt++] = arr[j++];
                }
            }
            while (i <= mid) {
                tmp[cnt++] = arr[i++];
            }
            while (j <= right) {
                tmp[cnt++] = arr[j++];
            }
            for (int k = 0; k < right - left + 1; k++) {
                arr[left + k] = tmp[k];
            }
        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 1、调整堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        // 2、排序
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    // 调整堆
    public static void adjustHeap(int[] arr, int i, int len) {
        for (int k = 2 * i + 1; k < len; k = 2 * i + 1) {
            if (k + 1 < len && arr[k + 1] > arr[k]) {
                k += 1;
            }
            if (arr[i] < arr[k]) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 3, 2, 4, 6, 7, 8, 5};
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
