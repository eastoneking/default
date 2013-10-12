package eastone.common.processor.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import eastone.common.convertor.Convertor;
import eastone.common.processor.AbstractProcessorWithResult;

public class InputStream2BytesProcessor extends AbstractProcessorWithResult<byte[],IOException> implements Convertor<InputStream, byte[], IOException>{
	
	private int bufferSize=524288;
	
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	public int getBufferSize() {
		return bufferSize;
	}
	
	@Override
	public byte[] convert(InputStream src) throws IOException {
		byte[] res = null;
		
		if(src==null){
			return res;
		}
		
		ByteArrayOutputStream buf = null;
		try{
			buf = new ByteArrayOutputStream();
			byte[] cur = new byte[bufferSize];
			int len = -1;
			while((len=src.read(cur))>=0){
				buf.write(cur,0,len);
			}
			buf.flush();
		}finally{
			try{
				buf.close();
			}catch(Exception e){
				logger.warn("",e);
			}
		}
		res = buf.toByteArray();
		return res;
	}
	
	private InputStream inputStream;
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	protected byte[] execute() throws IOException {
		return convert(inputStream);
	}

}
