public class Planet{
	private static final double G = 6.67e-11;
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		return Math.sqrt((yyPos-p.yyPos)*(yyPos-p.yyPos)+(xxPos-p.xxPos)*(xxPos-p.xxPos));
	}
	public double calcForceExertedBy(Planet p){
		return G * mass * p.mass/(calcDistance(p) * calcDistance(p));
	}
	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceExertedByX = 0;
		for ( Planet p : allPlanets ) {
			if (!this.equals(p)){
				netForceExertedByX = netForceExertedByX + calcForceExertedByX(p);
			}
		}
		return netForceExertedByX;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceExertedByY = 0;
		for ( Planet p : allPlanets ) {
			if (!this.equals(p)){
				netForceExertedByY = netForceExertedByY + calcForceExertedByY(p);
			}
		}
		return netForceExertedByY;
	}
	public void update(double dt, double xForce, double yForce){
		xxVel = xxVel + xForce * dt / mass;
		yyVel = yyVel + yForce * dt / mass;
		xxPos = xxPos + xxVel * dt;
		yyPos = yyPos + yyVel * dt;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,imgFileName);
	}	
}

