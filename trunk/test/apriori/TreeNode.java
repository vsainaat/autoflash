package apriori;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeNode {
	String item;
	int count = 0;
	TreeNode parent;
	Map<String, TreeNode> children = new TreeMap<String, TreeNode>();

	TreeNode(String s, TreeNode node) {
		item = s;
		parent = node;
	}
	
	void add(String item) {
		if (!children.containsKey(item))
			children.put(item, new TreeNode(item, this));
		// System.out.println(items+" "+item);
	}

	TreeNode get(String item) {
		assert children.containsKey(item);
		return children.get(item);
	}

	boolean has(String item) {
		return children.containsKey(item);
	}

	void incrCount(String[] items, int start) {
		if (children.isEmpty())
			count++;
		else {
			for (int i = start; i < items.length; ++i) {
				if (children.containsKey(items[i]))
					children.get(items[i]).incrCount(items, i + 1);
			}
		}
	}

	void print(int indent) {
		System.out.println("(" + count + ")");
		for (String item : children.keySet()) {
			for (int i = 0; i < indent; ++i)
				System.out.print(" ");
			System.out.print(item);
			children.get(item).print(indent + 8);
		}
	}

	int getCount(String[] items, int start) {
		if (start >= items.length)
			return count;
		else
			return children.get(items[start]).getCount(items, start + 1);
	}

	int grow(int depth, int currentDepth) {
		// System.out.println(itemset.length+" "+depth);
		int cnt = 0;
		if (currentDepth < depth - 1) {
			for (String item : children.keySet()) {
				cnt += get(item).grow(depth, currentDepth + 1);
			}
		} else {
			if (children.size() < 2)
				return 0;
			ArrayList<String> items = new ArrayList<String>();
			for (String item : children.keySet())
				items.add(item);
			for (int i = 0; i < items.size(); ++i) {
				for (int j = i + 1; j < items.size(); ++j) {
					List<String> itemset = new LinkedList<String>();
					itemset.add(item);
					itemset.add(items.get(i));
					itemset.add(items.get(j));
					if (parent == null || parent.check(itemset))
					{
						children.get(items.get(i)).add(items.get(j));
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	boolean check(List<String> items) {
		if (!contain(items, 1)) return false;
		((LinkedList<String>)items).addFirst(item);
		return (parent == null) || parent.check(items);
	}

	static List<String> pattern = new ArrayList<String>(); 

	int checkCount(int depth, int currentDepth, int minsup) {
//		System.out.println(depth+" "+ currentDepth);
		int cnt = 0;
		if (depth > currentDepth+1) {
			for (String item : children.keySet()) {
				pattern.add(item);
				cnt += get(item).checkCount(depth, currentDepth+1, minsup);
				pattern.remove(item);
			}
		} else {
			Iterator<String> iter = children.keySet().iterator();
			boolean flag = true;
			while (iter.hasNext()) {
				String item = iter.next();
				TreeNode node = children.get(item);
				if (node.count < minsup) {
					iter.remove();
				} else {
					cnt += 1;
//					if (flag) {
//						System.out.print(pattern);
//						flag = false;
//					}
//					System.out.print("("+item+","+node.count+") ");
				}
			}
		}
		return cnt;
	}

	boolean contain(List<String> items, int i) {
		if (!children.containsKey(items.get(i)))
			return false;
		if (i < items.size() - 1)
			return children.get(items.get(i)).contain(items, i + 1);
		else
			return true;
	}

}
