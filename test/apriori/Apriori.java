package apriori;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Apriori {

	public DataBase db;
	public List<ItemSet> fitemsets = new ArrayList<ItemSet>();
	public final static int minsup = 5;
	public Tree tree = new Tree();

	public Apriori(DataBase db) {
		this.db = db;
		Map<String, Integer> item_count = new HashMap<String, Integer>();
		for (ItemSet transaction : db.transactions) {
			for (String item : transaction.items) {
				int cnt = item_count.containsKey(item) ? item_count.get(item)
						: 0;
				item_count.put(item, cnt + 1);
			}
		}
		for (String item : item_count.keySet())
			if (item_count.get(item) >= minsup) {
				tree.root.add(item);
				tree.root.get(item).count = item_count.get(item);
			}
	}

	public void run() {
		while (tree.checkCount(minsup) > 1) {
			if (tree.grow() == 0) return;
			db.scan(tree);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DataBase db = new DataBase("f:/data/prr.dat");
			Apriori apr = new Apriori(db);
			System.out.println(new Date());
			apr.run();
			System.out.println(new Date());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
