package JavaProject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class program {
	@SuppressWarnings("unused")
	public static boolean allcheck(int[] data) {
		for(int x =0;x<data.length;x++) {
			for(int i=0;i<data.length;i++) {
				if((i!=x)&&(data[x]==data[i]))
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] datainput = new int[n];
		int[] datasort = new int[n];
		int[] dataoutput = new int[n];
		String[] test = br.readLine().split(" ");
		for(int i =0;i<n;i++)
			datainput[i] = Integer.valueOf(test[i]);
		datasort = Arrays.copyOf(datainput, n);
		Arrays.sort(datasort);
		for(int i =0;i<n;i++)
			dataoutput[i]=Arrays.binarySearch(datasort,datainput[i]);
		//logic TRUE
		do {
			dataoutput[dataoutput.length-1]+=1;
			for(int i=n-1;i>=1;i--) {
				if(dataoutput[i]== n) {
					dataoutput[i-1]+=1;
					dataoutput[i]=0;
				}
				if(dataoutput[0]==n) {
					System.out.println("\nAnswer :");
					for(int x=0;x<n;x++)
						System.out.print(datainput[x]+",");
					return ;
				}
			}
		}while(!allcheck(dataoutput));
		//output
		System.out.println("Answer :");
		for(int i=0;i<n-1;i++)
			System.out.print(datasort[dataoutput[i]]+"-");
		System.out.print(datasort[dataoutput[n-1]]);
	}
}
