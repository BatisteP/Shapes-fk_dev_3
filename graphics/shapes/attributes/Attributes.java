package graphics.shapes.attributes;

public  abstract class Attributes {
	public static final String SelectionID = "selection";
	public static final String FontID = "font";
	public static final String ColorID = "color";
	public static final String RotationID = "rotation";
	public static final String ResizeID = "resize";
	public abstract String getID();
	public abstract Attributes clone();
}
