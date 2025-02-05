package main;
import entity.Player;
import tile.TileManager;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


public class GamePanel extends JPanel implements Runnable {
    public  final int originalTileSize=16;
    final int scale=3;
    public final int tileSize=originalTileSize*scale;
    public final int maxScreenRow=12;
    public final int maxScreenCol=16;
    public final int screenWidth=tileSize*maxScreenCol;
    public final int screenHeight=tileSize*maxScreenRow;

    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight =tileSize * maxScreenRow;

    int FPS=60;
    TileManager tileM=new TileManager(this);
    KeyHandler keyH =new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker=new CollisionChecker(this);
    public Player player =new Player(this,keyH);

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void StartGameThread()
    {
        gameThread =new Thread(this);
        gameThread.start();
    }
    @Override
    public void run()
    {
        double drawInterval=1000000000/FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;
        while(gameThread!=null)
        {
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime=remainingTime/1000000;
                if(remainingTime<0){
                    remainingTime=0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime+=drawInterval;
                long currentTime = System.nanoTime();
                // System.out.println("Current Time" + currentTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

   public void update()
    {
        try {
            player.update();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

}