# What is COS.SIM? #
COS.SIM is an open source complex system for agent-based traffic flows microsimulation

**COS.SIM consists of four main components**:
  * Road Editor
  * Simulation Engine
  * Visualization Engine
  * Meters Engine

COS.SIM was verified and validated according to standards and procedures of Japan Society of Traffic Engineers.

Verification report is available by the following link
[COS.SIM Verification Report](https://drive.google.com/file/d/0B_1xsUBwvRVrSEF2Ni1hWmUxQXM)

Results of validation are similar to results of well known commercial microsimulation software packages.

To drill down and explore the system in details please see [JAVADOCs](http://cos-sim.googlecode.com/svn/trunk/docs/javadoc/index.html).

**COS.SIM Demonstration**

<a href='http://www.youtube.com/watch?feature=player_embedded&v=m5ZkkZVqFd4' target='_blank'><img src='http://img.youtube.com/vi/m5ZkkZVqFd4/0.jpg' width='640' height=480 /></a>

## Road Editor ##
Road editor is GUI application for road networks construction.

![http://cos-sim.googlecode.com/svn/wiki/RoadEditor.jpg](http://cos-sim.googlecode.com/svn/wiki/RoadEditor.jpg)

## Simulation Engine ##
Simulation Engine is an agent-based engine for traffic flows simulation. It contatins abstractions and implementation of all objects on the road network (road, lane, vehicle, traffic light, etc.)

Simulation Engine is based on COS.ABSF framework - framework for general purpose agent-based simulation. COS.ABSF provides simple API for dealing with any types of agent-based models.

## Visualization Engine ##
GUI for traffic simulation process animation and control.

![http://cos-sim.googlecode.com/svn/wiki/VisualizationEngine.jpg](http://cos-sim.googlecode.com/svn/wiki/VisualizationEngine.jpg)

## Meters Engine ##
Set of GUI and API tools to gather, record and present wide range of data from traffic simulation process. It could be gathered data like traffic volume, flow, density, speed, etc.

![http://cos-sim.googlecode.com/svn/wiki/MetersEngine1.png](http://cos-sim.googlecode.com/svn/wiki/MetersEngine1.png)
![http://cos-sim.googlecode.com/svn/wiki/MetersEngine2.png](http://cos-sim.googlecode.com/svn/wiki/MetersEngine2.png)