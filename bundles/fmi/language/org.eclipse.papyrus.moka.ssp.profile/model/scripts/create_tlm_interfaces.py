#
# Copyright (c) 2019 CEA LIST.
# 
#   All rights reserved. This program and the accompanying materials
#   are made available under the terms of the Eclipse Public License v1.0
#   which accompanies this distribution, and is available at
#   http://www.eclipse.org/legal/epl-v10.html
#  
#   Contributors:
#    CEA LIST - Initial API and implementation
# 

#name: Create TLM interfaces
#papypopup :enableFor(org.eclipse.uml2.uml.Package)
#script-engine : org.eclipse.ease.python.jython
from numba.dummyarray import Dim





loadModule("/Modeling/UML")
loadModule("/Modeling/UMLUtils")
include("platform:/plugin/org.eclipse.papyrus.moka.fmi.ease/script/fmi_util.py")


from org.eclipse.uml2.uml import AggregationKind
from org.eclipse.papyrus.sysml14.portsandflows import FlowDirection
from org.eclipse.papyrus.moka.ssp.omsimulatorprofile import Interpolation

package = getSelection()
interfaceBlockStereo = getPapyrusNamedElement(package, "SysML::PortsAndFlows::InterfaceBlock")
flowPortStereo = getPapyrusNamedElement(package, "SysML::DeprecatedElements::FlowPort")
realType = getPapyrusNamedElement(package, "PrimitiveTypes::Real")

tlmInterfaceDefinitionStereo = getPapyrusNamedElement(package, "OMSimulatorProfile::TLMInterfaceDefinition")
tlmSignalDefinition = getPapyrusNamedElement(package, "OMSimulatorProfile::TLMSignalDefinition")


initEPackage("http://www.eclipse.org/uml2/5.0.0/UML")
factory = getFactory()

def createInterfaceBlock(name, package, dim, interpolation):
        result = factory.createClass()
        result.setName(name)
        package.getPackagedElements().add(result)
        result.applyStereotype(interfaceBlockStereo)
        definition = result.applyStereotype(tlmInterfaceDefinitionStereo)
        definition.setDimensions(dim)
        
        return result
    


def createSignals(interface, signals):
    for signal in signals :
        port = interface.createOwnedPort(signal, realType)
        port.setAggregation(AggregationKind.COMPOSITE_LITERAL)
        flowPort = port.applyStereotype(flowPortStereo)
        flowPort.setDirection(FlowDirection.IN)
        signalDef = port.applyStereotype(tlmSignalDefinition)
        
        
def script():
    
    interface = createInterfaceBlock("Delayed Signal", package,1, Interpolation.NONE)
    createSignals(interface, ["value"])
    
    interface = createInterfaceBlock("1D physical", package,1, Interpolation.NONE)
    createSignals(interface, ["state", "flow", "effort"])
    
    interface = createInterfaceBlock("1D physical coarse-grained", package, 1, Interpolation.COARSEGRAINED)
    createSignals(interface, ["state", "flow", "wave", "impedance"])
    
    interface = createInterfaceBlock("1D physical fine-grained", package,1, Interpolation.FINEGRAINED)
    createSignals(interface, ["state", "flow", 
"wave1", "wave2", "wave3", "wave4", "wave5", "wave6", "wave7", "wave8", "wave9", "wave10", 
"time1", "time2", "time3", "time4", "time5", "time6", "time7", "time8", "time9", "time10", 
"impedance"
])
    
    interface = createInterfaceBlock("3D physical", package,3, Interpolation.NONE)
    createSignals(interface, ["state1", "state2", "state3", 
"A11", "A12", "A13", "A21", "A22", "A23", "A31", "A32", "A33", 
"flow1",  "flow2",  "flow3", "flow4",  "flow5", "flow6", 
"effort1", "effort2", "effort3", "effort4", "effort5", "effort6"
])
    
    interface = createInterfaceBlock("3D physical coarse-grained", package,3, Interpolation.COARSEGRAINED)
    createSignals(interface, ["state1", "state2", "state3", 
"A1_1",   "A1_2",   "A1_3", "A2_1",   "A2_2",   "A2_3", "A3_1",   "A3_2",   "A3_3", 
"flow1",  "flow2",  "flow3", "flow4",  "flow5",  "flow6", 
"wave1",  "wave2",  "wave3", "wave4",  "wave3",  "wave4", 
"impedance_t","impedance_r"])
    
    interface = createInterfaceBlock("3D physical fine-grained", package,3, Interpolation.FINEGRAINED)
    createSignals(interface, ["state1",   "state2",   "state3" 
"A1_1", "A1_2", "A1_3", "A2_1", "A2_2", "A2_3", "A3_1", "A3_2", "A3_3", 
"flow1", "flow2", "flow3", "flow4", "flow5", "flow6", 
"wave1_1", "wave2_1", "wave3_1", "wave4_1", "wave5_1", "wave6_1", 
"wave1_2", "wave2_2", "wave3_2", "wave4_2", "wave5_2", "wave6_2", 
"wave1_3", "wave2_3", "wave3_3", "wave4_3", "wave5_3", "wave6_3", 
"wave1_4", "wave2_4", "wave3_4", "wave4_4", "wave5_4", "wave6_4", 
"wave1_5", "wave2_5", "wave3_5", "wave4_5", "wave5_5", "wave6_5", 
"wave1_6", "wave2_6", "wave3_6", "wave4_6", "wave5_6", "wave6_6", 
"wave1_7", "wave2_7", "wave3_7", "wave4_7", "wave5_7", "wave6_7", 
"wave1_8", "wave2_8", "wave3_8", "wave4_8", "wave5_8", "wave6_8", 
"wave1_9", "wave2_9", "wave3_9", "wave4_9", "wave5_9", "wave6_9", 
"wave1_10", "wave2_10", "wave3_10", "wave4_10", "wave5_10", "wave6_10", 
"time1", "time2", "time3", "time4", "time5", "time6", "time7", "time8", "time9", "time10", 
"impedance_t","impedance_r"])
    
    

papyRun(script)