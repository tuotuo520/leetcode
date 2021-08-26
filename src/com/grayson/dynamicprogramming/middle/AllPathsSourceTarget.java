package com.grayson.dynamicprogramming.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * <p>
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 * <p>
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 * <p>
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 * <p>
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *  
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunhui
 */
public class AllPathsSourceTarget {

    //dfs
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> list = new ArrayList<>();
//        dfs(list,new ArrayList<>(),graph,0, graph.length);
//        return list;
//    }
//
//    public void dfs(List<List<Integer>> list, List<Integer> result, int[][] graph, int i, int n){
//        if(i == n - 1){
//            result.add(i);
//            list.add(new ArrayList<>(result));
//            result.remove(result.size() -1);
//            return;
//        }
//        result.add(i);
//        for (int nxt : graph[i]){
//            dfs(list,result,graph,nxt,n);
//        }
//        result.remove(result.size() -1);
//    }

    //bfs
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        //从0节点一层一层往外搜索
        List<List<Integer>> list = new ArrayList<>();
        //二维数组最大大小
        int n = graph.length;
        //构建一个节点队列
        Queue<Node> queue = new LinkedList<>();
        //新建0节点队列
        queue.offer(new Node(0));
        while (!queue.isEmpty()) {
            //出队列
            Node node = queue.poll();
            if (node.index == n - 1) {
                list.add(node.path);
                continue;
            }
            for (int next : graph[node.index]) {
                queue.offer(new Node(next, node.path));
            }
        }
        return list;

    }

    class Node {
        int index;
        List<Integer> path;

        public Node(int index) {
            this.index = index;
            this.path = new ArrayList<>();
            this.path.add(index);
        }

        public Node(int index, List<Integer> path) {
            this.index = index;
            //复制一个新的list 空间换时间
            this.path = new ArrayList<>(path);
            //把当前节点索引加入路径
            this.path.add(index);
        }
    }
}
