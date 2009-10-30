package apriori;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tree {

	static int cnt;
	static TreeNode root = new TreeNode("", null);
	int depth = 1;

	void scan(ItemSet transaction) {
		root.incrCount(transaction.items, 0);
	}

	void print() {
		root.print(4);
	}

	int getCount(String[] items) {
		return root.getCount(items, 0);
	}

	public void add(ArrayList<String> items) {
		// TODO Auto-generated method stub
		TreeNode node = root;
		for (String item : items) {
			node = node.get(item);
			// node.count ++;
		}
	}

	public int grow() {
		System.out.println("depth="+depth+" growing ... ");
		int cnt = root.grow(depth, 0);
		depth++;
		System.out.println("depth=" + depth + "\tcandidate=" + cnt);
		return cnt;
	}

	public int checkCount(int minsup) {
		System.out.print("depth="+depth+" checking ...");
		int cnt = root.checkCount(depth, 0, minsup);
		System.out.println("\tfrequent node=" + cnt);
		return cnt;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 Tree tree = new Tree();
//		 tree.add(new String[]{"D1","D2","R1","R2"});
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","D2","R1"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R2"})));
//		 tree.incrCount((new ItemSet(new String[]{"D1","R2"})));
//		 System.out.println(tree.getCount(new String[]{"D1","D2","R1","R2"}));
//		 System.out.println(tree.getCount(new String[]{"D1","D2","R1"}));
//		 System.out.println(tree.getCount(new String[]{"D1","R2"}));
//		 tree.print();
	}

}
