package task1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	/*
	 * task 1.1
	 */
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearch(target, 0);
	}

	private int recursiveLinearSearch(int target, int index) {
		if (index >= array.length) {
			return -1; // Trường hợp không tìm thấy
		}

		if (array[index] == target) {
			return index; // Trường hợp tìm thấy target tại vị trí index
		}

		// Gọi đệ quy với index tăng lên 1 để tìm kiếm tiếp
		return recursiveLinearSearch(target, index + 1);
	}

	/*
	 * task 1.2
	 */
	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int iterativeBinarySearch(int size, int target) {
		for (int i = 0; i < size - 1; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;

	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearch(target, 0, array.length - 1);
	}

	private int recursiveBinarySearch(int target, int left, int right) {
		if (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid; // Trả về index nếu tìm thấy target
			} else if (array[mid] < target) {
				return recursiveBinarySearch(target, mid + 1, right);
			} else {
				return recursiveBinarySearch(target, left, mid - 1);
			}
		}

		return -1; // Trường hợp không tìm thấy, trả về -1
	}

//	/*
//	 * task 1.3
//	 */
//	public void sortDescending() {
//        Arrays.sort(array);
//        reverseArray();
//    }
//
//    // Đảo ngược mảng
//    private void reverseArray() {
//        int left = 0;
//        int right = array.length - 1;
//
//        while (left < right) {
//            // Hoán đổi phần tử left và right
//            int temp = array[left];
//            array[left] = array[right];
//            array[right] = temp;
//
//            // Di chuyển left về phía trước và right về phía sau
//            left++;
//            right--;
//        }
//    }

	
	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target1 = 45;

		MyArray myArray = new MyArray(array);
		//myArray.sortDescending();

		int result1 = myArray.recursiveLinearSearch(target1);
		System.out.println(result1);
		int result2 = myArray.recursiveBinarySearch(target1);
		System.out.println(result2);
		
	}
}
