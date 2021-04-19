public class Exam2Voting {
    static int checkNumbers(int[] numbers, int low, int high) {
        for (int number : numbers) {
            // Declare and initialize mid
            int mid = low + (high - low) / 2;

            if (high < low) return -1;

            if (number == numbers[mid]) {
                return mid;
            } else if (number < numbers[mid]) {
                return checkNumbers(numbers, low, mid - 1);
            } else {
                System.out.println("else");
            }
        }
/* Divide and Conquer Algorithm in O(nlogn)
        int search(int[] A, int low, int high, int key){
            if (high < low) return NO_FOUND;
            mid = low + (high-low)/2

            if (key == A[mid]) return mid
            else if key < A[mid] return search(A, low, mid–1, key)
	else return search(A, mid+1, high, key)
        }
*/
        return -1;
    }
}
