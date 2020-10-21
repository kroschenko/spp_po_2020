
public class Lab1_SPP 
{

	
	public static void main(String[] args) 
	{
		
		Moda(1,0,4,9,5,6,7,3);
		
		double arr[] = {1,2,3,4,5,6,7};
		arr = shiftRight(arr, 3);
		for (int i = 0; i < arr.length; i++) 
			System.out.println(arr[i]);
		System.out.println(pangramEng("abcdefghijklmnoprstuvwxyz"));
	}
	
//////////////First task/////////////////
	public static void Moda(int ...digits)
	{
		int max = 0;
		for(int i=0; i<digits.length; i++)
			if (max<digits[i]) max = digits[i];
		
		int arr[] = new int[max+1];
		for(int i=0; i<arr.length; i++)
			arr[i] = 0;
		
		for(int c: digits)
		{
			arr[c] += 1;
		}
		
		max = 0;
		for(int i=0; i<arr.length; i++)
			if (max<arr[i]) max = arr[i];
		if (max != 1)
		{
			for(int i=0; i<arr.length; i++)
				if (arr[i]==max) System.out.println(i);
		}
		else System.out.println("No Moda in this array");	
	}
	
//////////////Second task/////////////////
	public static double[] shiftRight(double[] arr, int shift)
	{
		for (int j = 0; j<shift; j++)
		{
	    	double temp = arr[j];
		    for (int i = j+1; i < arr.length; i++) 
		    {
		        arr[j] = arr[i];// сохран€ем текущий элемент во временную €чейку 1
		        arr[i] = temp;   // вставл€ем в текущую €чейку предыдущий
		        temp = arr[j]; // запоминаем текущий элемент, чтоб использовать в следующей итерации цикла
		    }
		     arr[j] = arr.length-shift+j+1;
		}
		return arr;
	}
//////////////Third task/////////////////
	public static boolean pangramEng(String str)
	{
		int count = 0;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		str = str.toLowerCase();
		for(int i=0; i<alphabet.length(); i++)
		{
			for(int j=0; j<str.length(); j++)
			{
				if(alphabet.charAt(i)==str.charAt(j))
				{
					count++;
					break;
				}
			}
		}
		if (count >= 24) return true; else return false;
	}
	
}
