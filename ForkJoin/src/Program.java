import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Program {

	static Random rnd = new Random();
	static int total;

	public static void createRandomTree(TreeNode node, int level) {

		node.left = new TreeNode();
		node.right = new TreeNode();
		node.weight = rnd.nextInt(100);
		total += node.weight;
		level--;
		if (level == 0) {
			node.left.weight = rnd.nextInt(100);
			node.right.weight = rnd.nextInt(100);
			total += node.left.weight;
			total += node.right.weight;
			return;
		}
		createRandomTree(node.left, level);
		createRandomTree(node.right, level);
	}

	public static int weightTree(TreeNode root) {
		return root.weight + (root.left != null ? weightTree(root.left) : 0)
				+ (root.right != null ? weightTree(root.right) : 0);
	}

	public static int weightTreeMulti(TreeNode root) {
		class WaightCounter extends RecursiveTask<Integer> {
			TreeNode r;
			int level;

			public WaightCounter(TreeNode r, int level) {
				this.r = r;
				this.level = level;
			}

			@Override
			protected Integer compute() {

				final int newLevel = level - 1;
				if (level <= 0)
					return weightTree(r);

				int sum = r.weight;
				WaightCounter w1 = null, w2 = null;

				if (r.left != null) {
					w1 = new WaightCounter(r.left, newLevel);
					w1.fork();
				}
				if (r.right != null) {
					w2 = new WaightCounter(r.right, newLevel);
					w2.fork();
				}

				if (w1 != null)
					sum += w1.join();
				if (w2 != null)
					sum += w2.join();

				return sum;
			}
		}
		
		//return (new ForkJoinPool().invoke(new WaightCounter(root, Runtime.getRuntime().availableProcessors())));
		
		return ForkJoinPool.commonPool().invoke(new WaightCounter(root, Runtime.getRuntime().availableProcessors()));
	}

	public static void main(String[] args) {

		int treeLevel = 24;
		if (args.length >= 1)
			treeLevel = Integer.parseInt(args[0]);

		System.out.printf("Srarting tree creation with depth %d...\n", treeLevel);
		TreeNode root = new TreeNode();
		createRandomTree(root, treeLevel);
		System.out.printf("Tree created with weight %d: \n", total);

		weightTree(root); // PROFILING
		weightTree(root); // PROFILING

		long t1 = System.currentTimeMillis();
		int r1 = weightTree(root);
		long t2 = System.currentTimeMillis();
		System.out.printf("Single weight %d Time: %d\n", r1, t2 - t1);

		weightTreeMulti(root); // PROFILING
		weightTreeMulti(root); // PROFILING

		long t3 = System.currentTimeMillis();
		int r2 = weightTreeMulti(root);
		long t4 = System.currentTimeMillis();
		System.out.printf("Multi weight %d Time: %d\n", r2, t4 - t3);

	}

}
