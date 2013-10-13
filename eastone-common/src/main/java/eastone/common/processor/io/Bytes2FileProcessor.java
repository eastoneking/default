package eastone.common.processor.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import eastone.common.processor.Processor;

public class Bytes2FileProcessor extends eastone.common.Object implements Processor<IOException>{

	private boolean makeParentDirectory;
	
	private byte[] data;
	
	private File file;
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setMakeParentDirectory(boolean makeParentDirectory) {
		this.makeParentDirectory = makeParentDirectory;
	}
	
	public boolean isMakeParentDirectory() {
		return makeParentDirectory;
	}
	
	@Override
	public void process() throws IOException {
		assert file!=null;
		if(this.data!=null&&this.file!=null){
			if(!validateParentPath(file)){
				throw new IOException();
			}
			writeData2File(this.data,this.file);
		}
	}

	private void writeData2File(byte[] data, File file) throws IOException {
		assert file!=null;
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(file);
			fos.write(data);
			fos.flush();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					logger.warn("",e);
				}
			}
		}
	}

	private boolean validateParentPath(File file) {
		boolean res = false;
		File parent = file.getParentFile();
		res = parent.exists();
		if((!res)&&makeParentDirectory){
			parent.mkdirs();
			res = true;
		}
		return res;
	}

	
	
}
