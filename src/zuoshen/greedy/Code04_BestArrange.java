package zuoshen.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Code04_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	// timePoint 此时来到的时间点
	public static int bestArrange(Program[] programs, int timePoint) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		// 从左往右依次遍历所有的会议
		for (int i = 0; i < programs.length; i++) {
			if (timePoint <= programs[i].start) {
				result++;
				timePoint = programs[i].end;
			}
		}
		return result;
	}

	// 暴力全排列解法
	//会议的集合是set，当前时间点是timePoint
	//返回该集合中最多能安排几个项目
	public static int bestArrangeForce(Program[] programs, int timePoint) {
		HashSet<Program> set = new HashSet<> (Arrays .asList(programs));
		return process(set, timePoint);
	}

	public static int process (HashSet<Program> set, int timePoint) {
		HashSet<Program> candidates = new HashSet<>( );
		for(Program program : set) {
			if (program.start >= timePoint) {
				candidates.add(program);
			}
		}
		HashSet<Program> tmp = new HashSet<> (candidates); // 防止迭代器失效
		int result = 0;
		//尝试每一个项目，作为第一个安排的项目
		for(Program program : tmp) {
			candidates.remove(program);
			int next = process(candidates, program.end);
			result = Math.max(result, next + 1);
			candidates.add(program);
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
