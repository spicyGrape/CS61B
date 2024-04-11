public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		in.readInt();
		return in.readDouble();
	}
	public static Planet[] readPlanets(String fN){
		In in = new In(fN);
		int numP = in.readInt();
		Planet[] planets = new Planet[numP];
		in.readDouble();
		for(int i = 0; i < numP; i=i+1){
			planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),"images/"+in.readString());
		}
		return planets;
	}
	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double uniRad = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int numP = planets.length;

		StdDraw.setScale(-uniRad,uniRad);
		StdDraw.clear();
		StdDraw.picture(0,0, "images/starfield.jpg");
		for(Planet p : planets){
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		double[] xForces = new double[numP];
		double[] yForces = new double[numP];
		for (double t = 0; t < T; t = t + dt){
			for(int i = 0; i < numP; i = i+1){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			StdDraw.clear();
			StdDraw.picture(0,0, "images/starfield.jpg");
			for(int i = 0; i < numP; i = i+1){
				planets[i].update(dt, xForces[i], yForces[i]);
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}
