package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time: O(no of courses + no of pre-req) -> O(n + p)
// Go over every node (DFS) and resolve pre-req by removing from array in map when it can be done.
// Finally, check if no course has no pre-req in the map (all lists are empty).

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];

        // Map<Course, Pre-req>
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] preCourse: prerequisites) {
            map.get(preCourse[0]).add(preCourse[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i, visited, map)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Returns true if a course can be taken.
    private boolean dfs(int course, boolean[] visited, HashMap<Integer, List<Integer>> map) {
        // Cycle
        if (visited[course]) {
            return false;
        }

        List<Integer> currentPrerequisites = map.get(course);

        if (currentPrerequisites.isEmpty()) {
            return true; // Course can be taken
        }

        visited[course] = true;

        for (int i = 0; i < currentPrerequisites.size(); i++) {
            boolean validPreReq = dfs(currentPrerequisites.get(i), visited, map);
            if (validPreReq) {
                currentPrerequisites.remove(currentPrerequisites.get(i));
            } else {
                return false;
            }
        }

        visited[course] = false;
        return true;
    }
}
