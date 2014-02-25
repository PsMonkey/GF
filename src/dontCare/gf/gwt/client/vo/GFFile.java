package dontCare.gf.gwt.client.vo;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GFFile implements IsSerializable {
	public static final String SEPARATOR = "/";
	
	private String fullPath;
	private ArrayList<GFFile> children;
	
	GFFile() {}	//for GWT RPC
	
	public GFFile(String path, boolean isDir) {
		this.fullPath = path.replaceAll("\\\\", SEPARATOR);
		if (isDir) { children = new ArrayList<GFFile>(); }
	}
	
	public boolean isDirectory() {
		return children != null;
	}

	public String getFullPath() {
		return fullPath;
	}
	
	public String getPath() {
		return fullPath.substring(0, fullPath.lastIndexOf(SEPARATOR));
	}

	public String getName() {
		return fullPath.substring(
			fullPath.lastIndexOf(SEPARATOR) + SEPARATOR.length()
		);
	}

	public ArrayList<GFFile> getChildren() {
		return children;
	}
	
	public void addFile(GFFile file) {
		children.add(file);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GFFile [fullPath=");
		builder.append(fullPath);
		builder.append(", children=");
		builder.append(children);
		builder.append("]");
		return builder.toString();
	}
}