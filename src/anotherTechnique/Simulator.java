package anotherTechnique;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    


    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        

        //valores de las figuras
        myCircle.setHeight(70);
        myCircle.setWidth(70);

    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        int x = (int) (Math.random() * (myDisplayer.getWidth() - 240));
        int y = (int) (Math.random() * (myDisplayer.getHeight() - 240));
        //ciclo infinito
        while (true){
        

            int x1 = (int) (Math.random() * (myDisplayer.getWidth() - 240));
            int y1 = (int) (Math.random() * (myDisplayer.getWidth() - 240));

        
            while(x1!=x && y1!=y){
                
                getMyCircle().setRow(y);
                getMyCircle().setColumn(x);
                this.createImages();
                            //pone en espera el flujo del programa
                Thread.sleep(waitingTime);

                if(x<x1)
                    x+=1;
                if(x>x1)
                    x-=1;
                if(y<y1)
                    y+=1;
                if(y>y1)
                    y-=1;      
            }
            
  
        }
    }//end method


    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());


        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    

}
