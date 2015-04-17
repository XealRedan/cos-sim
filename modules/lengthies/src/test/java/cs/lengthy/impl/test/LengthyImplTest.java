package cs.lengthy.impl.test;

import java.util.List;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.cos.cs.lengthy.Fork;
import ru.cos.cs.lengthy.Join;
import ru.cos.cs.lengthy.Lengthy;
import ru.cos.cs.lengthy.Observation;
import ru.cos.cs.lengthy.RegularLengthy;
import ru.cos.cs.lengthy.Router;
import ru.cos.cs.lengthy.impl.CaseRouter;
import ru.cos.cs.lengthy.impl.LengthiesFactory;
import ru.cos.cs.lengthy.impl.LengthiesFactoryImpl;
import ru.cos.cs.lengthy.objects.Point;
import ru.cos.cs.lengthy.objects.continuous.Continuous;
import ru.cos.cs.lengthy.objects.continuous.ContinuousPoint;

public class LengthyImplTest {

	private LengthiesFactory factory = new LengthiesFactoryImpl();
	
	private RegularLengthy j1,j2,j3,
					l1,l2,l3,
					f1,f2,f3;
	private Join join;
	private Fork fork;
	

	@Before
	public void setUp() throws Exception {
		
		j1 = factory.createLengthy(120); 
		j2 = factory.createLengthy(120); 
		j3 = factory.createLengthy(120);
		join = factory.createJoin();
		l1 = factory.createLengthy(100); 
		l2 = factory.createLengthy(100); 
		l3 = factory.createLengthy(100);
		fork = factory.createFork();
		f1 = factory.createLengthy(140); 
		f2 = factory.createLengthy(140); 
		f3 = factory.createLengthy(140); 

		join.join(j1);join.join(j2);join.join(j3);
		join.setNext(l1); l1.setPrev(join);
		l1.setNext(l2); l2.setPrev(l1);
		l2.setNext(l3); l3.setPrev(l2);
		l3.setNext(fork); fork.setPrev(l3);
		fork.forkTo(f1);fork.forkTo(f2);fork.forkTo(f3);
		
	}

	@Test
	public void testMove() {
		Point point = factory.createObservable();
		CaseRouter router = new CaseRouter();
		router.addCase(fork, f1);
		
		l3.putPoint(point, 90);
		l3.move(point, 20, router);

		Assert.assertTrue(point.getLengthy() == f1);
		Assert.assertEquals(10, point.getPosition(), 0.0001);
	}
	
	@Test
	public void testMoveBackward() {
		Point point = factory.createObservable();
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		
		l1.putPoint(point, 10);
		l1.move(point, -20, router);
		
		Assert.assertTrue(point.getLengthy() == j3);
		Assert.assertEquals(110, point.getPosition(), 0.0001);
	}
	
	@Test
	public void testPutContinuous() {
		Continuous continuous = factory.createContinuous(50);
		CaseRouter router = new CaseRouter();
		router.addCase(fork, f1);
		
		l3.putContinuous(continuous, 90, router);
		
		ContinuousPoint frontPoint = continuous.getFrontPoint();
		ContinuousPoint backPoint = continuous.getBackPoint();
		List<Lengthy> occLengthies = continuous.getOccupiedLengthies();
		
		Assert.assertTrue(frontPoint.getLengthy() == f1);
		Assert.assertEquals(40, frontPoint.getPosition(), 0.0001);
		Assert.assertTrue(occLengthies.size() == 3);
		Assert.assertTrue(occLengthies.contains(l3) && occLengthies.contains(f1));
		
		List<Observation> observations = l3.observeForward(80, 100, router);
		Assert.assertTrue(observations.size() == 2);
		Assert.assertTrue(observations.get(0).getPoint() == backPoint);
		Assert.assertTrue(observations.get(1).getPoint() == frontPoint);
	}


