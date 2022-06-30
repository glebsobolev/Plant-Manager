package plantManager;

import java.util.Arrays;

import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class GameMap implements TileBasedMap {
	int[][] tiles;
	TiledMap tiledMap;
	
	public GameMap(TiledMap tiledMap) {
		this.tiles =new int[tiledMap.getHeight()][tiledMap.getWidth()] ;
		this.tiledMap = tiledMap;
		
		for(int i= 0;i<tiledMap.getWidth();i++) {
		
			for(int j=0;j<tiledMap.getHeight();j++) {
				tiles[i][j]=tiledMap.getTileId(i, j, 0);
			}
		}

	}
	
	@Override
	public boolean blocked(PathFindingContext arg0, int arg1, int arg2) {
		
		if(tiles[arg1][arg2]==84) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeightInTiles() {
		// TODO Auto-generated method stub
		return tiledMap.getHeight();
	}

	@Override
	public int getWidthInTiles() {
		// TODO Auto-generated method stub
		return tiledMap.getWidth();
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
