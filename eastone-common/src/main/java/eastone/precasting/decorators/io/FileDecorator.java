/*
 * create:2014年10月12日 下午7:47:20
 * author:wangds  
 */
package eastone.precasting.decorators.io;

import java.io.File;

import eastone.common.decorator.AbstractDecorator;
import eastone.common.processor.Clearable;

/**
 * .
 * @author wangds
 *
 */
public class FileDecorator extends AbstractDecorator<File> implements Clearable {
    private static final String DEFAULT_SEPARATOR = ".";

    /**
     * The constructor of FileDecorator.
     * @author wangds 2014年10月12日 下午7:48:56.
     */
    public FileDecorator(File file) {
        this.setComponent(file);
    }
    
    /*
     * @see eastone.common.decorator.AbstractDecorator#setComponent(java.lang.Object)
     * @author wangds 2014年10月12日 下午7:50:18.
     */
    @Override
    public void setComponent(File theComponent) {
        this.clear();
        super.setComponent(theComponent);
    }

    /*
     * @see eastone.common.processor.Clearable#clear()
     * @author wangds 2014年10月12日 下午7:49:48.
     */
    @Override
    public void clear() {
    }
    
    public String getSuffix(String sep, boolean with){
        if(sep == null){
            sep = DEFAULT_SEPARATOR;
        }
        String res = null;
        File file = this.getComponent();
        if(file==null){
            return res;
        }
        res = "";
        String path = file.getPath();
        int idx = path.lastIndexOf(sep);
        if(idx<0){
            return res;
        }
        if(!with){
            idx += sep.length();
        }
        res = path.substring(idx);
        return res;
    }
    
    public String getSuffix(){
        return this.getSuffix(DEFAULT_SEPARATOR, false);
    }
    
    public String getSuffix(String sep){
        return this.getSuffix(sep, false);
    }
    
    public String getSuffixWithSeparator(){
        return this.getSuffix(DEFAULT_SEPARATOR, true);
    }
    public String getSuffixWithSeparator(String sep){
        return this.getSuffix(sep, true);
    }
    
    public void mkdirsIfNotExist(){
        File file = this.getComponent();
        if(file==null){
            return;
        }
        if(!file.exists()){
            file.mkdirs();
        }
    }
    public void mkParentsDirIfNotExist(){
        File file = this.getComponent();
        if(file==null){
            return;
        }
        new FileDecorator(file.getParentFile()).mkdirsIfNotExist();
    }
}
