//An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph. 
//
// graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected. 
//
// Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges. 
//
// 
//
// 
// 
//
// Example 1: 
//
// 
//Input: [[1,2,3],[0],[0],[0]]
//Output: 4
//Explanation: One possible path is [1,0,2,0,3] 
//
// Example 2: 
//
// 
//Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
//Output: 4
//Explanation: One possible path is [0,1,4,2,3]
// 
//
// 
//
// Note: 
//
// 
// 1 <= graph.length <= 12 
// 0 <= graph[i].length < graph.length 
// 
// Related Topics Dynamic Programming Breadth-first Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

 /**
 * graph 是一个二维数组，其中第二维的长度是不固定的，表示当前节点与其余节点的联通情况
 * 例如： [[1,2,3],[0],[0],[0]]，其中[1,2,3] 表示第0个节点与1,2,3节点都有联通的路径； 第一个[0]表示节点1与0号节点联通。
 * 如下就是二维矩阵表示：
 * [
     [0,1,1,1],
     [1,0,0,0],
     [1,0,0,0],
     [1,0,0,0]
   ]
 */

   public int shortestPathLength(int[][] graph) {
   	int len=graph.length;

   	// 设置每一个节点的标记
   	boolean[][] book=new boolean[len][1<<len];
   	
   	// 表示所有节点全部遍历，因为1<<len -1 一定是 len-1 个1
   	int k=(1<<len)-1;

   	// 初始化队列，因为每一个节点都可以作为初始访问节点
   	Queue<int[]> queue=new LinkedList<>();
   	for (int i=0;i<len;i++)
   	{
   		queue.offer(new int[]{i,1<<i});
   	}


   	int step=0;
   	
   	// 开始遍历队列
   	while (!queue.isEmpty())
   	{
   		int size=queue.size();
   		while (size-->0)
   		{
   			// 出队列一个元素
   			int[] node=queue.poll();

   			// 如果已经遍历完所有的节点，直接返回
   			if(k==node[1])return step;

   			// 开始遍历与当前节点联通的节点
   			for (int next:graph[node[0]])
   			{
   				// 获取节点的状态
   				// 如果节点已经被访问，那么直接下一个节点，否则设置访问状态
   				int next_state=node[1]|(1<<next);
   				if(book[next][next_state])
   				 { continue; }
   				book[next][next_state]=true;

   				// 把下一层待访问的节点如队列
   				queue.offer(new int[]{next,next_state});
   			}
   		}
   		step++;
   	}
   	return step;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
