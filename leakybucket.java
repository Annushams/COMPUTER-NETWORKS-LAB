import java.util.*;
public class leakybucket
{
	static int min(int x,int y)
	{
		if(x<y)
		return x;
	else
		return y;
	}
	public static void main(String[] args)
 	{ 
 		int drop=0, j=0, iterations, b_size, count=0, mini, i, flow_rate;
		int inp[]=new int[25];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Bucket Size\n");
		b_size = sc.nextInt();
		System.out.println("Enter The Flow Rate\n");
		flow_rate = sc.nextInt();
		System.out.println("Enter The No. Of Iterations You Want To Stimulate\n");
		iterations=sc.nextInt();
		for(i=0;i<iterations;i++)
		{
			j = i+1; 
			System.out.print("Enter The Size Of The Packet Entering At "+ j + " Iteration : ");
			inp[i] = sc.nextInt();
		}
		System.out.println("\n|Iteration|Packet per Iteration| Packet Sent | Packet Left |Packet Dropped|\n");
		System.out.println("------------------------------------------------------------------------\n");
		for(i=0;i<iterations;i++)
		{
			count+=inp[i];
			if(count>b_size)
			{
				drop=count-b_size;
				count=b_size;
			}
			System.out.print(i+1);
			System.out.print("\t\t"+inp[i]);
			mini=min(count,flow_rate);
			System.out.print("\t\t"+mini);
			count=count-mini;
			System.out.print("\t\t"+count);
			System.out.print("\t\t"+drop);
			drop=0;
			System.out.println();
		}
		for(;count!=0;i++)
		{
			if(count>b_size)
			{
				drop=count-b_size;
				count=b_size;
			}
			System.out.print(i+1);
			System.out.print("\t\t0");
			mini=min(count,flow_rate);
			System.out.print("\t\t"+mini);
			count=count-mini;
			System.out.print("\t\t"+count);
			System.out.print("\t\t"+drop);
			System.out.println();
		}
	}
 }
