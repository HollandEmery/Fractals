import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class jpanel extends JPanel implements KeyListener{

	public static KeyHandler listener;
	public static double incriment=0.0078;//s
	public static double xShift=0;//x
	public static double yShift=0;//y
	public static double range=2;//r
	public static double br = 100;
	double pumapotha = 1;
	public double xs = 0;
	public double ys = 0;
	public static long[] factorials = {1  
		,	 1
		, 	 2
		, 	 6
		, 	 24
		, 	 120
		, 	 720
		, 	 5040
		, 	 40320
		,	 362880
		, 	 3628800
		, 	 39916800
		, 	 479001600
		, 	 6227020800l
		, 	 87178291200l
		, 	 1307674368000l
		, 	 20922789888000l
		, 	 355687428096000l
		, 	 6402373705728000l
		, 	 121645100408832000l
		, 	 2432902008176640000l
	};
	public static int e=4;;
	//public static ArrayList <Integer> toGraph=new ArrayList();
	//public static int[] graphing;
	//public static int[] toGraph;
	public static int iterations=50;//i
	public static double realc = 0;//c
	public static double imc =0;//v
	public static double relx = 1;
	public static double rely = 1;
	public static double bluhx = -1;
	public static double bluhy = 0;
	//private double angle = 0;
	public BufferedImage im = null;
	public jpanel() {
		setBackground(Color.black);
		this.setFocusable(true);
		this.requestFocus();
		//	listener = new KeyHandler();
		addKeyListener((KeyListener) this);

		/*try {
				im = ImageIO.read(new File("me.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

	}
	public void paintComponent(Graphics g){
		//	System.out.println("da paint");
		super.paintComponent(g);
		//	g.drawImage(im, 0, 0, 1920, 1080, null);
		//g.drawImage(im, 0, 0, 1000,1000 null);
		//	g.setXORMode(getBackground());
		this.requestFocus();
		//mandlebrot2(g);
		julia(g);
		//buddha(g);
		//composite(g);
		//drawc(g);
		/*
		if(graphing!=null){
			System.out.println("hi");
		for (int i=0; i<graphing.length-2;i+=3){
			Color col=Color.black;
			int e=1;
			if (graphing[i+2]!=-1){
			//	col=new Color((int)(255.0/2+255.0/2*Math.sin(Math.PI*7/13*toGraph[i+2]+Math.PI/5)),(int)(255.0/2+255.0/2*Math.sin(Math.PI*2/5*toGraph[i+2])),(int)(255.0/2+255.0/2*Math.sin(Math.PI*7/13*toGraph[i+2])));
			//col=new Color((int)(255.0/2+255.0/2*Math.sin(Math.PI*2/25*(graphing[i+2]+0))),(int)(255.0/2+255.0/2*Math.sin(Math.PI*3/25*(graphing[i+2]+3))),(int)(255.0/2+255.0/2*Math.sin(Math.PI*3/30*(graphing[i+2]+30))));
				//col=Color.blue;
				//col=new Color(toGraph[i+2]*5+1,toGraph[i+2]*5+17,toGraph[i+2]*5+3);
				col=new Color((int)(255.0/iterations*toGraph[i+2]*50)%255,(int)(255.0/2*Math.cos(toGraph[i+2]*Math.PI*2/iterations)+255.0/2),(int)(255.0/2*Math.sin(toGraph[i+2]*Math.PI*2/iterations)+255.0/2));
				e=2;
			}
			g.setColor(col);
			g.fillRect(graphing[i]-e/2, graphing[i+1]-e/2, e, e);
			//col=Color.black;
		//	g.setColor(col);
			//g.drawRect(401,401,200,200);}

		}
			System.out.println("helooo");

		}

		 */
	}
	public void drawc(Graphics g){
		//g.drawRect(realc, imc, realc+1, realc+0.1);
		pumapotha+=1/Math.sqrt(pumapotha/2);
		g.drawRect(800+(int)((realc)*1600/4), (500+(int)((imc)*1600/4)), e, e);
		realc+=0.05*Math.sin(pumapotha*2*Math.PI/10)*Math.sqrt(pumapotha/5.0);
		imc+=0.05*Math.cos(pumapotha*2*Math.PI/10)*Math.sqrt(pumapotha/5.0);

	}


	public void mandlebrot2(Graphics g){
		/*double br =1900;
		xShift=yShift=0;
		double q=0;

		int e=3;
		range =4;
		incriment = 0.001;*/
		double poo =5/2.0;;
		Color col =null;
		double max = Integer.MIN_VALUE;
		double maxx = 0,maxy = 0,maxxx=0,maxyy=0,maxc=0,maxcc=0;
		for (double i=-range/2+yShift;i<range/2+yShift;i+=incriment){
			System.out.println(100*(i-yShift+range/2)/incriment/(range/incriment));
			//System.out.println(powerDub4i(3,4,2));
			//System.out.println(xShift+"\n"+yShift+"\n\n");
			for (double a=-range/2+xShift;a<range/2+xShift;a+=incriment){
				int colerations=0;
				boolean didIt=false;
				double realc = a;
				double imc = i;
				double realz=0,imz=0;
				double tempx,tempy;
				double mindist = Double.MAX_VALUE;
				for(;colerations<iterations&&(realz*realz+imz*imz)<4;colerations+=1){
					tempx = realz;
					tempy = imz;
					//imz*=-1;
					realz = realz*realz - imz*imz + realc;
					imz = 2*tempx*imz +imc;
					if(colerations == 0){realz = realc;imz = imc;continue;};
					if((realz-xs)*(realz-xs)+(imz-ys)*(imz-ys)<mindist)mindist = (realz-xs)*(realz-xs)+(imz-ys)*(imz-ys);
					//realz = powerDub4real(realz,imz,poo)+realc;
					//imz = powerDub4i(tempx,imz,poo)+imc;
					//System.out.println("bluh: "+(realz-tempx*tempx+imz*imz-realc));
					//if(realz-tempx*tempx+imz*imz-realc>max){
					/*if(Math.sqrt(Math.pow(realz-tempx*tempx+tempy*tempy-realc,2)+Math.pow(imz-2*tempx*tempy-imc,2))>max){
						max = Math.sqrt(Math.pow(realz-tempx*tempx+tempy*tempy-realc,2)+Math.pow(imz-2*tempx*tempy-imc,2));
						maxx = tempx;
						maxxx = realz;
						maxyy = imz;
						maxy = tempy;
						maxc = realc;
						maxcc = imc;
					}*/
					/*
					if((realz>-q*incriment+realc&&realz<q*incriment+realc)&&((imz>-incriment*q+imc)&&(imz<q*incriment+imc))&&colerations!=0){
						//||false&&((((int)(z.real*10000)/10000==((int)(c.real*10000)/10000)&&((int)(z.imag*10000)/10000==(int)(c.imag*10000)/10000))&&colerations!=0
						didIt=true;
						//System.out.println("hello");
						break;
					}*/


				}
				//System.out.println(colerations+" "+realz+" "+imz);
				if (!didIt){


					if (colerations!=-1){

						int red = 255 - (int)(255.0/br*colerations*50)%255;
						//red =(int)((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz))/2/Math.PI*255);

						int green=(int)(255.0/2*Math.cos(colerations*Math.PI*2.0/br*20)+255.0/2);
						int blue = (int)(255.0/2*Math.sin(Math.PI-colerations*Math.PI*2/br)+255.0/2);

						double angle = ((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz)));
						//red =(int)(Math.pow(((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz)))/2/Math.PI,3)*255);
						// green=(int)(255.0/2*Math.cos(0*colerations*Math.PI*2.0/br*20+Math.atan(realz/imz) + angle*0)+255.0/2);
						// blue = (int)(255.0/2*Math.sin(Math.PI-0*colerations*Math.PI*2/br+Math.atan(imz/realz) -angle*0)+255.0/2);
						double modist = (Math.sqrt(mindist)/(2+Math.sqrt(xs*xs+ys*ys)));

						col = Color.getHSBColor( 1-(float)modist, (float)Math.cbrt(colerations/(iterations+0.0f)),(float)(angle/Math.PI/2));

						//col=new Color(green,red,blue);

						if(colerations==iterations){
							//	col = Color.CYAN;
						}

					}
					g.setColor(col);
					g.fillRect((800+(int)((a-1*xShift)*1600/range)), (500+(int)((i-1*yShift)*1600/range)), e, e);
					//g.fillRect((18600/2+(int)((a-1*xShift)*18600/range)), (19200/2+(int)((i-1*yShift)*18600/range)), e, e);
				}
			}
		}
		System.out.println(max+" "+maxx+" "+maxy+" "+maxxx+" "+ maxyy+" "+maxc+" "+maxcc);
	}

	public void sort(int[] array){
		int min,temp;

		for(int index = 0; index < array.length-1; index++){
			min = index;
			for(int scan = index+1;scan < array.length; scan++){
				if(array[scan]>array[min]){
					min = scan;
				}
			}

			temp = array[min];
			array[min]=array[index];
			array[index] = temp;
		}
	}

	public void julia(Graphics g){
		//System.out.println("bruh");

		//xShift=yShift=0;
		//	double q=3;


		Color col =null;

		//range =4;
		//incriment = 0.0034;

		double realz,imz;
		boolean didIt;
		int colerations;
		int red,green,blue;
		double tempx, tempy,tempx2;
		double i,a;

		//Sdouble mindist = Double.MAX_VALUE;
		double tol = 0.00001;
		//	System.out.println(powerInt4real(1,1,2)+" "+powerInt4i(1,1,2));
		for (i=-range/2+yShift;i<range/2+yShift;i+=incriment){
			//	System.out.println(100*(i-yShift+range/2)/incriment/(range/incriment));
			for (a=-range/2/1080*1920+xShift;a<range/2*1920/1080+xShift;a+=incriment){
				colerations=0;
				didIt=false;
				realz=a;
				imz=i;
				tempx = realz;
				tempy = imz;
				//System.out.println(100*(i-yShift+range/2)/incriment/(range/incriment));
				for(;colerations<iterations&&((realz*realz+imz*imz)<4&&true) && (true||Math.abs(powerDub4real(tempx,tempy,3)-1)>tol&&Math.abs(powerDub4i(tempx,tempy,3))>tol)&&(true||Math.abs(powerDub4real(tempx,tempy,4)-powerDub4real(tempx,tempy,3)-11*powerDub4real(tempx,tempy,2)-tempx-12)>tol);colerations++){
					tempx = realz;
					tempy = imz;
					//realz = realz*realz - imz*imz + realc;
					//imz = 2*tempx*imz +imc;
					//realz = mult4real(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+1.55*mult4real(realz,imz)+realc;
					//	imz = mult4i(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+1.55*mult4i(tempx,imz)+imc;

					/*tempx2=mult4real(realz,imz,mult4real(realz,imz),mult4i(realz,imz));
					imz = mult4i(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz));
					realz = mult4real(tempx2,imz)+realc;
					imz = mult4i(tempx2,imz)+imc;
					realz=mult4real(realz,imz,tempx,-tempy)/mult4real(tempx,tempy,tempx,-tempy);
					realz=mult4real(realz,imz,tempx,-tempy)/mult4real(tempx,tempy,tempx,-tempy);
					 */
					//	if((realz-xs)*(realz-xs)+(imz-ys)*(imz-ys)<mindist)mindist = (realz-xs)*(realz-xs)+(imz-ys)*(imz-ys);
					//(z^3+c)/z i think
					//realz = mult4real(mult4real(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+realc,mult4i(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+imc,realz,-imz)/mult4real(realz,imz,realz,-imz);
					//imz =   mult4i(mult4real(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+realc,mult4i(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+imc,tempx,-imz)/mult4real(tempx,imz,tempx,-imz);
					//(z^4+c)/z
					//realz = mult4real(mult4real(mult4real(realz,imz),mult4i(realz,imz))+realc,mult4i(mult4real(realz,imz),mult4i(realz,imz))+imc,realz,-imz)/mult4real(realz,imz,realz,-imz);
					//imz =   mult4i(mult4real(mult4real(tempx,imz),mult4i(tempx,imz))+realc,mult4i(mult4real(tempx,imz),mult4i(tempx,imz))+imc,tempx,-imz)/mult4real(tempx,imz,tempx,-imz);

					//

					//	imz*=-1;
					//realz = realz*realz - imz*imz + realc;
					//imz = 2*tempx*imz +imc;

					realz = mult4real(powerInt4real(realz,imz,3)+realc,powerInt4i(realz,imz,3)+imc,realz,-imz)/mult4real(realz,imz,realz,-imz);
					imz = mult4i(         powerInt4real(tempx,imz,3)+realc,powerInt4i(tempx,imz,3)+imc,tempx,-imz)/mult4real(tempx,imz,tempx,-imz);
					//imz*=-1;


					//	if( (realz>-q*incriment+realc&&realz<q*incriment+realc)&&((imz>-incriment*q+imc)&&(imz<q*incriment+imc))&&colerations!=0){
					//	didIt=true;
					//break;
					//	}

					//realz = powerInt4real(realz,imz,4)+realc;
					//	imz = powerInt4i(tempx,imz,4) + imc;
					//realz = mult4real(mult4real(realz,imz),mult4i(realz,imz))+realc;
					//imz = mult4i(mult4real(tempx,imz),mult4i(tempx,imz))+imc;

					//	realz = realz-relx*divide4real(powerInt4real(realz,imz, 3)-1,powerInt4i(tempx,imz,3),mult4real(tempx,imz),mult4i(tempx,imz))/3+realc;
					//imz = imz - rely*divide4i(powerInt4real(tempx,imz, 3)-1,powerInt4i(tempx,imz,3),mult4real(tempx,imz),mult4i(tempx,imz))/3+imc;
					//	double topx = divide4real(powerDub4real(tempx,imz,3)+realc,powerDub4i(tempx,imz,3)+imc,tempx,tempy);
					//	double topy = divide4i(powerDub4real(tempx,imz,3)+realc,powerDub4i(tempx,imz,3)+imc,tempx,tempy);
					//	double botx = 2*tempx - divide4real(realc,imc,tempx*tempx-imz*imz,2*imz*tempx);
					//	double boty = 2*tempx - divide4i(realc,imc,tempx*tempx-imz*imz,2*imz*tempx);
					//	realz = realz - divide4real(topx,topy,botx,boty);
					//	imz = imz -divide4i(topx,topy,botx,boty);
					/*	double topx = powerDub4real(tempx,tempy,4)-powerDub4real(tempx,tempy,3)-11*powerDub4real(tempx,tempy,2)-tempx-12;
					double topy = powerDub4i(tempx,tempy,4)-powerDub4i(tempx,tempy,3)-11*powerDub4i(tempx,tempy,2)-tempy;
					double botx = powerDub4real(tempx,tempy,3)*4-powerDub4real(tempx,tempy,2)*3-11*tempx*2-1;
					double boty = powerDub4i(tempx,tempy,3)*4-powerDub4i(tempx,tempy,2)*3-11*tempy*2;
					realz = realz - 1*divide4real(topx,topy,botx,boty);
					imz = imz -1*divide4i(topx,topy,botx,boty);*/

				}
				if (!didIt){
					if (colerations!=-1){

						red = 255 - (int)(255.0/br*colerations*50)%255;
						red =(int)(Math.pow(((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz)))/2/Math.PI,3)*255);
						green=(int)(255.0/2*Math.cos(colerations*Math.PI*2.0/br*20+Math.asin(realz/2.0))+255.0/2);
						//
						blue = (int)(255.0/2*Math.sin(Math.PI-colerations*Math.PI*2/br+Math.asin(imz/2.0))+255.0/2);
						// 
						//	 double angle = ((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz)));
						//	red =(int)(Math.pow(((imz<0 && realz<0)?Math.atan(imz/realz)+Math.PI:(imz<0)?2*Math.PI+Math.atan(imz/realz):Math.acos(realz/Math.sqrt(imz*imz+realz*realz)))/2/Math.PI,3)*255);
						// green=(int)(255.0/2*Math.cos(0*colerations*Math.PI*2.0/br*20+Math.atan(realz/imz)*0 + angle)+255.0/2);
						// blue = (int)(255.0/2*Math.sin(Math.PI*0-0*colerations*Math.PI*2/br+Math.atan(imz/realz)*0+ angle)+255.0/2);
						//red = 255 - (int)(255.0/br*colerations*50)%255;
						//	green=(int)(255.0/2*Math.cos(colerations*Math.PI*2.0/br*20)+255.0/2);
						//	blue = (int)(255.0/2*Math.sin(Math.PI-colerations*Math.PI*2/br)+255.0/2);
						/*
						red = 255 - colerations*12;
						green = red;
						blue = red;
						if(Math.abs(angle) < 0.1||Math.abs(angle-2*Math.PI)<0.1){
							green = 0;
							blue = 0;
						}
						else if(Math.abs(angle-Math.PI*2/3.0) <0.1){
							red = 0;
							green = 0;
						}
						else{
							red = 0;
							blue = 0;
						}*/
						col=new Color(green,red,blue);
						//	double modist = (Math.sqrt(mindist)/(2+Math.sqrt(xs*xs+ys*ys)));

						//col = Color.getHSBColor( 1-(float)modist, (float)Math.cbrt(colerations/(iterations+0.0f)),(float)(angle/Math.PI/2));
						//	col.brighter();
						//col=Color.magenta;
						//e=12;
						if(colerations == iterations){
							col = Color.CYAN;
							//	e=7;
						}
						//	System.out.println(colerations);
						//col = Color.white;
						//if(colerations%2 == 0) col =Color.black;

					}
					g.setColor(col);
					g.fillRect((1920/2+(int)((a-1*xShift)*1080/range)), (1080/2+(int)((i-1*yShift)*1080/range)), e, e);
					//g.setColor(Color.black);
					//	g.drawLine((1920/2+(int)((-2-1*xShift)*1080/range)), (1080/2+(int)((0-1*yShift)*1080/range)),(1920/2+(int)((-2-1*xShift)*1080/range)), (1080/2+(int)((2-1*yShift)*1080/range)));
					//	g.drawLine((1920/2+(int)((2-1*xShift)*1080/range)), (1080/2+(int)((0-1*yShift)*1080/range)),(1920/2+(int)((2-1*xShift)*1080/range)), (1080/2+(int)((2-1*yShift)*1080/range)));
					//	g.drawLine((1920/2+(int)((-1-1*xShift)*1080/range)), (1080/2+(int)((0-1*yShift)*1080/range)),(1920/2+(int)((-1-1*xShift)*1080/range)), (1080/2+(int)((2-1*yShift)*1080/range)));
					//	g.drawLine((1920/2+(int)((1-1*xShift)*1080/range)), (1080/2+(int)((0-1*yShift)*1080/range)),(1920/2+(int)((1-1*xShift)*1080/range)), (1080/2+(int)((2-1*yShift)*1080/range)));
					/*
					 * above: from(0,0) to (1920,1080)
					 * mxn pics m is across
					 * each has range -2,2 in both directions
					 * pixeldims:1080/m X 1080/n
					 * it is the kth pic k starts at 0 for first
					 * nope this is all wrong cuz unequal
					 * start at: k*1080/m
					 * end at: (k+1)*1080/m
					 */
				}
			}

		}
		//realc+=incriment;

	}
	public void buddha(Graphics g){
		int[][] ar = new int[(int)(range/1080*1920/incriment)][(int)(range/incriment)];
		ArrayList<Double> ara = new ArrayList<Double>();

		double avg = 0;
		int count = 0;
		for (double i=-range/2+yShift;i<range/2+yShift;i+=incriment){
			//	System.out.println(100*(i-yShift+range/2)/incriment/(range/incriment));
			for (double a=-range/2/1080*1920+xShift;a<range/2*1920/1080+xShift;a+=incriment){
				int colerations=0;
				boolean didIt=false;
				//double realc = a;
				//double imc = i;
				double realz=a,imz=i;
				double tempx,tempy;
				ara.clear();
				double mindist = Double.MAX_VALUE;
				for(;colerations<iterations&&(realz*realz+imz*imz)<4;colerations+=1){
					tempx = realz;
					tempy = imz;
					realz = realz*realz - imz*imz + realc;
					imz = 2*tempx*imz +imc;
					//(z^3+c)/z i think
					//	realz = mult4real(mult4real(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+realc,mult4i(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+imc,realz,-imz)/mult4real(realz,imz,realz,-imz);
					//	imz =   mult4i(mult4real(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+realc,mult4i(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+imc,tempx,-imz)/mult4real(tempx,imz,tempx,-imz);

					if(tempy<range/2&&tempy>-range/2&&tempx<range/2*1920/1080&&tempx>-range/2/1080*1920){
						ara.add(tempx);
						ara.add(tempy);
					}
				}
				if(colerations==iterations)
					for(int k = 0;k<ara.size();k+=2){
						if(ar[(int)((ara.get(k)+range/2/1080*1920-xShift)/range/1920*1080*(ar.length-1))][(int)((ara.get(k+1)+range/2-yShift)/range*(ar[0].length-1))]==0)count++;
						ar[(int)((ara.get(k)+range/2/1080*1920-xShift)/range/1920*1080*(ar.length-1))][(int)((ara.get(k+1)+range/2-yShift)/range*(ar[0].length-1))]++;
						//else ar[(int)((ara.get(k)+range/2/1080*1920-xShift)/range/1920*1080*(ar.length-1))][(int)((ara.get(k+1)+range/2-yShift)/range*(ar[0].length-1))]++;
						avg++;
					}
			}
		}
		for(int i=0;i<ar.length;i++){
			for(int j = 0; j<ar[0].length; j++){
				//
				g.setColor(Color.black);

				if(ar[i][j]>0){
					//g.setColor(Color.white);
					g.setColor(new Color(Color.HSBtoRGB(0, 0, (float)((ar[i][j])/30.0))));
				}
				g.fillRect( i*1920/(ar.length), j*1080/(ar[0].length), e, e);
			}
		}
	}
	public void composite(Graphics g){
		Color col =null;
		double realz,imz;
		boolean didIt;
		int colerations;
		int red,green,blue;
		double tempx, tempy,tempx2;
		double i,a;
		int count=0;
		double ccount=0;
		int m=100,n=100,b,c;
		for(b = 0;b<m;b++){
			realc = (b+0.5)/m*4-2;
			for(c = 0; c< n; c++){
				System.out.println(100*(b*m+c+0.0)/(m*n));
				imc = (c+0.5)/n*4-2;
				count=0;
				ccount=0;
				for (i=-range/2+yShift;i<range/2+yShift;i+=incriment*4){
					for (a=-range/2+xShift;a<range/2+xShift;a+=incriment*4){
						count++;
						colerations=0;
						didIt=false;
						realz=i;
						imz=a;
						tempx = realz;
						tempy = imz;

						for(;colerations<iterations&&(realz*realz+imz*imz)<4;colerations++){
							tempx = realz;
							tempy = imz;
							realz = realz*realz - imz*imz + realc;
							imz = 2*tempx*imz +imc;
							//	realz = mult4real(mult4real(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+realc,mult4i(realz,imz,mult4real(realz,imz),mult4i(realz,imz))+imc,realz,-imz)/mult4real(realz,imz,realz,-imz);
							//	imz =   mult4i(mult4real(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+realc,mult4i(tempx,imz,mult4real(tempx,imz),mult4i(tempx,imz))+imc,tempx,-imz)/mult4real(tempx,imz,tempx,-imz);
						}
						red = 255 - (int)(255.0/br*colerations*50)%255;
						green=(int)(255.0/2*Math.cos(colerations*Math.PI*2.0/br*20)+255.0/2);
						blue = (int)(255.0/2*Math.sin(Math.PI-colerations*Math.PI*2/br)+255.0/2);
						col=new Color(green,red,blue);
						if(colerations == iterations){
							//col = Color.black;
							ccount++;
						}
						else{
							//col = Color.white;
						}
						g.setColor(col);
						g.fillRect((1920/2+(int)((a-1*xShift)*1080/range)), (1080/2+(int)((i-1*yShift)*1080/range)), e, e);
							g.fillRect(b*1080/m + (int)(a*1080/m/range), c*1080/n + (int)(i*1080/n/range) , e , e);
					}
					
					g.setColor(col);
					g.fillRect(b*1080/m , c*1080/n  , 1080/m , 1080/n);
				}
			}
		}
	}
	/*
	 * above: from(0,0) to (1920,1080)
	 * mxn pics m is across
	 * each has range -2,2 in both directions
	 * pixeldims:1080/m X 1080/n
	 * it is the kth pic k starts at 0 for first
	 * nope this is all wrong cuz unequal
	 * start at: k*1080/m
	 * end at: (k+1)*1080/m
	 */
	public static double tooth(double i){
		return Math.abs(4*(Math.abs((i/2.0/Math.PI-0.25))%1)-2)-1;
	}
	public static double mult4real(double r1, double i1, double r2, double i2){
		return r1*r2-i1*i2;
	}
	public static double mult4real(double r1, double i1){
		return r1*r1-i1*i1;
	}
	public static double mult4i(double r1, double i1, double r2, double i2){
		return r1*i2+i1*r2;
	}
	public static double mult4i(double r1, double i1){
		return r1*i1+i1*r1;
	}
	public static double powerInt4real(double r1, double i1, int power){
		double toReturn=0;
		//if(power == 1) return r1;
		for(int i=0;i<=power;i+=2){
			toReturn += factorials[power]/factorials[power-i]/factorials[i]*(i % 4 == 0? 1: -1 )*Math.pow(r1,power-i)*Math.pow(i1,i);
		}
		return toReturn;
	}
	public static double powerInt4i(double r1, double i1, int power){
		double toReturn=0;
		//if(power == 1) return i1;
		for(int i=1;i<=power;i+=2){
			toReturn += factorials[power]/factorials[power-i]/factorials[i]*((i-1) % 4 == 0? 1: -1 )*Math.pow(r1,power-i)*Math.pow(i1,i);
		}
		return toReturn;
	}
	public static double divide4real(double r1,double i1,double r2, double i2){
		return mult4real(r1,i1,r2,-i2)/(r2*r2+i2*i2);
	}
	public static double divide4i(double r1,double i1,double r2, double i2){
		return mult4i(r1,i1,r2,-i2)/(r2*r2+i2*i2);
	}
	public static double powerDub4real(double r1, double i1, double power){
		double angle = ((i1<0 && r1<0)?Math.atan(i1/r1)+Math.PI:(i1<0)?Math.atan(i1/r1):Math.acos(r1/Math.sqrt(i1*i1+r1*r1)));
		double r = Math.sqrt(r1*r1+i1*i1);
		return Math.pow(r, power)*Math.cos(angle*power);
	}
	public static double powerDub4i(double r1, double i1, double power){
		double angle = ((i1<0 && r1<0)?Math.atan(i1/r1)+Math.PI:(i1<0)?Math.atan(i1/r1):Math.acos(r1/Math.sqrt(i1*i1+r1*r1)));
		double r = Math.sqrt(r1*r1+i1*i1);
		return Math.pow(r, power)*Math.sin(angle*power);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char whichKey=e.getKeyChar();
		whichKey = (whichKey+"").toLowerCase().charAt(0);
		int s = e.isShiftDown()? -1 : 1;

		switch(whichKey){

		case 'i'://iterations
			jpanel.iterations += s*1;
			break;
		case 's'://incriment
			jpanel.incriment *= Math.pow(1.1, s); 
			break;
		case 'x'://xShift
			jpanel.xShift += jpanel.incriment*s*50;
			break;
		case 'y'://yShift
			jpanel.yShift += jpanel.incriment*s*50;
			break;
		case 'r'://range
			jpanel.range *= Math.pow(1.5, s);
			jpanel.incriment *= Math.pow(1.5, s);
			break;
		case 'c'://realc
			jpanel.realc += jpanel.incriment*s*5;
			bluhx += incriment*s;
			break;
		case 'v'://imc
			jpanel.imc += jpanel.incriment*s*5;
			bluhy += incriment*s;
			break;
		case 'b':
			br+=30*s;
			break;
		case 'e':
			jpanel.e+=s;
			jpanel.e=Math.abs(jpanel.e);
			break;
		case 't':
			relx+=s*0.01;
			break;
		case 'u':
			rely+=0.01;
			break;
		case 'q':
			xs+=0.1*s;
			break;
		case 'w':
			ys+=0.1*s;
		}
		System.out.println("its: "+iterations+" inc: "+incriment+" xShift: "+xShift+" yShift: "+yShift+" range: "+ range+" realc: "+realc+" imc: "+imc+" e:"+jpanel.e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void mandlebrot(Graphics g){
		double br =1900;
		xShift=-1.985540371654130485531439;
		yShift=0.000000000000000000000000000001565;

		xShift=-0.3585614710926859372;
		yShift=0.3229491840959411351;

		xShift = -1.740062382579339905220844167065825638296641720436171866879862418461182919644153056054840718339483225743450008259172138785492983677893366503417299549623738838303346465461290768441055486136870719850559269507357211790243666940134793753068611574745943820712885258222629105433648695946003865;
		yShift = 0.0281753397792110489924115211443195096875390767429906085704013095958801743240920186385400814658560553615695084486774077000669037710191665338060418999324320867147028768983704831316527873719459264592084600433150333362859318102017032958074799966721030307082150171994798478089798638258639934;
		//xShift = -0.750045367143;
		//yShift = 0.004786271734;

		//xShift =  -0.789374599271466936740382412558;
		//yShift = 0.163089252677526719026415054868;

		xShift =  0.405655815301385298448805944204 ;
		yShift = 0.148137310677896953031129846869;

		//xShift=-0.25901892;//more=go right;see left       less=left
		//yShift= -0.77688699;

		//range=0.00000000000009;
		//incriment=0.0000000000000001;



		range =Math.pow(2,-39);
		incriment = Math.pow(2,-49.8);

		//range =Math.pow(2,-37);
		//incriment = Math.pow(2,-47);
		//	range = Math.pow(2,-41);
		//incriment = Math.pow(2,-52);

		//range = Math.pow(2,-6);
		//incriment = Math.pow(2,-17);

		//range = Math.pow(2,-31);
		//incriment = Math.pow(2,-42);

		//xShift=0.3750001200618655;
		//yShift=-0.2166393884377127;

		range=4;
		incriment = 0.0005;

		System.out.println(incriment+1);
		double b = (1.0+incriment)-1.0;
		System.out.println(b/incriment);

		//int placement=0;
		double q=0;
		Color col =null;
		int e=1;
		//toGraph=new int[((int)((range/incriment+1)*(range/incriment+1)*3+3))];
		for (double i=-range/2+yShift;i<range/2+yShift;i+=incriment){
			//	System.out.println(100*(i-yShift+range/2)/incriment/(range/incriment));

			for (double a=-range/2+xShift;a<range/2+xShift;a+=incriment){
				Complex c= new Complex(a,i);
				int colerations=0;
				Complex z=new Complex(0,0);

				boolean didIt=false;

				//double p=Math.sqrt(	Math.pow(z.real-1/4.0,2)+z.imag*z.imag);
				//boolean dontDoIt = z.real<p-2*p*p+1/4.0;
				//dontDoIt = dontDoIt &&	Math.pow(z.real+1, 2)+z.imag*z.imag<1/16.0;
				//if(dontDoIt)	colerations = iterations;
				for(;colerations<iterations&&(z.real*z.real+z.imag*z.imag)<4;colerations+=1){
					//z.imag*=-1;
					z=Complex.addem(Complex.square(z),c);
					//z=Complex.addem(Complex.square(Complex.square(z)), c);

					/*	if(colerations%5==0&&colerations%6<3){
					z=Complex.addem(Complex.square(Complex.square(z)), c);
					}
					else if(colerations%13==0){

					z=Complex.addem(Complex.multiply(Complex.square(z),z),c);
					}
					else {
						z.imag*=-1;
						z=Complex.addem(Complex.square(Complex.square(Complex.square(z))), c);
					}

					/*else{
						z=Complex.addem(Complex.multiply(Complex.square(Complex.square(z)),z), c);
					}*/
					if((z.real>-q*incriment+c.real&&z.real<q*incriment+c.real)&&((z.imag>-incriment*q+c.imag)&&(z.imag<q*incriment+c.imag))&&colerations!=0){
						//||false&&((((int)(z.real*10000)/10000==((int)(c.real*10000)/10000)&&((int)(z.imag*10000)/10000==(int)(c.imag*10000)/10000))&&colerations!=0
						didIt=true;
						//System.out.println("hello");
						break;
					}

				}
				if (!didIt){

					//System.out.println(didIt);

					//System.out.println(test);
					//toGraph[placement+2]=(colerations);
					//toGraph[placement+1]=(500+(int)((i-yShift)*1600/range));
					//toGraph[placement]=(800+(int)((a-1*xShift)*1600/range));

					if (colerations!=-1){
						//	col=new Color((int)(255.0/2+255.0/2*Math.sin(Math.PI*7/13*toGraph[i+2]+Math.PI/5)),(int)(255.0/2+255.0/2*Math.sin(Math.PI*2/5*toGraph[i+2])),(int)(255.0/2+255.0/2*Math.sin(Math.PI*7/13*toGraph[i+2])));
						//col=new Color((int)(255.0/2+255.0/2*Math.sin(Math.PI*2/25*(graphing[i+2]+0))),(int)(255.0/2+255.0/2*Math.sin(Math.PI*3/25*(graphing[i+2]+3))),(int)(255.0/2+255.0/2*Math.sin(Math.PI*3/30*(graphing[i+2]+30))));
						//col=Color.blue;
						//col=new Color(toGraph[i+2]*5+1,toGraph[i+2]*5+17,toGraph[i+2]*5+3);
						int red = 255 - (int)(255.0/br*colerations*50)%255;
						int green=(int)(255.0/2*Math.cos(colerations*Math.PI*2.0/br*20)+255.0/2);
						int blue = (int)(255.0/2*Math.sin(Math.PI-colerations*Math.PI*2/br)+255.0/2);
						col=new Color(red,green,blue);
						;
						if(colerations==iterations){
							col = Color.CYAN;
						}
					}
					g.setColor(col);
					//g.fillRect((800+(int)((a-1*xShift)*1600/range)), (500+(int)((i-1*yShift)*1600/range)), e, e);
					g.fillRect((800+(int)((a-1*xShift)*1600/range)), (500+(int)((i-1*yShift)*1600/range)), e, e);
					//g.drawLine((800+(int)((a-1*xShift)*1600/range))-e/2, (500+(int)((i-1*yShift)*1600/range))-e/2, (800+(int)((a-1*xShift)*1600/range)), (500+(int)((i-1*yShift)*1600/range)));

					/*System.out.println(toGraph[placement]);
				System.out.println(toGraph[placement+1]);
				System.out.println(toGraph[placement+3]);*/
					//placement+=3;
				}

			}


		}

		//graphing=(int[]) toGraph.toArray();

	}
}