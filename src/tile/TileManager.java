package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
   public Tile[] tile;
   public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
    }


    private void getTileImage() {
        try{
           tile[0]=new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/base.jpg"));

            tile[1]=new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/tree.jpg"));
            tile[1].collision=true;

            tile[2]=new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/door.png"));

            tile[3]=new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile/grasss.jpg"));

            tile[4]=new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile/win.png"));

            //start of house
            tile[5]=new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile/1.png"));
            tile[6]=new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile/2.png"));
            tile[7]=new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile/3.png"));
            tile[8]=new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tile/11.png"));
            tile[9]=new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tile/12.png"));
            tile[10]=new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tile/12.png"));
            tile[11]=new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tile/13.png"));
            tile[12]=new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tile/21.png"));
            tile[13]=new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tile/22.png"));
            tile[14]=new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tile/23.png"));
            tile[15]=new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tile/31.png"));
            tile[16]=new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tile/32.png"));
            tile[17]=new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tile/33.png"));
            tile[18]=new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tile/41.png"));
            tile[19]=new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tile/42.png"));
            tile[20]=new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tile/43.png"));
            tile[21]=new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tile/51.png"));
            tile[22]=new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tile/52.png"));
            tile[23]=new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tile/53.png"));
            tile[24]=new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tile/61.png"));
            tile[25]=new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tile/62.png"));
            tile[26]=new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tile/63.png"));
            tile[27]=new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tile/71.png"));
            tile[28]=new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tile/72.png"));
            tile[29]=new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tile/73.png"));
            tile[30]=new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tile/81.png"));
            tile[31]=new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tile/82.png"));
            tile[32]=new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tile/83.png"));
            tile[33]=new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tile/91.png"));
            tile[34]=new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tile/92.png"));
            tile[35]=new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tile/93.png"));
            tile[36]=new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tile/101.png"));
            tile[37]=new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tile/102.png"));
            tile[38]=new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tile/103.png"));
            tile[39]=new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tile/111.png"));
            tile[40]=new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tile/112.png"));
            tile[41]=new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tile/113.png"));
            tile[42]=new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tile/121.png"));
            tile[43]=new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tile/122.png"));
            tile[44]=new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tile/123.png"));
            tile[45]=new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tile/131.png"));
            tile[46]=new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tile/132.png"));
            tile[47]=new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tile/133.png"));


            //End of House


        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
            catch (Exception e) {


            }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum =mapTileNum[worldCol][worldRow];
            int worldx=worldCol*gp.tileSize;
            int worldy=worldRow*gp.tileSize;
            int screenx=worldx-gp.player.worldx+gp.player.screenx;
            int screeny=worldy-gp.player.worldy+gp.player.screeny;

            g2.drawImage(tile[tileNum].image, screenx, screeny, gp.tileSize, gp.tileSize, null);
            worldCol++;


        if (worldCol == gp.maxWorldCol) {
            worldCol = 0;
            worldRow++;

        }



        }
    }


    }
