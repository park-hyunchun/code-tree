import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[][] attackTime;
	static boolean[][] isEffect;
	static int N, M, K;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[] rdr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] rdc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int weakTurretR = -1;
	static int weakTurretC = -1;
	static int powerfulTurretR = -1;
	static int powerfulTurretC = -1;
	static int turn = 1;
	static Queue<int[]> shortcut = new LinkedList<>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		attackTime = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			isEffect = new boolean[N][M];
//			printMap();
			findWeakTurret();
//			printMap();
			findPowerfulTurret();
			if (!laserAttack()) {
				cannonAttack();
			}
//			printMap();
			refair();
//			printMap();
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > result) {
					result = map[i][j];
				}
			}
		}
		
		System.out.println(result);

	}

	private static void refair() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !isEffect[i][j]) {
					map[i][j]++;
				}
			}
		}
	}

	private static void cannonAttack() {
		int damage = map[weakTurretR][weakTurretC];
		int r = powerfulTurretR;
		int c = powerfulTurretC;
		map[r][c] = Math.max(0, map[r][c] - damage);
		isEffect[r][c] = true;
		
		for (int d = 0; d < 8; d++) {
			int nr = (r + rdr[d] + N) % N;
			int nc = (c + rdc[d] + M) % M;
			if (map[nr][nc] == 0) {
				continue;
			}
			if (nr == weakTurretR && nc == weakTurretC) {
				continue;
			}
			isEffect[nr][nc] = true;
			map[nr][nc] = Math.max(0, map[nr][nc] - (damage/2));
		}
	}

	private static boolean laserAttack() {
		int damage = map[weakTurretR][weakTurretC];
		boolean[][] visited = new boolean[N][M];
		int[][][] parent = new int[N][M][2];
		Queue<int[]> que = new LinkedList<>();
		
		visited[weakTurretR][weakTurretC] = true;
		que.offer(new int[] {weakTurretR, weakTurretC });
		
		while (!que.isEmpty()) {
			
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			if (r == powerfulTurretR && c == powerfulTurretC) {
				map[r][c] = Math.max(0, map[r][c] - damage);
				findShortcut(parent);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = (r + dr[d] + N) % N;
				int nc = (c + dc[d] + M) % M;
				if (map[nr][nc] > 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
					parent[nr][nc] = new int[] { r, c };
				}
			}
			
		}
		
		if (shortcut.isEmpty()) {
			return false;
		}
		
		while (!shortcut.isEmpty()) {
			int[] cur = shortcut.poll();
			isEffect[cur[0]][cur[1]] = true;
			map[cur[0]][cur[1]] = Math.max(0, map[cur[0]][cur[1]] - (damage/2));
		}
		
		return true;
	}

	private static void findShortcut(int[][][] parent) {
		int r = powerfulTurretR;
		int c = powerfulTurretC;
		
		while (parent[r][c][0] != weakTurretR || parent[r][c][1] != weakTurretC) {
			int[] cur = parent[r][c];
			shortcut.add(cur);
			r = cur[0];
			c = cur[1];
		}
	}

	private static void findPowerfulTurret() {
		int powerfulPower = -1;
		int r = 0;
		int c = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (i == weakTurretR && j == weakTurretC) {
					continue;
				}
				if (map[i][j] > powerfulPower) {
					powerfulPower = map[i][j];
					r = i;
					c = j;
				} else if (map[i][j] == powerfulPower) {
					if (attackTime[i][j] < attackTime[r][c]) {
						r = i;
						c = j;
					}
				}
			}
			
		}
		
		isEffect[r][c] = true;
		powerfulTurretR = r;
		powerfulTurretC = c;
		
	}

	private static void findWeakTurret() {
		int minPower = Integer.MAX_VALUE;
		int r = 0;
		int c = 0;
		for (int i = N-1; i >= 0; i--) {
			for (int j = M-1; j >= 0; j--) {
				if (map[i][j] == 0) {
					continue;
				}
				if (map[i][j] < minPower) {
					minPower = map[i][j];
					r = i;
					c = j;
				} else if (map[i][j] == minPower) {
					if (attackTime[i][j] > attackTime[r][c]) {
						r = i;
						c = j;
					}
				}
			}
		}
		isEffect[r][c] = true;
		map[r][c] += (N+M);
		attackTime[r][c] = turn++;
		weakTurretR = r;
		weakTurretC = c;
	}
	
	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

}
