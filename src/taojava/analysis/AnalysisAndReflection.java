package taojava.analysis;

public class AnalysisAndReflection {
/*
 * This comment will comprise parts 4 and 5
 * 
 * Part 4:
 * Here is a sample run of SkipListAnalyzer:
 *             add/1   index iterate   add/2   rem/1   rem/2   total
Round  0       64       0       4      42      41      12     151
Round  1       37       0       5      54      27       4     123
Round  2       29       0       2      46      15       5      92
Round  3       31       0       0      35      22       7      88
Round  4       26       0       2      45      17       6      90
Round  5       36       0       3      53      13       4     105
Round  6       28       0       3      48      21       7     100
Round  7       35       0       2      51      18       6     106
Round  8       25       0       2      46      22       7      95
Round  9       36       0       0      36      21       7      93
Round 10       38       0       2      46      26       7     112
Round 11       28       0       2      53      26      10     110
Round 12       37       0       0      33      18       7      88
Round 13       29       0       2      46      23       7     100
Round 14       33       0       2      42      27       7     104
Round 15       36       0       0      37      24       9      97
Round 16       34       0       5      47      22       7     108
Round 17       30       0       2      46      28       7     106
Round 18       25       0       2      43      26       9      96
Round 19       35       0       3      52      16       5     106
Average        33       0       2      45      22       7     103

Indexing in all tests has been removed because my skip list implementation
does not have a good get method

Here is a run of SortedArrayListAnalyzer

            add/1   index iterate   add/2   rem/1   rem/2   total
Round  0       57       0       6     136     249      74     448
Round  1       57       0       1     127     243      83     428
Round  2       52       0       0     122     236      78     410
Round  3       50       0       0     133     228      72     411
Round  4       50       0       0     135     220      75     405
Round  5       50       0       0     125     233      76     408
Round  6       41       0       0     126     215      66     382
Round  7       41       0       1     139     221      68     402
Round  8       49       0       0     129     227      65     405
Round  9       50       0       0     141     221      75     412
Round 10       43       0       0     131     234      72     408
Round 11       46       0       0     122     236      75     404
Round 12       46       0       0     125     231      72     402
Round 13       41       0       0     130     219      78     390
Round 14       52       0       0     123     241      91     416
Round 15       41       0       0     139     219      73     399
Round 16       42       0       0     127     236      88     405
Round 17       49       0       0     131     225      80     405
Round 18       46       0       0     129     225      86     400
Round 19       47       0       0     134     238      84     419
Average        47       0       0     130     229      76     407

And Here is a run of SortedLinkedListAnalyzer

            add/1   index iterate   add/2   rem/1   rem/2   total
Round  0      517       0       5    1266      11       5    1799
Round  1      590       0      91    1175       8       3    1864
Round  2      588       0       0    1218       1       0    1807
Round  3      511       0       0    1318       1       0    1830
Round  4      421       0       0    1237       1       0    1660
Round  5      406       0       1    1263       1       0    1671
Round  6      424       0       0    1318       1       0    1743
Round  7      429       0       1    1283       1       0    1714
Round  8      482       0       0    1326       1       0    1809
Round  9      573       0       0    1400       1       0    1974
Round 10      590       0       0    1128       1       0    1719
Round 11      517       0       0    1266       1       1    1784
Round 12      448       0       0    1223       0       0    1671
Round 13      444       0       0    1313       1       0    1758
Round 14      414       0       0    1276       1       0    1691
Round 15      413       0       0    1259       1       1    1673
Round 16      479       0       0    1330       1       1    1810
Round 17      548       0       1    1389       1       1    1941
Round 18      591       0       0    1266       1       0    1858
Round 19      517       0       0    1229       1       0    1747
Average       495       0       4    1274       1       0    1776

As is evident, SkipLists have the fastest adding and removing, but the obvious limitation
is the lack of indexing (At least in my implementation). If we expect to be inserting and removing
many entries, and assuming a functioning get() method has ben implemented, there is really no reason
not to use skip lists. Otherwise, SortedArrayLists is another good choice. 

Part 5:

1) The use of random numbers in skip lists is interesting because it guarantees that the probability 
of having a node level n is p^n, where p is the lists probability. This is cool because it assures that 
really high levels are unlikely, making them real "express lanes" to the node being searched for. This 
could also be used for an interesting discrete probability distribution if needed.

2) The general find method for skip lists is interesting because it combines elements of skip lists and
trees. By taking the skip list "express lanes" as far as possible, it makes it easy to find the elements
and fast, too. This find method could also really be used in every other SkipList algorithm if it could
be modified to return the node rather than a boolean 

3) I thought the analysis suite for timing the speed of these data structures was interesting because
it provided detailed insight into how "expensive" each algorithm for the data structure is. For example, 
it allows us to easily see that adding is fast in ArrayLists, but not removing. We also see that LinkedList
removal can be very fast, but insertion takes time. This could really be used to analyze any linear data
structure. 

 */
}
