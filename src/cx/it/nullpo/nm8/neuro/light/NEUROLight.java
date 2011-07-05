package cx.it.nullpo.nm8.neuro.light;

import java.io.IOException;

import cx.it.nullpo.nm8.gui.framework.NFFont;
import cx.it.nullpo.nm8.gui.framework.NFGraphics;
import cx.it.nullpo.nm8.gui.framework.NFSystem;
import cx.it.nullpo.nm8.neuro.core.NEUROCore;
import cx.it.nullpo.nm8.neuro.error.PluginInitializationException;
import cx.it.nullpo.nm8.neuro.event.DebugEvent;
import cx.it.nullpo.nm8.neuro.plugin.Nullterm;

public class NEUROLight extends NEUROCore {
	
	NFFont font;
	
	/**
	 * Constructs a NEUROLight.
	 */
	public NEUROLight(NFSystem sys) {
		super(sys);
		try {
			new Nullterm().init(this);
		} catch (PluginInitializationException e) {}
		
		try {
			font = sys.loadFont("data/res/font/font_neuro.ttf",12,false,false);
		} catch (IOException e) {
			font = null;
			dispatchEvent(new DebugEvent(this,DebugEvent.TYPE_WARNING,"Unable to load NEURO font"));
		}
	}

	public String getName() {
		return "NEURO Light";
	}

	public float getVersion() {
		return 0.1F;
	}
	
	public void draw(NFGraphics g) {
		super.draw(g);
		if (font != null) {
			g.setFont(font);
			g.drawString("POWERED BY "+getName().toUpperCase()+" "+getVersion(),5,450);
		}
	}

}