
public class Main {

	public static void main(String[] args) {
		
		Vector2D v1 = new Vector2D(1, 1);
		Vector2D v2 = new Vector2D(2, 2);
		
		System.out.println("v1 + v2 = " + (Vector2D.add(v1, v2)));
		System.out.println("v1 - v2 = " + (Vector2D.sub(v1, v2)));
		System.out.println("v1 . v2 = " + (Vector2D.dotProduct(v1, v2)));
		System.out.println("v1 * 3  = " + (Vector2D.mul(v1, 3)));
		System.out.println("v1 heading " + v1.getDirection());
		System.out.println("Translate [1, -1] : " + v1.translate(1,  -1));
		System.out.println("Rotate +PI/4 : " + v1.rotate(Math.PI/4));
		System.out.println("Zero Vector : " + Vector2D.ZERO_VECTOR);
	}

}
