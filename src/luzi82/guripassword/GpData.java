package luzi82.guripassword;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class GpData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5958390738812505770L;

	private final LinkedList<GpEntry> entryList = new LinkedList<GpEntry>();

	public Collection<GpEntry> getEntryList() {
		return entryList;
	}

}
