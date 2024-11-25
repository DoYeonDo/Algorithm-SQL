package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_19236_청소년상어 {
    static class Fish {
        int num, dir;

        Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    static int maxEatFish = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] fishMap = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 8; j += 2) {
                int num = Integer.parseInt(input[j]);
                int dir = Integer.parseInt(input[j + 1]);
                fishMap[i][j / 2] = new Fish(num, dir);
            }
        }

        int sharkX = 0, sharkY = 0, sharkDir = fishMap[0][0].dir;
        int startEat = fishMap[0][0].num;
        fishMap[0][0] = null;

        dfs(fishMap, sharkX, sharkY, sharkDir, startEat);
        System.out.println(maxEatFish);
    }

    private static void dfs(Fish[][] map, int sharkX, int sharkY, int sharkDir, int eatFishCnt) {
        maxEatFish = Math.max(maxEatFish, eatFishCnt);

        Fish[][] tempMap = copyFishMap(map);
        moveAllFish(tempMap, sharkX, sharkY);

        for(int step = 1; step < 4; step++) {
            int nx = sharkX + dx[sharkDir] * step;
            int ny = sharkY + dy[sharkDir] * step;

            if (!isInArea(nx, ny) || tempMap[nx][ny] == null) continue;

            Fish eatFish = tempMap[nx][ny];
            tempMap[nx][ny] = null;
            dfs(tempMap, nx, ny, eatFish.dir, eatFishCnt + eatFish.num);
            tempMap[nx][ny] = eatFish;
        }
    }

    private static void moveAllFish(Fish[][] map, int sharkX, int sharkY) {
        for(int num = 1; num <= 16; num++) {
            int fx = -1, fy = -1;

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(map[i][j] != null && map[i][j].num == num) {
                        fx = i;
                        fy = j;
                    }
                }
            }
            if(fx == -1) continue;

            Fish fish = map[fx][fy];
            for(int d = 0; d < 8; d++) {
                int ndir = (fish.dir + d - 1) % 8 + 1;
                int nx = fx + dx[ndir];
                int ny = fy + dy[ndir];

                if(isInArea(nx, ny) && !(nx==sharkX && ny==sharkY)) {
                    fish.dir = ndir;
                    swap(map, fx, fy, nx, ny);
                    break;
                }
            }
        }
    }

    private static void swap(Fish[][] map, int x1, int y1, int x2, int y2) {
        Fish temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static Fish[][] copyFishMap(Fish[][] original) {
        Fish[][] copy = new Fish[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(original[i][j] != null) {
                    copy[i][j] = new Fish(original[i][j].num, original[i][j].dir);
                }
            }
        }
        return copy;
    }

    private static boolean isInArea(int x, int y) {
        return x>=0 && x<4 && y>=0 && y<4;
    }
}
