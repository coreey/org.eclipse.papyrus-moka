# Moka

Moka is an open source project that aims to provide the MBSE community with a
framework enabling UML based models execution and debugging.  

## General

### Features
Moka provides three key features: Execution, Debugging and Animation.

#### Execution
The execution feature relies on implementation of OMG Executable UML standards:
[fUML 1.4][1], [PSCS 1.2][2] and [PSSM 1.0][3]. It enables execution of any UML
model conforming to the syntactic subset identified by the union of these standards.
The conformance perimeter is therefore limited to classes, composite structures,
activities and state machines.

While Moka was initially developped to enable UML based models execution, it's
scope is not limited to UML and UML extensions. Indeed Moka execution framework
is generic enough to enable development of execution engines supporting any type
of EMF based models.

#### Debugging
Execution is useful but not sufficient to assess / understand what is going on
when a modeled system is executed. It is especially true when the modeled systems
does not behave as expected. In order to overcome this problem Moka comes with a
specialization of the Eclipse debug framework. The Moka debug framework enables the
final user to control the execution of a model (e.g., thread suspension) and to
observe the state (e.g., variable values) of this later.

While Moka debug feaure was initially developped to provide debugging facilities
for UML models execution, it is not limited to this perimeter. Indeed, the debug
framework is generic enough to be specialized for any EMF based models debugging.

#### Animation
The animation feature completes execution and debugging by providing the user with
the capability to follow the execution flow. In the context of UML based models,
this feature change the visual state of model elements on diagrams (e.g., when a
state is entered then its visual representation changes).

While Moka animation feature was initially developped for UML diagrams it is generic
enough to be adapted to other graphical frameworks.

### Installation
In order to install Moka follows the steps below:

1. Open Eclipse
1. Go to **Help** > **Install** > **Install New Software**
1. Copy this [update site URL][4] to the **Work with** field.
1. Check **Moka Core (Incubation)**
1. Hit the **Next** button
1. When the installation process completes then restart Eclipse

### Configuration
In order to make Moka usable in your Eclipse, it needs to be configured. The
configuration consists in the following steps:

1. Download **Mosquitto** from this [URL][5]
1. Install **Moquitto** on your system
1. In Eclipse, go to **Window** > **Preferences**
1. Unfold the **Papyrus** category and select the **Simulation** item
1. Add the absolute path to the **mosquitto** executable file
1. Specify the port used by **Mosquitto**
1. Apply your changes

## Architecture
Moka implementation is divided as follows.

1. **Kernel**
  1. **org.eclipse.papyrus.moka.kernel**
    - API to implement an execution engine
    - API to implement an execution engine service
    - API to implement service with MQTT client
    - Extension points to declare engines and services
  1. **org.eclipse.papyrus.moka.kernel.debug**
    - API to implement a debuggable execution engine
    - API to implement a debug service
    - Implementation of the debug target
    - Implementation of the communication protocol (debug target - engine)
  1. **org.eclipse.papyrus.moka.Kernel.animation**
    - API to implement an animation service
    - Implemention of a generic animation engine
  1. **org.eclipse.papyrus.moka.kernel.scheduling**
    - API to implement execution engine specific scheduling
    - API to implement execution engine specific control (e.g., suspend / resume) over tasks

1. **UML**
  1. **org.eclipse.papyrus.moka.engine.uml**
    - UML execution engine implementation
    - Extension point to declare libraries installed at an execution engine
  1. **org.eclipse.papyrus.moka.engine.uml.animation**
    - UML animation service implementation
  1. **org.eclipse.papyrus.moka.engine.uml.debug**
    - UML debug service implementation
  1. **org.eclipse.papyrus.moka.engine.uml.scheduling**
    - UML execution engine specific scheduling
    - UML execution engine specific tasks
  1. **org.eclipse.papyrus.moka.fuml**
    - Implementation of the [fUML 1.4][1] semantic model
  1. **org.eclipse.papyrus.moka.fuml.interfaces**
    - API of the [fUML 1.4][1] semantic model
  1. **org.eclipse.papyrus.moka.pscs**
    - Implementation of the [PSCS 1.2][2] semantic model
  1. **org.eclipse.papyrus.moka.pscs.interfaces**
    - API of the [PSCS 1.2][2] semantic model
  1. **org.eclipse.papyrus.moka.pssm**
    - Implementation of the [PSSM 1.0][3] semantic model
  1. **org.eclipse.papyrus.moka.pssm.interfaces**
    - API of the [PSSM 1.0][3] semantic model
  1. **org.eclipse.papyrus.moka.fuml.standardlibrary**
    - Implementation of the [fUML 1.4][1] model library

1. **UI**
  1. **org.eclipse.papyrus.moka.ui**
  1. **org.eclipse.papyrus.moka.utils.ui**
  1. **org.eclipse.papyrus.moka.ui.tracepoint.view**

1. **Misc**
  1. **org.eclipse.papyrus.moka.modeling.utils**
  1. **org.eclipse.papyrus.moka.pscs.utils**
  1. **org.eclipse.papyrus.moka.utils**
  1. **org.eclipse.papyrus.moka.trace**
  1. **org.eclipse.papyrus.moka.trace.interfaces**
  1. **org.eclipse.papyrus.moka.trace.model**
  1. **org.eclipse.papyrus.moka.trace.model**


[1]: https://www.omg.org/spec/FUML/1.4/
[2]: https://www.omg.org/spec/PSCS/1.2/
[3]: https://www.omg.org/spec/PSSM/1.0/
[4]: http://is148366.intra.cea.fr:8080/view/Moka/job/MokaV3/lastSuccessfulBuild/artifact/source/releng/org.eclipse.papyrus.moka.p2/target/repository/
[5]: https://mosquitto.org/download/
