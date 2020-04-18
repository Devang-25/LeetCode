package Topics.BTree;

import Libs.TreeNode;

import java.util.*;

public class BTVerticalOrderTraversal2 {
    List<Location> l;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        l = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(l);
        int i = l.get(0).x;
        re.add(new ArrayList<>());
        for (Location lo : l) {
            if (lo.x != i) {
                re.add(new ArrayList<>());
            }
            i = lo.x;
            re.get(re.size()-1).add(lo.val);
        }
        return re;
    }


    private void dfs(TreeNode root, int x, int y) {
        if (root != null) {
            l.add(new Location(x, y, root.val));
            dfs(root.left, x-1, y+1);
            dfs(root.right, x+1, y+1);
        }
    }

    class Location implements Comparable<Location> {
        int x, y, val;
        Location(int _x, int _y, int _val) {
            x = _x;
            y = _y;
            val = _val;
        }

        @Override
        public int compareTo(Location l) {
            if (l.x != this.x) {
                return Integer.compare(this.x, l.x);
            } else if (l.y != this.y) {
                return Integer.compare(this.y, l.y);
            } else {
                return Integer.compare(this.val, l.val);
            }
        }
    }
}