	@Test
	public void testPutContinuousWithJoin() {
		Continuous continuous = factory.createContinuous(50);
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		
		l1.putContinuousFromEndPoint(continuous, 10, router);

		ContinuousPoint frontPoint = continuous.getFrontPoint();
		ContinuousPoint backPoint = continuous.getBackPoint();
		List<Lengthy> occLengthies = continuous.getOccupiedLengthies();

		Assert.assertTrue(frontPoint.getLengthy() == l1);
		Assert.assertEquals(10, frontPoint.getPosition(), 0.0001);
		Assert.assertTrue(backPoint.getLengthy() == j3);
		Assert.assertEquals(80, backPoint.getPosition(), 0.0001);
		Assert.assertTrue(occLengthies.size() == 3);
		Assert.assertTrue(occLengthies.contains(l1) && occLengthies.contains(j3));
		
		List<Observation> observations = l1.observeBackward(20, 100, router);
		Assert.assertTrue(observations.size() == 2);
		Assert.assertTrue(observations.get(0).getPoint() == frontPoint);
		Assert.assertTrue(observations.get(1).getPoint() == backPoint);
		
	}
	

	@Test
	public void testPutLongContinuousWithFork() {
		Continuous continuous = factory.createContinuous(400);
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		router.addCase(fork, f1);
		
		j3.putContinuous(continuous, 100, router);

		checkLongContinuous(continuous, router);
	}


	@Test
	public void testPutLongContinuousWithJoin() {
		Continuous continuous = factory.createContinuous(400);
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		router.addCase(fork, f1);
		
		f1.putContinuousFromEndPoint(continuous, 80, router);

		checkLongContinuous(continuous, router);
	}	

	@Test
	public void testPointsOnFork() {
		Point point1 = factory.createObservable(),
				point2 = factory.createObservable();
		fork.putPoint(point1, 0);
		fork.putPoint(point2, 0);
		
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		router.addCase(fork, f1);
		
		List<Observation> observations =  l3.observeForward(l3.getLength()-10, 20, router);
		Assert.assertEquals(2, observations.size());
		
		for(Observation obs:observations){
			Assert.assertTrue(obs.getPoint() == point1 || obs.getPoint() == point2);
			Assert.assertEquals(10, obs.getDistance(), 0.00000001);
			Assert.assertEquals(0, obs.getPoint().getPosition(), 0.0000000001);
			Assert.assertTrue(obs.getPoint().getLengthy() == fork);
		}
	}
	

	@Test
	public void testPointsOnJoin() {
		Point point1 = factory.createObservable(),
				point2 = factory.createObservable();
		join.putPoint(point1, 0);
		join.putPoint(point2, 0);
		
		CaseRouter router = new CaseRouter();
		router.addCase(join, j3);
		router.addCase(fork, f1);
		
		List<Observation> observations =  l1.observeBackward(10, 20, router);
		Assert.assertEquals(2, observations.size());
		
		for(Observation obs:observations){
			Assert.assertTrue(obs.getPoint() == point1 || obs.getPoint() == point2);
			Assert.assertEquals(-10, obs.getDistance(), 0.00000001);
			Assert.assertEquals(0, obs.getPoint().getPosition(), 0.0000000001);
			Assert.assertTrue(obs.getPoint().getLengthy() == join);
		}
	}	
	
	private void checkLongContinuous(Continuous continuous, Router router){

		ContinuousPoint frontPoint = continuous.getFrontPoint();
		ContinuousPoint backPoint = continuous.getBackPoint();
		List<Lengthy> occLengthies = continuous.getOccupiedLengthies();

		Assert.assertTrue(frontPoint.getLengthy() == f1);
		Assert.assertEquals(80, frontPoint.getPosition(), 0.0001);
		Assert.assertTrue(backPoint.getLengthy() == j3);
		Assert.assertEquals(100, backPoint.getPosition(), 0.0001);
		Assert.assertTrue(occLengthies.size() == 7);

		Assert.assertTrue(occLengthies.get(0) == j3);
		Assert.assertTrue(occLengthies.get(2) == l1);
		Assert.assertTrue(occLengthies.get(3) == l2);
		Assert.assertTrue(occLengthies.get(4) == l3);
		Assert.assertTrue(occLengthies.get(6) == f1);
		
		List<Observation> observations = j3.observeForward(90, 450, router);
		Assert.assertTrue(observations.size() == 2);
		Assert.assertTrue(observations.get(0).getPoint() == backPoint);
		
	}
}