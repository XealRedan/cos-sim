package ru.cos.sim.visualizer.scene.shapes;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import ru.cos.sim.visualizer.color.Color;
import ru.cos.sim.visualizer.math.Vector2f;
import ru.cos.sim.visualizer.renderer.Renderer.RenderType;
import ru.cos.sim.visualizer.scene.impl.ITrafficLight;
import ru.cos.sim.visualizer.trace.item.base.TrafficLight;

public class TransitionForm extends AbstractItem implements ITrafficLight{
	protected ArrayList<Vector2f> points;
	protected ArrayList<Integer> indexes;
	protected TrafficLight.Color currentColor;
	protected Float position = new Float(0);
	
	public TransitionForm() {
		super();
		this.points = new ArrayList<Vector2f>();
		this.indexes = new ArrayList<Integer>();
		this.color = Color.transitioRule;
		this.currentColor = TrafficLight.Color.None;
	}
	
	

	public Float getPosition() {
		return position;
	}



	public void setPosition(Float position) {
		this.position = position;
	}



	public void addIndex(Integer i)
	{
		this.indexes.add(i);
	}
	
	public void addPoint(Vector2f point)
	{
		this.points.add(point);
	}
	
	public int getVertexCount()
	{
		return points.size();
	}
	
	@Override
	public void render(RenderType mode) {
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor3f(color.r, color.g, color.b);
		for (int i = 0; i < indexes.size(); i++)
		{
			GL11.glVertex2f(points.get(indexes.get(i)).x, points.get(indexes.get(i)).y);
		}
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_LINES);
		GL11.glColor3f(color.r, color.g, color.b);
		for (int i = 0; i < indexes.size(); i++)
		{
			GL11.glVertex2f(points.get(indexes.get(i)).x, points.get(indexes.get(i)).y);
		}
		GL11.glEnd();
	}

	@Override
	public void switchLight(TrafficLight.Color color) {
		this.currentColor = color;
		switch (color) {
		case Green:
			this.setColor(Color.greenLight);
			break;
		case Yellow:
			this.setColor(Color.yellow);
			break;
		case Red:
			this.setColor(Color.red);
			break;

		}
	}

	@Override
	public TrafficLight.Color getLightColor() {
		return this.currentColor;
	}

}
