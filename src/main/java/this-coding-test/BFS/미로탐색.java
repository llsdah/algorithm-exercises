package 이코테.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로찾기 {

	static int n, m;
	static int[][] arr;

	public static void main(String[] args) {

		int[][] arr2 = { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1  },
				{ 1, 1, 1, 0, 1 }, };

		n = arr2.length;
		m = arr2[0].length;
		
		arr = arr2;
		int answer = bfs(0, 0);
		System.out.println(answer);
	}

	// 이동할 방향ㅇ
	public static int dx[] = { -1, 1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 };

	private static int bfs(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));

		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if (arr[nx][ny] == 0) {
					continue;
				} else if (arr[nx][ny] == 1) {
					arr[nx][ny] = arr[x][y] + 1;
					q.offer(new Node(nx, ny));
				}

			}
			

		}
		System.out.println(n+ "'"+m);
		return arr[n-1][m-1];
		
	}

}

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
