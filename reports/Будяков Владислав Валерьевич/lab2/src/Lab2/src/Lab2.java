import java.util.*;
import java.io.*;

public class Lab2 
{

	public static void main(String[] args) throws IOException
	{
		
/////////TASK1////////////////////////////////////////////
		StringBuilder text= new StringBuilder();
		FileReader reader = new FileReader("K:\\file.txt");
		BufferedReader br = new BufferedReader(reader);
		String line;
		
		while((line = br.readLine())!=null){
		text.append(line);
		}
		br.close();
		//System.out.println(text);
		String[] words = text.toString().split("[?!., ]");
		//System.out.println(words);
		Vector<String> vec = new Vector();
		for(String word: words) 
		{
			vec.addElement(word);
		}
		while (!vec.isEmpty())
		{
			String first = (String) vec.firstElement();
			int count = 0;
			while(vec.contains(first))
			{
				count++;
				vec.remove(first);
			}
			System.out.println(first+" "+count);
		}	
	}
}
