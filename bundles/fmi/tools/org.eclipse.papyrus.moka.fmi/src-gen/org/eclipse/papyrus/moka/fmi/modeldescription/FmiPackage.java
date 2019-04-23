/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.modeldescription;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * Copyright(c) 2008-2011, MODELISAR consortium. All rights reserved.
 * This file is licensed by the copyright holders under the BSD License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2008-2011 MODELISAR consortium,
 *              2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2008-2011 MODELISAR consortium,
 *              2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause Licensee
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2008-2011 MODELISAR consortium,
 *              2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2008-2011 MODELISAR consortium,
 *              2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * 
 * Copyright(c) 2008-2011 MODELISAR consortium,
 *              2012-2013 Modelica Association Project "FMI".
 *              All rights reserved.
 * This file is licensed by the copyright holders under the BSD 2-Clause License
 * (http://www.opensource.org/licenses/bsd-license.html):
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------------
 * 
 * with the extension:
 * 
 * You may distribute or publicly perform any modification only under the
 * terms of this license.
 * (Note, this means that if you distribute a modified file,
 * the modified file must also be provided under this license).
 *     
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface FmiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modeldescription";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/org.eclipse.papyrus.moka.fmi/schema/fmi2ModelDescription.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modeldescription";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmiPackage eINSTANCE = org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl <em>Base Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getBaseUnitType()
	 * @generated
	 */
	int BASE_UNIT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__A = 0;

	/**
	 * The feature id for the '<em><b>Cd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__CD = 1;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__FACTOR = 2;

	/**
	 * The feature id for the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__K = 3;

	/**
	 * The feature id for the '<em><b>Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__KG = 4;

	/**
	 * The feature id for the '<em><b>M</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__M = 5;

	/**
	 * The feature id for the '<em><b>Mol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__MOL = 6;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__OFFSET = 7;

	/**
	 * The feature id for the '<em><b>Rad</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__RAD = 8;

	/**
	 * The feature id for the '<em><b>S</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE__S = 9;

	/**
	 * The number of structural features of the '<em>Base Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Base Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.BooleanTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__DECLARED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__START = 1;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CategoryTypeImpl <em>Category Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.CategoryTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCategoryType()
	 * @generated
	 */
	int CATEGORY_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Category Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Category Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl <em>Co Simulation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCoSimulationType()
	 * @generated
	 */
	int CO_SIMULATION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__SOURCE_FILES = 0;

	/**
	 * The feature id for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE = 2;

	/**
	 * The feature id for the '<em><b>Can Handle Variable Communication Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE = 3;

	/**
	 * The feature id for the '<em><b>Can Interpolate Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS = 4;

	/**
	 * The feature id for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = 5;

	/**
	 * The feature id for the '<em><b>Can Run Asynchronuously</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY = 6;

	/**
	 * The feature id for the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE = 7;

	/**
	 * The feature id for the '<em><b>Max Output Derivative Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER = 8;

	/**
	 * The feature id for the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__MODEL_IDENTIFIER = 9;

	/**
	 * The feature id for the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL = 10;

	/**
	 * The feature id for the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE = 11;

	/**
	 * The number of structural features of the '<em>Co Simulation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Co Simulation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_SIMULATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl <em>Default Experiment Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDefaultExperimentType()
	 * @generated
	 */
	int DEFAULT_EXPERIMENT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE__STEP_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE__STOP_TIME = 2;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE__TOLERANCE = 3;

	/**
	 * The number of structural features of the '<em>Default Experiment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Default Experiment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXPERIMENT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl <em>Display Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDisplayUnitType()
	 * @generated
	 */
	int DISPLAY_UNIT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_TYPE__FACTOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_TYPE__OFFSET = 2;

	/**
	 * The number of structural features of the '<em>Display Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Display Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DocumentRootImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Fmi Model Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FMI_MODEL_DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__DECLARED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__MAX = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__MIN = 2;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__QUANTITY = 3;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__START = 4;

	/**
	 * The number of structural features of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationType1Impl <em>Enumeration Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getEnumerationType1()
	 * @generated
	 */
	int ENUMERATION_TYPE1 = 8;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE1__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE1__ITEM = 1;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE1__QUANTITY = 2;

	/**
	 * The number of structural features of the '<em>Enumeration Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE1_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Enumeration Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileTypeImpl <em>File Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFileType()
	 * @generated
	 */
	int FILE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileType1Impl <em>File Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFileType1()
	 * @generated
	 */
	int FILE_TYPE1 = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE1__NAME = 0;

	/**
	 * The number of structural features of the '<em>File Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE1_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>File Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2AnnotationImpl <em>Fmi2 Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2AnnotationImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2Annotation()
	 * @generated
	 */
	int FMI2_ANNOTATION = 11;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_ANNOTATION__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_ANNOTATION__TOOL = 1;

	/**
	 * The number of structural features of the '<em>Fmi2 Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Fmi2 Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl <em>Fmi2 Scalar Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2ScalarVariable()
	 * @generated
	 */
	int FMI2_SCALAR_VARIABLE = 12;

	/**
	 * The feature id for the '<em><b>Real</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__REAL = 0;

	/**
	 * The feature id for the '<em><b>Integer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__INTEGER = 1;

	/**
	 * The feature id for the '<em><b>Boolean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__BOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>String</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__STRING = 3;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__ENUMERATION = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__ANNOTATIONS = 5;

	/**
	 * The feature id for the '<em><b>Can Handle Multiple Set Per Time Instant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT = 6;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__CAUSALITY = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__DESCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__INITIAL = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__NAME = 10;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__VALUE_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE__VARIABILITY = 12;

	/**
	 * The number of structural features of the '<em>Fmi2 Scalar Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Fmi2 Scalar Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SCALAR_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl <em>Fmi2 Simple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2SimpleType()
	 * @generated
	 */
	int FMI2_SIMPLE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Real</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__REAL = 0;

	/**
	 * The feature id for the '<em><b>Integer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__INTEGER = 1;

	/**
	 * The feature id for the '<em><b>Boolean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__BOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>String</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__STRING = 3;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__ENUMERATION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE__NAME = 6;

	/**
	 * The number of structural features of the '<em>Fmi2 Simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Fmi2 Simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_SIMPLE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl <em>Fmi2 Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2Unit()
	 * @generated
	 */
	int FMI2_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Base Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT__BASE_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT__GROUP = 1;

	/**
	 * The feature id for the '<em><b>Display Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT__DISPLAY_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Fmi2 Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Fmi2 Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2VariableDependencyImpl <em>Fmi2 Variable Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2VariableDependencyImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2VariableDependency()
	 * @generated
	 */
	int FMI2_VARIABLE_DEPENDENCY = 15;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_VARIABLE_DEPENDENCY__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_VARIABLE_DEPENDENCY__UNKNOWN = 1;

	/**
	 * The number of structural features of the '<em>Fmi2 Variable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_VARIABLE_DEPENDENCY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Fmi2 Variable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI2_VARIABLE_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl <em>Model Description Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmiModelDescriptionType()
	 * @generated
	 */
	int FMI_MODEL_DESCRIPTION_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Model Exchange</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE = 1;

	/**
	 * The feature id for the '<em><b>Co Simulation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION = 2;

	/**
	 * The feature id for the '<em><b>Unit Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS = 3;

	/**
	 * The feature id for the '<em><b>Type Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS = 4;

	/**
	 * The feature id for the '<em><b>Log Categories</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES = 5;

	/**
	 * The feature id for the '<em><b>Default Experiment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT = 6;

	/**
	 * The feature id for the '<em><b>Vendor Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS = 7;

	/**
	 * The feature id for the '<em><b>Model Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES = 8;

	/**
	 * The feature id for the '<em><b>Model Structure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE = 9;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__AUTHOR = 10;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT = 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION = 12;

	/**
	 * The feature id for the '<em><b>Fmi Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION = 13;

	/**
	 * The feature id for the '<em><b>Generation Date And Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME = 14;

	/**
	 * The feature id for the '<em><b>Generation Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL = 15;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__GUID = 16;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__LICENSE = 17;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME = 18;

	/**
	 * The feature id for the '<em><b>Number Of Event Indicators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS = 19;

	/**
	 * The feature id for the '<em><b>Variable Naming Convention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION = 20;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE__VERSION = 21;

	/**
	 * The number of structural features of the '<em>Model Description Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE_FEATURE_COUNT = 22;

	/**
	 * The number of operations of the '<em>Model Description Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMI_MODEL_DESCRIPTION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.InitialUnknownsTypeImpl <em>Initial Unknowns Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.InitialUnknownsTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialUnknownsType()
	 * @generated
	 */
	int INITIAL_UNKNOWNS_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWNS_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWNS_TYPE__UNKNOWN = 1;

	/**
	 * The number of structural features of the '<em>Initial Unknowns Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWNS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Initial Unknowns Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_UNKNOWNS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__DECLARED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MAX = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MIN = 2;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__QUANTITY = 3;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__START = 4;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerType1Impl <em>Integer Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getIntegerType1()
	 * @generated
	 */
	int INTEGER_TYPE1 = 19;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE1__MAX = 0;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE1__MIN = 1;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE1__QUANTITY = 2;

	/**
	 * The number of structural features of the '<em>Integer Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE1_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Integer Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ItemTypeImpl <em>Item Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ItemTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getItemType()
	 * @generated
	 */
	int ITEM_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Item Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Item Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.LogCategoriesTypeImpl <em>Log Categories Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.LogCategoriesTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getLogCategoriesType()
	 * @generated
	 */
	int LOG_CATEGORIES_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CATEGORIES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CATEGORIES_TYPE__CATEGORY = 1;

	/**
	 * The number of structural features of the '<em>Log Categories Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CATEGORIES_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Log Categories Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CATEGORIES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl <em>Model Exchange Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelExchangeType()
	 * @generated
	 */
	int MODEL_EXCHANGE_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__SOURCE_FILES = 0;

	/**
	 * The feature id for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE = 2;

	/**
	 * The feature id for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = 3;

	/**
	 * The feature id for the '<em><b>Can Serialize FM Ustate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE = 4;

	/**
	 * The feature id for the '<em><b>Completed Integrator Step Not Needed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED = 5;

	/**
	 * The feature id for the '<em><b>Model Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER = 6;

	/**
	 * The feature id for the '<em><b>Needs Execution Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL = 7;

	/**
	 * The feature id for the '<em><b>Provides Directional Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE = 8;

	/**
	 * The number of structural features of the '<em>Model Exchange Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Model Exchange Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXCHANGE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl <em>Model Structure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelStructureType()
	 * @generated
	 */
	int MODEL_STRUCTURE_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STRUCTURE_TYPE__OUTPUTS = 0;

	/**
	 * The feature id for the '<em><b>Derivatives</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STRUCTURE_TYPE__DERIVATIVES = 1;

	/**
	 * The feature id for the '<em><b>Initial Unknowns</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS = 2;

	/**
	 * The number of structural features of the '<em>Model Structure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STRUCTURE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Model Structure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_STRUCTURE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelVariablesTypeImpl <em>Model Variables Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelVariablesTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelVariablesType()
	 * @generated
	 */
	int MODEL_VARIABLES_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Scalar Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLES_TYPE__SCALAR_VARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Model Variables Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLES_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model Variables Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__DECLARED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__DERIVATIVE = 1;

	/**
	 * The feature id for the '<em><b>Display Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__DISPLAY_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__MAX = 3;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__MIN = 4;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NOMINAL = 5;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__QUANTITY = 6;

	/**
	 * The feature id for the '<em><b>Reinit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__REINIT = 7;

	/**
	 * The feature id for the '<em><b>Relative Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__RELATIVE_QUANTITY = 8;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__START = 9;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__UNBOUNDED = 10;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__UNIT = 11;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl <em>Real Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getRealType1()
	 * @generated
	 */
	int REAL_TYPE1 = 26;

	/**
	 * The feature id for the '<em><b>Display Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__DISPLAY_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__MAX = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__MIN = 2;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__NOMINAL = 3;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__QUANTITY = 4;

	/**
	 * The feature id for the '<em><b>Relative Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__RELATIVE_QUANTITY = 5;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__UNBOUNDED = 6;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1__UNIT = 7;

	/**
	 * The number of structural features of the '<em>Real Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Real Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesTypeImpl <em>Source Files Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getSourceFilesType()
	 * @generated
	 */
	int SOURCE_FILES_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE__FILE = 1;

	/**
	 * The number of structural features of the '<em>Source Files Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Source Files Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesType1Impl <em>Source Files Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getSourceFilesType1()
	 * @generated
	 */
	int SOURCE_FILES_TYPE1 = 28;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE1__GROUP = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE1__FILE = 1;

	/**
	 * The number of structural features of the '<em>Source Files Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE1_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Source Files Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILES_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__DECLARED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__START = 1;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ToolTypeImpl <em>Tool Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ToolTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getToolType()
	 * @generated
	 */
	int TOOL_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TYPE__ANY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Tool Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tool Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.TypeDefinitionsTypeImpl <em>Type Definitions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.TypeDefinitionsTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getTypeDefinitionsType()
	 * @generated
	 */
	int TYPE_DEFINITIONS_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITIONS_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Simple Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITIONS_TYPE__SIMPLE_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Type Definitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITIONS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type Definitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnitDefinitionsTypeImpl <em>Unit Definitions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnitDefinitionsTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnitDefinitionsType()
	 * @generated
	 */
	int UNIT_DEFINITIONS_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DEFINITIONS_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DEFINITIONS_TYPE__UNIT = 1;

	/**
	 * The number of structural features of the '<em>Unit Definitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DEFINITIONS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Unit Definitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DEFINITIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownTypeImpl <em>Unknown Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownTypeImpl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnknownType()
	 * @generated
	 */
	int UNKNOWN_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE__DEPENDENCIES = 0;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE__DEPENDENCIES_KIND = 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE__INDEX = 2;

	/**
	 * The number of structural features of the '<em>Unknown Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Unknown Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl <em>Unknown Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnknownType1()
	 * @generated
	 */
	int UNKNOWN_TYPE1 = 34;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE1__DEPENDENCIES = 0;

	/**
	 * The feature id for the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE1__DEPENDENCIES_KIND = 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE1__INDEX = 2;

	/**
	 * The number of structural features of the '<em>Unknown Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE1_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Unknown Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType <em>Causality Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCausalityType()
	 * @generated
	 */
	int CAUSALITY_TYPE = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem <em>Dependencies Kind Type Item</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItem()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE_ITEM = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1 <em>Dependencies Kind Type Item1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItem1()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE_ITEM1 = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialType <em>Initial Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialType()
	 * @generated
	 */
	int INITIAL_TYPE = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType <em>Variability Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariabilityType()
	 * @generated
	 */
	int VARIABILITY_TYPE = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType <em>Variable Naming Convention Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariableNamingConventionType()
	 * @generated
	 */
	int VARIABLE_NAMING_CONVENTION_TYPE = 40;

	/**
	 * The meta object id for the '<em>Causality Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCausalityTypeObject()
	 * @generated
	 */
	int CAUSALITY_TYPE_OBJECT = 41;

	/**
	 * The meta object id for the '<em>Dependencies Kind Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindType()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE = 42;

	/**
	 * The meta object id for the '<em>Dependencies Kind Type1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindType1()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE1 = 43;

	/**
	 * The meta object id for the '<em>Dependencies Kind Type Item Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItemObject()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE_ITEM_OBJECT = 44;

	/**
	 * The meta object id for the '<em>Dependencies Kind Type Item Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItemObject1()
	 * @generated
	 */
	int DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1 = 45;

	/**
	 * The meta object id for the '<em>Dependencies Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesType()
	 * @generated
	 */
	int DEPENDENCIES_TYPE = 46;

	/**
	 * The meta object id for the '<em>Dependencies Type1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesType1()
	 * @generated
	 */
	int DEPENDENCIES_TYPE1 = 47;

	/**
	 * The meta object id for the '<em>Initial Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialTypeObject()
	 * @generated
	 */
	int INITIAL_TYPE_OBJECT = 48;

	/**
	 * The meta object id for the '<em>Variability Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariabilityTypeObject()
	 * @generated
	 */
	int VARIABILITY_TYPE_OBJECT = 49;

	/**
	 * The meta object id for the '<em>Variable Naming Convention Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariableNamingConventionTypeObject()
	 * @generated
	 */
	int VARIABLE_NAMING_CONVENTION_TYPE_OBJECT = 50;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType <em>Base Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Unit Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType
	 * @generated
	 */
	EClass getBaseUnitType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getA()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_A();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd <em>Cd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cd</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getCd()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Cd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getFactor()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Factor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getK()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_K();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg <em>Kg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kg</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getKg()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Kg();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM <em>M</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>M</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getM()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_M();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol <em>Mol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mol</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getMol()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Mol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getOffset()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad <em>Rad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rad</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getRad()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_Rad();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS <em>S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BaseUnitType#getS()
	 * @see #getBaseUnitType()
	 * @generated
	 */
	EAttribute getBaseUnitType_S();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#getDeclaredType()
	 * @see #getBooleanType()
	 * @generated
	 */
	EAttribute getBooleanType_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart()
	 * @see #getBooleanType()
	 * @generated
	 */
	EAttribute getBooleanType_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType <em>Category Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType
	 * @generated
	 */
	EClass getCategoryType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType#getDescription()
	 * @see #getCategoryType()
	 * @generated
	 */
	EAttribute getCategoryType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CategoryType#getName()
	 * @see #getCategoryType()
	 * @generated
	 */
	EAttribute getCategoryType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType <em>Co Simulation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Co Simulation Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType
	 * @generated
	 */
	EClass getCoSimulationType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getSourceFiles <em>Source Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getSourceFiles()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EReference getCoSimulationType_SourceFiles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Be Instantiated Only Once Per Process</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanBeInstantiatedOnlyOncePerProcess()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanBeInstantiatedOnlyOncePerProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Get And Set FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanGetAndSetFMUstate()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanGetAndSetFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanHandleVariableCommunicationStepSize <em>Can Handle Variable Communication Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Handle Variable Communication Step Size</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanHandleVariableCommunicationStepSize()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanHandleVariableCommunicationStepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanInterpolateInputs <em>Can Interpolate Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Interpolate Inputs</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanInterpolateInputs()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanInterpolateInputs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Not Use Memory Management Functions</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanNotUseMemoryManagementFunctions()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanNotUseMemoryManagementFunctions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanRunAsynchronuously <em>Can Run Asynchronuously</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Run Asynchronuously</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanRunAsynchronuously()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanRunAsynchronuously();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Serialize FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isCanSerializeFMUstate()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_CanSerializeFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getMaxOutputDerivativeOrder <em>Max Output Derivative Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Output Derivative Order</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getMaxOutputDerivativeOrder()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_MaxOutputDerivativeOrder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getModelIdentifier <em>Model Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Identifier</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#getModelIdentifier()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_ModelIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isNeedsExecutionTool <em>Needs Execution Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs Execution Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isNeedsExecutionTool()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_NeedsExecutionTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provides Directional Derivative</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CoSimulationType#isProvidesDirectionalDerivative()
	 * @see #getCoSimulationType()
	 * @generated
	 */
	EAttribute getCoSimulationType_ProvidesDirectionalDerivative();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType <em>Default Experiment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Experiment Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType
	 * @generated
	 */
	EClass getDefaultExperimentType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStartTime()
	 * @see #getDefaultExperimentType()
	 * @generated
	 */
	EAttribute getDefaultExperimentType_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStepSize()
	 * @see #getDefaultExperimentType()
	 * @generated
	 */
	EAttribute getDefaultExperimentType_StepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getStopTime()
	 * @see #getDefaultExperimentType()
	 * @generated
	 */
	EAttribute getDefaultExperimentType_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DefaultExperimentType#getTolerance()
	 * @see #getDefaultExperimentType()
	 * @generated
	 */
	EAttribute getDefaultExperimentType_Tolerance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType <em>Display Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Unit Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType
	 * @generated
	 */
	EClass getDisplayUnitType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor()
	 * @see #getDisplayUnitType()
	 * @generated
	 */
	EAttribute getDisplayUnitType_Factor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getName()
	 * @see #getDisplayUnitType()
	 * @generated
	 */
	EAttribute getDisplayUnitType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset()
	 * @see #getDisplayUnitType()
	 * @generated
	 */
	EAttribute getDisplayUnitType_Offset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getFmiModelDescription <em>Fmi Model Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fmi Model Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DocumentRoot#getFmiModelDescription()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FmiModelDescription();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType
	 * @generated
	 */
	EClass getEnumerationType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getDeclaredType()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EAttribute getEnumerationType_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getMax()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EAttribute getEnumerationType_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getMin()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EAttribute getEnumerationType_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getQuantity()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EAttribute getEnumerationType_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType#getStart()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EAttribute getEnumerationType_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1 <em>Enumeration Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1
	 * @generated
	 */
	EClass getEnumerationType1();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getGroup()
	 * @see #getEnumerationType1()
	 * @generated
	 */
	EAttribute getEnumerationType1_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Item</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getItem()
	 * @see #getEnumerationType1()
	 * @generated
	 */
	EReference getEnumerationType1_Item();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.EnumerationType1#getQuantity()
	 * @see #getEnumerationType1()
	 * @generated
	 */
	EAttribute getEnumerationType1_Quantity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType
	 * @generated
	 */
	EClass getFileType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType#getName()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType1 <em>File Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType1
	 * @generated
	 */
	EClass getFileType1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FileType1#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FileType1#getName()
	 * @see #getFileType1()
	 * @generated
	 */
	EAttribute getFileType1_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation <em>Fmi2 Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fmi2 Annotation</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation
	 * @generated
	 */
	EClass getFmi2Annotation();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation#getGroup()
	 * @see #getFmi2Annotation()
	 * @generated
	 */
	EAttribute getFmi2Annotation_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Annotation#getTool()
	 * @see #getFmi2Annotation()
	 * @generated
	 */
	EReference getFmi2Annotation_Tool();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable <em>Fmi2 Scalar Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fmi2 Scalar Variable</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable
	 * @generated
	 */
	EClass getFmi2ScalarVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Real</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getReal()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_Real();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Integer</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInteger()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_Integer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getBoolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Boolean</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getBoolean()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_Boolean();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>String</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getString()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_String();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumeration</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getEnumeration()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_Enumeration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotations</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getAnnotations()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EReference getFmi2ScalarVariable_Annotations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant <em>Can Handle Multiple Set Per Time Instant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Handle Multiple Set Per Time Instant</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#isCanHandleMultipleSetPerTimeInstant()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality <em>Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Causality</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getCausality()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_Causality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getDescription()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getInitial()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_Initial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getName()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Reference</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getValueReference()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_ValueReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability <em>Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variability</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable#getVariability()
	 * @see #getFmi2ScalarVariable()
	 * @generated
	 */
	EAttribute getFmi2ScalarVariable_Variability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType <em>Fmi2 Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fmi2 Simple Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType
	 * @generated
	 */
	EClass getFmi2SimpleType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Real</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getReal()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EReference getFmi2SimpleType_Real();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Integer</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getInteger()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EReference getFmi2SimpleType_Integer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getBoolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Boolean</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getBoolean()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EReference getFmi2SimpleType_Boolean();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>String</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getString()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EReference getFmi2SimpleType_String();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumeration</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getEnumeration()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EReference getFmi2SimpleType_Enumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getDescription()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EAttribute getFmi2SimpleType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getName()
	 * @see #getFmi2SimpleType()
	 * @generated
	 */
	EAttribute getFmi2SimpleType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit <em>Fmi2 Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fmi2 Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit
	 * @generated
	 */
	EClass getFmi2Unit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getBaseUnit <em>Base Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getBaseUnit()
	 * @see #getFmi2Unit()
	 * @generated
	 */
	EReference getFmi2Unit_BaseUnit();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getGroup()
	 * @see #getFmi2Unit()
	 * @generated
	 */
	EAttribute getFmi2Unit_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getDisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Display Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getDisplayUnit()
	 * @see #getFmi2Unit()
	 * @generated
	 */
	EReference getFmi2Unit_DisplayUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getName()
	 * @see #getFmi2Unit()
	 * @generated
	 */
	EAttribute getFmi2Unit_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency <em>Fmi2 Variable Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fmi2 Variable Dependency</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency
	 * @generated
	 */
	EClass getFmi2VariableDependency();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency#getGroup()
	 * @see #getFmi2VariableDependency()
	 * @generated
	 */
	EAttribute getFmi2VariableDependency_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2VariableDependency#getUnknown()
	 * @see #getFmi2VariableDependency()
	 * @generated
	 */
	EReference getFmi2VariableDependency_Unknown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType <em>Model Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Description Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType
	 * @generated
	 */
	EClass getFmiModelDescriptionType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGroup()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelExchange <em>Model Exchange</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Exchange</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelExchange()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_ModelExchange();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getCoSimulation <em>Co Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Co Simulation</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getCoSimulation()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_CoSimulation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getUnitDefinitions <em>Unit Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Definitions</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getUnitDefinitions()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_UnitDefinitions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getTypeDefinitions <em>Type Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Definitions</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getTypeDefinitions()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_TypeDefinitions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getLogCategories <em>Log Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Categories</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getLogCategories()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_LogCategories();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getDefaultExperiment <em>Default Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Experiment</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getDefaultExperiment()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_DefaultExperiment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVendorAnnotations <em>Vendor Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vendor Annotations</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVendorAnnotations()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_VendorAnnotations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelVariables <em>Model Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Variables</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelVariables()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_ModelVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelStructure <em>Model Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Structure</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelStructure()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EReference getFmiModelDescriptionType_ModelStructure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getAuthor()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copyright</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getCopyright()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Copyright();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getDescription()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getFmiVersion <em>Fmi Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmi Version</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getFmiVersion()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_FmiVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGenerationDateAndTime <em>Generation Date And Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Date And Time</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGenerationDateAndTime()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_GenerationDateAndTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGenerationTool <em>Generation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGenerationTool()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_GenerationTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getGuid()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Guid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getLicense()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_License();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getModelName()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_ModelName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getNumberOfEventIndicators <em>Number Of Event Indicators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Event Indicators</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getNumberOfEventIndicators()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_NumberOfEventIndicators();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVariableNamingConvention <em>Variable Naming Convention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Naming Convention</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVariableNamingConvention()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_VariableNamingConvention();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType#getVersion()
	 * @see #getFmiModelDescriptionType()
	 * @generated
	 */
	EAttribute getFmiModelDescriptionType_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType <em>Initial Unknowns Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial Unknowns Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType
	 * @generated
	 */
	EClass getInitialUnknownsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getGroup()
	 * @see #getInitialUnknownsType()
	 * @generated
	 */
	EAttribute getInitialUnknownsType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unknown</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialUnknownsType#getUnknown()
	 * @see #getInitialUnknownsType()
	 * @generated
	 */
	EReference getInitialUnknownsType_Unknown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getDeclaredType()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getMax()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getMin()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getQuantity()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType#getStart()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1 <em>Integer Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1
	 * @generated
	 */
	EClass getIntegerType1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax()
	 * @see #getIntegerType1()
	 * @generated
	 */
	EAttribute getIntegerType1_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin()
	 * @see #getIntegerType1()
	 * @generated
	 */
	EAttribute getIntegerType1_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getQuantity()
	 * @see #getIntegerType1()
	 * @generated
	 */
	EAttribute getIntegerType1_Quantity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ItemType <em>Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ItemType
	 * @generated
	 */
	EClass getItemType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getDescription()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getName()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ItemType#getValue()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType <em>Log Categories Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Categories Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType
	 * @generated
	 */
	EClass getLogCategoriesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType#getGroup()
	 * @see #getLogCategoriesType()
	 * @generated
	 */
	EAttribute getLogCategoriesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Category</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.LogCategoriesType#getCategory()
	 * @see #getLogCategoriesType()
	 * @generated
	 */
	EReference getLogCategoriesType_Category();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType <em>Model Exchange Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Exchange Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType
	 * @generated
	 */
	EClass getModelExchangeType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#getSourceFiles <em>Source Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#getSourceFiles()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EReference getModelExchangeType_SourceFiles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanBeInstantiatedOnlyOncePerProcess <em>Can Be Instantiated Only Once Per Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Be Instantiated Only Once Per Process</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanBeInstantiatedOnlyOncePerProcess()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_CanBeInstantiatedOnlyOncePerProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanGetAndSetFMUstate <em>Can Get And Set FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Get And Set FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanGetAndSetFMUstate()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_CanGetAndSetFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanNotUseMemoryManagementFunctions <em>Can Not Use Memory Management Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Not Use Memory Management Functions</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanNotUseMemoryManagementFunctions()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_CanNotUseMemoryManagementFunctions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanSerializeFMUstate <em>Can Serialize FM Ustate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Serialize FM Ustate</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCanSerializeFMUstate()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_CanSerializeFMUstate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completed Integrator Step Not Needed</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isCompletedIntegratorStepNotNeeded()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_CompletedIntegratorStepNotNeeded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#getModelIdentifier <em>Model Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Identifier</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#getModelIdentifier()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_ModelIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isNeedsExecutionTool <em>Needs Execution Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs Execution Tool</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isNeedsExecutionTool()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_NeedsExecutionTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isProvidesDirectionalDerivative <em>Provides Directional Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provides Directional Derivative</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelExchangeType#isProvidesDirectionalDerivative()
	 * @see #getModelExchangeType()
	 * @generated
	 */
	EAttribute getModelExchangeType_ProvidesDirectionalDerivative();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType <em>Model Structure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Structure Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType
	 * @generated
	 */
	EClass getModelStructureType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outputs</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getOutputs()
	 * @see #getModelStructureType()
	 * @generated
	 */
	EReference getModelStructureType_Outputs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getDerivatives <em>Derivatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Derivatives</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getDerivatives()
	 * @see #getModelStructureType()
	 * @generated
	 */
	EReference getModelStructureType_Derivatives();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getInitialUnknowns <em>Initial Unknowns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Unknowns</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelStructureType#getInitialUnknowns()
	 * @see #getModelStructureType()
	 * @generated
	 */
	EReference getModelStructureType_InitialUnknowns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType <em>Model Variables Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Variables Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType
	 * @generated
	 */
	EClass getModelVariablesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType#getGroup()
	 * @see #getModelVariablesType()
	 * @generated
	 */
	EAttribute getModelVariablesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType#getScalarVariable <em>Scalar Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scalar Variable</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ModelVariablesType#getScalarVariable()
	 * @see #getModelVariablesType()
	 * @generated
	 */
	EReference getModelVariablesType_ScalarVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDeclaredType()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative <em>Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivative</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDerivative()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Derivative();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getDisplayUnit()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_DisplayUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMax()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getMin()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal <em>Nominal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominal</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getNominal()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Nominal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getQuantity()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit <em>Reinit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reinit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isReinit()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Reinit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity <em>Relative Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isRelativeQuantity()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_RelativeQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getStart()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded <em>Unbounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbounded</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#isUnbounded()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Unbounded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType#getUnit()
	 * @see #getRealType()
	 * @generated
	 */
	EAttribute getRealType_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1 <em>Real Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1
	 * @generated
	 */
	EClass getRealType1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getDisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getDisplayUnit()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_DisplayUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getMax()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getMin()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getNominal <em>Nominal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nominal</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getNominal()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Nominal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getQuantity()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#isRelativeQuantity <em>Relative Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Quantity</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#isRelativeQuantity()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_RelativeQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#isUnbounded <em>Unbounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbounded</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#isUnbounded()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Unbounded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.RealType1#getUnit()
	 * @see #getRealType1()
	 * @generated
	 */
	EAttribute getRealType1_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType <em>Source Files Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Files Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType
	 * @generated
	 */
	EClass getSourceFilesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType#getGroup()
	 * @see #getSourceFilesType()
	 * @generated
	 */
	EAttribute getSourceFilesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType#getFile()
	 * @see #getSourceFilesType()
	 * @generated
	 */
	EReference getSourceFilesType_File();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1 <em>Source Files Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Files Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1
	 * @generated
	 */
	EClass getSourceFilesType1();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1#getGroup()
	 * @see #getSourceFilesType1()
	 * @generated
	 */
	EAttribute getSourceFilesType1_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.SourceFilesType1#getFile()
	 * @see #getSourceFilesType1()
	 * @generated
	 */
	EReference getSourceFilesType1_File();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.StringType#getDeclaredType <em>Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declared Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.StringType#getDeclaredType()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_DeclaredType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.StringType#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.StringType#getStart()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ToolType <em>Tool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ToolType
	 * @generated
	 */
	EClass getToolType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ToolType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ToolType#getAny()
	 * @see #getToolType()
	 * @generated
	 */
	EAttribute getToolType_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.ToolType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.ToolType#getName()
	 * @see #getToolType()
	 * @generated
	 */
	EAttribute getToolType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType <em>Type Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Definitions Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType
	 * @generated
	 */
	EClass getTypeDefinitionsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getGroup()
	 * @see #getTypeDefinitionsType()
	 * @generated
	 */
	EAttribute getTypeDefinitionsType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getSimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getSimpleType()
	 * @see #getTypeDefinitionsType()
	 * @generated
	 */
	EReference getTypeDefinitionsType_SimpleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType <em>Unit Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Definitions Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType
	 * @generated
	 */
	EClass getUnitDefinitionsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType#getGroup()
	 * @see #getUnitDefinitionsType()
	 * @generated
	 */
	EAttribute getUnitDefinitionsType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnitDefinitionsType#getUnit()
	 * @see #getUnitDefinitionsType()
	 * @generated
	 */
	EReference getUnitDefinitionsType_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType <em>Unknown Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType
	 * @generated
	 */
	EClass getUnknownType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getDependencies()
	 * @see #getUnknownType()
	 * @generated
	 */
	EAttribute getUnknownType_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getDependenciesKind <em>Dependencies Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getDependenciesKind()
	 * @see #getUnknownType()
	 * @generated
	 */
	EAttribute getUnknownType_DependenciesKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType#getIndex()
	 * @see #getUnknownType()
	 * @generated
	 */
	EAttribute getUnknownType_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1 <em>Unknown Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Type1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1
	 * @generated
	 */
	EClass getUnknownType1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependencies()
	 * @see #getUnknownType1()
	 * @generated
	 */
	EAttribute getUnknownType1_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependenciesKind <em>Dependencies Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies Kind</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getDependenciesKind()
	 * @see #getUnknownType1()
	 * @generated
	 */
	EAttribute getUnknownType1_DependenciesKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.UnknownType1#getIndex()
	 * @see #getUnknownType1()
	 * @generated
	 */
	EAttribute getUnknownType1_Index();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType <em>Causality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Causality Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @generated
	 */
	EEnum getCausalityType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem <em>Dependencies Kind Type Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependencies Kind Type Item</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
	 * @generated
	 */
	EEnum getDependenciesKindTypeItem();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1 <em>Dependencies Kind Type Item1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependencies Kind Type Item1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
	 * @generated
	 */
	EEnum getDependenciesKindTypeItem1();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialType <em>Initial Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Initial Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @generated
	 */
	EEnum getInitialType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType <em>Variability Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variability Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @generated
	 */
	EEnum getVariabilityType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType <em>Variable Naming Convention Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Naming Convention Type</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
	 * @generated
	 */
	EEnum getVariableNamingConventionType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType <em>Causality Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Causality Type Object</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType"
	 *        extendedMetaData="name='causality_._type:Object' baseType='causality_._type'"
	 * @generated
	 */
	EDataType getCausalityTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Dependencies Kind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Kind Type</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='dependenciesKind_._type' itemType='dependenciesKind_._type_._item'"
	 * @generated
	 */
	EDataType getDependenciesKindType();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Dependencies Kind Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Kind Type1</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='dependenciesKind_._1_._type' itemType='dependenciesKind_._1_._type_._item'"
	 * @generated
	 */
	EDataType getDependenciesKindType1();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem <em>Dependencies Kind Type Item Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Kind Type Item Object</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem"
	 *        extendedMetaData="name='dependenciesKind_._type_._item:Object' baseType='dependenciesKind_._type_._item'"
	 * @generated
	 */
	EDataType getDependenciesKindTypeItemObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1 <em>Dependencies Kind Type Item Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Kind Type Item Object1</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1"
	 *        extendedMetaData="name='dependenciesKind_._1_._type_._item:Object' baseType='dependenciesKind_._1_._type_._item'"
	 * @generated
	 */
	EDataType getDependenciesKindTypeItemObject1();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Dependencies Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Type</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='dependencies_._type' itemType='http://www.eclipse.org/emf/2003/XMLType#unsignedInt'"
	 * @generated
	 */
	EDataType getDependenciesType();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Dependencies Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dependencies Type1</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='dependencies_._1_._type' itemType='http://www.eclipse.org/emf/2003/XMLType#unsignedInt'"
	 * @generated
	 */
	EDataType getDependenciesType1();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialType <em>Initial Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Initial Type Object</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.InitialType"
	 *        extendedMetaData="name='initial_._type:Object' baseType='initial_._type'"
	 * @generated
	 */
	EDataType getInitialTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType <em>Variability Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Variability Type Object</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType"
	 *        extendedMetaData="name='variability_._type:Object' baseType='variability_._type'"
	 * @generated
	 */
	EDataType getVariabilityTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType <em>Variable Naming Convention Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Variable Naming Convention Type Object</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
	 * @model instanceClass="org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType"
	 *        extendedMetaData="name='variableNamingConvention_._type:Object' baseType='variableNamingConvention_._type'"
	 * @generated
	 */
	EDataType getVariableNamingConventionTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FmiFactory getFmiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl <em>Base Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.BaseUnitTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getBaseUnitType()
		 * @generated
		 */
		EClass BASE_UNIT_TYPE = eINSTANCE.getBaseUnitType();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__A = eINSTANCE.getBaseUnitType_A();

		/**
		 * The meta object literal for the '<em><b>Cd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__CD = eINSTANCE.getBaseUnitType_Cd();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__FACTOR = eINSTANCE.getBaseUnitType_Factor();

		/**
		 * The meta object literal for the '<em><b>K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__K = eINSTANCE.getBaseUnitType_K();

		/**
		 * The meta object literal for the '<em><b>Kg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__KG = eINSTANCE.getBaseUnitType_Kg();

		/**
		 * The meta object literal for the '<em><b>M</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__M = eINSTANCE.getBaseUnitType_M();

		/**
		 * The meta object literal for the '<em><b>Mol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__MOL = eINSTANCE.getBaseUnitType_Mol();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__OFFSET = eINSTANCE.getBaseUnitType_Offset();

		/**
		 * The meta object literal for the '<em><b>Rad</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__RAD = eINSTANCE.getBaseUnitType_Rad();

		/**
		 * The meta object literal for the '<em><b>S</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT_TYPE__S = eINSTANCE.getBaseUnitType_S();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.BooleanTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TYPE__DECLARED_TYPE = eINSTANCE.getBooleanType_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TYPE__START = eINSTANCE.getBooleanType_Start();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CategoryTypeImpl <em>Category Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.CategoryTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCategoryType()
		 * @generated
		 */
		EClass CATEGORY_TYPE = eINSTANCE.getCategoryType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_TYPE__DESCRIPTION = eINSTANCE.getCategoryType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_TYPE__NAME = eINSTANCE.getCategoryType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl <em>Co Simulation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.CoSimulationTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCoSimulationType()
		 * @generated
		 */
		EClass CO_SIMULATION_TYPE = eINSTANCE.getCoSimulationType();

		/**
		 * The meta object literal for the '<em><b>Source Files</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CO_SIMULATION_TYPE__SOURCE_FILES = eINSTANCE.getCoSimulationType_SourceFiles();

		/**
		 * The meta object literal for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = eINSTANCE.getCoSimulationType_CanBeInstantiatedOnlyOncePerProcess();

		/**
		 * The meta object literal for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_GET_AND_SET_FM_USTATE = eINSTANCE.getCoSimulationType_CanGetAndSetFMUstate();

		/**
		 * The meta object literal for the '<em><b>Can Handle Variable Communication Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_HANDLE_VARIABLE_COMMUNICATION_STEP_SIZE = eINSTANCE.getCoSimulationType_CanHandleVariableCommunicationStepSize();

		/**
		 * The meta object literal for the '<em><b>Can Interpolate Inputs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_INTERPOLATE_INPUTS = eINSTANCE.getCoSimulationType_CanInterpolateInputs();

		/**
		 * The meta object literal for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = eINSTANCE.getCoSimulationType_CanNotUseMemoryManagementFunctions();

		/**
		 * The meta object literal for the '<em><b>Can Run Asynchronuously</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_RUN_ASYNCHRONUOUSLY = eINSTANCE.getCoSimulationType_CanRunAsynchronuously();

		/**
		 * The meta object literal for the '<em><b>Can Serialize FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__CAN_SERIALIZE_FM_USTATE = eINSTANCE.getCoSimulationType_CanSerializeFMUstate();

		/**
		 * The meta object literal for the '<em><b>Max Output Derivative Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__MAX_OUTPUT_DERIVATIVE_ORDER = eINSTANCE.getCoSimulationType_MaxOutputDerivativeOrder();

		/**
		 * The meta object literal for the '<em><b>Model Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__MODEL_IDENTIFIER = eINSTANCE.getCoSimulationType_ModelIdentifier();

		/**
		 * The meta object literal for the '<em><b>Needs Execution Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__NEEDS_EXECUTION_TOOL = eINSTANCE.getCoSimulationType_NeedsExecutionTool();

		/**
		 * The meta object literal for the '<em><b>Provides Directional Derivative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CO_SIMULATION_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE = eINSTANCE.getCoSimulationType_ProvidesDirectionalDerivative();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl <em>Default Experiment Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DefaultExperimentTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDefaultExperimentType()
		 * @generated
		 */
		EClass DEFAULT_EXPERIMENT_TYPE = eINSTANCE.getDefaultExperimentType();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_EXPERIMENT_TYPE__START_TIME = eINSTANCE.getDefaultExperimentType_StartTime();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_EXPERIMENT_TYPE__STEP_SIZE = eINSTANCE.getDefaultExperimentType_StepSize();

		/**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_EXPERIMENT_TYPE__STOP_TIME = eINSTANCE.getDefaultExperimentType_StopTime();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_EXPERIMENT_TYPE__TOLERANCE = eINSTANCE.getDefaultExperimentType_Tolerance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl <em>Display Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DisplayUnitTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDisplayUnitType()
		 * @generated
		 */
		EClass DISPLAY_UNIT_TYPE = eINSTANCE.getDisplayUnitType();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_UNIT_TYPE__FACTOR = eINSTANCE.getDisplayUnitType_Factor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_UNIT_TYPE__NAME = eINSTANCE.getDisplayUnitType_Name();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_UNIT_TYPE__OFFSET = eINSTANCE.getDisplayUnitType_Offset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.DocumentRootImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Fmi Model Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FMI_MODEL_DESCRIPTION = eINSTANCE.getDocumentRoot_FmiModelDescription();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getEnumerationType()
		 * @generated
		 */
		EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE__DECLARED_TYPE = eINSTANCE.getEnumerationType_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE__MAX = eINSTANCE.getEnumerationType_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE__MIN = eINSTANCE.getEnumerationType_Min();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE__QUANTITY = eINSTANCE.getEnumerationType_Quantity();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE__START = eINSTANCE.getEnumerationType_Start();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationType1Impl <em>Enumeration Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.EnumerationType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getEnumerationType1()
		 * @generated
		 */
		EClass ENUMERATION_TYPE1 = eINSTANCE.getEnumerationType1();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE1__GROUP = eINSTANCE.getEnumerationType1_Group();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_TYPE1__ITEM = eINSTANCE.getEnumerationType1_Item();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_TYPE1__QUANTITY = eINSTANCE.getEnumerationType1_Quantity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileTypeImpl <em>File Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFileType()
		 * @generated
		 */
		EClass FILE_TYPE = eINSTANCE.getFileType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__NAME = eINSTANCE.getFileType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileType1Impl <em>File Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FileType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFileType1()
		 * @generated
		 */
		EClass FILE_TYPE1 = eINSTANCE.getFileType1();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE1__NAME = eINSTANCE.getFileType1_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2AnnotationImpl <em>Fmi2 Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2AnnotationImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2Annotation()
		 * @generated
		 */
		EClass FMI2_ANNOTATION = eINSTANCE.getFmi2Annotation();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_ANNOTATION__GROUP = eINSTANCE.getFmi2Annotation_Group();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_ANNOTATION__TOOL = eINSTANCE.getFmi2Annotation_Tool();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl <em>Fmi2 Scalar Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2ScalarVariableImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2ScalarVariable()
		 * @generated
		 */
		EClass FMI2_SCALAR_VARIABLE = eINSTANCE.getFmi2ScalarVariable();

		/**
		 * The meta object literal for the '<em><b>Real</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__REAL = eINSTANCE.getFmi2ScalarVariable_Real();

		/**
		 * The meta object literal for the '<em><b>Integer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__INTEGER = eINSTANCE.getFmi2ScalarVariable_Integer();

		/**
		 * The meta object literal for the '<em><b>Boolean</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__BOOLEAN = eINSTANCE.getFmi2ScalarVariable_Boolean();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__STRING = eINSTANCE.getFmi2ScalarVariable_String();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__ENUMERATION = eINSTANCE.getFmi2ScalarVariable_Enumeration();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SCALAR_VARIABLE__ANNOTATIONS = eINSTANCE.getFmi2ScalarVariable_Annotations();

		/**
		 * The meta object literal for the '<em><b>Can Handle Multiple Set Per Time Instant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__CAN_HANDLE_MULTIPLE_SET_PER_TIME_INSTANT = eINSTANCE.getFmi2ScalarVariable_CanHandleMultipleSetPerTimeInstant();

		/**
		 * The meta object literal for the '<em><b>Causality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__CAUSALITY = eINSTANCE.getFmi2ScalarVariable_Causality();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__DESCRIPTION = eINSTANCE.getFmi2ScalarVariable_Description();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__INITIAL = eINSTANCE.getFmi2ScalarVariable_Initial();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__NAME = eINSTANCE.getFmi2ScalarVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Value Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__VALUE_REFERENCE = eINSTANCE.getFmi2ScalarVariable_ValueReference();

		/**
		 * The meta object literal for the '<em><b>Variability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SCALAR_VARIABLE__VARIABILITY = eINSTANCE.getFmi2ScalarVariable_Variability();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl <em>Fmi2 Simple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2SimpleTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2SimpleType()
		 * @generated
		 */
		EClass FMI2_SIMPLE_TYPE = eINSTANCE.getFmi2SimpleType();

		/**
		 * The meta object literal for the '<em><b>Real</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SIMPLE_TYPE__REAL = eINSTANCE.getFmi2SimpleType_Real();

		/**
		 * The meta object literal for the '<em><b>Integer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SIMPLE_TYPE__INTEGER = eINSTANCE.getFmi2SimpleType_Integer();

		/**
		 * The meta object literal for the '<em><b>Boolean</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SIMPLE_TYPE__BOOLEAN = eINSTANCE.getFmi2SimpleType_Boolean();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SIMPLE_TYPE__STRING = eINSTANCE.getFmi2SimpleType_String();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_SIMPLE_TYPE__ENUMERATION = eINSTANCE.getFmi2SimpleType_Enumeration();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SIMPLE_TYPE__DESCRIPTION = eINSTANCE.getFmi2SimpleType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_SIMPLE_TYPE__NAME = eINSTANCE.getFmi2SimpleType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl <em>Fmi2 Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2UnitImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2Unit()
		 * @generated
		 */
		EClass FMI2_UNIT = eINSTANCE.getFmi2Unit();

		/**
		 * The meta object literal for the '<em><b>Base Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_UNIT__BASE_UNIT = eINSTANCE.getFmi2Unit_BaseUnit();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_UNIT__GROUP = eINSTANCE.getFmi2Unit_Group();

		/**
		 * The meta object literal for the '<em><b>Display Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_UNIT__DISPLAY_UNIT = eINSTANCE.getFmi2Unit_DisplayUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_UNIT__NAME = eINSTANCE.getFmi2Unit_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2VariableDependencyImpl <em>Fmi2 Variable Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.Fmi2VariableDependencyImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmi2VariableDependency()
		 * @generated
		 */
		EClass FMI2_VARIABLE_DEPENDENCY = eINSTANCE.getFmi2VariableDependency();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI2_VARIABLE_DEPENDENCY__GROUP = eINSTANCE.getFmi2VariableDependency_Group();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI2_VARIABLE_DEPENDENCY__UNKNOWN = eINSTANCE.getFmi2VariableDependency_Unknown();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl <em>Model Description Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiModelDescriptionTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getFmiModelDescriptionType()
		 * @generated
		 */
		EClass FMI_MODEL_DESCRIPTION_TYPE = eINSTANCE.getFmiModelDescriptionType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__GROUP = eINSTANCE.getFmiModelDescriptionType_Group();

		/**
		 * The meta object literal for the '<em><b>Model Exchange</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__MODEL_EXCHANGE = eINSTANCE.getFmiModelDescriptionType_ModelExchange();

		/**
		 * The meta object literal for the '<em><b>Co Simulation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__CO_SIMULATION = eINSTANCE.getFmiModelDescriptionType_CoSimulation();

		/**
		 * The meta object literal for the '<em><b>Unit Definitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__UNIT_DEFINITIONS = eINSTANCE.getFmiModelDescriptionType_UnitDefinitions();

		/**
		 * The meta object literal for the '<em><b>Type Definitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__TYPE_DEFINITIONS = eINSTANCE.getFmiModelDescriptionType_TypeDefinitions();

		/**
		 * The meta object literal for the '<em><b>Log Categories</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__LOG_CATEGORIES = eINSTANCE.getFmiModelDescriptionType_LogCategories();

		/**
		 * The meta object literal for the '<em><b>Default Experiment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__DEFAULT_EXPERIMENT = eINSTANCE.getFmiModelDescriptionType_DefaultExperiment();

		/**
		 * The meta object literal for the '<em><b>Vendor Annotations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__VENDOR_ANNOTATIONS = eINSTANCE.getFmiModelDescriptionType_VendorAnnotations();

		/**
		 * The meta object literal for the '<em><b>Model Variables</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__MODEL_VARIABLES = eINSTANCE.getFmiModelDescriptionType_ModelVariables();

		/**
		 * The meta object literal for the '<em><b>Model Structure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMI_MODEL_DESCRIPTION_TYPE__MODEL_STRUCTURE = eINSTANCE.getFmiModelDescriptionType_ModelStructure();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__AUTHOR = eINSTANCE.getFmiModelDescriptionType_Author();

		/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__COPYRIGHT = eINSTANCE.getFmiModelDescriptionType_Copyright();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__DESCRIPTION = eINSTANCE.getFmiModelDescriptionType_Description();

		/**
		 * The meta object literal for the '<em><b>Fmi Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__FMI_VERSION = eINSTANCE.getFmiModelDescriptionType_FmiVersion();

		/**
		 * The meta object literal for the '<em><b>Generation Date And Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__GENERATION_DATE_AND_TIME = eINSTANCE.getFmiModelDescriptionType_GenerationDateAndTime();

		/**
		 * The meta object literal for the '<em><b>Generation Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__GENERATION_TOOL = eINSTANCE.getFmiModelDescriptionType_GenerationTool();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__GUID = eINSTANCE.getFmiModelDescriptionType_Guid();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__LICENSE = eINSTANCE.getFmiModelDescriptionType_License();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__MODEL_NAME = eINSTANCE.getFmiModelDescriptionType_ModelName();

		/**
		 * The meta object literal for the '<em><b>Number Of Event Indicators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__NUMBER_OF_EVENT_INDICATORS = eINSTANCE.getFmiModelDescriptionType_NumberOfEventIndicators();

		/**
		 * The meta object literal for the '<em><b>Variable Naming Convention</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__VARIABLE_NAMING_CONVENTION = eINSTANCE.getFmiModelDescriptionType_VariableNamingConvention();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMI_MODEL_DESCRIPTION_TYPE__VERSION = eINSTANCE.getFmiModelDescriptionType_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.InitialUnknownsTypeImpl <em>Initial Unknowns Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.InitialUnknownsTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialUnknownsType()
		 * @generated
		 */
		EClass INITIAL_UNKNOWNS_TYPE = eINSTANCE.getInitialUnknownsType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIAL_UNKNOWNS_TYPE__GROUP = eINSTANCE.getInitialUnknownsType_Group();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIAL_UNKNOWNS_TYPE__UNKNOWN = eINSTANCE.getInitialUnknownsType_Unknown();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__DECLARED_TYPE = eINSTANCE.getIntegerType_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MAX = eINSTANCE.getIntegerType_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MIN = eINSTANCE.getIntegerType_Min();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__QUANTITY = eINSTANCE.getIntegerType_Quantity();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__START = eINSTANCE.getIntegerType_Start();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerType1Impl <em>Integer Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.IntegerType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getIntegerType1()
		 * @generated
		 */
		EClass INTEGER_TYPE1 = eINSTANCE.getIntegerType1();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE1__MAX = eINSTANCE.getIntegerType1_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE1__MIN = eINSTANCE.getIntegerType1_Min();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE1__QUANTITY = eINSTANCE.getIntegerType1_Quantity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ItemTypeImpl <em>Item Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ItemTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getItemType()
		 * @generated
		 */
		EClass ITEM_TYPE = eINSTANCE.getItemType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__DESCRIPTION = eINSTANCE.getItemType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__NAME = eINSTANCE.getItemType_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__VALUE = eINSTANCE.getItemType_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.LogCategoriesTypeImpl <em>Log Categories Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.LogCategoriesTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getLogCategoriesType()
		 * @generated
		 */
		EClass LOG_CATEGORIES_TYPE = eINSTANCE.getLogCategoriesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_CATEGORIES_TYPE__GROUP = eINSTANCE.getLogCategoriesType_Group();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_CATEGORIES_TYPE__CATEGORY = eINSTANCE.getLogCategoriesType_Category();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl <em>Model Exchange Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelExchangeTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelExchangeType()
		 * @generated
		 */
		EClass MODEL_EXCHANGE_TYPE = eINSTANCE.getModelExchangeType();

		/**
		 * The meta object literal for the '<em><b>Source Files</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_EXCHANGE_TYPE__SOURCE_FILES = eINSTANCE.getModelExchangeType_SourceFiles();

		/**
		 * The meta object literal for the '<em><b>Can Be Instantiated Only Once Per Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__CAN_BE_INSTANTIATED_ONLY_ONCE_PER_PROCESS = eINSTANCE.getModelExchangeType_CanBeInstantiatedOnlyOncePerProcess();

		/**
		 * The meta object literal for the '<em><b>Can Get And Set FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__CAN_GET_AND_SET_FM_USTATE = eINSTANCE.getModelExchangeType_CanGetAndSetFMUstate();

		/**
		 * The meta object literal for the '<em><b>Can Not Use Memory Management Functions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__CAN_NOT_USE_MEMORY_MANAGEMENT_FUNCTIONS = eINSTANCE.getModelExchangeType_CanNotUseMemoryManagementFunctions();

		/**
		 * The meta object literal for the '<em><b>Can Serialize FM Ustate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__CAN_SERIALIZE_FM_USTATE = eINSTANCE.getModelExchangeType_CanSerializeFMUstate();

		/**
		 * The meta object literal for the '<em><b>Completed Integrator Step Not Needed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__COMPLETED_INTEGRATOR_STEP_NOT_NEEDED = eINSTANCE.getModelExchangeType_CompletedIntegratorStepNotNeeded();

		/**
		 * The meta object literal for the '<em><b>Model Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__MODEL_IDENTIFIER = eINSTANCE.getModelExchangeType_ModelIdentifier();

		/**
		 * The meta object literal for the '<em><b>Needs Execution Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__NEEDS_EXECUTION_TOOL = eINSTANCE.getModelExchangeType_NeedsExecutionTool();

		/**
		 * The meta object literal for the '<em><b>Provides Directional Derivative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_EXCHANGE_TYPE__PROVIDES_DIRECTIONAL_DERIVATIVE = eINSTANCE.getModelExchangeType_ProvidesDirectionalDerivative();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl <em>Model Structure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelStructureTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelStructureType()
		 * @generated
		 */
		EClass MODEL_STRUCTURE_TYPE = eINSTANCE.getModelStructureType();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_STRUCTURE_TYPE__OUTPUTS = eINSTANCE.getModelStructureType_Outputs();

		/**
		 * The meta object literal for the '<em><b>Derivatives</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_STRUCTURE_TYPE__DERIVATIVES = eINSTANCE.getModelStructureType_Derivatives();

		/**
		 * The meta object literal for the '<em><b>Initial Unknowns</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_STRUCTURE_TYPE__INITIAL_UNKNOWNS = eINSTANCE.getModelStructureType_InitialUnknowns();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelVariablesTypeImpl <em>Model Variables Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ModelVariablesTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getModelVariablesType()
		 * @generated
		 */
		EClass MODEL_VARIABLES_TYPE = eINSTANCE.getModelVariablesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_VARIABLES_TYPE__GROUP = eINSTANCE.getModelVariablesType_Group();

		/**
		 * The meta object literal for the '<em><b>Scalar Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_VARIABLES_TYPE__SCALAR_VARIABLE = eINSTANCE.getModelVariablesType_ScalarVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__DECLARED_TYPE = eINSTANCE.getRealType_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Derivative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__DERIVATIVE = eINSTANCE.getRealType_Derivative();

		/**
		 * The meta object literal for the '<em><b>Display Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__DISPLAY_UNIT = eINSTANCE.getRealType_DisplayUnit();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__MAX = eINSTANCE.getRealType_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__MIN = eINSTANCE.getRealType_Min();

		/**
		 * The meta object literal for the '<em><b>Nominal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__NOMINAL = eINSTANCE.getRealType_Nominal();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__QUANTITY = eINSTANCE.getRealType_Quantity();

		/**
		 * The meta object literal for the '<em><b>Reinit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__REINIT = eINSTANCE.getRealType_Reinit();

		/**
		 * The meta object literal for the '<em><b>Relative Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__RELATIVE_QUANTITY = eINSTANCE.getRealType_RelativeQuantity();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__START = eINSTANCE.getRealType_Start();

		/**
		 * The meta object literal for the '<em><b>Unbounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__UNBOUNDED = eINSTANCE.getRealType_Unbounded();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE__UNIT = eINSTANCE.getRealType_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl <em>Real Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.RealType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getRealType1()
		 * @generated
		 */
		EClass REAL_TYPE1 = eINSTANCE.getRealType1();

		/**
		 * The meta object literal for the '<em><b>Display Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__DISPLAY_UNIT = eINSTANCE.getRealType1_DisplayUnit();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__MAX = eINSTANCE.getRealType1_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__MIN = eINSTANCE.getRealType1_Min();

		/**
		 * The meta object literal for the '<em><b>Nominal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__NOMINAL = eINSTANCE.getRealType1_Nominal();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__QUANTITY = eINSTANCE.getRealType1_Quantity();

		/**
		 * The meta object literal for the '<em><b>Relative Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__RELATIVE_QUANTITY = eINSTANCE.getRealType1_RelativeQuantity();

		/**
		 * The meta object literal for the '<em><b>Unbounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__UNBOUNDED = eINSTANCE.getRealType1_Unbounded();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_TYPE1__UNIT = eINSTANCE.getRealType1_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesTypeImpl <em>Source Files Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getSourceFilesType()
		 * @generated
		 */
		EClass SOURCE_FILES_TYPE = eINSTANCE.getSourceFilesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILES_TYPE__GROUP = eINSTANCE.getSourceFilesType_Group();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_FILES_TYPE__FILE = eINSTANCE.getSourceFilesType_File();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesType1Impl <em>Source Files Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.SourceFilesType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getSourceFilesType1()
		 * @generated
		 */
		EClass SOURCE_FILES_TYPE1 = eINSTANCE.getSourceFilesType1();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILES_TYPE1__GROUP = eINSTANCE.getSourceFilesType1_Group();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_FILES_TYPE1__FILE = eINSTANCE.getSourceFilesType1_File();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.StringTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '<em><b>Declared Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__DECLARED_TYPE = eINSTANCE.getStringType_DeclaredType();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__START = eINSTANCE.getStringType_Start();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.ToolTypeImpl <em>Tool Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.ToolTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getToolType()
		 * @generated
		 */
		EClass TOOL_TYPE = eINSTANCE.getToolType();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_TYPE__ANY = eINSTANCE.getToolType_Any();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_TYPE__NAME = eINSTANCE.getToolType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.TypeDefinitionsTypeImpl <em>Type Definitions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.TypeDefinitionsTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getTypeDefinitionsType()
		 * @generated
		 */
		EClass TYPE_DEFINITIONS_TYPE = eINSTANCE.getTypeDefinitionsType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DEFINITIONS_TYPE__GROUP = eINSTANCE.getTypeDefinitionsType_Group();

		/**
		 * The meta object literal for the '<em><b>Simple Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFINITIONS_TYPE__SIMPLE_TYPE = eINSTANCE.getTypeDefinitionsType_SimpleType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnitDefinitionsTypeImpl <em>Unit Definitions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnitDefinitionsTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnitDefinitionsType()
		 * @generated
		 */
		EClass UNIT_DEFINITIONS_TYPE = eINSTANCE.getUnitDefinitionsType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_DEFINITIONS_TYPE__GROUP = eINSTANCE.getUnitDefinitionsType_Group();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_DEFINITIONS_TYPE__UNIT = eINSTANCE.getUnitDefinitionsType_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownTypeImpl <em>Unknown Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownTypeImpl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnknownType()
		 * @generated
		 */
		EClass UNKNOWN_TYPE = eINSTANCE.getUnknownType();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE__DEPENDENCIES = eINSTANCE.getUnknownType_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependencies Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE__DEPENDENCIES_KIND = eINSTANCE.getUnknownType_DependenciesKind();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE__INDEX = eINSTANCE.getUnknownType_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl <em>Unknown Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.UnknownType1Impl
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getUnknownType1()
		 * @generated
		 */
		EClass UNKNOWN_TYPE1 = eINSTANCE.getUnknownType1();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE1__DEPENDENCIES = eINSTANCE.getUnknownType1_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependencies Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE1__DEPENDENCIES_KIND = eINSTANCE.getUnknownType1_DependenciesKind();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_TYPE1__INDEX = eINSTANCE.getUnknownType1_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType <em>Causality Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCausalityType()
		 * @generated
		 */
		EEnum CAUSALITY_TYPE = eINSTANCE.getCausalityType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem <em>Dependencies Kind Type Item</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItem()
		 * @generated
		 */
		EEnum DEPENDENCIES_KIND_TYPE_ITEM = eINSTANCE.getDependenciesKindTypeItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1 <em>Dependencies Kind Type Item1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItem1()
		 * @generated
		 */
		EEnum DEPENDENCIES_KIND_TYPE_ITEM1 = eINSTANCE.getDependenciesKindTypeItem1();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.InitialType <em>Initial Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialType()
		 * @generated
		 */
		EEnum INITIAL_TYPE = eINSTANCE.getInitialType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType <em>Variability Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariabilityType()
		 * @generated
		 */
		EEnum VARIABILITY_TYPE = eINSTANCE.getVariabilityType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType <em>Variable Naming Convention Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariableNamingConventionType()
		 * @generated
		 */
		EEnum VARIABLE_NAMING_CONVENTION_TYPE = eINSTANCE.getVariableNamingConventionType();

		/**
		 * The meta object literal for the '<em>Causality Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getCausalityTypeObject()
		 * @generated
		 */
		EDataType CAUSALITY_TYPE_OBJECT = eINSTANCE.getCausalityTypeObject();

		/**
		 * The meta object literal for the '<em>Dependencies Kind Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindType()
		 * @generated
		 */
		EDataType DEPENDENCIES_KIND_TYPE = eINSTANCE.getDependenciesKindType();

		/**
		 * The meta object literal for the '<em>Dependencies Kind Type1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindType1()
		 * @generated
		 */
		EDataType DEPENDENCIES_KIND_TYPE1 = eINSTANCE.getDependenciesKindType1();

		/**
		 * The meta object literal for the '<em>Dependencies Kind Type Item Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItemObject()
		 * @generated
		 */
		EDataType DEPENDENCIES_KIND_TYPE_ITEM_OBJECT = eINSTANCE.getDependenciesKindTypeItemObject();

		/**
		 * The meta object literal for the '<em>Dependencies Kind Type Item Object1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.DependenciesKindTypeItem1
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesKindTypeItemObject1()
		 * @generated
		 */
		EDataType DEPENDENCIES_KIND_TYPE_ITEM_OBJECT1 = eINSTANCE.getDependenciesKindTypeItemObject1();

		/**
		 * The meta object literal for the '<em>Dependencies Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesType()
		 * @generated
		 */
		EDataType DEPENDENCIES_TYPE = eINSTANCE.getDependenciesType();

		/**
		 * The meta object literal for the '<em>Dependencies Type1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getDependenciesType1()
		 * @generated
		 */
		EDataType DEPENDENCIES_TYPE1 = eINSTANCE.getDependenciesType1();

		/**
		 * The meta object literal for the '<em>Initial Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.InitialType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getInitialTypeObject()
		 * @generated
		 */
		EDataType INITIAL_TYPE_OBJECT = eINSTANCE.getInitialTypeObject();

		/**
		 * The meta object literal for the '<em>Variability Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariabilityType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariabilityTypeObject()
		 * @generated
		 */
		EDataType VARIABILITY_TYPE_OBJECT = eINSTANCE.getVariabilityTypeObject();

		/**
		 * The meta object literal for the '<em>Variable Naming Convention Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.VariableNamingConventionType
		 * @see org.eclipse.papyrus.moka.fmi.modeldescription.impl.FmiPackageImpl#getVariableNamingConventionTypeObject()
		 * @generated
		 */
		EDataType VARIABLE_NAMING_CONVENTION_TYPE_OBJECT = eINSTANCE.getVariableNamingConventionTypeObject();

	}

} //FmiPackage
