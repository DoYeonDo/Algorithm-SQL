package swea;
import java.util.*;

public class SWEA_1824_혁진이의프로그램검증 {
    static int R, C;
    static char[][] grid;
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            R = sc.nextInt();
            C = sc.nextInt();
            grid = new char[R][C];

            for (int i = 0; i < R; i++) {
                grid[i] = sc.next().toCharArray();
            }

            System.out.println("#" + t + " " + (simulate() ? "YES" : "NO"));
        }
        
        sc.close();
    }

    static boolean simulate() {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        
        queue.add(new State(0, 0, 0, 0));
        visited.add(new State(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int x = currentState.x;
            int y = currentState.y;
            int dir = currentState.dir;
            int memory = currentState.memory;

            char command = grid[x][y];

            //@를 만나면 프로그램 정지
            if (command == '@') {
                return true;
            }

            if('0'<=command && command<='9')
            	memory = (int)(command-'0');
            else {
	            switch (command) {
	                case '>': dir = 0; break;
	                case 'v': dir = 1; break;
	                case '<': dir = 2; break;
	                case '^': dir = 3; break;
	                case '_': dir = (memory == 0) ? 0 : 2; break;
	                case '|': dir = (memory == 0) ? 1 : 3; break;
	                case '+': memory = (memory + 1) % 16; break;
	                case '-': memory = (memory == 0) ? 15 : memory - 1; break;
	                case '.': break;
	                case '?':
	                    for (int d = 0; d < 4; d++) {
	                        int nx = (x + dx[d] + R) % R;
	                        int ny = (y + dy[d] + C) % C;
	                        State nextState = new State(nx, ny, d, memory);
	                        if (!visited.contains(nextState)) {
	                            visited.add(nextState);
	                            queue.add(nextState);
	                        }
	                    }
	                    continue;
	            }
            }

            int nx = (x + dx[dir] + R) % R;
            int ny = (y + dy[dir] + C) % C;

            State nextState = new State(nx, ny, dir, memory);

            if (!visited.contains(nextState)) {
                visited.add(nextState);
                queue.add(nextState);
            }
        }

        return false;
    }
}

class State {
    int x, y, dir, memory;

    public State(int x, int y, int dir, int memory) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.memory = memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return x == state.x && y == state.y && dir == state.dir && memory == state.memory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dir, memory);
    }
}
