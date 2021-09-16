package com.grayson.doublepointer.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunhui
 */
public class FindWords {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    char[][] bd;
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        bd = board;
        m = board.length;
        n = board[0].length;
        int[] cnts = new int[26];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) cnts[board[i][j] - 'a']++;
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int[] cur = new int[26];
            for (char c : word.toCharArray()) cur[c - 'a']++;
            boolean valid = true;
            for (int i = 0; i < 26; i++)
                if (cnts[i] < cur[i]) {
                    valid = false;
                    break;
                }
            if (!valid) continue;
            boolean find = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    if (dfs(word, 0, i, j, new HashSet<Integer>())) {
                        find = true;
                        ans.add(word);
                        break;
                    }
                if (find) break;
            }
        }
        return ans;
    }


    public boolean dfs(String word, int idx, int x, int y, Set<Integer> explored) {
        if (idx == word.length()) return true;
        Integer pos = x * n + y;
        if (explored.contains(pos) || x < 0 || y < 0 || x == m || y == n) return false;
        if (bd[x][y] == word.charAt(idx++)) {
            explored.add(pos);
            for (int[] dir : dirs) if (dfs(word, idx, x + dir[0], y + dir[1], explored)) return true;
            explored.remove(pos);
        }
        return false;
    }
}
