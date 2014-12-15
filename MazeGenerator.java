
/*
 * (C) Copyright ${2014} Luciano Porretta (http://homepages.ulb.ac.be/~lporrett) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */



import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
 
/*
 * HOW TO RUN: java MazeGenerator [rows=8] [cols=8] [monsters=4] [candies=3]
 */

public class MazeGenerator {
	private final int x;
	private final int y;
	private final int[][] maze;
	private Random rand;
 
	public MazeGenerator(int x, int y) {
		this.x = x;
		this.y = y;
		maze = new int[this.x][this.y];
		generateMaze(0, 0);
		this.rand = new Random();
	}

	public void display() {
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < x-1; j++) {
			System.out.print("+---");
		}
		System.out.println("+   +");
	}
 
	private void generateMaze(int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y)
					&& (maze[nx][ny] == 0)) {
				maze[cx][cy] |= dir.bit;
				maze[nx][ny] |= dir.opposite.bit;
				generateMaze(nx, ny);
			}
		}
	}
 
	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
 
	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;
 
		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}
 
		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	};
 
	public static void main(String[] args) {
		int y = args.length >= 1 ? (Integer.parseInt(args[0])) : 8;
		int x = args.length >= 2 ? (Integer.parseInt(args[1])) : 8;
		int monstres = args.length >= 3 ? (Integer.parseInt(args[2])) : 4;
		int bonbons = args.length == 4 ? (Integer.parseInt(args[3])) : 3;
		MazeGenerator maze = new MazeGenerator(x, y);
		System.out.println("Labyrinthe: "+y+" fois "+x);
		maze.display();
		System.out.println("Elements du Labyrinthe: ");
		System.out.println("\tMonstres: "+monstres);
		System.out.println("\tBonbons: "+bonbons);
		int[][] position = new int [x][y];
		System.out.println("Emplacements:");
		for (int i=0; i<x; ++i){
			for (int j=0; j<y; ++j){
				position[i][j]=0;
			}
		}		
		int px=x-1, py=y-1;
		while (px==x-1 && py==y-1){
			px = maze.rand.nextInt(x); 
			py = maze.rand.nextInt(y);			
		}
		position[px][py]=1;
		System.out.println("\tPakkuman: ("+px+","+py+")");
		int fx=px, fy=py;
		System.out.print("\tMonstres: "); 
		for(int i=0; i<monstres; ++i){
			while (position[fx][fy]==1){
				fx = maze.rand.nextInt(x); 
				fy = maze.rand.nextInt(y);
			}
			position[fx][fy]=1;
			System.out.print("("+fx+","+fy+") ");
		}
		System.out.println();
		int gx=px, gy=py;
		System.out.print("\tBonbons: "); 
		for(int i=0; i<bonbons; ++i){
			while (position[gx][gy]==1){
				gx = maze.rand.nextInt(x); 
				gy = maze.rand.nextInt(y);
			}
			position[gx][gy]=1;
			System.out.print("("+gx+","+gy+") ");
		}
		System.out.println();
	}
 
}