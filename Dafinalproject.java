
package dafinalproject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

import org.jgrapht.*;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;


class MyProject
{
    char again = 0;
    Scanner scanObj = new Scanner(System.in);
    private HashSet <String> WordList = new HashSet<String>();
    private Scanner scanFile;
    String beginWord;
    String endWord;
    String searchWord;
   public void search(TreeSet<String> treeSet){
       Scanner scanObj = new Scanner(System.in);
       System.out.println("Search = "); searchWord = scanObj.nextLine();
       Set<String> similarWords = new HashSet<String>(treeSet);
       char firstLetter = searchWord.charAt(0);
       
       for(String word : similarWords){
                        char checkLetter = word.charAt(0);
                        if(firstLetter == checkLetter){
                            if((word.contains(searchWord)) == true ){
                                System.out.println(word);
                            }
                        }
                    }

   }
public Set<String> searchladder(String begin, String end, Set<String> wordsDict){
    Set<String> temp = new HashSet<String>();    
    char firstLetter = begin.charAt(0);
            for(String word : wordsDict){
                        char checkLetter = word.charAt(0);
                        if(firstLetter == checkLetter){
                            if((word.contains(searchWord)) == true ){
                                System.out.println(word);
                                temp.add(word);
                                
                            }
                        }
                    }

    return temp;

}
public int length2(String begin, String end, Set<String> wordsDict) {
    Queue<String> curLevel = new LinkedList<>();
    Queue<String> nextLevel = new LinkedList<>();
    curLevel.add(begin);
    
    wordsDict.add(end);

    String curWord;
    int level = 0;

    while(!curLevel.isEmpty()){
        level++;
        while(!curLevel.isEmpty()) {
            curWord = curLevel.poll();

            char[] arr = curWord.toCharArray();
            char[] arr2 = end.toCharArray();
            for(int i=0; i< arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    
                    if(arr[i] != arr2[i])
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);

                    if(newWord.equals(end)){
                        return level;
                    }
                    if(wordsDict.contains(newWord)){
                        System.out.println(newWord);
                        nextLevel.add(newWord);
                        wordsDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }
        curLevel = nextLevel;
        nextLevel = new LinkedList<>();

    }

    return 0;
}
    MyProject(){
        do{ 
        try{
            Scanner scanObj = new Scanner(System.in);
            Scanner scanObj2 = new Scanner(System.in);
            System.out.println("Enter filename (Only)");
            String fileName = scanObj.nextLine();
            scanFile = null;
            try{
                scanFile = new Scanner(new File(fileName+".txt"));
                String temp = null;

                while(scanFile.hasNext()) {
                    String line = scanFile.nextLine();
                    String buf[] = line.split("(?<=\\G.....)");
                    temp = buf[0];
                    WordList.add(temp);

                    }
                    try{
                        TreeSet<String> treeSet = new TreeSet<String>(WordList); 
                        List<String> list = new ArrayList<String>(WordList);
                        Collections.sort(list);
                        
                        System.out.println("Search?: "); char ans = scanObj.next().charAt(0);
                        if(ans == 'Y' || ans == 'y'){ search(treeSet);
                            }else{
                                    System.out.println("Enter 5-letter word 1 = ");
                                    beginWord = scanObj2.nextLine();
                                    System.out.println("Enter 5-letter word 2 = "); 
                                    endWord = scanObj2.nextLine();
                                    int distance = length2(beginWord,endWord, WordList);
                                    //int distance = ladder(beginWord,endWord,list);
                                    System.out.println(distance);
                                    //searchladder(list,beginWord,endWord);
                                }
                        
                        

                        
                        
                    
                    }catch(Exception e){/*WordLadder inputing*/}
         
            }catch(Exception e){ /* catch for buffered */ }
            
            
            
        }catch(Exception e) /*catch for filename*/{System.out.println("File name is wrong is not exist!.\n");}
        
     }while(again == 'Y' || again =='y');    
    }    
    
        
    
}

public class Dafinalproject {

    public static void main(String[] args) {
    new MyProject();   
           
    }// end of main
}// end of file

           //run again argument System.out.println("Continue Y/y");
               // again = scanObj.next().charAt(0);

 
                      /* 
                       String nextWord = new String(word);
                       if(unvisited.contains(nextWord)){
                           
                           if(nextWord.equals(endWord))
                               return distance;
                           else{
                               queue.offer(nextWord);
                               System.out.println(nextWord);
                               unvisited.remove(nextWord);
                           }
                       }
                       */