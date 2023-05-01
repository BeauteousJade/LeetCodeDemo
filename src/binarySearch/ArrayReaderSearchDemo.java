package binarySearch;

/**
 * 702. 搜索长度未知的有序数组 -- 二分
 * <p>
 * https://leetcode.cn/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class ArrayReaderSearchDemo {

    public static void main(String[] args) {
        ArrayReaderSearchDemo demo = new ArrayReaderSearchDemo();
        int[] array = {-1, 0, 3, 5, 9, 12};

        System.out.println(demo.searchV2(new ArrayReaderImpl(array), 9));
    }


    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = (int) Math.pow(10, 4);
        while (left < right) {
            int mid = (left + right) / 2;
            int value = reader.get(mid);
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 谁前进或者后退，最后就选择哪一个。
        return reader.get(left) == target ? left : -1;
    }


    public int searchV2(ArrayReader reader, int target) {
        int left = 0;
        int right = (int) Math.pow(10, 4);
        while (left < right) {
            int mid = (left + right) / 2;
            int value = reader.get(mid);
            if (value == target) {
                return mid;
            }
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 这里两个都前进或者后退了的，所以都得判断。
        if (reader.get(left) == target) {
            return left;
        }
        if (reader.get(right) == target) {
            return right;
        }
        return -1;
    }

    public int searchV3(ArrayReader reader, int target) {
        int left = 0;
        int right = (int) Math.pow(10, 4);
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = reader.get(mid);
            if (value == target) {
                return mid;
            }
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static class ArrayReaderImpl implements ArrayReader {

        private final int[] array;

        public ArrayReaderImpl(int[] array) {
            this.array = array;
        }


        @Override
        public int get(int index) {
            if (index >= array.length) {
                return Integer.MAX_VALUE;
            }
            return array[index];
        }
    }


    interface ArrayReader {
        int get(int index);
    }
}
