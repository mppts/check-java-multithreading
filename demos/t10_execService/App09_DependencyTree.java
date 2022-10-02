
// https://www.baeldung.com/thread-pool-java-and-guava

package demos.t10_execService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class App09_DependencyTree {
    public static void main(String[] args) {
        var tree = new TreeNode(10,
                new TreeNode(-20),
                new TreeNode(23,
                        new TreeNode(17),
                        new TreeNode(-1)));

        var forkJoinPool = ForkJoinPool.commonPool();

        int result = forkJoinPool.invoke(new TreeSumTask(tree));

        System.out.println(result);
    }
}

/**
 * TreeNode
 */
class TreeNode {
    int value;
    List<TreeNode> children;

    TreeNode(int value, TreeNode... children) {
        this.value = value;
        this.children = Arrays.asList(children);
    }
}

class TreeSumTask extends RecursiveTask<Integer> {

    final TreeNode node;

    TreeSumTask(TreeNode node) {
        this.node = node;
    }

    @Override
    protected Integer compute() {
        return node.value
                + node.children.stream()
                        .map(child -> new TreeSumTask(child).fork())
                        .collect(Collectors.summingInt(ForkJoinTask::join));
    }
}