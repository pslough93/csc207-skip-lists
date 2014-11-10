package taojava.expt;

import java.io.PrintWriter;
import java.util.Iterator;

import taojava.util.SkipList;
import taojava.util.SkipList.Node;

/**
 * An experiment with SkipLists.
 * 
 * @author Samuel A. Rebelsky
 */
public class SkipListExpt
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    SortedListExpt.stringExperiment(pen, new SkipList<String>());
    
    /*SkipList<Integer> sl = new SkipList<Integer>();
    Iterator<Integer> slit = sl.iterator();
    
    sl.add(1);
    sl.add(2);
    sl.add(2);
    sl.add(4);
    
    while(slit.hasNext()){
    	pen.println(slit.next());
    }

    
    pen.println(sl.contains(1));
    pen.println(sl.contains(2));
    pen.println(sl.contains(3));
    pen.println(sl.contains(4));
    sl.remove(1);
    sl.remove(2);
    sl.remove(3);
    sl.remove(5);
    pen.println(sl.contains(1));
    pen.println(sl.contains(2));
    pen.println(sl.contains(3));
    pen.println(sl.contains(4));

    
    Iterator<Integer> slit2 = sl.iterator();

    while(slit2.hasNext()){
    	pen.println(slit2.next());
    }
*/
    
    pen.flush();
  } // main(String[])
} // class SkipListExpt

