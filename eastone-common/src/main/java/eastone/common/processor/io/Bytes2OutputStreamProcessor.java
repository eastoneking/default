package eastone.common.processor.io;

import java.io.IOException;
import java.io.OutputStream;

import eastone.common.processor.Processor;

public class Bytes2OutputStreamProcessor extends eastone.common.Object implements Processor<IOException>{
	
	private OutputStream outputStream;
	
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public OutputStream getOutputStream() {
		return outputStream;
	}
	
	private byte[] data;
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public byte[] getData() {
		return data;
	}
	
	@Override
	public void run() throws IOException {
		if(outputStream!=null){
			outputStream.write(data);
			outputStream.flush();
		}
	}

}
