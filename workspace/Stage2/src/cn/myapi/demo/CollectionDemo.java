package cn.myapi.demo;

public class CollectionDemo {
	/**
	* @param 模拟一个 Collections min(Collecton coll,Comparator comp)
	*/
	public static void main(String[] args) {
		String[] arr=new String[3];
		swap(arr,1,2);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static <T> void swap(T[] arr, int i, int j) {
		T temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}