import java.util.*;
import java.io.*;

public class assfive
{
	public long dictCount = 0;
	public int wordsFound = 0;
	public int wordsNotFound = 0;
	public double compFound = 0;
	public double compNotFound = 0;
	public double avgcompswordsfound = 0.0;
	public double avgcompswordsnotfound = 0.0;
	BinarySearchTree[] dict = new BinarySearchTree[26];
	
	public static void main (String[] args)
	{
		long Start = System.nanoTime();
		assfive ryan = new assfive();
		ryan.makeDict();
		ryan.parseString();
		ryan.averages();
		long Stop = System.nanoTime();
		long time = (Stop - Start);
		System.out.println("time = " + time);

		
		//avgcompswordsfound =  compFound / wordsFound; // ( avg # of comps per word)
		//avgcompswordsnotfound = compNotFound / wordsNotFound; //(avg # of comps per word not found)
	}
	public void averages()
	{
		avgcompswordsfound =  compFound / wordsFound; // ( avg # of comps per word)
		avgcompswordsnotfound = compNotFound / wordsNotFound; //(avg # of comps per word not found)	
		System.out.println("average comps words found= " + avgcompswordsfound);
		System.out.println("average comps words notfound= " + avgcompswordsnotfound);
		System.out.println("words found = " + wordsFound);
		System.out.println("words not found = " + wordsNotFound);
	}
	public void makeDict(){
		for(int i = 0 ; i < dict.length; i++)
			dict[i] = new BinarySearchTree<String>(); 

		try{	
			File f = new File("random_dictionary.txt");
			Scanner scan = new Scanner(f);
			
			while (scan.hasNext())
			{	
			String word = scan.nextLine();
			String Lword = word.toLowerCase();
		
			dict[Lword.charAt(0) - 97].insert(Lword);
			dictCount ++;
			}	
			scan.close();
		}
		catch(IOException e)
		{
			System.out.println("Unable to read file");
		}
		System.out.println("There were " + dictCount + " words added to dictionary MyLinkedList");
	
	}
	
	
	public void parseString()
	{		
		try{	
				File f = new File("oliver.txt");
				Scanner scan = new Scanner(f);
				String word = "";
				while(scan.hasNext())
				{
					/**read in next line trim spaces before and after.....converts to lowercase.....
					replaces all undesiaables with spaces.....then splits on spaces
					*/
					String[] array = scan.nextLine().trim().toLowerCase().replaceAll("[^A-Za-z]", " ").split("\\s+");	
				   
					for(int i = 0; i < array.length; i++)
					{
						if(!array[i].isEmpty())
							{
								int find = array[i].charAt(0) - 97;
								
								if (dict[find].search(array[i]))
								{
									//new here!
									ArrayList<Integer> list = dict[find].path2(array[i]); 	
									compFound += list.indexOf(array[i]) +1;
									//old below
									//compFound += dict[find].indexOf(array[i]) +1;
									wordsFound++;
								}
								else
								{
									wordsNotFound++;
									ArrayList<Integer> list = dict[find].path2(array[i]);
									compNotFound += list.size();
									//counter to count comparsions because it wont be N if not found it will be log n
									//path returns array list!!!!!!!!
								}
							}		
					}
				
			}
			scan.close();
		}
		catch(IOException r)
		{
			System.out.println("Unable to read file");
		}
		
	
	}
}	