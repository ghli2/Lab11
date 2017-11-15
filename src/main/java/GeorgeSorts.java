import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@SuppressWarnings("checkstyle:all")
public class GeorgeSorts {

	public static void main(String[] args) {
	}
	public static <T> void printArr(T[] arr){
		for (T i : arr)
			System.out.print(i+" ");
		System.out.println();
	}
	//single threaded mergesort
	public static <T extends Comparable<T>> void mergeSort(T[] arr){
		if (arr.length <= 1)
			return;
		int pivPt = arr.length/2;
		T[] arrSlice1 = Arrays.copyOfRange(arr,0,pivPt);
		T[] arrSlice2 = Arrays.copyOfRange(arr,pivPt,arr.length);
		mergeSort(arrSlice1);
		mergeSort(arrSlice2);
		int a=0, b=0, c=0;
		while (c < arr.length) 
			arr[c++] =  (a < arrSlice1.length) && ( b >= arrSlice2.length || arrSlice1[a].compareTo(arrSlice2[b]) < 0) ? arrSlice1[a++] : arrSlice2[b++]; 
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] arr){
		for (int i = 0; i < arr.length-1;) {
			T min = arr[i+1];
			int mIndex = i+1;
			for (int j = i+1; j < arr.length;++j) {
				if (min.compareTo(arr[j]) > 0) {
					min = arr[j];
					mIndex = j;
				}
			}
			arr[mIndex] = arr[i];
			arr[i++] = min;
		}
	}
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		List<T> al = Arrays.asList(arr);
		for (int i = 1, temp = i; i < arr.length; ++i, temp=i) {
			while (temp > 0 && al.get(temp).compareTo(al.get(temp-1)) < 0)
					Collections.swap(al, temp, (temp--)-1);
		}
	}
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int swaps = 0;
		int i = 0;
		do {
			swaps = 0;
			for (i = 0; i < arr.length-1; ++i) {
				if (arr[i+1].compareTo(arr[i]) < 0) {
					++swaps;
					T temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
					
			}
		} while(swaps != 0);
	}
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		List<T> al = Arrays.asList(arr);
		quickSort(al);
	}
	private static <T extends Comparable<T>> void quickSort(List<T> arr) {
		if (arr.size() < 2)
			return;
		int piv = (int) (Math.random() * arr.size());
		for (int i = piv-1; i >= 0; --i) 
			if(arr.get(i).compareTo(arr.get(piv)) > 0) {
				for (;i<piv;++i)
					Collections.swap(arr, i, i+1);
				--piv;
			}
		for (int i = piv+1; i < arr.size(); ++i)
			if(arr.get(i).compareTo(arr.get(piv)) < 0) {
				for(;i>piv;--i)
					Collections.swap(arr, i, i-1);
				++piv;
			}
		quickSort(arr.subList(0, piv));
		quickSort(arr.subList(piv,arr.size()));
	}
}
