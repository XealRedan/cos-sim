/**
 * 
 */
package ru.cos.sim.road.link;

import ru.cos.sim.road.exceptions.RoadNetworkException;
import ru.cos.sim.utils.Hand;

/**
 * Trapezium road segment in which bases are last left and last right lanes (they are parallel),
 * sides are cuts of the road.
 * @author zroslaw
 */
public class TrapeziumSegment extends Segment {

	/**
	 * 
	 */
	protected float trapeziumShift = 0;
	
	public TrapeziumSegment(int id) {
		super(id);
	}

	@Override
	public float calculateAdjacentPosition(int laneIndex, float position, Hand hand) {
		int index=0;
		// First, let's handle situations when we have no adjacent lane on a given hand
		if (hand.equals(Hand.Left)){
			index = laneIndex-1;
			if(index<0) throw new RoadNetworkException("There is no left lane to calculate adjacent position on it");
		} else if (hand.equals(Hand.Right)){
			index = laneIndex+1;
			if(index+1>lanes.length) throw new RoadNetworkException("There is no right lane to calculate adjacent position on it");
		}
		// Second, calculating adjacent position on the basis of theory of similar triangles
		// 2.1 calculate beginnings of lane that are not in the rectangle of trapezium
		float beginingShiftCurrent = laneIndex==0?0:-trapeziumShift*(laneIndex+1)/lanes.length;
		float beginingShiftAdjacent = index==0?0:-trapeziumShift*(index+1)/lanes.length;
		// in case of position in the beginning shift region
		if (position<=Math.abs(beginingShiftCurrent)){
			return laneIndex==0?0:position*index/laneIndex;
		}
		// in case when position in the rectangle of trapezium
		if (position<beginingShiftCurrent+lanes[0].getLength()){
			return (position-beginingShiftCurrent)+beginingShiftAdjacent;
		}
		// in this case position in the end shifting region
		if (laneIndex==0) return lanes[index].getLength(); // if we are on the lasr left lane there is no triangle
		float positionOnCurrentLaneInShiftRegion = position-lanes[0].getLength()+beginingShiftCurrent;
		return (lanes[0].getLength()+beginingShiftAdjacent)+   // distance to the end of trapezium rectangle
				positionOnCurrentLaneInShiftRegion*index/laneIndex; // plus position on the current lane product of similarity coefficient
	}

	public float getTrapeziumShift() {
		return trapeziumShift;
	}

	public void setTrapeziumShift(float trapeziumShift) {
		this.trapeziumShift = trapeziumShift;
	}

	@Override
	public final SegmentType getSegmentType() {
		return SegmentType.TrapeziumSegment;
	}

}
