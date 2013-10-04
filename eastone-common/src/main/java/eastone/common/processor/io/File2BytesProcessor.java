package eastone.common.processor.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import eastone.common.adapter.Adapter;
import eastone.common.convertor.Convertor;
import eastone.common.processor.AbstractProcessorWithResult;
import eastone.common.processor.Processor;

public class File2BytesProcessor extends AbstractProcessorWithResult<byte[],IOException> implements Convertor<File,byte[], IOException>, Adapter<Convertor<InputStream,byte[],IOException>>, Processor<IOException>{

	private File file;
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	
	private Convertor<InputStream, byte[], IOException> inner;
	
	@Override
	public Convertor<InputStream, byte[], IOException> getInner() {
		return inner;
	}
	
	public void setInner(Convertor<InputStream, byte[], IOException> inner) {
		this.inner = inner;
	}

	@Override
	public byte[] convert(File src) throws IOException {
		byte[] res = null;
		if(src==null){
			return res;
		}
		if(!src.exists()){
			throw new FileNotFoundException(src.getPath());
		}
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(src);
			this.inner.convert(fis);
		}finally{
			if(fis!=null){
				try{
					fis.close();
				}catch(Exception e){
					logger.warn("",e);
				}
			}
		}
		return res;
	}
	

	@Override
	protected byte[] execute() throws IOException {
		return convert(file);
	}

}
