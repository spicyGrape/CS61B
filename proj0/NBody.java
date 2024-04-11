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
			planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}
		return planets;
	}
}
