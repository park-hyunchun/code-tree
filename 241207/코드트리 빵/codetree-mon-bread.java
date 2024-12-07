import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[][][] parent;
	static int n, m;
	static int minute = 0;
	static Person[] people;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static class Person {
		int x;
		int y;
		int goalX;
		int goalY;
		boolean isIn;

		public Person(int x, int y, int goalX, int goalY, boolean isIn) {
			this.x = x;
			this.y = y;
			this.goalX = goalX;
			this.goalY = goalY;
			this.isIn = isIn;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		people = new Person[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			people[i] = new Person(-1, -1, x, y, false);
			map[x][y] = 2;
		}

		while (!allIn()) {
			move();
			isIn();
			if (minute < m) {				
				goBaseCamp();
			}
			minute++;
		}
		System.out.println(minute);

	}

	private static boolean allIn() {
		for (int i = 0; i < m; i++) {
			if(!people[i].isIn) {
				return false;
			}
		}
		return true;
	}

	private static void goBaseCamp() {
		int goalX = people[minute].goalX;
		int goalY = people[minute].goalY;
		int minDistance = Integer.MAX_VALUE;
		int distance;
		int x = -1;
		int y = -1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					distance = Math.abs(goalX - i) + Math.abs(goalY - j);
					if (distance < minDistance) {
						minDistance = distance;
						x = i;
						y = j;
					}
				}
			}
		}
		
		people[minute].x = x;
		people[minute].y = y;
		map[x][y] = 3;
		
	}

	private static void isIn() {
		int x;
		int y;
		int goalX;
		int goalY;
		for (int i = 0; i < m; i++) {
			
			if (people[i].isIn) {
				continue;
			}
			
			x = people[i].x;
			y = people[i].y;
			goalX = people[i].goalX;
			goalY = people[i].goalY;
			
			if (x == -1 || y == -1) {
				continue;
			}
			
			if (x == goalX && y == goalY) {
				map[x][y] = 4;
				people[i].isIn = true;
			}
		}
	}

	private static void move() {
		int x;
		int y;
		int goalX;
		int goalY;
		for (int i = 0; i < m; i++) {
			if (people[i].isIn) {
				continue;
			}
			
			if (people[i].x == -1 || people[i].x == -1) {
				continue;
			}
			
			x = people[i].x;
			y = people[i].y;
			goalX = people[i].goalX;
			goalY = people[i].goalY;
			
			getShortcut(x, y, goalX, goalY);
			
			int r = goalX;
			int c = goalY;
			
			while (!(parent[r][c][0] == x && parent[r][c][1] == y)) {
				r = parent[r][c][0];
				c = parent[r][c][1];
			}
			
			people[i].x = r;
			people[i].y = c;
			
		}
	}

	private static void getShortcut(int startX, int startY, int goalX, int goalY) {
		visited = new boolean[n][n];
		que = new LinkedList<>();
		parent = new int[n][n][2];

		visited[startX][startY] = true;
		que.offer(new int[] { startX, startY });

		while (!que.isEmpty()) {
			
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			if (r == goalX && c == goalY) {
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] < 3) {
					visited[nr][nc] = true;
					parent[nr][nc] = new int[] { r, c };
					que.offer(new int[] { nr, nc });
				}
				
			}
			
		}

	}


	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
}
