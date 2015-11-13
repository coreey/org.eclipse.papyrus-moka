package org.eclipse.papyrus.moka.animation.css;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.infra.gmfdiag.css.service.IMarkerToPseudoSelectorMappingProvider;
import org.eclipse.papyrus.moka.animation.utils.AnimationUtils;

public class AnimationPseudoSelectorMappingProvider implements IMarkerToPseudoSelectorMappingProvider {
	
	protected Map<String, String> mappings;

	public final static String BREAKPOINT_MARKER_PSEUDO_SELECTOR = "breakpoint";

	public final static String SUSPENDED_MARKER_PSEUDO_SELECTOR = "suspended";

	public final static String ANIMATION_MARKER_PSEUDO_SELECTOR = "animated";

	public AnimationPseudoSelectorMappingProvider() {}
	
	public Map<String, String> getMappings() {
		if (this.mappings == null) {
			this.mappings = new HashMap<String, String>();
			// Adds pseudo selectors for 'suspended' and 'animation' markers
			this.mappings.put(AnimationUtils.SUSPENDED_MARKER_ID, SUSPENDED_MARKER_PSEUDO_SELECTOR);
			this.mappings.put(AnimationUtils.ANIMATED_MARKER_ID, ANIMATION_MARKER_PSEUDO_SELECTOR);
		}
		return this.mappings;
	}
}
