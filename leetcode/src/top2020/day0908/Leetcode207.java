package top2020.day0908;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 课程表
 * 拓扑排序
 * 思路，根据pre构建图，以及入度数组
 * 每次将入度为0的节点加入队列中，删除该节点与对应的指向边。对应修改指向节点的入度值，重复该过程
 * 最后检测队列总共出去的节点是否等于节点个数
 */
public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) {
            return true;
        }
        int[][] matrix = new int[numCourses][numCourses];
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            in[prerequisites[i][0]]++;
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            cnt++;
            for (int i = 0; i < numCourses; ++i) {
                if (matrix[tmp][i] == 1) {
                    in[i]--;
                    if (in[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}
