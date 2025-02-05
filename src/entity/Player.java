package entity;

import main.GamePanel;
import main.KeyHandler;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
  public GamePanel gp;
    KeyHandler keyH;

    public final int screenx;
    public final int screeny;
    public boolean gameFinished=false;

    public int winx;
    public int winy;


    public Player(GamePanel gp,KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;

        screenx=gp.screenWidth/2-(gp.tileSize);
        screeny=gp.screenHeight/2-(gp.tileSize);
        solidArea=new Rectangle();
        solidArea.x=0;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;


        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldx=280; //gp.tileSize*23;323;
        worldy=330; //gp.tileSize*21;35*65;
        speed=4;
        direction="down";
    }
    public void getPlayerImage(){
      try {
            up1= ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
        }
         /* try {
            up1= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_down_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_right_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/Monster/orc_left_2.png"));
        }*/

        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update() throws InterruptedException {
        if((keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed) == true) {
            if (keyH.upPressed == true) {

                direction = "up";
            } else if (keyH.downPressed == true) {

                direction = "down";
            } else if (keyH.leftPressed == true) {

                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";

            }
            collisionOn = false;
            gp.cChecker.checkTile(this);
            if (collisionOn == false) {
                switch (direction) {

                    case "up":
                        worldy = worldy - speed;
                        break;
                    case "down":
                        worldy = worldy + speed;
                        break;
                    case "right":
                        worldx += speed;
                        break;
                    case "left":
                        worldx -= speed;
                        break;

                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
                System.out.println("Player coordinates: x=" + worldx + ", y=" + worldy);
                // Display coordinates in the console
                for (int i = 323; i <= 351; i++) {
                    for (int j = 2275; j <= 2327; j++) {
                        if (worldx == i && worldy == j) {
                         //   System.out.println("you have win");
                          //  JOptionPane.showMessageDialog(null, "You have won!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                            String message = "<html><body style='text-align: center; font-family: Arial;'>"
                                    + "<h1 style='color: green;'>You Have Won!</h1>"
                                    + "<h2 style='color: blue;'>Congratulations!</h2>"
                                    + "<p style='color: red; font-size: 16px;'>Enjoy your success!</p>"
                                    + "</body></html>";

                            // Displaying the message in a dialog box
                            JOptionPane.showMessageDialog(null, message, "Winner Announcement", JOptionPane.INFORMATION_MESSAGE);

                            try {
                                Thread.sleep(2000); // Delay for 3 seconds (3000 milliseconds)
                            } catch (InterruptedException e) {
                                e.printStackTrace(); // Handle interruption
                            }
                            System.exit(0);
                        }
                    }
                }
            }
        }
        }

    public void draw(Graphics2D g2)
    {
        //  g2.setColor(Color.white);
        // g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image=null;
        switch(direction)
        {
            case "up":
                if(spriteNum==1) {
                    image = up1;
                }
                if(spriteNum==2)
                {
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1) {
                    image = down1;
                }  if(spriteNum==2) {
                image=down2;
            }
                break;
            case"left":  if(spriteNum==1) {
                image = left1;
            }  if(spriteNum==2) {
                image = left2;
            }
                break;
            case"right":  if(spriteNum==1) {
                image = right1;
            }  if(spriteNum==2) {
                image = right2;
            }
                break;
        }
        g2.drawImage(image,screenx,screeny,gp.tileSize,gp.tileSize,null);
    }



    }



