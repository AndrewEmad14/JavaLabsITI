import java.util.Arrays; 
public class MinMax {
	public static void printMaxAndMin(int inputArr[]){
		int minimum=inputArr[0],maximum=inputArr[0];
		for(int i=1;i<inputArr.length;i++){
			if(inputArr[i]>maximum){
				maximum=inputArr[i];
			}else if(inputArr[i]<minimum){
				minimum=inputArr[i];
			}
		}
		System.out.println("Maximum= "+maximum+" Minimum= "+minimum);
	}
	public static int customBinarySearch(int target,int inputArr[]){
		int start=0,end=inputArr.length-1;
		int mid=0;
		while(start<=end){
			mid = start+(end-start)/2;
			if(inputArr[mid]==target){
				return mid;
			}else if(inputArr[mid]>target){
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {


		int inputArr[] = new int[1000];
		
		for(int i=0;i<1000;i++){
			inputArr[i]=(int)(Math.random()*1000);        	
		}
		
		
		Arrays.sort(inputArr);
		long startTime=System.currentTimeMillis();
		int target=customBinarySearch(10,inputArr);
		//printMaxAndMin(inputArr);
		long endTime=System.currentTimeMillis();
		long computedTime=endTime-startTime;
		System.out.println("Computed Time= "+computedTime+"ms");


	}
}
