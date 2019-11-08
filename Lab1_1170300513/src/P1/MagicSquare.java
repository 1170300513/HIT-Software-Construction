package P1;
import java.io.*;
import java.util.*;
public class MagicSquare 
{
	
			public static void main(String[] args)
			{
				boolean s1 =  isLegalMagicSquare("1.txt");
				if(s1)
				{
					System.out.println("1.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("1.txt does not contains a MagicSquare.");
				}
				System.out.println();
				boolean s2 =  isLegalMagicSquare("2.txt");
				if(s2)
				{
					System.out.println("2.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("2.txt does not contains a MagicSquare.");
				}
				System.out.println();
				boolean s3 =  isLegalMagicSquare("3.txt");
				if(s3)
				{
					System.out.println("3.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("3.txt does not contains a MagicSquare.");
				}
				System.out.println();
				boolean s4 =  isLegalMagicSquare("4.txt");
				if(s4)
				{
					System.out.println("4.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("4.txt does not contains a MagicSquare.");
				}
				System.out.println();
				boolean s5 =  isLegalMagicSquare("5.txt");
				if(s5)
				{
					System.out.println("5.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("5.txt does not contains a MagicSquare.");
				}
				System.out.println();
				System.out.println("������n: ");
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				boolean s6 = generateMagicSquare(n);
			    s6 =  isLegalMagicSquare("6.txt");
				if(s6)
				{
					System.out.println("6.txt contains a MagicSquare.");
				}
				else
				{
					System.out.println("6.txt does not contains a MagicSquare.");
				}
				
			}
			
			public static boolean isLegalMagicSquare(String fileName)
			{
				int mycounter1 = 0;
				String [] line = new String[10000];
				//�ļ��Ķ�д��
			    try {
			    	
			    	String pathname = "src\\P1\\txt\\"+fileName;
			    	File filename = new File(pathname);
			    	InputStreamReader reader = new InputStreamReader(  new  FileInputStream(filename));
			    	BufferedReader br = new BufferedReader(reader);
				
			    	while((line[mycounter1]=br.readLine())!= null)
			    	{
			    		mycounter1 += 1;
			    	}
			    	}catch (Exception e) 
			    	{
			    		e.printStackTrace(); 
			    	}
			    
			    	int i , j , num ;
			    	int sum1 = 0;
			    	int sum2 = 0;
			    	int [][] square = new int[mycounter1][mycounter1];
			    	for(i = 0; i < mycounter1 ; i++)
			    	{
			    		
			    	  String[] sArray = line[i].split("\t"); //��txt��ÿһ���ַ����ָ�Ϊ���ֹ��ɵ��ַ�����
			    		num = sArray.length;
			    		if(num != mycounter1) //�����������������Ȼ���Ǿ��󣬲�����Magic Square�Ķ��壬������false����
			    		{
			    			System.out.println("It's not a matrix!");
			    			return false;
			    		}
			    		for(j = 0 ; j < num ; j++)
			    		{
			    		try {
			    			square[i][j] = Integer.valueOf(sArray[j]); //���ַ���ת��Ϊ����ֵ��
			    			if(square[i][j] < 0) //�����к��и������򲻷���Magic Square�Ķ��壬������false����
			    			{
			    				System.out.println("Number problems (non-positive integer)!");
			    				return false;
			    			}
			    		}catch (Exception e) { /**Integer.valueOf()�������������ո���С����ᴥ���쳣�����ô�������try/catch����
			    								 * ������С��������"\t"�������������false��*/
							System.out.println("Incorrect data format (with decimal or numeric spacing errors)!");
							return false;
						}
			    		//sum1�洢��һ�е�ֵ��sum2ͨ��ѭ����¼ÿ��ÿ�жԽ��ߵĺͣ����õ�ʽ�Ĵ����ԣ�ֻ��ÿ�ζ�������ղ��ܷ���Magic Square�Ķ��壬����true�����򷵻�false��	
			    		square[i][j] = Integer.valueOf(sArray[j]);
			    			sum2 += square[i][j];
			    			if(i == 0)
			    				sum1 = sum2;
			    		}
			    		if(sum2 != sum1)
			    			return false;	
			    		sum2 = 0;
			    	}
			    	for(i = 0; i < mycounter1 ; i++)
			    	{
			    		sum2 += square[i][i];
			    	}
			    	if(sum2 != sum1)
			    		return false;
			    	sum2 = 0;
			    	for(i = 0 ; i < mycounter1 ; i++)
			    	{
			    		sum2 += square[i][mycounter1-1-i];
			    	}
			    	if(sum2 != sum1)
			    		return false;
			   	

			    return true;
			}
			public static boolean generateMagicSquare(int n)
			{
				if(n < 0) //�ж�n�Ƿ�Ϊ����������Ϊ����ʾ�������ء�
				{
					System.out.println("n is negative��");
					System.out.println("false");
					System.exit(0);
				}
				try {
				int row = 0, col = n / 2, i, j, square = n * n;
				int magic[][] = new int[n][n];
				String[] liner = new String[n];
				for (i = 1; i <= square; i++) { //�޲����������׻÷���
					magic[row][col] = i; //һ�����������롣
					if (i % n == 0) //����б����Ī����
						row++;
					else {
						if (row == 0) //�ϳ���ʱ���·š�
							row = n - 1;
						else
							row--;
						if (col == (n - 1)) //�ҳ���ʱ����š�
							col = 0;
						else
							col++;
					}
				}

				for (i = 0; i < n; i++) { //����ʽ����÷���
					for (j = 0; j < n; j++)
					{
						System.out.print(magic[i][j] + "\t");
						if(j < n - 1 && liner[i] != null)
							liner[i] = liner[i] + magic[i][j] + "\t";
						else if(j < n - 1)
							liner[i] = magic[i][j] + "\t";
						else
							liner[i] = liner[i] + magic[i][j];

					}
					System.out.println();
				}
				File writename = new File("src\\P1\\txt\\6.txt");//����6.txt�����÷�����д��txt�ļ��С�
				writename.createNewFile();
				BufferedWriter out = new BufferedWriter(new FileWriter(writename));
				for(i = 0 ; i < n ; i++)
				{
					out.write(liner[i] + "\r\n");
				}
				out.close();
				}catch (Exception e) {
					System.out.println("n is even number��");
					System.out.println("false");
					System.exit(0);
				}
				return true;
			}
}
