/**
 * 
 */
package cs.lengthy.impl.test;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.cos.cs.lengthy.Lengthy;
import ru.cos.cs.lengthy.Observation;
import ru.cos.cs.lengthy.RegularLengthy;
import ru.cos.cs.lengthy.impl.LengthiesFactory;
import ru.cos.cs.lengthy.impl.LengthiesFactoryImpl;
import ru.cos.cs.lengthy.objects.continuous.Continuous;
import ru.cos.cs.lengthy.objects.continuous.ContinuousPoint;

/**
 * 
 * @author zroslaw
 */
public class LengthyContinuousTest {

	private LengthiesFactory factory = new LengthiesFactoryImpl();
	Continuous c1,c2,c3;
	RegularLengthy l1,l2,l3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		l1 = factory.createLengthy(100.f);
		l2 = factory.createLengthy(100.f);
		l3 = factory.createLengthy(100.f);
		l1.setNext(l2);
		l2.setNext(l3);l2.setPrev(l1);
		l3.setPrev(l2);
		
		c1 = factory.createContinuous(70);
		l2.putContinuous(c1, 50, null);
	}

	/**
	 * Test method for {@link ru.cos.cs.lengthy.Lengthy#putContinuous(ru.cos.cs.lengthy.objects.continuous.Continuous, float, ru.cos.cs.lengthy.Router)}.
	 */
	@Test
	public void testPutContinuous() {
		ContinuousPoint backPoint = c1.getBackPoint();
		ContinuousPoint frontPoint =	c1.getFrontPoint();
		List<Lengthy> occupiedLengthies = (List<Lengthy>)c1.getOccupiedLengthies();

		Assert.assertTrue(backPoint.getLengthy() == l2);
		Assert.assertTrue(frontPoint.getLengthy() == l3);
		Assert.assertTrue(backPoint.getContinuous() == c1);
		Assert.assertTrue(frontPoint.getContinuous() == c1);
		Assert.assertEquals(backPoint.getPosition(), 50, 0.001);
		Assert.assertEquals(frontPoint.getPosition(), 20, 0.001);
		
		Assert.assertTrue(occupiedLengthies.size() == 2);
		Assert.assertTrue(occupiedLengthies.get(0) == l2);
		Assert.assertTrue(occupiedLengthies.get(1) == l3);
		
		
		List<Observation> observations = l2.observeForward(40, 95, null);
		Assert.assertTrue(observations.size() == 2);
		Observation backPointObs = observations.get(0);	
		Observation frontPointObs = observations.get(1);	
		Assert.assertTrue(backPointObs.getPoint() == backPoint);
		Assert.assertTrue(frontPointObs.getPoint() == frontPoint);
		
		Set<ContinuousPoint> cPoints = l2.observeContinuous(60);
		Assert.assertTrue(cPoints.size() == 1);
		ContinuousPoint cPoint = cPoints.iterator().next();
		Assert.assertTrue(cPoint.getContinuous() == c1);
		Assert.assertEquals(cPoint.getPositionOnContinuous(), 10, 0.001);
		
		cPoints = l3.observeContinuous(10);
		Assert.assertTrue(cPoints.size() == 1);
		cPoint = cPoints.iterator().next();
		Assert.assertTrue(cPoint.getContinuous() == c1);
		Assert.assertTrue(cPoint.getLengthy() == l3);
		Assert.assertEquals(cPoint.getPositionOnContinuous(), 60, 0.001);
	}


	/**
	 * Test method for {@link ru.cos.cs.lengthy.Lengthy#removeContinuous(ru.cos.cs.lengthy.objects.continuous.Continuous)}.
	 */
	@Test
	public void testRemoveContinuous() {
		l2.removeContinuous(c1);
		ContinuousPoint backPoint = c1.getBackPoint();
		ContinuousPoint frontPoint =	c1.getFrontPoint();
		List<Lengthy> occupiedLengthies = (List<Lengthy>)c1.getOccupiedLengthies();
		Assert.assertTrue(backPoint.getLengthy() == null);
		Assert.assertTrue(new Float(backPoint.getPosition()).equals(Float.NaN));
		Assert.assertTrue(frontPoint.getLengthy() == null);
		Assert.assertTrue(new Float(frontPoint.getPosition()).equals(Float.NaN));
		Assert.assertTrue(occupiedLengthies.size() == 0);
		
		List<Observation> observations = l2.observeForward(40, 55, null);
		Assert.assertTrue(observations.size() == 0);

		Set<ContinuousPoint> cPoints = l2.observeContinuous(60);
		Assert.assertTrue(cPoints.size() == 0);
		
	}
	
	/**
	 * Test method for {@link ru.cos.cs.lengthy.Lengthy#putContinuousFromEndPoint(ru.cos.cs.lengthy.objects.continuous.Continuous, float, ru.cos.cs.lengthy.Router)}.
	 */
	@Test
	public void testPutContinuousFromEndPoint() {
		l2.removeContinuous(c1);
		l3.putContinuousFromEndPoint(c1, 20, null);
		testPutContinuous();
	}
	
	@Test
	public void testMoveContinuous(){
		l2.move(c1, 40, null);
		
		Assert.assertTrue(c1.getBackPoint().getLengthy() == l2);
		Assert.assertEquals(c1.getBackPoint().getPosition(), 90, 0.001);
		Assert.assertTrue(c1.getFrontPoint().getLengthy() == l3);
		Assert.assertEquals(c1.getFrontPoint().getPosition(), 60, 0.001);
		
		Set<ContinuousPoint> contObservations = l3.observeContinuous(10);
		Assert.assertTrue(contObservations.size() == 1);
		Assert.assertEquals(contObservations.iterator().next().getPositionOnContinuous(), 20, 0.0001);
		
		List<Observation> observations = l2.observeForward(80, 100, null);
		Assert.assertTrue(observations.size() == 2);
		Observation o1 = observations.get(0),
		o2 = observations.get(1);
		Assert.assertTrue(o1.getPoint() == c1.getBackPoint());
		Assert.assertEquals(o1.getDistance(), 10, 0.0001);
		Assert.assertTrue(o2.getPoint() == c1.getFrontPoint());
		Assert.assertEquals(o2.getDistance(), 80, 0.0001);
	}

}
