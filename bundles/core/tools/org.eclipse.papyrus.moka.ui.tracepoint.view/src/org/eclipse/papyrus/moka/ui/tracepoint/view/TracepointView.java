/*****************************************************************************
 * Copyright (c) 2012, 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *  Pauline DEVILLE (CEA LIST) - Bug 546467 
 *  
 *****************************************************************************/

package org.eclipse.papyrus.moka.ui.tracepoint.view;

import java.util.Map;

import javax.swing.text.View;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.moka.tracepoint.service.MarkerUtils;
import org.eclipse.papyrus.moka.tracepoint.service.TraceState;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;
import org.eclipse.papyrus.moka.tracepoint.service.dialogs.TraceActionSelection;
import org.eclipse.papyrus.moka.ui.tracepoint.view.internal.utils.IconUtil;
import org.eclipse.papyrus.moka.ui.tracepoint.view.internal.utils.TraceViewImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be presented in the view. Each view can present the same model objects using different labels and icons, if needed. Alternatively, a single label provider can be shared between views in order
 * to ensure that objects of the same type are presented in the same way everywhere.
 * <p>
 */

public class TracepointView extends ViewPart implements ISelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.moka.ui.tracepoint.view.Tracepoints"; //$NON-NLS-1$


	private CheckboxTableViewer viewer;

	protected Action actionDelete;

	protected Action actionDeleteAll;

	protected Action actionGoto;

	protected Action actionSkip;

	protected Action actionTraceSelect;

	private Action doubleClickAction;

	private IFileObserver fileObserver = null;

	protected TraceActionSelection tas;

	/**
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content
	 * (like Task List, for example).
	 */
	class ViewContentProvider implements IStructuredContentProvider {

		@Override
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object parent) {
			try {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				if (root != null) {
					return root.findMarkers(TracepointConstants.tracepointMarker, true, IResource.DEPTH_INFINITE);
				}
			} catch (CoreException e) {
			}
			return new String[] {};
		}
	}



	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public String getColumnText(Object obj, int index) {
			if (obj instanceof IMarker) {
				final String separator = " - "; //$NON-NLS-1$
				EObject eobj = MarkerUtils.getEObjectOfMarker((IMarker) obj);
				StringBuilder builder = new StringBuilder();
				if (eobj.eResource() != null) {
					builder.append(eobj.eResource().getURI().lastSegment().toString());
				}
				if (eobj instanceof NamedElement) {
					builder.append(separator);
					builder.append(((NamedElement) eobj).getQualifiedName());
				} else if (eobj != null) {
					builder.append(separator);
					builder.append(eobj.toString());
				}
				return builder.toString();
			}
			return getText(obj);

		}

		@Override
		public Image getColumnImage(Object obj, int index) {
			if (TraceState.skipAllTracepoints) {
				return TraceViewImages.getSkipAllImage();
			}
			if (obj instanceof IMarker) {
				IMarker marker = (IMarker) obj;
				Image image = null;
				boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
				boolean isTracepoint = marker.getAttribute(TracepointConstants.isTracepoint, false);
				if (isTracepoint) {
					image = isActive ? IconUtil.getActivateTracepointIcon() : IconUtil.getInactivateTracepointIcon();
				} else {
					// FIXME remove every reference to breakpoint
					image = isActive ? IconUtil.getActivateTracepointIcon() : IconUtil.getInactivateTracepointIcon();
				}
				return image;
			}
			return null;
		}
	}

	/**
	 * The constructor.
	 */
	public TracepointView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = CheckboxTableViewer.newCheckList(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setCheckStateProvider(new ICheckStateProvider() {

			@Override
			public boolean isGrayed(Object element) {
				return false;
			}

			@Override
			public boolean isChecked(Object element) {
				if (element instanceof IMarker) {
					IMarker marker = (IMarker) element;
					return marker.getAttribute(TracepointConstants.isActive, false);
				}
				return false;
			}
		});

		// viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		getViewSite().getPage().addSelectionListener(this);


		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.eclipse.papyrus.views.tracepoints.viewer"); //$NON-NLS-1$
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		viewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				boolean isChecked = event.getChecked();
				if (element instanceof IMarker) {
					IMarker marker = (IMarker) element;
					try {
						marker.setAttribute(TracepointConstants.isActive, isChecked);
						switchUI();
					} catch (CoreException e) {
					}
				}
			}
		});

		fileObserver = new IFileObserver() {

			@Override
			public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
				switchUI();
			}

			@Override
			public void handleMarkerChanged(IMarker marker) {
				switchUI();
			}

			@Override
			public void handleMarkerAdded(IMarker marker) {
				switchUI();
			}

			// TODO need to handle?
			@Override
			public void handleFileRenamed(IFile oldFile, IFile file) {
			}

			@Override
			public void handleFileMoved(IFile oldFile, IFile file) {
			}

			@Override
			public void handleFileDeleted(IFile file) {
			}

			@Override
			public void handleFileChanged(IFile file) {
			}
		};

		FileChangeManager.getInstance().addFileObserver(fileObserver);
	}

	@Override
	public void dispose() {
		if (fileObserver != null) {
			FileChangeManager.getInstance().addFileObserver(fileObserver);
		}
		super.dispose();
	}

	public void switchUI() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				// ... do any work that updates the screen ...
				viewer.refresh();
			}
		});
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				TracepointView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	protected void fillLocalPullDown(IMenuManager manager) {
		manager.add(actionDelete);
		manager.add(new Separator());
		manager.add(actionGoto);
	}

	protected void fillContextMenu(IMenuManager manager) {
		manager.add(actionDelete);
		manager.add(actionGoto);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	protected void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionDelete);
		manager.add(actionDeleteAll);
		manager.add(actionGoto);
		manager.add(actionSkip);
		manager.add(actionTraceSelect);
	}

	protected void makeActions() {
		actionSkip = new Action("Skip All", IAction.AS_CHECK_BOX) { //$NON-NLS-1$

			@Override
			public void run() {
				TraceState.skipAllTracepoints = !TraceState.skipAllTracepoints;
				switchUI();
			}
		};
		actionSkip.setChecked(TraceState.skipAllTracepoints);

		actionSkip.setImageDescriptor(TraceViewImages.getSkipAllID());
		actionSkip.setToolTipText("Skip All Tracepoints"); //$NON-NLS-1$

		actionDelete = new Action("Delete") { //$NON-NLS-1$

			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					for (Object obj : ((IStructuredSelection) selection).toList()) {
						if (obj instanceof IMarker) {
							IMarker marker = (IMarker) obj;
							try {
								marker.delete();
							} catch (CoreException e) {
							}
						}
					}
				}
			}
		};
		actionDelete.setToolTipText("Delete tracepoint"); //$NON-NLS-1$
		actionDelete.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));

		actionDeleteAll = new Action() {

			@Override
			public void run() {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				if (root != null) {
					try {
						root.deleteMarkers(TracepointConstants.tracepointMarker, true, IResource.DEPTH_INFINITE);
					} catch (CoreException e) {
					}
				}
			}
		};
		actionDeleteAll.setText("Remove Selected Tracepoints (Delete)"); //$NON-NLS-1$
		actionDeleteAll.setToolTipText("Remove All Tracepoints"); //$NON-NLS-1$
		actionDeleteAll.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

		actionGoto = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof IMarker) {
					IMarker marker = (IMarker) obj;
					boolean onlyNavigatoToActiveEditor = false;
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					if (onlyNavigatoToActiveEditor) {
						IEditorPart part = activePage.getActiveEditor();
						if (part instanceof IGotoMarker) {
							((IGotoMarker) part).gotoMarker(marker);
						}
					} else {
						try {
							IDE.openEditor(activePage, marker, OpenStrategy.activateOnOpen());
						} catch (PartInitException e) {

						}
					}
				}
			}
		};
		actionGoto.setText("GoTo"); //$NON-NLS-1$
		actionGoto.setToolTipText("Navigate to tracepoint"); //$NON-NLS-1$
		actionGoto.setImageDescriptor(TraceViewImages.getGotoObjID());
		doubleClickAction = actionGoto;

		actionTraceSelect = new Action() {

			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof IMarker) {
					// EditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, null);
					IMarker marker = (IMarker) obj;
					EObject eobj = MarkerUtils.getEObjectOfMarker(marker);
					if (eobj instanceof Element) {
						TraceActionSelection tad = new TraceActionSelection(Display.getCurrent().getActiveShell(), (IMarker) obj, (Element) eobj);
						tad.open();
						if (tad.getReturnCode() == IDialogConstants.OK_ID) {
							Object[] result = tad.getResult();
							if (result != null && result.length >= 2) {
								Integer traceAction = (Integer) result[0];
								String traceMechanism = (String) result[1];
								try {
									marker.setAttribute(TracepointConstants.traceAction, traceAction);
									marker.setAttribute(TracepointConstants.traceMechanism, traceMechanism);
								} catch (CoreException e) {
								}
							}
						}
					}
				}
			}

		};
		actionTraceSelect.setText("Trace Action"); //$NON-NLS-1$
		actionTraceSelect.setToolTipText("Select Trace Action"); //$NON-NLS-1$
		actionTraceSelect.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	protected void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 * org.eclipse.jface.viewers.ISelection)
	 */
	// TODO: function not used currently
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		IStructuredSelection sSelection = null;
		if (selection instanceof IStructuredSelection) {
			sSelection = (IStructuredSelection) selection;
		}

		// exclude case of an empty selection which is not a Tree selection, since changing views provokes an
		// empty selection (selection gets lost, although same element remains selected)
		if ((selection != null) && (sSelection != null) && sSelection.isEmpty()) {
			return;
		}
		currentElement = null;

		// No available selection: switch to default panel
		if ((sSelection == null) || (sSelection.size() != 1)) {
			switchUI();
			return;
		}

		// Retrieve selected object
		Object currentObject = sSelection.getFirstElement();
		// If the object is an edit part, try to get semantic bridge
		if (currentObject instanceof GraphicalEditPart) {
			GraphicalEditPart editPart = (GraphicalEditPart) currentObject;
			if (editPart.getModel() instanceof View) {
				View view = (View) editPart.getModel();
				if (view.getElement() instanceof Element) {
					currentObject = view.getElement();
				}
			}
		} else if (currentObject instanceof IAdaptable) {
			// modisco ModelElementItem supports IAdaptable (cleaner than cast / dependency with modisco)
			currentObject = ((IAdaptable) currentObject).getAdapter(EObject.class);
		}

		if (currentObject instanceof Element) {
			currentElement = (Element) currentObject;
			// switchUI();
		}
	}

	protected Element currentElement;
}
