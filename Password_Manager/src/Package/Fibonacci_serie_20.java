package Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.event.MouseWheelListener;
 
/**
 * This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class Fibonacci_serie_20 extends JFrame {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<JLabel> list_Of_JLabel = new ArrayList<JLabel>();
	public int scale=10;
	public int scale2=10;
	public BigDecimal Golden_Ratio; 


    public Fibonacci_serie_20() {
        super("fibonacci sequence");
        getContentPane().addMouseWheelListener(new MouseWheelListener() {
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		
        		int notches = e.getWheelRotation();
        		int notches2 = -1*e.getWheelRotation();

        		scale+=notches;
        		scale=clamp(scale,1,80);
        		scale2+=notches2;
        		scale2=clamp(scale2,5,100);
        		
        		System.out.println("scale"+scale);
        		System.out.println("scale2"+scale2);

                Size_Correction();
                reload();
                
                
        	}
        });
 
        setSize(500, 500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        
        
    }
 
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int center_x=getSize().height;
        int center_y=getSize().width;
        int size=100;
        int [] febu=new int[size];
        Object [] pos=new Object[2];
 
        //Draw_Curved_Lines(g);
        Draw_Grid(g,scale2);
        
        g2d.setColor(Color.RED);
        g2d.drawLine(0, center_y/2, center_x, center_y/2);
        g2d.drawLine( center_x/2,0, center_x/2, center_y);
        //Draw_Square(g,scale,400,400);
        
        //Draw_Square(g,scale,400,420);
        

        
        febu=Generate_Sequence(size);
     
        pos=Generate_Position_Sequence_2(20,febu,center_x/2,center_y/2);
        
        Loop_Draw_Square(g,febu,(double[])pos[0],(double[])pos[1]);


         
       // g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
       // g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
 
    }
    
    public void Draw_Square(Graphics g,int s ,int x, int y)
    {
        Graphics2D g3d = (Graphics2D) g;
        
        g3d.setColor(Color.BLUE);
        g3d.drawLine(x-s, y-s, x+s, y-s);
        g3d.drawLine(x-s, y+s, x+s, y+s);
        g3d.drawLine(x-s, y-s, x-s, y+s);
        g3d.drawLine(x+s, y+s, x+s, y-s);

        JLabel lblNewLabel = new JLabel(String.valueOf(s));
        lblNewLabel.setBounds(x-s-4, y-40, 20, 20);
        getContentPane().add(lblNewLabel);
        setSize( 801 , 801 );

    }
    public void Loop_Draw_Square(Graphics g,int[] febu ,double[] X,double[] Y)
    {
    	
    	
    	if(list_Of_JLabel.size()!=0)
    	{
    		for (JLabel var : list_Of_JLabel) 
    		{ 
    		    this.remove(var);
    		}
    		
    		list_Of_JLabel.clear();
    	}
    	
        Graphics2D g3d = (Graphics2D) g;
        for(int i=0;i<X.length;i++)
        {
        g3d.setColor(Color.BLUE);
        g3d.draw(new Line2D.Double(X[i]-febu[i]*scale, Y[i]-febu[i]*scale, X[i]+febu[i]*scale, Y[i]-febu[i]*scale));
        g3d.draw(new Line2D.Double(X[i]-febu[i]*scale, Y[i]+febu[i]*scale, X[i]+febu[i]*scale, Y[i]+febu[i]*scale));
        g3d.draw(new Line2D.Double(X[i]-febu[i]*scale, Y[i]-febu[i]*scale, X[i]-febu[i]*scale, Y[i]+febu[i]*scale));
        g3d.draw(new Line2D.Double(X[i]+febu[i]*scale, Y[i]+febu[i]*scale, X[i]+febu[i]*scale, Y[i]-febu[i]*scale));

        JLabel lblNewLabel = new JLabel(String.valueOf(febu[i]));
        lblNewLabel.setBounds((int)X[i],(int) Y[i]-40, clamp(scale*i/2,30,80), clamp(scale*i/2,30,80));
        Font f = new Font("Tahoma", Font.PLAIN, clamp(scale*i/2,15,80));
        lblNewLabel.setFont(f);
        getContentPane().add(lblNewLabel);
        //setSize( getSize().height , getSize().width );

        list_Of_JLabel.add(lblNewLabel);
        
        }
    }
    public int[] Generate_Sequence(int size)
    {
    	int [] sequence= new int[size];
    			
    			for(int i=0;i<sequence.length;i++)
    	        {
    				
    	        	if(i==0)
    	        	{
    	        		sequence[i]=1;
    	        		
    	        		
    	        	}else if(i==1)
    	        	{
    	        		sequence[i]=1;
    	        	}else
    	        	{
    	        		sequence[i]=Math.abs(sequence[i-2]+sequence[i-1]);
    	        	}
    	        	

    	        	
    	        }
    			System.out.println( Arrays.toString(sequence));
    			
    			//Golden_Ratio=Golden_Ratio.divide((BigDecimal.valueOf(sequence[sequence.length-1])),100,RoundingMode.UNNECESSARY);
    			
    			//BigDecimal part1=((BigDecimal.valueOf(sequence[sequence.length-1])).add((BigDecimal.valueOf(sequence[sequence.length-2])))); 
    			//BigDecimal divi=(BigDecimal.valueOf(sequence[sequence.length-1])); 


    			//Golden_Ratio=part1.divide(divi,100,RoundingMode.UNNECESSARY);

    			//System.err.println("==Golden_Ratio=="+sequence[sequence.length-1]+"+"+sequence[sequence.length-2]+"/"+sequence[sequence.length-1]);

    			//System.err.println("==Golden_Ratio=="+Golden_Ratio);

    			return sequence;
    	
    }
    public Object[] Generate_Position_Sequence(int size,int [] febu,int center_x,int center_y)
    {
    	int [] sequence_x= new int[size];
    	int [] sequence_y= new int[size];

    	int neg_pos_x=-1;
    	int neg_pos_y=1;


    
    	   //THIS GENERATE THE X POSITION
        for(int i=0;i<size;i++)
        {
        	if(i==0)
        	{
        		sequence_x[i]=center_x + (febu[i]*scale)*neg_pos_x;
            	neg_pos_x*=-1;
        		
        	}else if(i==1)
         	{
             	sequence_x[i]=center_x + (febu[i]*scale*i)*neg_pos_x+(sequence_x[i-1]-center_x)*neg_pos_x*-1;
             	neg_pos_x*=-1;

             	}else
        	{
        	sequence_x[i]=center_x + (febu[i]*scale*i)*neg_pos_x+(sequence_x[i-2]-center_x)*neg_pos_x*-1;
        	neg_pos_x*=-1;

        	}

        	
        }

		System.out.println( Arrays.toString(sequence_x));


 	   //THIS GENERATE THE Y POSITION
     for(int i=0;i<size;i++)
     {
     	
     	
    	 if(i==0)
     	{
     		sequence_y[i]=center_y + (febu[i])*neg_pos_y;
         	neg_pos_y*=-1;
     		
     	}else if(i==1)
     	{
     	sequence_y[i]=center_y + (febu[i]*5*i)*neg_pos_y+(sequence_y[i-1]-center_y)*neg_pos_y*-1;
     	neg_pos_y*=-1;

     	}else
     	{
     	sequence_y[i]=center_y + (febu[i]*5*i)*neg_pos_y+(sequence_y[i-2]-center_y)*neg_pos_x*-1;
     	neg_pos_y*=-1;

     	}
     	
     }
		System.out.println( Arrays.toString(sequence_y));

    	Object [] varr= new Object [2];
    	varr[0]=sequence_x;
    	varr[1]=sequence_y;
    	return varr;
    	
    }
    public Object[] Generate_Position_Sequence_2(int size,int [] febu,int center_x,int center_y)
    {
    	double [] sequence_x= new double[size];
    	double [] sequence_y= new double[size];

    	int neg_pos_x_1=-1;
    	int neg_pos_x_2=1;

    	@SuppressWarnings("unused")
		int neg_reff=-1;
    	
    	int neg_incr_x_1=1;
    	int neg_incr_x_2=0;

    

    
    	   //THIS GENERATE THE X POSITION
		System.out.println("THIS GENERATE THE X POSITION");

        for(int i=0;i<size;i++)
        {
        	if(i==0)
        	{
        		sequence_x[i]=center_x + (febu[i]*scale)*neg_pos_x_1;
        		neg_pos_x_1*=-1;
        		
        	}else if(i==1)
         	{
             	sequence_x[i]=center_x + (febu[i]*scale)*neg_pos_x_1;
             	neg_pos_x_1*=-1;

            }else
        	{
            	//neg increment 1
            	if(neg_incr_x_1==0||neg_incr_x_1==1)
            	{
            		neg_incr_x_1++;

            	}
            	
            	
            	//neg increment 2
            	if(neg_incr_x_2==0||neg_incr_x_2==1)
            	{
            		neg_incr_x_2++;

            	}
             
            

        	sequence_x[i]= sequence_x[i-1] + ((febu[i-1]*scale)*neg_pos_x_1) + ((febu[i]*scale)*neg_pos_x_2) ;

        	if(i==2)sequence_x[i]=center_x;

        	neg_reff*=-1;
    		System.out.println("neg_pos :("+neg_pos_x_1+"|"+ neg_pos_x_2+") | I : "+febu[i] +" increment 1,2 : ("+neg_incr_x_1+"|"+neg_incr_x_2+")");

    		
    		
        	if(neg_incr_x_1==2)
        	{
        		
        		neg_pos_x_1*=-1;
        		neg_incr_x_1=0;

        	}
        	if(neg_incr_x_2==2)
        	{
        		
        		neg_pos_x_2*=-1;
        		neg_incr_x_2=0;

        	}

        	}

        	
        }
        

		System.out.println( Arrays.toString(sequence_x));

		
		neg_pos_x_1=1;
    	neg_pos_x_2=1;

    	neg_reff=-1;
    	
    	neg_incr_x_1=0;
    	neg_incr_x_2=1;

 
		

 	   //THIS GENERATE THE Y POSITION
		System.out.println("THIS GENERATE THE Y POSITION");

     for(int i=0;i<size;i++)
     {
    	 if(i==0)
     	{
     		sequence_y[i]=center_x + (febu[i]*scale)*neg_pos_x_1;
     		neg_pos_x_1*=-1;
     		
     	}else if(i==1)
      	{
          	sequence_y[i]=sequence_y[i-1];
          	neg_pos_x_1*=-1;

         }else
     	{
         	//neg increment 1
         	if(neg_incr_x_1==0||neg_incr_x_1==1)
         	{
         		neg_incr_x_1++;

         	}
         	
         	
         	//neg increment 2
         	if(neg_incr_x_2==0||neg_incr_x_2==1)
         	{
         		neg_incr_x_2++;

         	}
          
         

     	sequence_y[i]= sequence_y[i-1] + ((febu[i-1]*scale)*neg_pos_x_1) + ((febu[i]*scale)*neg_pos_x_2) ;

     	//if(i==2)sequence_y[i]=center_x;

     	neg_reff*=-1;
 		System.out.println("neg_pos :("+neg_pos_x_1+"|"+ neg_pos_x_2+") | I : "+febu[i] +" increment 1,2 : ("+neg_incr_x_1+"|"+neg_incr_x_2+")");

 		
 		
     	if(neg_incr_x_1==2)
     	{
     		
     		neg_pos_x_1*=-1;
     		neg_incr_x_1=0;

     	}
     	if(neg_incr_x_2==2)
     	{
     		
     		neg_pos_x_2*=-1;
     		neg_incr_x_2=0;

     	}

     	}

     	
     }
		System.out.println( Arrays.toString(sequence_y));

    	Object [] varr= new Object [2];
    	varr[0]=sequence_x;
    	varr[1]=sequence_y;
    	return varr;
    	
    }
    public void Draw_Grid(Graphics g,int lines)
    {
    	   Graphics2D g3d = (Graphics2D) g;
           
           g3d.setColor(new Color(192,192,192));
           float x = 0;
           
    	   
        for(int i=0;i<lines;i++)
        {
        	x+=(getSize().height/lines);
        	
            g3d.draw(new Line2D.Double(0, x , getSize().height, x ));
            g3d.draw(new Line2D.Double(x, 0 , x  , getSize().height));

        	
        }
        
    	
    	
    }
    public void Clean_JLabel() {
     
    }
    protected static int clamp(int val, int min, int max) {
		int clamped=(int) Math.max(min, Math.min(max, val));
	    return clamped;
	}
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
    public void Draw_Curved_Lines(Graphics g)
    {
        Graphics2D g3d = (Graphics2D) g;

    	// create new QuadCurve2D.Float
    	QuadCurve2D q = new QuadCurve2D.Float();
    	// draw QuadCurve2D.Float with set coordinates
    	q.setCurve((getSize().width/10), (getSize().getHeight()/10), 100, 300 , (getSize().width/3),(getSize().getHeight()/3));
    	g3d.draw(q);
    	//
    	
    	/*  Instruction to use to be able to code the curve of 
    	 * the fibonacci sequence inside each cube the sequence
    	 * is dinamic so i wont matter how big or small ^^
    	+=======+==========+============+=======+===========+
        | Order | Vertical | Horizental | Order | Fibonacci |
        +=======+==========+============+=======+===========+
        |     1 |        - |    -       |     2 |         1 |
        +-------+----------+------------+-------+-----------+
        |     2 |        + |    -       |     1 |         1 |
        +-------+----------+------------+-------+-----------+
        |     1 |        + |    +       |     2 |         2 |
        +-------+----------+------------+-------+-----------+
        |     2 |        - |    +       |     1 |         3 |
        +-------+----------+------------+-------+-----------+
        |     1 |        - |    -       |     2 |         5 |
        +-------+----------+------------+-------+-----------+
        |     2 |        + |    -       |     1 |         8 |
        +-------+----------+------------+-------+-----------+
        |     1 |        + |    +       |     2 |        13 |
        +-------+----------+------------+-------+-----------+
    	*/
    	
    }
    public void reload ()
    {
    	
    		
    		this.validate();
            this.repaint();
            this.revalidate(); 
    		this.repaint();
    		
    	
    	   

    }
    public void Size_Correction ()
    {
    	
    		
    		setSize(getSize().height,getSize().height);
    		
    	
    	   

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fibonacci_serie_20().setVisible(true);
            }
        });
    }
}
