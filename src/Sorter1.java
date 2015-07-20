//Работа 4: Сортировка массивов. Минин Евгений Александрович, ИН-21\2
public class Sorter1 {
	int assign_count = 0;
	int compare_count = 0;
	int max_number = 7003;
	int length;
	long time;
	double time_end;
	int[] arr;
	String rand_output = "", output = "";
	public void generateRandomArray(int length){
		 int i;
		 int[] temp_arr = new int[length];
	     for(i = 0; i < length; i++) {
	         temp_arr[i] = (int) (Math.random() * max_number);
	     }
	     this.arr = temp_arr;
	}
	public void generateStraightArray(int length){
		 int[] temp_arr = new int[length];
	     for(int i = 0; i < length; i++) {
	         temp_arr[i] = i;
	     }
	     this.arr = temp_arr;
	}
	public void generateReversedArray(int length){
		 int[] temp_arr = new int[length];
	     for(int i = 0; i < length; i++) {
	         temp_arr[i] = length - i;
	     }
	     this.arr = temp_arr;
	}
	public void printArray(){
		 for(int i = 0; i < this.arr.length; i++){
			 System.out.println("arr["+ i + "] = " + arr[i]);
		 }
	}
	public void insertionSort() {
	     int i, j, key;
	     for(j = 1; j < arr.length; j++){
	          key = this.arr[j];
	          i = j - 1;
	          assign_count+=2;
	          while ( i >= 0 && this.arr[i] > key) {
	                this.arr[i+1] = this.arr[i];
	                i = i - 1;
	                assign_count+=2;
	          }
              compare_count+=2;
	          this.arr[i+1] = key;
	          assign_count++;
	     }
	}
	public int[] sort(int[] a) {
        if (a.length == 1) {
            return a;
        }

        int middle = a.length / 2;
        assign_count++;
        int[] left = new int[middle];
        int[] right = new int[a.length - middle];

        for (int i = 0; i < a.length; i++) {
            if (i < middle) {
                left[i] = a[i];
                assign_count++;
                compare_count++;
            } else {
                right[i - middle] = a[i];
                compare_count++;
            }
        }

        return mergeSort(sort(left), sort(right));
    }

    private int[] mergeSort(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (k < result.length) {
            if (i == left.length) {
                result[k] = right[j];
                j++;
            } else if (j == right.length) {
                result[k] = left[i];
                i++;
            } else {
                if (left[i] < right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
                compare_count++;
            }
            compare_count += 2;
            k++;
            assign_count += 3;
        }
        return result;
    }
	public void heapSort(){
	    int i, temp;
	    for (i = (this.arr.length / 2) - 1; i >= 0; i--){
	        siftDown(i, this.arr.length);
	    }
	    for (i = this.arr.length - 1; i >= 1; i--){
	        temp = this.arr[0];
	        this.arr[0] = this.arr[i];
	        this.arr[i] = temp;
	        assign_count+=3;
	        siftDown(0, i - 1);
	    }
	}
	public void siftDown(int i, int j){
	    boolean done = false;
	    int maxChild;
	    int temp;
	 
	    while ((i * 2 < j) && (!done)){
	    	compare_count+=2;
	        if (i * 2 == j){
	        	maxChild = i * 2;
	        	assign_count++;
	        }
	        else if (this.arr[i * 2] > this.arr[i * 2 + 1]){
	            maxChild = i * 2;
	            assign_count++;
	        }
	        else{
	            maxChild = i * 2 + 1;
	            assign_count++;
	        }
	        if (this.arr[i] < this.arr[maxChild]){
	            temp = this.arr[i];
	            this.arr[i] = this.arr[maxChild];
	            this.arr[maxChild] = temp;
	            i = maxChild;
	            assign_count+=4;
	            compare_count++;
	        }
	        else{
	            done = true;
	           
	        }
	    }
	}
	public void quickSort(int low, int high) {
	      int i = low;
	      int j = high;
	      int x = this.arr[(low+high)/2];
	      do {
	         while(this.arr[i] < x){
	        	 assign_count++;
	        	 compare_count++;
	        	 ++i;
	         }
	         while(this.arr[j] > x){
	        	 assign_count++;
	        	 compare_count++;
	        	 --j;
	         }
	         if(i <= j){
	            int temp = this.arr[i];
	            this.arr[i] = this.arr[j];
	            this.arr[j] = temp;
	            i ++ ; j --;
	            assign_count+=5;
	            compare_count++;
	         }
	      } while(i <= j);
	      //рекурсивные вызовы функции quickSort  
	      if(low < j) quickSort(low, j);
	      if(i < high) quickSort(i, high);
	  }
	public void tester(int length, String arr_type, int sort_kind){
		this.length = length;
		this.compare_count = 0;
		this.assign_count = 0;
		if(arr_type == "Random") generateRandomArray(length);
		else if(arr_type == "Straight") generateStraightArray(length);
		else if (arr_type == "Reversed") generateReversedArray(length);
		for (int i = 0; i < length; i++){
			rand_output += Integer.toString(this.arr[i]) + "; ";
		}
		time = System.nanoTime();
        if(sort_kind == 1){
        	insertionSort();
        }
        else if(sort_kind == 2){
        	sort(this.arr);
        }
        else if(sort_kind == 3){
        	heapSort();
        }
        else if(sort_kind == 4){
        	quickSort(0,length-1);
        }
        for (int i = 0; i < length; i++){
			output += Integer.toString(this.arr[i]) + "; ";
		}
        time_end = (double)(System.nanoTime() - time) / 1000000000;
	}
}