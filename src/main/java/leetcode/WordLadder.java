package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/8/8 12:49
 * @description leetcode 单词接龙
 */
public class WordLadder {


  /**
   * 找到从beginWord->endWord最短路径和
   *
   * @param beginWord
   * @param endWord
   * @param wordList  单词接龙
   * @return 最短路径
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //使用一个hashSet<>存储单词列表-便于判断一个单词是否在单词列表
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordList.size() == 0 || !wordList.contains(endWord)) {
      return 0;
    }
    wordSet.remove(beginWord);

    //使用图的广度优先搜索：队列 +是否访问过的集合visited（hash或者数组）
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int wordLen = beginWord.length();

    //包含起点，初始化步数为：1
    int step = 1;
    while (!queue.isEmpty()) {
      int currentSize = queue.size();
      for (int i = 0; i < currentSize; i++) {
        // 依次遍历当前队列中的单词-移除和获取元素
        String word = queue.poll();
        char[] chars = word.toCharArray();
        // 修改每一个字符
        for (int j = 0; j < wordLen; j++) {
          // 一轮以后应该重置，否则结果不正确
          char originChar = chars[j];
          for (char k = 'a'; k <= 'z'; k++) {
            if (k == originChar) {
              continue;
            }
            chars[j] = k;
            String nextWord = String.valueOf(chars);

            if (wordSet.contains(nextWord)) {
              if (nextWord.equals(endWord)) {
                return step + 1;
              }
              if (!visited.contains(nextWord)) {
                queue.add(nextWord);
                // 注意：添加到队列以后，必须马上标记为已经访问
                visited.add(nextWord);
              }
            }
          }
          // 恢复
          chars[j] = originChar;
        }
      }
      step++;
    }
    return 0;
  }


  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    Collections.addAll(wordList, wordListArray);
    WordLadder solution = new WordLadder();
    int res = solution.ladderLength(beginWord, endWord, wordList);
    System.out.println(res);
  }

}
