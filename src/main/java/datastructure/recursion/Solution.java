package datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/7/12 17:50
 * @description 递归的应用 很多算法都可以找问题重复性
 */
public class Solution {


  private List<String> res;

  /**
   * 生成n对括号
   * 1、利用递归，检测括号的合法性：必须先有左括号，再有右括号
   * 2、左括号个数  > 右括号个数
   * @param n
   * @return
   */
  public List<String> generateParenthesis(int n) {
    res = new ArrayList<>();
    //生成括号
    generate(0,0,n,"");
    return res;

  }

  private void generate(int left, int right, int n, String s) {
    //terminator
    //左括号用完，右括号用完
    if(left == n && right == n){
      res.add(s);
      return;
    }
    //handle  current logic

    //drill down
    // 判断左括号是否用完
    if(left < n){
      generate(left+1,right,n,s+"(");
    }
    //判断右括号是否用完
    if(right < left){
      generate(left,right + 1,n,s +")");
    }
    //reverse state

  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.generateParenthesis(3));
  }


}
