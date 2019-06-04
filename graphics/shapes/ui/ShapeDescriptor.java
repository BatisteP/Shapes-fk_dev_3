package graphics.shapes.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SImage;
import graphics.shapes.SPalette;
import graphics.shapes.SPolygon;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.RotationAttributes;


public class ShapeDescriptor implements ShapeVisitor{
	
	public static final ColorAttributes DEFAULTCOLORATTRIBUTES = new ColorAttributes();
	public static FontAttributes DEFAULTFONTATTRIBUTES = new FontAttributes();

	
	public void visitRectangle(SRectangle rect) {
		ColorAttributes ca = (ColorAttributes) rect.getAttributes(Attributes.ColorID);
		RotationAttributes rot = (RotationAttributes) rect.getAttributes(Attributes.RotationID);
		if (ca == null) {
			ca = DEFAULTCOLORATTRIBUTES;
		}
		System.out.println("\tRectangle");
		System.out.println("  position (x,y) = ("+rect.getCenter().x+","+rect.getCenter().y+")"
				+ " width="+rect.getRect().width+" height="+rect.getRect().height);
		if (ca.filled()) {
			System.out.println("  filled :" +getRGBString(ca.filledColor()));
		}
		if (ca.stroked()) {
			System.out.println("  stroked :" +getRGBString(ca.strokedColor()));
		}
		if (rot==null) {
			rot = new RotationAttributes();
		}
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println("--------------------------------------------------------------------");
		
	}

	@Override
	public void visitCircle(SCircle c) {
		ColorAttributes ca = (ColorAttributes) c.getAttributes(Attributes.ColorID);
		RotationAttributes rot = (RotationAttributes) c.getAttributes(Attributes.RotationID);
		if (ca == null) {
			ca = DEFAULTCOLORATTRIBUTES;
		}
		System.out.println("\tCircle");
		System.out.println("  position (x,y) = ("+c.getCenter().x+","+c.getCenter().y+") radius="
				+c.getRadius());
		if (ca.filled()) {
			System.out.println("  filled :" +getRGBString(ca.filledColor()));
		}
		if (ca.stroked()) {
			System.out.println("  stroked :" +getRGBString(ca.strokedColor()));
		}
		if (rot==null) {
			rot = new RotationAttributes();
		}
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println("--------------------------------------------------------------------");
		
	}

	@Override
	public void visitText(SText t) {
		ColorAttributes ca = (ColorAttributes) t.getAttributes(Attributes.ColorID);
		RotationAttributes rot = (RotationAttributes) t.getAttributes(Attributes.RotationID);
		FontAttributes fa = (FontAttributes) t.getAttributes(Attributes.FontID);
		if (ca == null) {
			ca = DEFAULTCOLORATTRIBUTES;
		}
		System.out.println("\tText");
		System.out.println("  \"" + t.getText()+"\"");
		if (fa==null) {
			fa=DEFAULTFONTATTRIBUTES;
		}
		System.out.println("  font : "+getFontString(fa.font())+" "+getRGBString(fa.fontColor()));
		System.out.println("  position (x,y) = ("+t.getCenter().x+","+t.getCenter().y+")"
				+ " width="+t.getBounds().width+" height="+t.getBounds().height);
		if (ca.filled()) {
			System.out.println("  filled :" +getRGBString(ca.filledColor()));
		}
		if (ca.stroked()) {
			System.out.println("  stroked :" +getRGBString(ca.strokedColor()));
		}
		if (rot==null) {
			rot = new RotationAttributes();
		}
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println("--------------------------------------------------------------------");
	}
	
	public void visitPolygon(SPolygon pol) {
		ColorAttributes ca = (ColorAttributes) pol.getAttributes(Attributes.ColorID);
		RotationAttributes rot = (RotationAttributes) pol.getAttributes(Attributes.RotationID);
		if (ca == null) {
			ca = DEFAULTCOLORATTRIBUTES;
		}
		System.out.println("\tPolygon");
		System.out.println("  position (x,y) = ("+pol.getCenter().x+","+pol.getCenter().y+")"
				+ " width="+pol.getBounds().width+" height="+pol.getBounds().height);
		if (ca.filled()) {
			System.out.println("  filled :" +getRGBString(ca.filledColor()));
		}
		if (ca.stroked()) {
			System.out.println("  stroked :" +getRGBString(ca.strokedColor()));
		}
		if (rot==null) {
			rot = new RotationAttributes();
		}
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println(" Polygon vertices");
		Polygon polygon = pol.getPolygon();
		for (int i=0;i<polygon.xpoints.length;i++) {
			Point p = new Point(i,polygon.ypoints[i]);
			System.out.println("  ("+p.x+","+p.y+")");
		}
		
		System.out.println("--------------------------------------------------------------------");
	}
	@Override
	public void visitCollection(SCollection col) {
		RotationAttributes rot = (RotationAttributes) col.getAttributes(Attributes.RotationID);
		System.out.println("############Collection############");
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println("  Shapes in collection :");
		System.out.println("  ");
		for (Iterator<Shape> it = col.iterator(); it.hasNext();) {
			it.next().accept(this);
		}
		System.out.println("############End of collection############");
		
	}
	public String getRGBString(Color c) {
		String str = "  RGB("+c.getRed()+","+c.getGreen()+","+c.getBlue()+")";
		return str;
	}
	public String getFontString(Font f) {
		String str="  name="+f.getName()+" style="+f.getStyle()+" size="+f.getSize();
		return str;
	}

	@Override
	public void visitImage(SImage i) {
		RotationAttributes rot = (RotationAttributes) i.getAttributes(Attributes.RotationID);
		System.out.println("\tImage");
		System.out.println("  position (x,y) = ("+i.getCenter().x+","+i.getCenter().y+")"
				+ " width="+i.getBounds().width+" height="+i.getBounds().height);
		
		if (rot==null) {
			rot = new RotationAttributes();
		}
		System.out.println("  Path: "+i.getUrl());
		if (rot.getAngle()<1) {
			System.out.println("  Rotation : " +rot.getAngle()+" degree");
		}
		else System.out.println("  Rotation : " +rot.getAngle()+" degrees");
		System.out.println("--------------------------------------------------------------------");
		
	}

	@Override
	public void visitPalette(SPalette p) {		
	}
		
	
	

}
